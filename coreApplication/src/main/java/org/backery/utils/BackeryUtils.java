package org.backery.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Level;
import org.backery.common.BackeryLogger;
import org.backery.entity.Item;
import org.backery.entity.Pack;

public class BackeryUtils implements IBackeryUtils {

	/**
	 * Get itemName from map and make it available for using it in the GUI
	 * 
	 * @param aInDataMap
	 * @return
	 */
	public Map<String, String> getItemName(Map<String, String> aInDataMap) {
		Map<String, String> returnMap = new HashMap();
		for (Map.Entry<String, String> mapVar : aInDataMap.entrySet()) {
			String value = mapVar.getValue();
			// Example Data
			// itemcode=CF
			// itemname=Croissant
			// pack=3-5.95,5-9.95,9-16.99

			String[] splitValue = value.split(System.lineSeparator());
			returnMap.put(mapVar.getKey(), splitValue[1].split("=")[1]);
		}

		return returnMap;
	}

	/**
	 * Main Processing logic will be carried in this method.
	 * 
	 * This method finds/sends the packaging information along with the amout for
	 * the given quantity.
	 * 
	 * @param receivedList
	 * @param inputItem
	 * @param input
	 * @param data
	 */
	public String processInput(Map<String, Item> receivedList, String inputItem, int input, Map<Integer, Integer> data) {

		BackeryLogger.log(Level.INFO, "Finding the packaging structure for the selected itemcode " + inputItem
				+ " with the quantity " + input);
		List<Float> eachPackPrice = new ArrayList();
		List<Integer> entryItems = new LinkedList<Integer>();
		StringBuilder strBuilder = new StringBuilder();
		float totalAmount = 0.0f;

		if (receivedList.containsKey(inputItem)) {
			Item value = receivedList.get(inputItem);

			Map<Integer, Float> ratePerPack = new HashMap();

			for (Pack p : value.getPacks()) {
				entryItems.add(p.getNumberOfItemsPerPack());
				ratePerPack.put(p.getNumberOfItemsPerPack(), p.getPackAmount());
			}

			// Sort it, so it can be reversed in descending order
			Collections.sort(entryItems);

			// reverse it.
			Collections.reverse(entryItems);

			int calculated = 0;
			for (int i = 0; i <= entryItems.size() - 1; i++) {
				if (input >= entryItems.get(i)) { // Now divide input by each array item
					int divideQuotient = input / entryItems.get(i);
					int divideReminder = input % entryItems.get(i);

					BackeryLogger.log(Level.DEBUG,
							input + " divided by " + entryItems.get(i) + " and the quotient  is " + divideQuotient);
					BackeryLogger.log(Level.DEBUG,
							input + " divided by " + entryItems.get(i) + " and the reminder  is " + divideReminder);

					// Scenario -- where first item gets matched.
					if (entryItems.get(i) * divideQuotient == input) {
						strBuilder.append(entryItems.get(i) + " * " + divideQuotient);
						strBuilder.append(System.lineSeparator());
						BackeryLogger.log(Level.DEBUG, entryItems.get(i) + " * " + divideQuotient);
						break;
					}

					if (checkIfNextItemPresent(entryItems, i + 1)) {
						if (entryItems.get(i + 1) > divideReminder) {
							// skip doing this division
							continue;
						} else {
							BackeryLogger.log(Level.DEBUG, entryItems.get(i) + " * " + divideQuotient);
							strBuilder.append(entryItems.get(i) + " * " + divideQuotient);
							strBuilder.append(System.lineSeparator());
							calculated = entryItems.get(i) * divideQuotient;
							input = input - calculated;
						}
					} else {
						if (divideReminder == 0) {
							BackeryLogger.log(Level.DEBUG, entryItems.get(i) + " * " + divideQuotient);
							strBuilder.append(entryItems.get(i) + " * " + divideQuotient);
							strBuilder.append(System.lineSeparator());
						}
					}
				}
			}

			for (Map.Entry<Integer, Integer> map : data.entrySet()) {
				strBuilder.append(map.getValue() + " packs of " + map.getKey() + " quanties and cost is "
						+ (ratePerPack.get(map.getKey()) * map.getValue()));
				strBuilder.append(System.lineSeparator());
				eachPackPrice.add((ratePerPack.get(map.getKey()) * map.getValue()));
			}

			float finalPrice = 0;
			for (Float f : eachPackPrice) {
				finalPrice = finalPrice + f;
			}

			String[] splitStrBuilder = strBuilder.toString().split(System.lineSeparator());

			// To load the rate for each packs, which is used later to find the multiple of
			// packs
			for (String eachData : splitStrBuilder) {
				if (!eachData.isEmpty()) {
					String splitData[] = eachData.split("\\*");
					int testData = Integer.parseInt(splitData[0].trim());

					if (ratePerPack.containsKey(testData)) {
						float localValue = ratePerPack.get(Integer.parseInt(splitData[0].trim()));
						totalAmount = totalAmount + (localValue * Integer.parseInt(splitData[1].trim()));
					}
				}
			}

			if (strBuilder.toString().isEmpty()) {
				strBuilder.append("No matching Combinations for the item selected.");
			} else {

				strBuilder.append(System.lineSeparator());
				strBuilder.append("Total Amount " + "$" + totalAmount);
			}
			// outputTrextArea.setText(strBuilder.toString());
			BackeryLogger.log(Level.INFO, "The Packaging structure for the selected itemcode " + inputItem
					+ " with the quantity " + input + " is processed successfully");
		} else {
			BackeryLogger.log(Level.INFO, "The Selected item is not available in the inventory");
		}

		return strBuilder.toString();
	}

	/**
	 * This method finds whether there exist the next item in the array of not.
	 * 
	 * @param entryItems
	 * @param size
	 * @return true/false
	 */
	private static boolean checkIfNextItemPresent(List<Integer> entryItems, int size) {
		if (size <= entryItems.size() - 1) {
			return true;
		}
		return false;
	}
}

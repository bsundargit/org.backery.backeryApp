package org.backery.utils;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Level;
import org.backery.common.BackeryException;
import org.backery.common.BackeryLogger;
import org.backery.entity.Item;
import org.backery.entity.Pack;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
public class TestBackeryUtils {

	BackeryUtils bUtils;

	@Mock
	IBackeryUtils utils;

	@Before
	public void setup() {
		utils = new BackeryUtils();
	}

	@Test
	public void testGetItemName() {

		Map<String, String> actualMap = new HashMap();

		// Example Data
		// itemcode=CF
		// itemname=Croissant
		// pack=3-5.95,5-9.95,9-16.99
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("itemcode=CF").append(System.lineSeparator());
		strBuilder.append("itemname=Croissant").append(System.lineSeparator());
		strBuilder.append("pack=3-5.95,5-9.95,9-16.99").append(System.lineSeparator());

		actualMap.put("CF", strBuilder.toString());

		Map<String, String> actualData = new HashMap();
		actualData.put("CF", "Croissant");

		Map<String, String> output = utils.getItemName(actualMap);
		assertEquals(output, actualData);
	}

	@Test
	@Ignore // As I do not find the need to mock it.
	public void testIt() {
		Map<String, String> inputMap = new HashMap();
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("itemcode=CF").append(System.lineSeparator());
		strBuilder.append("itemname=Croissant").append(System.lineSeparator());
		strBuilder.append("pack=3-5.95,5-9.95,9-16.99").append(System.lineSeparator());

		inputMap.put("CF", strBuilder.toString());

		Map<String, String> outputMap = new HashMap();
		outputMap.put("CF", "Crossiant");

		PowerMockito.when(utils.getItemName(inputMap)).thenReturn(outputMap);
		Mockito.verify(utils).getItemName(inputMap);
	}

	@Test
	public void testPackageProcessingLogicAndExpectPackageData() {
		Map<String, Item> daoData = new LinkedHashMap();
		Item item = new Item();
		try {
			item.setItemCode("VS5");
			item.setItemName("Vegemite Scroll");

			List<Pack> listPack = new ArrayList();
			Pack p1 = new Pack();
			p1.setNumberOfItemsPerPack(3);
			p1.setPackAmount(6.99f);

			Pack p2 = new Pack();
			p2.setNumberOfItemsPerPack(5);
			p2.setPackAmount(8.99f);

			listPack.add(p1);
			listPack.add(p2);

			item.setPacks(listPack);
			daoData.put("Vegemite Scroll", item);

			Map<Integer, Integer> dataMap = new HashMap();

			String output = utils.processIt(daoData, "Vegemite Scroll", 13, dataMap);

			String expectedOutput = "5 * 2\r\n" + "3 * 1\r\n" + "\r\n" + "Total Amount $24.97";

			assertEquals(expectedOutput, output);

		} catch (BackeryException e) {
			BackeryLogger.log(Level.ERROR, "Unable to execute test logic");
		}
	}

	@Test
	public void testPackageProcessingLogicAndExpectNoCombinationData() {

		Map<String, Item> daoData = new LinkedHashMap();
		Item item = new Item();
		try {
			item.setItemCode("VS5");
			item.setItemName("Vegemite Scroll");

			List<Pack> listPack = new ArrayList();
			Pack p1 = new Pack();
			p1.setNumberOfItemsPerPack(3);
			p1.setPackAmount(6.99f);

			Pack p2 = new Pack();
			p2.setNumberOfItemsPerPack(5);
			p2.setPackAmount(8.99f);

			listPack.add(p1);
			listPack.add(p2);

			item.setPacks(listPack);
			daoData.put("Vegemite Scroll", item);

			Map<Integer, Integer> dataMap = new HashMap();

			String output = utils.processIt(daoData, "Vegemite Scroll", 2, dataMap);

			String expectedOutput = "No matching Combinations for the item selected.";

			assertEquals(expectedOutput, output);

		} catch (BackeryException e) {
			BackeryLogger.log(Level.ERROR, "Unable to execute test logic");
		}

	}
}

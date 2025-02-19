package org.backery.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Level;
import org.backery.common.BackeryConstants;
import org.backery.common.BackeryException;
import org.backery.common.BackeryLogger;
import org.backery.entity.Item;
import org.backery.entity.Pack;

/**
 * This class reads the data from the properties file
 * which will be available in the backery gui.
 * @author esxxbhs
 * 
 */
public class ReadDataFromPropertiesFile {

	Map<String, String> fileData = new HashMap();

	/**
	 * Read data from properties file.
	 * @return
	 */
	public Map<String, String> getPropertiesFileData() {
		try {
			FileReader reader = new FileReader(BackeryConstants.PROPERTIES_FILE_URL);
				BufferedReader bufferedReader = new BufferedReader(reader);
			// read line by line
			String line;
			StringBuilder str = new StringBuilder();
			String key = "";
			
			while ((line = bufferedReader.readLine()) != null) {
				if (!line.isEmpty()) {
					if (line.contains("itemcode"))
						key = line.split("=")[1];

					if (line.contains("pack")) {
						// End of One Record
						str.append(line);
						fileData.put(key, str.toString());
						key = "";
						str.setLength(0);
					} else {
						str.append(line);
						str.append(System.lineSeparator());
					}
				}
			}
			
			bufferedReader.close();

		} catch (FileNotFoundException e) {
			BackeryLogger.log(Level.ERROR, "Properties file not found " + e.getMessage());
			BackeryLogger.log(Level.ERROR, "Ensure the properties file exist and relaunch the application " + e.getMessage());
			System.exit(0);
		} catch (IOException e) {
			BackeryLogger.log(Level.ERROR, "IO Exception occured " + e.getMessage());
		} 
		return fileData;
	}

	/**This method returns the contents 
	 * read from the properites file and 
	 * return it as POJO objects 
	 * for further use
	 *  
	 * @return Map<String, Item>
	 */
	public Map<String, Item> getAllItemsAsObject() { 
		Map<String, Item> daoData = new LinkedHashMap();
		BackeryLogger.log(Level.INFO,"Started to generate properties file contents as POJO objects ");
		for (Map.Entry<String, String> map : fileData.entrySet()) {
			Item item = new Item();
			try {
				item.setItemName(map.getKey());
				String getValue = map.getValue();
				String[] split = getValue.split(System.lineSeparator());
				item.setItemCode(split[1]);
				String[] splitPacks = split[2].split("=")[1].split(",");

				List<Pack> packs = new ArrayList();
				for (int i = 0; i < splitPacks.length; i++) {
					Pack pack = new Pack();
					pack.setNumberOfItemsPerPack(Integer.parseInt(splitPacks[i].split("-")[0]));
					pack.setPackAmount(Float.parseFloat(splitPacks[i].split("-")[1]));
					packs.add(pack);
				}

				item.setPacks(packs);
				daoData.put(item.getItemName(), item);
				BackeryLogger.log(Level.INFO,"Completed generating file contents as POJO objects ");

			} catch (BackeryException e) {
				BackeryLogger.log(Level.ERROR, "Unable to generate backery inventory as objects " + e.getMessage());
			}
		}
		return daoData;
	}
}

package org.backery.dao;

import java.util.Map;

import org.backery.common.BackeryException;
import org.backery.entity.Item;
import org.backery.utils.ReadDataFromPropertiesFile;

/**
 * Implementation file for the DataSource.properties file.
 * @author esxxbhs
 *
 */
public class DataImplementation implements DataSourceService {

	public Map<String, Item> getAllData() throws BackeryException {

		ReadDataFromPropertiesFile readData = new ReadDataFromPropertiesFile();
		readData.getPropertiesFileData();
		//Returns the file contents as POJO objects
		Map<String, Item> inventoryItemsAsObject = readData.getAllItemsAsObject();
		return inventoryItemsAsObject;
	}

}

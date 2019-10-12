package org.backery.utils;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.backery.entity.Item;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class TestReadDataFromPropertiesFile {

	public static String PROPERTIES_FILE_URL = "src/main/resources/dataSource.properties";
	public static String UNAVAILABLE_FILE_URL = "src/main/resources/dataSource1.properties";
	
	ReadDataFromPropertiesFile pf = Mockito.mock(ReadDataFromPropertiesFile.class);
	Map<String,Item> daoData = Mockito.mock(HashMap.class);
	Map<String, String> fileData = Mockito.mock(HashMap.class);
	
	@Before
	public void init() {
		fileData.put("CF", "value");
	}
	
	@Test
	public void testIsPropertiesFileExist() {
		File filePath = new File(PROPERTIES_FILE_URL);
		assertTrue(filePath.exists());
	}
	
	@Test(expected = AssertionError.class)
	public void testIsPropertiesFileNotExist() {
		File filePath = new File(UNAVAILABLE_FILE_URL);
		assertTrue(filePath.exists());
	}
	
	@Test
	public void testGetAllItemsAsObject() {
		when(pf.getAllItemsAsObject()).thenReturn(daoData);
		assertTrue(!daoData.isEmpty());
	}
	
	@Test
	public void testGetObjects() {
		when(pf.fileData).thenReturn(fileData);
		assertTrue(!fileData.isEmpty());
	}
	
}

package org.backery.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.backery.entity.BackeryException;
import org.backery.entity.Item;
import org.backery.entity.Pack;

public class DataImplementation implements DataSourceService{
	
	public DataImplementation() {
		//Read the file and keep the contents in memory.
		loadData();
	}

	private void loadData() {
		try {
			FileReader reader=new FileReader("src/main/resources/dataSource.properties");
			Properties p=new Properties();  
			 p.load(reader);  
			 
			 Set<Object> keys = p.keySet();
			 
		        for(Object k:keys){
		            String key = (String)k;
		            //System.out.println(key+": "+ p.getProperty(key));
		        }
			 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}  
	}

	public Map<String,List<Item>> getAllData() throws BackeryException {
		
		Map<String,List<Item>> daoData = new LinkedHashMap();
		
		List<Item> itemsList = new LinkedList();
		List<Pack> packsList = new LinkedList();
		
		Pack bm = new Pack();
		bm.setNumberOfItemsPerPack(2);
		bm.setPackAmount(9.95f);
		packsList.add(bm);
		
		Pack bm1 = new Pack();
		bm1.setNumberOfItemsPerPack(5);
		bm1.setPackAmount(16.95f);
		bm1.setIndividualItemPrice(bm1.getPackAmount()/bm1.getNumberOfItemsPerPack());
		packsList.add(bm1);
		
		Pack bm2 = new Pack();
		bm2.setNumberOfItemsPerPack(8);
		bm2.setPackAmount(24.95f);
		bm2.setIndividualItemPrice(bm2.getPackAmount()/bm2.getNumberOfItemsPerPack());
		packsList.add(bm2);
		
		Item item2 = new Item();
		item2.setItemName("Blueberry Muffin");
		item2.setItemCode("MB11");
		item2.setPacks(packsList);
		
		
		itemsList.add(item2);
		
		daoData.put("Blueberry Muffin",itemsList);
		
		return daoData;
	}

}

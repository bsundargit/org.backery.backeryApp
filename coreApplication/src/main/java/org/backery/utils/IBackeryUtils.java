package org.backery.utils;

import java.util.Map;

import org.backery.entity.Item;

public interface IBackeryUtils {

	public Map<String, String> getItemName(Map<String, String> aInDataMap);

	public String processInput(Map<String, Item> receivedList, String inputItem, int input, Map<Integer, Integer> data);
}

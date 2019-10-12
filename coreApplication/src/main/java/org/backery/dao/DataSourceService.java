package org.backery.dao;

import java.util.List;
import java.util.Map;

import org.backery.entity.BackeryException;
import org.backery.entity.Item;

public interface DataSourceService {
	public Map<String, Item> getAllData() throws BackeryException;
}

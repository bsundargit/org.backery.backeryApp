package org.backery.dao;

import java.util.List;
import java.util.Map;

import org.backery.entity.BackeryException;
import org.backery.entity.Item;
import org.backery.entity.Pack;

public interface DataSourceService {
	public Map<String,List<Item>> getAllData() throws BackeryException;
}

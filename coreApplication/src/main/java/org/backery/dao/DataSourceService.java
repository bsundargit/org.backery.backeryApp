package org.backery.dao;

import java.util.Map;

import org.backery.common.BackeryException;
import org.backery.entity.Item;

/**
 * Interface file for DB ( dataSource.properties )
 * 
 * @author esxxbhs
 *
 */
public interface DataSourceService {
	public Map<String, Item> getAllData() throws BackeryException;
}

package org.backery.entity;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Level;
import org.backery.common.BackeryException;
import org.backery.common.BackeryLogger;
import org.junit.Before;
import org.junit.Test;

public class TestItem {

	Item item;
	List<Pack> packs = new ArrayList();

	@Before
	public void setup() {
		item = new Item();
	}

	@Test
	public void testCreateItem() {
		try {

			item.setItemName("Vegemite Scroll");
			item.setItemCode("VS5");

			Pack pack1 = new Pack();
			pack1.setNumberOfItemsPerPack(10);
			pack1.setPackAmount(10);

			Pack pack2 = new Pack();
			pack2.setNumberOfItemsPerPack(12);
			pack2.setPackAmount(90);

			packs.add(pack1);
			packs.add(pack2);
			item.setPacks(packs);

			assertNotNull(item);

		} catch (BackeryException e) {
			BackeryLogger.log(Level.ERROR, "Unable to create item " + e);
		}
	}

	@Test(expected = BackeryException.class)
	public void testItemName() throws BackeryException {
		item.setItemName("");
		assertNotNull(item);
	}

	@Test(expected = BackeryException.class)
	public void testItemCode() throws BackeryException {
		item.setItemCode("");
		assertNotNull(item);
	}

	@Test(expected = BackeryException.class)
	public void testPackSize() throws BackeryException {
		List<Pack> packs = new ArrayList();
		item.setPacks(packs);
		assertTrue(packs.size() == 0);
	}

	@Test
	public void testPackContents() {
		List<Pack> packs = new ArrayList();
		Pack pack1 = new Pack();
		try {
			pack1.setNumberOfItemsPerPack(10);
			pack1.setPackAmount(10);
			packs.add(pack1);
			item.setPacks(packs);
			assertTrue(packs.size() != 0);
		} catch (BackeryException e) {
			BackeryLogger.log(Level.ERROR, "Invalid input " + e);
		}
	}
}

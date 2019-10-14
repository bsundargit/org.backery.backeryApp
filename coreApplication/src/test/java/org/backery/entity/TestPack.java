package org.backery.entity;

import org.backery.common.BackeryException;
import org.junit.Before;
import org.junit.Test;

public class TestPack {

	Pack newPack;

	@Before
	public void setUp() {
		newPack = new Pack();
	}

	@Test(expected = BackeryException.class)
	public void testSetNumberOfItemsPerPack() throws BackeryException {
		newPack.setNumberOfItemsPerPack(0);
	}

	@Test(expected = BackeryException.class)
	public void testSetAmountPerPack() throws BackeryException {
		newPack.setPackAmount(0);
	}
}

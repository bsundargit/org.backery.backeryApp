package org.backery.entity;

import org.backery.common.BackeryException;
import org.junit.Test;

public class TestPack {

	Pack newPack = new Pack();
	
	@Test(expected = BackeryException.class)
	public void setNumberOfItemsPerPack() throws BackeryException {
		newPack.setNumberOfItemsPerPack(0);
	}
}

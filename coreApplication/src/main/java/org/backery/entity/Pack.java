package org.backery.entity;

import org.backery.common.BackeryException;

/**
 * Pack Class which contains the Pack Quantity/Size and its amount.
 * 
 * @author esxxbhs
 *
 */
public class Pack {

	int numberOfItemsPerPack;
	float packAmount;

	public int getNumberOfItemsPerPack() {
		return numberOfItemsPerPack;
	}

	public void setNumberOfItemsPerPack(int numberOfItemsPerPack) throws BackeryException {
		if (numberOfItemsPerPack == 0)
			throw new BackeryException("Number of Items cannot be zero");
		this.numberOfItemsPerPack = numberOfItemsPerPack;
	}

	public float getPackAmount() {
		return packAmount;
	}

	public void setPackAmount(float packAmount) throws BackeryException {
		if (packAmount == 0.00f)
			throw new BackeryException("Amount cannot be zero ");
		this.packAmount = packAmount;
	}
}

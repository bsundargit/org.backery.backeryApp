package org.backery.entity;

public class Pack {

	int numberOfItemsPerPack;
	float packAmount;
	float individualItemPrice = 0.0f;

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

	public float getIndividualItemPrice() {
		return individualItemPrice;
	}

	public void setIndividualItemPrice(float individualItemPrice) {
		this.individualItemPrice = individualItemPrice;
	}	
	
}

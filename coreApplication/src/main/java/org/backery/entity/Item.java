package org.backery.entity;

import java.util.List;

public class Item {

	public String itemName;
	public String itemCode;
	public List<Pack> packs;
	
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) throws BackeryException {
		if(itemName.isEmpty()) 
			throw new BackeryException("ItemName cannot be blank");
		this.itemName = itemName;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) throws BackeryException {
		if(itemCode.isEmpty())
			throw new BackeryException("ItemCode cannot be left blank");
		this.itemCode = itemCode;
	}
	public List<Pack> getPacks() {
		return packs;
	}
	public void setPacks(List<Pack> packs) {
		this.packs = packs;
	}
}

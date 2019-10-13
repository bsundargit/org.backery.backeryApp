package org.backery.common;

/**
 * Custom class for Bakery Exception
 * 
 * @author esxxbhs
 *
 */
public class BackeryException extends Exception {

	String data;

	public BackeryException(String data1) {
		this.data = data1;
	}

	@Override
	public String toString() {
		return data;
	}
}

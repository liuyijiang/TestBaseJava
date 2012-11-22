package org.basejava.clas;

import java.math.BigDecimal;

public class TestBig {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigDecimal b = new BigDecimal(12.23);
		BigDecimal c = new BigDecimal(0.45);
		BigDecimal d = b.multiply(c).setScale(2,BigDecimal.ROUND_HALF_UP);
		System.out.println(d);
		
		
	}

}

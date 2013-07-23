package org.basejava.emun;

public class TestEmunSwitch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		UserType type = UserType.ADMIN;
		switch (type) {
		   case ADMIN:
		   System.out.println(1);
		   break;
		   case USER:
		   System.out.println(1);
		   break;
		}
        System.out.println(UserType.USER);
        System.out.println(CataLogStatType.FINISHED.getString());
	}

}

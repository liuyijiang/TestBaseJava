package org.basejava.emun;

public enum OrderByEnumType {

	//���ݼ���������
		ASC() {
			@Override
			public String getOrderbyTypeString() {
				return "SSS";
			}
		} ,
		//���ݼ���������
		DESC() {
			public String getOrderbyTypeString() {
				return "DESC";
			}
		};
		public abstract String getOrderbyTypeString();
	
}

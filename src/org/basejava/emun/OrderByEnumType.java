package org.basejava.emun;

public enum OrderByEnumType {

	//数据集升序排序
		ASC() {
			@Override
			public String getOrderbyTypeString() {
				return "SSS";
			}
		} ,
		//数据集降序排序
		DESC() {
			public String getOrderbyTypeString() {
				return "DESC";
			}
		};
		public abstract String getOrderbyTypeString();
	
}

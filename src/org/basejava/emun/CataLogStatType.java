package org.basejava.emun;

public enum CataLogStatType {
	FINISHED(){
		public String getString() {
			return "已完成编目";
		}
	},UNFINISHED(){
		public String getString() {
			return "未完成编目";
		}
	},PROBLEM(){
		public String getString() {
			return "编目有问题";
		}
	},CANCEL(){
		public String getString() {
			return "取消编目";
		}
	},SKIP(){
		public String getString() {
			return "跳过编目";
		}
	},IGNORE(){
		public String getString() {
			return "忽略编目";
		}
	};
	public abstract String getString();
}

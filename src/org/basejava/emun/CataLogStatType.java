package org.basejava.emun;

public enum CataLogStatType {
	FINISHED(){
		public String getString() {
			return "����ɱ�Ŀ";
		}
	},UNFINISHED(){
		public String getString() {
			return "δ��ɱ�Ŀ";
		}
	},PROBLEM(){
		public String getString() {
			return "��Ŀ������";
		}
	},CANCEL(){
		public String getString() {
			return "ȡ����Ŀ";
		}
	},SKIP(){
		public String getString() {
			return "������Ŀ";
		}
	},IGNORE(){
		public String getString() {
			return "���Ա�Ŀ";
		}
	};
	public abstract String getString();
}

package com.epam.tgrynchuk.jewelry.mvc.models.enums;

public enum StoneTransparency {
	CLEAR(3) {
		@Override
		public String toString() {
			return "��������";
		}
	},
	SEMITRANSPARENT(2) {
		@Override
		public String toString() {
			return "������������";
		}
	},
	TRANSTLUCENT(1) {
		@Override
		public String toString() {
			return "����������� �� �����";
		}
	},
	OPAQUE(0) {
		@Override
		public String toString() {
			return "����������";
		}
	};
	
	private int index;
	
	private StoneTransparency(int index) {
		this.index = index;
		
	}

	public int getIndex() {
		return index;
	}
	
	
}
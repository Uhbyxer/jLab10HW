package com.epam.tgrynchuk.jewelry.mvc.models.enums;

public enum StoneTransparency {
	CLEAR(3) {
		@Override
		public String toString() {
			return "Прозорий";
		}
	},
	SEMITRANSPARENT(2) {
		@Override
		public String toString() {
			return "Напівпрозорий";
		}
	},
	TRANSTLUCENT(1) {
		@Override
		public String toString() {
			return "Просвічуючий по краях";
		}
	},
	OPAQUE(0) {
		@Override
		public String toString() {
			return "Непрозорий";
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
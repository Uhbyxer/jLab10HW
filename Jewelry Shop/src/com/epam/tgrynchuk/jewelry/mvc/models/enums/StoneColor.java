package com.epam.tgrynchuk.jewelry.mvc.models.enums;

public enum StoneColor {
	RED {
		@Override
		public String toString() {
			return "��������";
		}
	},
	BLUE {
		@Override
		public String toString() {
			return "���������";
		}
	},
	GREEN {
		@Override
		public String toString() {
			return "�������";
		}
	},
	COLORLESS {
		@Override
		public String toString() {
			return "����������";
		}
	},
	STRAW {
		@Override
		public String toString() {
			return "����-������";
		}
	},
	GRAY {
		@Override
		public String toString() {
			return "�i���";
		}
	}
	
}

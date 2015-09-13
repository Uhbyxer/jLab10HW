package com.epam.tgrynchuk.jewelry.mvc.models.enums;

public enum PreciousStoneCategory {
	FIRST_CATEGORY {
		@Override
		public String toString() {
			return "I порядку";
		}
	},
	SECOND_CATEGORY {
		@Override
		public String toString() {
			return "II порядку";
		}
	},
	THIRD_CATEGORY {
		@Override
		public String toString() {
			return "III порядку";
		}
	},
	FOURTH_CATEGORY {
		@Override
		public String toString() {
			return "IV порядку";
		}
	},
}

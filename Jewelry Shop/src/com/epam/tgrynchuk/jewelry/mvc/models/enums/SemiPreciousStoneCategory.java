package com.epam.tgrynchuk.jewelry.mvc.models.enums;

public enum SemiPreciousStoneCategory {
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

}

package com.epam.tgrynchuk.jewelry.mvc.models.enums;

public enum StoneColor {
	RED {
		@Override
		public String toString() {
			return "Червоний";
		}
	},
	BLUE {
		@Override
		public String toString() {
			return "Блакитний";
		}
	},
	GREEN {
		@Override
		public String toString() {
			return "Зелений";
		}
	},
	COLORLESS {
		@Override
		public String toString() {
			return "Безбарвний";
		}
	},
	STRAW {
		@Override
		public String toString() {
			return "Блідо-жовтий";
		}
	},
	GRAY {
		@Override
		public String toString() {
			return "Сiрий";
		}
	}
	
}

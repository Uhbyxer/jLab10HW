package com.epam.tgrynchuk.jewelry.mvc.models.enums;

public enum Glance {
	GLASS {
		@Override
		public String toString() {
			return "Скляний";
		}
	},
	DIAMOND {
		@Override
		public String toString() {
			return "Алмазний";
		}
	},
	SEMIMETALIC {
		@Override
		public String toString() {
			return "Напівметалічний";
		}
	},
	METALIC {
		@Override
		public String toString() {
			return "Металічний";
		}
	},
	FAT {
		@Override
		public String toString() {
			return "Масний";
		}
	},
	WAX {
		@Override
		public String toString() {
			return "Восковий";
		}
	},
	MAT {
		@Override
		public String toString() {
			return "Матовий";
		}
	}
	
}	
	
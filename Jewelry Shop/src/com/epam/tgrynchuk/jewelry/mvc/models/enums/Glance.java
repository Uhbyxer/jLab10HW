package com.epam.tgrynchuk.jewelry.mvc.models.enums;

public enum Glance {
	GLASS {
		@Override
		public String toString() {
			return "�������";
		}
	},
	DIAMOND {
		@Override
		public String toString() {
			return "��������";
		}
	},
	SEMIMETALIC {
		@Override
		public String toString() {
			return "�������������";
		}
	},
	METALIC {
		@Override
		public String toString() {
			return "���������";
		}
	},
	FAT {
		@Override
		public String toString() {
			return "������";
		}
	},
	WAX {
		@Override
		public String toString() {
			return "��������";
		}
	},
	MAT {
		@Override
		public String toString() {
			return "�������";
		}
	}
	
}	
	
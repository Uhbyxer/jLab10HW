package com.epam.tgrynchuk.jewelry.mvc.models.enums;

//�������
public enum CrystalSystem {
	TRICLINIC {
		@Override
		public String toString() {
			return "��������";
		}
	},
	MONOCLINIC {
		@Override
		public String toString() {
			return "���������";
		}
	},
	RHOMBIC {
		@Override
		public String toString() {
			return "�������";
		}
	},
	TRIGONAL {
		@Override
		public String toString() {
			return "�����������";
		}
	},
	TETRAGONAL {
		@Override
		public String toString() {
			return "�������������";
		}
	},
	HEXAGONAL {
		@Override
		public String toString() {
			return "�������������";
		}
	},
	CUBIC {
		@Override
		public String toString() {
			return "������";
		}
	}
}

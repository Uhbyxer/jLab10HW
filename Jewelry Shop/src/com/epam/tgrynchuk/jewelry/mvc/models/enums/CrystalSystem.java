package com.epam.tgrynchuk.jewelry.mvc.models.enums;

//сингонія
public enum CrystalSystem {
	TRICLINIC {
		@Override
		public String toString() {
			return "Триклінна";
		}
	},
	MONOCLINIC {
		@Override
		public String toString() {
			return "Моноклінна";
		}
	},
	RHOMBIC {
		@Override
		public String toString() {
			return "Ромбічна";
		}
	},
	TRIGONAL {
		@Override
		public String toString() {
			return "Тригональна";
		}
	},
	TETRAGONAL {
		@Override
		public String toString() {
			return "Тетрагональна";
		}
	},
	HEXAGONAL {
		@Override
		public String toString() {
			return "Гексагональна";
		}
	},
	CUBIC {
		@Override
		public String toString() {
			return "Кубічна";
		}
	}
}

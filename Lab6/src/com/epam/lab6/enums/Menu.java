package com.epam.lab6.enums;

public enum Menu {
	EXIT("exit: Exit the game") {
		
		@Override
		public void select() {
			System.out.println("Bye-bye...");
			System.exit(1);
		}
	},
	
	ONE("one: One player game") {
		
		@Override
		public void select() {
			System.out.println("You wil play a single player game!");
		}
		
	},
	
	TWO("two: Two players game") {

		@Override
		public void select() {
			System.out.println("You wil play a multi player game!");
		}
		
	};
	
	private String name;
	
	private Menu(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "\t" + name;
	}
	
	public abstract void select();
}

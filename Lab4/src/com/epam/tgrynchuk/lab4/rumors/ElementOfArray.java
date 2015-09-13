package com.epam.tgrynchuk.lab4.rumors;

public class ElementOfArray implements Comparable<ElementOfArray> {
	Integer value, index;

	public Integer getValue() {
		return value;
	}

	public Integer getIndex() {
		return index;
	}

	public ElementOfArray(Integer index, Integer value) {
		super();
		this.value = value;
		this.index = index;
	}

	@Override
	public int compareTo(ElementOfArray other) {
		return other.getValue().compareTo(getValue());
	}
	
}

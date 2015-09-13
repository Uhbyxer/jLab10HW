package com.epam.lab6.deque;

import java.util.Iterator;

public class Deque implements Iterable<Integer> {
	private int size;
	private Entry entry;
	
	private class Entry {
		
		private int value;
		private Entry head, tail;
		
		public Entry(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}
	}
	
	public Deque() {
		entry = new Entry(0);
		entry.head = entry;
		entry.tail = entry;
		size = 0;
	}
	
	public int size() {
		return size;
	}
	
	public void addLast(int value) {
		size++;
		//���
		Entry last = new Entry(value);
		//�������� 
		Entry prevLast = entry.tail;
		
		//������ � ��� �� entry
		last.head = entry;
		//� ��� �� ��������
		last.tail = prevLast;
		//� �������� �� ���
		prevLast.head = last;
		//� ���� �� ���
		entry.tail = last;
	}
	
	public void addFirst(int value) {
		size++;
		//������
		Entry first = new Entry(value);
		//������
		Entry nextFirst = entry.head;
		
		//������ � ������� �� ����
		first.tail = entry;
		//� ������� �� ������
		first.head = nextFirst;
		//� ������� �� ������
		nextFirst.tail = first;
		//� ���� �� ������
		entry.head = first;
		
	}	
	
	public Integer removeLast() {
		if(size == 0) return null;

		//���
		Entry last = entry.tail;
		Entry prevLast = last.tail;
		
		//������ � �������� �� entry
		prevLast.head = entry;
		//� ���� �� ��������
		entry.tail = prevLast;
		
		size--;
		return last.getValue();
	}
	
	public Integer removeFirst() {
		if(size == 0) return null;

		//����
		Entry first = entry.head;
		Entry nextFirst = first.head;
		
		//������ � ������� �� entry
		nextFirst.tail = entry;
		//� ���� �� ������
		entry.head = nextFirst;
		
		size--;
		return first.getValue();
	}	
	
	@Override
	public Iterator<Integer> iterator() {
		return new Iterator<Integer>() {
			
			Entry current = entry;

			@Override
			public boolean hasNext() {
				return current.head != entry;
			}

			@Override
			public Integer next() {
				current = current.head;
				
				return current.getValue();
			}
			
		};
	}
}

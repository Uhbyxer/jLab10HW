package com.epam.lab8.cmd;

import java.io.File;

public class MyFile extends File implements Comparable<File>{

	public MyFile(String pathname) {
		super(pathname);
	}

	@Override
	public String toString() {
		String res = "";
		if(isDirectory()) {
			res = "[" + getName().toUpperCase()+ "]";
		}else if(isFile()) {
			res = getName().toLowerCase();
		}else res = getName();
		
		if(isHidden()) res += " <HIDDEN>";
		
		return res;
	}
	
	@Override
	public int compareTo(File pathname) {
		int res = -((Boolean) isDirectory()).compareTo(pathname.isDirectory());
		if(res == 0) {
			res = getName().compareTo(pathname.getName());
		}
		return res;
	}
	
	
}

package com.epam.lab8.cmd;

import java.io.File;
import java.util.Collections;

public class Cmd {
	
	public static void main(String[] args) {
		File file = new File("\\"); 
		
		for(;;) {
			System.out.println(file.getAbsolutePath() + " -->");
			String com = ScannerSigleton.readString();
			if("exit".equals(com)) {
				break;
			} else if("dir".equals(com)) {
				MyFiles files = new MyFiles();
				
				for(String f: file.list()) {
					files.add(new MyFile(file.getAbsolutePath() + f));
				}
				Collections.sort(files);
				
				for(MyFile f: files) {
					System.out.println(f);
				}
			} else {
				
				try {
					String[] a = com.split(";");
					if("cd".equals(a[0])) {
						
						if("..".equals(a[1])) {
							String parent = file.getParentFile().getAbsolutePath();
							file = new File(parent);
							
							continue;
						} 
						
						if(!new File(file.getAbsolutePath() + a[1]).exists())
							throw new Exception("Invalid filename !");
						
						file = new File(file.getAbsolutePath() + a[1]);
						 
					}
				} catch(Exception e) {
					System.out.println("Wrong command !");
				}
			}
				
		}
		
	}
	
	
	
}

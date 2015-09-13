package com.epam.lab8.pushbackcomments;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PushbackInputStream;
import java.io.PushbackReader;
import java.util.concurrent.TimeUnit;

public class CommentReader {

	public static final String FILENAME = "BattleController.java";
	
	public static void main(String[] args) {
		
		char[] buf = new char[1];
		char[] bufSec = new char[2];
		
		boolean oneRowCommentStarts =  false;
		boolean fewRowCommentStarts =  false;
		char firstChar = (char) 0, secondChar = (char) 0;
		String comment = "";
		
		
		try(PushbackReader in = new PushbackReader(new FileReader(FILENAME),2)) {
			
			
			
			int end = 0;
			while((end = in.read(buf)) != -1) {
				in.unread(buf);
				//System.out.println(buf[0]);
				
				int res = in.read(bufSec);
				
				in.unread(bufSec);
				in.read(buf);
				
	
				
				if(oneRowCommentStarts) {
					if(bufSec[1] == '\n') {
						oneRowCommentStarts = false;
						System.out.println(comment);
						comment = "";
					}
					else comment += buf[0];
				} else if(fewRowCommentStarts) {
					if(buf[0] == '*' && bufSec[1] == '/') {
						fewRowCommentStarts = false;
						comment += "*/";
						System.out.println(comment);
						comment = "";
					} else comment += buf[0];
				} else if(buf[0] == '/' && bufSec[1] == '/') {
					oneRowCommentStarts = true;
					comment += buf[0];
					
				} else if(buf[0] == '/' && bufSec[1] == '*') {
					fewRowCommentStarts = true;
					comment += buf[0];
				}
				
				if(end==-1) break;

			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		

	}

}

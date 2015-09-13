package com.epam.tgrynchuk.jdbcdemo.pipes;


import java.io.OutputStreamWriter;
import java.io.PipedReader;
import java.io.PipedWriter;

public class Consumer implements Runnable {
    private final PipedReader in;
    private final OutputStreamWriter out;
    public static final int BUFFER_SIZE = 16;

    public Consumer( PipedReader pi, OutputStreamWriter toFile ){
        this.out = toFile;
        this.in = pi;
    }

    @Override
    public void run(){
        char[] buffer = new char[BUFFER_SIZE];
        
		try {

//			for (int charsRead; -1 != (charsRead = in.read(buffer, 0, BUFFER_SIZE));) {
//				out.write(buffer, 0, charsRead);
//			}
			
			
			int item;
			while ((item = in.read()) != -1) {
				out.write(item);
			}
			

		} catch (Exception e) {
			
		}

	}
}

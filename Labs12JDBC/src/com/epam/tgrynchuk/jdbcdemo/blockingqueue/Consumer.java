package com.epam.tgrynchuk.jdbcdemo.blockingqueue;




import java.util.concurrent.BlockingQueue;

import com.epam.tgrynchuk.jdbcdemo.model.Group;

public class Consumer implements Runnable {
    private final BlockingQueue<Group> in;

    
    private int max;
    private int count = 0;

    public Consumer(BlockingQueue<Group> in, int max){
        
        this.in = in;
        this.max = max;
    }

    @Override
    public void run(){
    	
    	while(count < max) {
			try {
				System.out.println(in.take());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			count++;
    	}
    	
    }
}

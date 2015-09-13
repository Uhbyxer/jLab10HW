package com.epam.tgrynchuk.jdbcdemo.blockingqueue;


import java.util.List;
import java.util.concurrent.BlockingQueue;

import com.epam.tgrynchuk.jdbcdemo.model.Group;

public class Producer implements Runnable {
	private final BlockingQueue<Group> out;
    private final List<Group> list;

    public Producer(BlockingQueue<Group> out, List<Group> list ){
        this.out = out;
        this.list = list;
    }

    @Override
	public void run() {

		try {
			for (Group g : list) {
				
				out.put(g);
			}

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}


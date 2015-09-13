package com.epam.tgrynchuk.jdbcdemo.blockingqueue;


import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


import com.epam.tgrynchuk.jdbcdemo.model.Group;

import com.epam.tgrynchuk.jdbcdemo.service.GroupService;

public class BlockingQueueDemo {

	public static void main(String[] args) throws Exception {

		System.out.println("Starts...");
		List<Group> list = GroupService.getListOfGroups();

		BlockingQueue<Group> queue = new ArrayBlockingQueue<Group>(list.size());

		ExecutorService exec = Executors.newFixedThreadPool(2);
		exec.execute(new Producer(queue, list));
		exec.execute(new Consumer(queue, list.size()));
		exec.shutdown();

	}

}

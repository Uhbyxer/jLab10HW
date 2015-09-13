package com.tgrynchuk.concurrency;

public class PingPong {
	private final int COUNT_OF_GAMES = 100;
	private volatile int currentGame = 0;
	private volatile boolean flag = true;

	public synchronized void ping() {
		if (flag) {
			currentGame++;
			System.out.println("Ping");
			flag = false;
		}
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public synchronized void pong() {
		if (!flag) {
			currentGame++;
			System.out.println("Pong");
			flag = true;
		}
		notifyAll();
	}

	public static void main(String... args)  {
		PingPong pingpong = new PingPong();
		
		new Thread(
			    () -> {
					while (pingpong.currentGame < pingpong.COUNT_OF_GAMES)
						pingpong.ping();
			    }
			).start();
		
		new Thread(
			    () -> {
					while (pingpong.currentGame < pingpong.COUNT_OF_GAMES)
						pingpong.pong();
			    }
			).start();
		

	}
}

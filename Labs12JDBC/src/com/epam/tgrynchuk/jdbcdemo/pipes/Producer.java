package com.epam.tgrynchuk.jdbcdemo.pipes;

import java.io.IOException;

import java.io.PipedWriter;
import java.util.List;

import com.epam.tgrynchuk.jdbcdemo.model.Group;

public class Producer implements Runnable {
	private final PipedWriter out;
    private final List<Group> list;

    public Producer( PipedWriter po, List<Group> list ){
        this.out = po;
        this.list = list;
    }

    @Override
	public void run() {

		try {
			for (Group g : list) {
				
				out.write (g.toString());
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

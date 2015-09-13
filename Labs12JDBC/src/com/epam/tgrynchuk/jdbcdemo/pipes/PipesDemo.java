package com.epam.tgrynchuk.jdbcdemo.pipes;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;









import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.epam.tgrynchuk.jdbcdemo.model.Group;
import com.epam.tgrynchuk.jdbcdemo.model.Student;
import com.epam.tgrynchuk.jdbcdemo.service.GroupService;
import com.epam.tgrynchuk.jdbcdemo.service.StudentService;

public class PipesDemo {

	public static void main(String[] args) throws Exception {
		
			System.out.println("Starts...");
			List<Group> list = GroupService.getListOfGroups();
			
		
			OutputStreamWriter toFile = new FileWriter("./main/java/resources/groups.txt");		
			
						
			PipedReader pi = new PipedReader();
			PipedWriter po = new PipedWriter(pi);
			
			ExecutorService exec = Executors.newFixedThreadPool(2);
			exec.execute(new Producer( po, list ));
			
			TimeUnit.MILLISECONDS.sleep(500);
			
			exec.execute(new Consumer( pi, toFile ));
			exec.shutdown();	
			
			
			TimeUnit.MILLISECONDS.sleep(1500);

			
			toFile.close();
			System.out.println(list);
			
		
	}

}

package za.proj3;



//import com.sun.corba.se.pept.transport.EventHandler;

import sun.misc.Launcher;
import javafx.application.*;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.*;

public class EventHanlerApp extends Application{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		launch(args);

	}

	@Override
	public void start(Stage stage) throws Exception {
		javafx.scene.control.Button bit = new javafx.scene.control.Button("but");
		bit.setOnAction(new DemoEventhandler());
		
		stage.setScene(new Scene(bit));
		stage.show();
		
	}

}

class DemoEventhandler implements javafx.event.EventHandler<ActionEvent> {

	@Override
	public void handle(ActionEvent e) {
		System.out.println("Handle " + e);
		
	}
	
}

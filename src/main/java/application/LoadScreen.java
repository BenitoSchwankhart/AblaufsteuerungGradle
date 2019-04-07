package application;

import java.util.Timer;
import java.util.TimerTask;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class LoadScreen {
	static Timer tm= new Timer(); 
	static Stage ilk;
	static int count;

	public static  void check() {      

	    ilk=new Stage();
	    TimerTask mission = null;

	   TimerTask gorev = new TimerTask() {
	        @Override
	        public void run() {

	            Group root = new Group();     

	            Scene scene;
	            scene = new Scene(root, 960, 540);
	            scene.setFill(Color.BLACK);
	            ilk.setScene(scene);
	            ilk.setTitle("Splash Screen"); 

	            if(count==5){
	                tm.cancel();
	                ilk.show();  
	            }
	        }
	    };
	    tm.schedule(mission, 0, 2000);
	}
	
	public static void main(String[] args) {
		check();
	}
}

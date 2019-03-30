package application;

import java.io.File;
import java.io.IOException;

public class Initialisierung {
	
	public boolean neuesProgramm() throws IOException {
	    final File f = new File(System.getProperty("java.io.tmpdir") + "/FileLock.lock");
	    if (f.exists()) {
	      System.out.println("Programm bereits initialisiert");
	      return true;
	    }
	    else {
	    f.createNewFile();
	    System.out.println("Willkommen!");
		return false;
	  }
	}
	
}

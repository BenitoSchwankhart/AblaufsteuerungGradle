package application;

import java.io.File;

public class DeleteInitialisierung {
	public static void main(String[] args) {
		final File f = new File(System.getProperty("java.io.tmpdir") + "/FileLock.lock");
	    f.delete();
	}
}

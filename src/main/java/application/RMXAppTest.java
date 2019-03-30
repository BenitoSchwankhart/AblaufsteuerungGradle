package application;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class RMXAppTest {
	public boolean isOtherInstanceRunning(String filename) {
		try {
			File f = new File(System.getProperty("java.io.tmpdir") + "/" + filename + ".lock");
			FileOutputStream fos = new FileOutputStream(f);
			FileChannel fc = fos.getChannel();
			FileLock lock = fc.tryLock();
			if (lock == null) {
				fc.close();
				fos.close();
				return true;
			}
			f.deleteOnExit();
		} catch (Exception e) {
			return false;
		}
		return false;
	}
}

package org.serversmc.serverlog.threads;

import org.serversmc.serverlog.utils.DataManager;

public class DataThread implements Runnable {

	public static Boolean running = true;
	
	public Thread thread = new Thread(this);

	public void terminate() {
		running = false;
		try {
			thread.join();
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		while (running) {
			DataManager.commit();
			try {
				Thread.sleep(1000);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

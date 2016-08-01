package org.serversmc.serverlog.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.serversmc.serverlog.interfaces.LogListener;
import org.serversmc.serverlog.threads.DataThread;

public class DataManager {
	
	public static Connection con;
	public static DataThread thread = new DataThread();
	
	public static Boolean connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/serverlog", "root", "");
			return true;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static void setupListeners() {
		for (LogListener listener : LogListener.listeners) {
			listener.setup();
		}
	}
	
	public static void commit() {
		for (LogListener listener : LogListener.listeners) {
			listener.execute();
		}
	}
	
}

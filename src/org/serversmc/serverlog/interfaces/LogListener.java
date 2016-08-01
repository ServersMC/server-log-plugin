package org.serversmc.serverlog.interfaces;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import org.bukkit.event.Listener;
import org.serversmc.serverlog.utils.DataManager;

public abstract class LogListener implements Listener {
	
	public static ArrayList<LogListener> listeners = new ArrayList<LogListener>();
	
	public PreparedStatement STMT;
	
	public LogListener() {
		listeners.add(this);
	}
	
	public abstract String getSQL();
	
	public void setup() {
		try {
			STMT = DataManager.con.prepareStatement(getSQL());
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void execute() {
		try {
			STMT.executeBatch();
		}
		catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}
	
	public PreparedStatement getPreparedStatement() {
		return STMT;
	}
	
}

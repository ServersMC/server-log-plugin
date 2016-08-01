package org.serversmc.serverlog.core;

import org.bukkit.plugin.java.JavaPlugin;
import org.serversmc.serverlog.threads.DataThread;
import org.serversmc.serverlog.utils.Console;
import org.serversmc.serverlog.utils.DataManager;
import org.serversmc.serverlog.utils.PluginUtils;

public class Main extends JavaPlugin {
	
	public static Main plugin;
	public static DataThread dataThread = new DataThread();
	
	@Override
	public void onEnable() {
		plugin = this;
		
		DataManager.connect();
		PluginUtils.registerEvents();
		DataManager.setupListeners();
		dataThread.thread.start();
		Console.info("Enabled!");
	}
	
	@Override
	public void onDisable() {
		dataThread.terminate();
		Console.info("Disabled!");
	}
	
}

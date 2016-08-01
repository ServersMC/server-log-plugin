package org.serversmc.serverlog.utils;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.serversmc.serverlog.core.Main;
import org.serversmc.serverlog.events.BlockBreak;

public class PluginUtils {

	public static void registerEvents() {
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new BlockBreak(), Main.plugin);
	}
	
}

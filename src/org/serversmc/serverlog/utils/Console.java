package org.serversmc.serverlog.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class Console {

	public static void info(String s) {
		Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "[ServerLog-Beta] " + s);
	}

	public static void warn(String s) {
		Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "[ServerLog-Beta] " + s);
	}

	public static void err(String s) {
		Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "[ServerLog-Beta] " + s);
	}
	
}

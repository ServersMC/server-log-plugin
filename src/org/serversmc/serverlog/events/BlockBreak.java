package org.serversmc.serverlog.events;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.serversmc.serverlog.interfaces.LogListener;

public class BlockBreak extends LogListener {
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onBlockBreak(BlockBreakEvent event) {
		if (event.isCancelled()) {
			return;
		}
		Block block = event.getBlock();
		Player player = event.getPlayer();

		try {
			PreparedStatement stmt = getPreparedStatement();
			stmt.setString(1, block.getWorld().getName());
			stmt.setInt(2, block.getX());
			stmt.setInt(3, block.getY());
			stmt.setInt(4, block.getZ());
			stmt.setString(5, player.getUniqueId().toString());
			stmt.setString(6, block.getType().name());
			stmt.setInt(7, block.getData());
			stmt.setString(8, player.getInventory().getItemInMainHand().getType().name());
			stmt.setInt(9, player.getInventory().getItemInMainHand().getData().getData());
			stmt.setLong(10, System.currentTimeMillis());
			stmt.addBatch();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getSQL() {
		return "INSERT INTO block_break (world, x, y, z, player, block_id, block_data, item_id, item_data, time) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	}
	
}

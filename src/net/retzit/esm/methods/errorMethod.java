package net.retzit.esm.methods;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class errorMethod {
	
	public void error(Player p, String message) {
		p.sendMessage(ChatColor.RED + message);
	}
	
}

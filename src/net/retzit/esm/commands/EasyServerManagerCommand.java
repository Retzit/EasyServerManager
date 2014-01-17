package net.retzit.esm.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.retzit.esm.Main;
import net.retzit.esm.exceptions.commandExceptions;
import net.retzit.esm.methods.errorMethod;

public class EasyServerManagerCommand implements CommandExecutor {
	
	commandExceptions exc;
	Main plugin;
	
	public void error(Player p, String message) {
		p.sendMessage(ChatColor.RED + message);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd,
			String commandLabel, String[] args) {
		Player p = (Player) sender;

		p.sendMessage("");
		p.sendMessage(ChatColor.RED
				+ "▁▂▃▄▅▆▇█"
				+ ChatColor.WHITE 
				+ " EasyServerManager "
				+ ChatColor.RED
				+ "█▇▆▅▄▃▂▁");
		p.sendMessage(ChatColor.GREEN + "Author: " 
				+ ChatColor.AQUA 
				+ "Retzit Development");
		p.sendMessage(ChatColor.GREEN + "Version: " 
				+ ChatColor.AQUA 
				+ "0.0.1-ALPHA");
		p.sendMessage(ChatColor.GREEN + "Website: " 
				+ ChatColor.AQUA 
				+ "www.retzit.net");
		p.sendMessage(ChatColor.GREEN + "Wiki: " 
				+ ChatColor.AQUA 
				+ "wiki.retzit.net/esm/");
		p.sendMessage("");
		p.sendMessage(ChatColor.GREEN + "" 
				+ "Copyright © 2014 - "
				+ ChatColor.BOLD 
				+ "Retzit Development");
		p.sendMessage("");
		return true;
	}
}

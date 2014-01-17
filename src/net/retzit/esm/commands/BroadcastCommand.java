package net.retzit.esm.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.retzit.esm.exceptions.commandExceptions;
import net.retzit.esm.methods.errorMethod;

public class BroadcastCommand implements CommandExecutor {
	
	commandExceptions exc;
	
	public void error(Player p, String message) {
		p.sendMessage(ChatColor.RED + message);
	}
	
	public void broadcast(String message) {
		Bukkit.broadcastMessage(ChatColor.RED + "[" + ChatColor.GOLD + "Broadcast" + ChatColor.RED + "] " + ChatColor.GREEN + "" + ChatColor.translateAlternateColorCodes('&', message));
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd,
			String commandLabel, String[] args) {
		Player p = (Player) sender;
        if (!(sender.hasPermission("esm.broadcast"))) {
        	error(p, commandExceptions.NO_PERM.error);
        }
        else {
			if (args.length == 0 || args == null) { 
	        	error(p, commandExceptions.WRONG_ARGS.error);
			} else if (args.length > 0) {
				String message = "";
				for (String part : args) {
				    if (message != "") message += " ";
				    message += part;
				}
				broadcast(message);
			}
			return true;
		}
		return true;
	}
}

package net.retzit.esm.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.retzit.esm.exceptions.commandExceptions;
import net.retzit.esm.methods.errorMethod;

public class GamemodeCommand implements CommandExecutor {
	
	commandExceptions exc;
	
	public void error(Player p, String message) {
		p.sendMessage(ChatColor.RED + message);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd,
			String commandLabel, String[] args) {
		Player p = (Player) sender;
        if (!(sender.hasPermission("esm.gm"))) {
        	error(p, commandExceptions.NO_PERM.error);
        }
        else {
			if (args.length == 0 || args == null) { 
	        	error(p, commandExceptions.WRONG_ARGS.error);
			} else if (args.length == 1) {
				p.performCommand("gamemode " + args[0]);
			}
			return true;
		}
		return true;
	}
}

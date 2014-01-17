package net.retzit.esm.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.retzit.esm.exceptions.commandExceptions;
import net.retzit.esm.methods.errorMethod;

public class HealCommand implements CommandExecutor {
	
	commandExceptions exc;
	
	public void error(Player p, String message) {
		p.sendMessage(ChatColor.RED + message);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd,
			String commandLabel, String[] args) {
		Player p = (Player) sender;
        if (!(sender.hasPermission("esm.heal"))) {
        	error(p, commandExceptions.NO_PERM.error);
        }
        else {
			if (args.length == 0 || args == null) { 
				p.sendMessage(ChatColor.GOLD + "You just healed yourself.");
				p.setHealth(20);
				p.setFoodLevel(20);
			} else if (args.length == 1) {
				Player toHeal = Bukkit.getPlayer(args[0]);
				if(toHeal == null || !toHeal.isOnline()) {
					error(p, commandExceptions.NOT_ONLINE.error);
				} else {
					p.sendMessage(ChatColor.GOLD + "You just healed "
					+ ChatColor.RED
					+ toHeal.getName());
					toHeal.sendMessage(ChatColor.RED 
					+ p.getName() 
					+ "" + ChatColor.GOLD 
					+ " healed you.");
					toHeal.setHealth(20);
					toHeal.setFoodLevel(20);
				}
			}
			return true;
		}
		return true;
	}
}

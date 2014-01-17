package net.retzit.esm.commands;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.retzit.esm.exceptions.commandExceptions;
import net.retzit.esm.methods.errorMethod;

public class FlyCommand implements CommandExecutor {

	commandExceptions exc;

	public void error(Player p, String message) {
		p.sendMessage(ChatColor.RED + message);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd,
			String commandLabel, String[] args) {
		Player p = (Player) sender;
        if (!(sender.hasPermission("esm.fly"))) {
        	error(p, commandExceptions.NO_PERM.error);
        }
        else {
			if (args.length == 0 || args == null) { 
				p.sendMessage(ChatColor.GOLD + "Toggled fly to for player: "
				+ ChatColor.RED
				+ sender.getName());           
				if (p.getAllowFlight() == true){
					p.setAllowFlight(false);
				}
				else if (p.getAllowFlight() == false){
					p.setAllowFlight(true);
				}
			} else if (args.length == 1) {
				Player toFly = Bukkit.getPlayer(args[0]);
				if(toFly == null || !toFly.isOnline()) {
					error(p, commandExceptions.NOT_ONLINE.error);
				} else {
					p.sendMessage(ChatColor.GOLD + "Toggled fly to for player: "
					+ ChatColor.RED
					+ toFly.getName());
					toFly.sendMessage(ChatColor.RED 
					+ p.getName() 
					+ "" + ChatColor.GOLD 
					+ " toggled fly to for player: "
					+ ChatColor.RED
					+ toFly.getName());
					if (toFly.getAllowFlight() == true){
						toFly.setAllowFlight(false);
					}
					else if (toFly.getAllowFlight() == false){
						toFly.setAllowFlight(true);
					}
				}
			}
			return true;
		}
		return true;
	}
}

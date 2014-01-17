package net.retzit.esm.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.retzit.esm.exceptions.commandExceptions;
import net.retzit.esm.methods.errorMethod;

public class VanishCommand implements CommandExecutor {
	
	commandExceptions exc;
	
	public void error(Player p, String message) {
		p.sendMessage(ChatColor.RED + message);
	}
	
	public void msg(Player p, String message) {
		p.sendMessage(ChatColor.GOLD + message);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd,
			String commandLabel, String[] args) {
		Player p = (Player) sender;
        if (!(sender.hasPermission("esm.vanish"))) {
        	error(p, commandExceptions.NO_PERM.error);
        }
        else {
			if (args.length == 0 || args == null) { 
				for (Player h : Bukkit.getServer()
						.getOnlinePlayers()) {
					h.hidePlayer(p);
				}
				msg(p, "You're now hided for other players!");
			} else if (args.length == 1) {
				Player toHide = Bukkit.getPlayer(args[0]);
				if(toHide == null || !toHide.isOnline()) {
					error(p, commandExceptions.NOT_ONLINE.error);
				} else {
					msg(p, "You just hided " + toHide);
					msg(toHide, "You're now hided for other players by " + ChatColor.GRAY + p + ChatColor.GOLD + "!");	
				}
			}
			return true;
		}
		return true;
	}
}

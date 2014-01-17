package net.retzit.esm.exceptions;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public enum commandExceptions implements Listener {
	NO_PERM("You don't have permissions to perform this command!"), NOT_ONLINE("The player you were looking for isn't online..."), WRONG_ARGS("Wrong arguments! Check out the description...");
	public String error;
	commandExceptions(String error) {
		this.error = error;
	}
}

package net.retzit.esm;

import net.retzit.esm.commands.BroadcastCommand;
import net.retzit.esm.commands.EasyServerManagerCommand;
import net.retzit.esm.commands.FeedCommand;
import net.retzit.esm.commands.FlyCommand;
import net.retzit.esm.commands.GamemodeCommand;
import net.retzit.esm.commands.HealCommand;
import net.retzit.esm.commands.VanishCommand;

import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	public final PluginDescriptionFile pdf = this.getDescription();
    
	
	@Override
	public void onEnable() {
		getLogger().info("Trying to start EasyServermanager!");
		getLogger().info("EasyServerManager succesfully started!");
		getLogger().info("Thank you for using our plugin.");
		

		getCommand("easyservermanager").setExecutor(new EasyServerManagerCommand());
		getCommand("esm").setExecutor(new EasyServerManagerCommand());
		getCommand("fly").setExecutor(new FlyCommand());
		getCommand("heal").setExecutor(new HealCommand());
		getCommand("feed").setExecutor(new FeedCommand());
		getCommand("gm").setExecutor(new GamemodeCommand());
		getCommand("vanish").setExecutor(new VanishCommand());
		getCommand("broadcast").setExecutor(new BroadcastCommand());
		getCommand("bc").setExecutor(new BroadcastCommand());
	}
	
	@Override
	public void onDisable() {
		getLogger().info("EasyServerManager succesfully stopped!");
		getLogger().info("Thank you for using our plugin.");
	}
}

package net.retzit.esm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	public static final int BUKKIT_VERSION = 2957;
	public final PluginDescriptionFile pdf = this.getDescription();
    public static YamlConfiguration LANG;
    public static File LANG_FILE;
	
	@Override
	public void onEnable() {
		getLogger().info("Trying to start EasyServermanager!");
		getLogger().info("EasyServerManager succesfully started!");
		getLogger().info("Thank you for using our plugin.");
	}
	
	@Override
	public void onDisable() {
		getLogger().info("");
	}
}

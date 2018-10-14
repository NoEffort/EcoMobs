package me.noeffort.ecomobs.util.config;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;

import me.noeffort.ecomobs.Main;

public class MobConfig implements Listener {

	private static FileConfiguration config = null;
	private static File configFile = null;
	
	//Initiating the Main class
	Main plugin;
	
	//Constructor
	public MobConfig(Main instance) {
		this.plugin = instance;
	}
	
	//Used to create and reload the config file
	public void reloadMobConfig() {
		//Checking for file
		if(configFile == null) {
			//Making new config file
			configFile = new File(plugin.getDataFolder(), "mobs.yml");
			//Checking for existence
			if(!configFile.exists()) {
				//File not found
				plugin.saveResource("mobs.yml", false);
				Bukkit.getLogger().log(Level.INFO, "Mobs.yml config file generated!");
			} else {
				//File found
				saveMobConfig();
				Bukkit.getLogger().log(Level.INFO, "Mobs.yml file found, no worries!");
			}
		}
		//Setting file
		config = YamlConfiguration.loadConfiguration(configFile);
		
		//Allowing inputs to file
		Reader defaultConfigStream = new InputStreamReader(plugin.getResource("mobs.yml"));
		if(defaultConfigStream != null) {
			YamlConfiguration defaultConfig = YamlConfiguration.loadConfiguration(defaultConfigStream);
			defaultConfig.addDefault("useDefaults", true);
			defaultConfig.addDefault("mobs.ZOMBIE", 2.0);
			defaultConfig.addDefault("mobs.ZOMBIE_VILLAGER", 2.0);
			defaultConfig.addDefault("mobs.SKELETON", 2.5);
			defaultConfig.addDefault("mobs.CREEPER", 3.0);
			defaultConfig.addDefault("mobs.SPIDER", 2.0);
			defaultConfig.addDefault("mobs.CAVE_SPIDER", 2.5);
			defaultConfig.addDefault("mobs.HUSK", 2.0);
			defaultConfig.addDefault("mobs.STRAY", 2.5);
			defaultConfig.addDefault("mobs.BLAZE", 3.0);
			defaultConfig.addDefault("mobs.ENDERMITE", 2.75);
			defaultConfig.addDefault("mobs.GHAST", 5.0);
			defaultConfig.addDefault("mobs.EVOKER", 10.0);
			defaultConfig.addDefault("mobs.VINDICATOR", 4.0);
			defaultConfig.addDefault("mobs.WITCH", 3.5);
			defaultConfig.addDefault("mobs.WITHER_SKELETON", 2.5);
			defaultConfig.addDefault("mobs.SLIME", 1.0);
			defaultConfig.addDefault("mobs.MAGMA_CUBE", 1.5);
			defaultConfig.addDefault("mobs.SILVERFISH", 2.5);
			defaultConfig.addDefault("mobs.SHULKER", 5.0);
			defaultConfig.addDefault("mobs.GUARDIAN", 3.5);
			defaultConfig.addDefault("mobs.ELDER_GUARDIAN", 25.0);
			defaultConfig.addDefault("mobs.PIG_ZOMBIE", 4.5);
			defaultConfig.addDefault("mobs.ENDERMAN", 3.0);
			defaultConfig.addDefault("mobs.ENDER_DRAGON", 175.0);
			defaultConfig.addDefault("mobs.WITHER", 200.0);
			defaultConfig.addDefault("mobs.GIANT", 500.0);
			defaultConfig.options().copyDefaults(true);
			config.setDefaults(defaultConfig);
		}
	}
	
	//Used to get the custom config file
	public FileConfiguration getMobConfig() {
		//Checking for file
		if(config == null) {
			reloadMobConfig();
		}
		//Returning the file
		return config;
	}
	
	//Used to save the custom file
	public void saveMobConfig() {
		//Checking for file
		if(config == null || configFile == null) {
			return;
		}
		//Saving file
		try {
			getMobConfig().save(configFile);
		} catch (IOException e) {
			//Error boi
			plugin.getLogger().log(Level.SEVERE, "Could not save config to " + configFile, e);
		}
	}
	
	//Saving the defaults of the file, reverting to base settings
	public void saveDefaultMobConfig() {
		//Checking for file
		if(configFile == null) {
			configFile = new File(plugin.getDataFolder(), "mobs.yml");
			plugin.saveResource("mobs.yml", false);
			Bukkit.getLogger().log(Level.INFO, "Mobs.yml config file generated!");
		}
		//Saving defaults
		if(configFile.exists()) {
			plugin.saveResource("mobs.yml", false);
		}
	}
	
	public File getMobConfigFile() {
		return configFile;
	}
	
}

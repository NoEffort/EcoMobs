package me.noeffort.ecomobs;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import me.noeffort.ecomobs.util.KillListener;
import me.noeffort.ecomobs.util.MessageUtil;
import me.noeffort.ecomobs.util.config.MobConfig;
import me.noeffort.ecomobs.Main;
import net.milkbowl.vault.economy.Economy;

public class Main extends JavaPlugin {
	
	//Making instances of the Main class
	private static Main instance;
	
	//Getting the mobConfig file
	private static MobConfig mobConfig;
	
	//Logger and economy input
	private static final Logger log = Logger.getLogger("Minecraft");
	private static Economy economy = null;
	
	@Override
	public void onEnable() {
		//Checks if Vault exists
		if(!setupEconomy()) {
			log.severe("Vault not found!");
			getServer().getPluginManager().disablePlugin(this);
			return;
		}
		
		instance = this;
		//Registering the listener
		registerListeners();
		
		mobConfig = new MobConfig(instance);
		
		mobConfig.getMobConfigFile();
		mobConfig.reloadMobConfig();
	}
	
	//Getting and loading all listeners in the program
	private void registerListeners() {
		getServer().getPluginManager().registerEvents(new KillListener(this), this);
		getServer().getPluginManager().registerEvents(new MobConfig(this), this);
	}
	
	//Setting up the economy
	private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        economy = rsp.getProvider();
        return economy != null;
    }
	
    public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args) {
    	//Checks for player
        if(!(sender instanceof Player)) {
        	sender.sendMessage(MessageUtil.translate(Messages.player));
        	return true;
        }
        
        //Sets the player
        Player player = (Player) sender;
        
        //Looks for this command
        if(command.getName().equalsIgnoreCase("reloadmobs")) {
        	//Checking for op
        	if(player.isOp()) {
        		//Reload message
				player.sendMessage(MessageUtil.translate(Messages.reload));
				
				//Checking for existance of file
				if(!mobConfig.getMobConfigFile().exists()) {
					player.sendMessage(MessageUtil.translate(Messages.missingfile));
					saveResource("mobs.yml", false);
					player.sendMessage(MessageUtil.translate(Messages.filefound));
					Bukkit.getLogger().log(Level.INFO, "Config files generated!");
					return true;
				} else {
					//Getting and reloading the config
					mobConfig.getMobConfigFile();
					mobConfig.reloadMobConfig();
				}
				return true;
			} else {
				//Invalid permissions
				player.sendMessage(MessageUtil.translate(Messages.permissions));
			}
        } else {
        	return true;
        }
		return true;
    }
    
    //Getter for the economy
    public static Economy getEconomy() {
        return economy;
    }
    
    //Getter for the Main class
    public static Main get() {
    	return instance;
    }
}

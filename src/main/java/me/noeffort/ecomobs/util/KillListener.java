package me.noeffort.ecomobs.util;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import me.noeffort.ecomobs.Main;
import me.noeffort.ecomobs.Messages;
import me.noeffort.ecomobs.util.config.MobConfig;
import net.milkbowl.vault.economy.Economy;

public class KillListener implements Listener {

	Main plugin;
	
	//Constructor
	public KillListener(Main instance) {
		this.plugin = instance;
	}
	
	Economy economy;
	MobConfig mobConfig;
	
	public void depositMoney(Player player, MobConfig config, EntityType type) {
		economy.depositPlayer(player, config.getMobConfig().getDouble("mobs." + type));
	}
	
	public String getDeposited(EntityType type) {
		Double deposited = mobConfig.getMobConfig().getDouble("mobs." + type);
		return "$" + deposited;
	}
	
	@EventHandler
	public void onMobDeath(EntityDeathEvent event) {
		
		mobConfig = new MobConfig(plugin);

		if(event.getEntity().getKiller() != null) {
			Player killer = event.getEntity().getKiller();
			economy = Main.getEconomy();
			if(!economy.hasAccount(killer)) {
				economy.createPlayerAccount(killer);
			} else {
				switch(event.getEntity().getType()) {
				case ZOMBIE:
					if(mobConfig.getMobConfig().getBoolean("useDefaults")) {
						if(true) {
							economy.depositPlayer(killer, 2.0);
							killer.sendMessage(MessageUtil.translate(Messages.reward + "$2.0"));
						}
					} else {
						depositMoney(killer, mobConfig, EntityType.ZOMBIE);
						killer.sendMessage(MessageUtil.translate(Messages.reward + getDeposited(EntityType.ZOMBIE)));
					}
					break;
				case ZOMBIE_VILLAGER:
					if(mobConfig.getMobConfig().getBoolean("useDefaults")) {
						if(true) {
							economy.depositPlayer(killer, 2.0);
							killer.sendMessage(MessageUtil.translate(Messages.reward + "$2.0"));
						}
					} else {
						depositMoney(killer, mobConfig, EntityType.ZOMBIE_VILLAGER);
						killer.sendMessage(MessageUtil.translate(Messages.reward + getDeposited(EntityType.ZOMBIE_VILLAGER)));
					}
					break;
				case SKELETON:
					if(mobConfig.getMobConfig().getBoolean("useDefaults")) {
						if(true) {
							economy.depositPlayer(killer, 2.5);
							killer.sendMessage(MessageUtil.translate(Messages.reward + "$2.5"));
						}
					} else {
						depositMoney(killer, mobConfig, EntityType.SKELETON);
						killer.sendMessage(MessageUtil.translate(Messages.reward + getDeposited(EntityType.SKELETON)));
					}
					break;
				case CREEPER:
					if(mobConfig.getMobConfig().getBoolean("useDefaults")) {
						if(true) {
							economy.depositPlayer(killer, 3.0);
							killer.sendMessage(MessageUtil.translate(Messages.reward + "$3.0"));
						}
					} else {
						depositMoney(killer, mobConfig, EntityType.CREEPER);
						killer.sendMessage(MessageUtil.translate(Messages.reward + getDeposited(EntityType.CREEPER)));
					}
					break;
				case SPIDER:
					if(mobConfig.getMobConfig().getBoolean("useDefaults")) {
						if(true) {
							economy.depositPlayer(killer, 2.0);
							killer.sendMessage(MessageUtil.translate(Messages.reward + "$2.0"));
						}
					} else {
						depositMoney(killer, mobConfig, EntityType.SPIDER);
						killer.sendMessage(MessageUtil.translate(Messages.reward + getDeposited(EntityType.SPIDER)));
					}
					break;
				case CAVE_SPIDER:
					if(mobConfig.getMobConfig().getBoolean("useDefaults")) {
						if(true) {
							economy.depositPlayer(killer, 2.5);
							killer.sendMessage(MessageUtil.translate(Messages.reward + "$2.5"));
						}
					} else {
						depositMoney(killer, mobConfig, EntityType.CAVE_SPIDER);
						killer.sendMessage(MessageUtil.translate(Messages.reward + getDeposited(EntityType.CAVE_SPIDER)));
					}
					break;
				case HUSK:
					if(mobConfig.getMobConfig().getBoolean("useDefaults")) {
						if(true) {
							economy.depositPlayer(killer, 2.0);
							killer.sendMessage(MessageUtil.translate(Messages.reward + "$2.0"));
						}
					} else {
						depositMoney(killer, mobConfig, EntityType.HUSK);
						killer.sendMessage(MessageUtil.translate(Messages.reward + getDeposited(EntityType.HUSK)));
					}
					break;
				case STRAY:
					if(mobConfig.getMobConfig().getBoolean("useDefaults")) {
						if(true) {
							economy.depositPlayer(killer, 2.5);
							killer.sendMessage(MessageUtil.translate(Messages.reward + "$2.5"));
						}
					} else {
						depositMoney(killer, mobConfig, EntityType.STRAY);
						killer.sendMessage(MessageUtil.translate(Messages.reward + getDeposited(EntityType.STRAY)));
					}
					break;
				case BLAZE:
					if(mobConfig.getMobConfig().getBoolean("useDefaults")) {
						if(true) {
							economy.depositPlayer(killer, 3.0);
							killer.sendMessage(MessageUtil.translate(Messages.reward + "$3.0"));
						}
					} else {
						depositMoney(killer, mobConfig, EntityType.BLAZE);
						killer.sendMessage(MessageUtil.translate(Messages.reward + getDeposited(EntityType.BLAZE)));
					}
					break;
				case ENDERMITE:
					if(mobConfig.getMobConfig().getBoolean("useDefaults")) {
						if(true) {
							economy.depositPlayer(killer, 2.75);
							killer.sendMessage(MessageUtil.translate(Messages.reward + "$2.75"));
						}
					} else {
						depositMoney(killer, mobConfig, EntityType.ENDERMITE);
						killer.sendMessage(MessageUtil.translate(Messages.reward + getDeposited(EntityType.ENDERMITE)));
					}
					break;
				case GHAST:
					if(mobConfig.getMobConfig().getBoolean("useDefaults")) {
						if(true) {
							economy.depositPlayer(killer, 5.0);
							killer.sendMessage(MessageUtil.translate(Messages.reward + "$5.0"));
						}
					} else {
						depositMoney(killer, mobConfig, EntityType.GHAST);
						killer.sendMessage(MessageUtil.translate(Messages.reward + getDeposited(EntityType.GHAST)));
					}
					break;	
				case EVOKER:
					if(mobConfig.getMobConfig().getBoolean("useDefaults")) {
						if(true) {
							economy.depositPlayer(killer, 10.0);
							killer.sendMessage(MessageUtil.translate(Messages.reward + "$10.0"));
						}
					} else {
						depositMoney(killer, mobConfig, EntityType.EVOKER);
						killer.sendMessage(MessageUtil.translate(Messages.reward + getDeposited(EntityType.EVOKER)));
					}
					break;
				case VINDICATOR:
					if(mobConfig.getMobConfig().getBoolean("useDefaults")) {
						if(true) {
							economy.depositPlayer(killer, 4.0);
							killer.sendMessage(MessageUtil.translate(Messages.reward + "$4.0"));
						}
					} else {
						depositMoney(killer, mobConfig, EntityType.VINDICATOR);
						killer.sendMessage(MessageUtil.translate(Messages.reward + getDeposited(EntityType.VINDICATOR)));
					}
					break;
				case WITCH:
					if(mobConfig.getMobConfig().getBoolean("useDefaults")) {
						if(true) {
							economy.depositPlayer(killer, 3.5);
							killer.sendMessage(MessageUtil.translate(Messages.reward + "$3.5"));
						}
					} else {
						depositMoney(killer, mobConfig, EntityType.WITCH);
						killer.sendMessage(MessageUtil.translate(Messages.reward + getDeposited(EntityType.WITCH)));
					}
					break;
				case WITHER_SKELETON:
					if(mobConfig.getMobConfig().getBoolean("useDefaults")) {
						if(true) {
							economy.depositPlayer(killer, 2.5);
							killer.sendMessage(MessageUtil.translate(Messages.reward + "$2.5"));
						}
					} else {
						depositMoney(killer, mobConfig, EntityType.WITHER_SKELETON);
						killer.sendMessage(MessageUtil.translate(Messages.reward + getDeposited(EntityType.WITHER_SKELETON)));
					}
					break;
				case SLIME:
					if(mobConfig.getMobConfig().getBoolean("useDefaults")) {
						if(true) {
							economy.depositPlayer(killer, 1.0);
							killer.sendMessage(MessageUtil.translate(Messages.reward + "$1.0"));
						}
					} else {
						depositMoney(killer, mobConfig, EntityType.SLIME);
						killer.sendMessage(MessageUtil.translate(Messages.reward + getDeposited(EntityType.SLIME)));
					}
					break;
				case MAGMA_CUBE:
					if(mobConfig.getMobConfig().getBoolean("useDefaults")) {
						if(true) {
							economy.depositPlayer(killer, 1.5);
							killer.sendMessage(MessageUtil.translate(Messages.reward + "$1.5"));
						}
					} else {
						depositMoney(killer, mobConfig, EntityType.MAGMA_CUBE);
						killer.sendMessage(MessageUtil.translate(Messages.reward + getDeposited(EntityType.MAGMA_CUBE)));
					}
					break;
				case SILVERFISH:
					if(mobConfig.getMobConfig().getBoolean("useDefaults")) {
						if(true) {
							economy.depositPlayer(killer, 2.5);
							killer.sendMessage(MessageUtil.translate(Messages.reward + "$2.5"));
						}
					} else {
						depositMoney(killer, mobConfig, EntityType.SILVERFISH);
						killer.sendMessage(MessageUtil.translate(Messages.reward + getDeposited(EntityType.SILVERFISH)));
					}
					break;	
				case SHULKER:
					if(mobConfig.getMobConfig().getBoolean("useDefaults")) {
						if(true) {
							economy.depositPlayer(killer, 5.0);
							killer.sendMessage(MessageUtil.translate(Messages.reward + "$5.0"));
						}
					} else {
						depositMoney(killer, mobConfig, EntityType.SHULKER);
						killer.sendMessage(MessageUtil.translate(Messages.reward + getDeposited(EntityType.SHULKER)));
					}
					break;	
				case GUARDIAN:
					if(mobConfig.getMobConfig().getBoolean("useDefaults")) {
						if(true) {
							economy.depositPlayer(killer, 3.5);
							killer.sendMessage(MessageUtil.translate(Messages.reward + "$3.5"));
						}
					} else {
						depositMoney(killer, mobConfig, EntityType.GUARDIAN);
						killer.sendMessage(MessageUtil.translate(Messages.reward + getDeposited(EntityType.GUARDIAN)));
					}
					break;	
				case ELDER_GUARDIAN:
					if(mobConfig.getMobConfig().getBoolean("useDefaults")) {
						if(true) {
							economy.depositPlayer(killer, 25.0);
							killer.sendMessage(MessageUtil.translate(Messages.reward + "$25.0"));
						}
					} else {
						depositMoney(killer, mobConfig, EntityType.ELDER_GUARDIAN);
						killer.sendMessage(MessageUtil.translate(Messages.reward + getDeposited(EntityType.ELDER_GUARDIAN)));
					}
					break;
				case PIG_ZOMBIE:
					if(mobConfig.getMobConfig().getBoolean("useDefaults")) {
						if(true) {
							economy.depositPlayer(killer, 4.5);
							killer.sendMessage(MessageUtil.translate(Messages.reward + "$4.5"));
						}
					} else {
						depositMoney(killer, mobConfig, EntityType.PIG_ZOMBIE);
						killer.sendMessage(MessageUtil.translate(Messages.reward + getDeposited(EntityType.PIG_ZOMBIE)));
					}
					break;	
				case ENDERMAN:
					if(mobConfig.getMobConfig().getBoolean("useDefaults")) {
						if(true) {
							economy.depositPlayer(killer, 3.0);
							killer.sendMessage(MessageUtil.translate(Messages.reward + "$3.0"));
						}
					} else {
						depositMoney(killer, mobConfig, EntityType.ENDERMAN);
						killer.sendMessage(MessageUtil.translate(Messages.reward + getDeposited(EntityType.ENDERMAN)));
					}
					break;	
				case ENDER_DRAGON:
					if(mobConfig.getMobConfig().getBoolean("useDefaults")) {
						if(true) {
							economy.depositPlayer(killer, 175.0);
							killer.sendMessage(MessageUtil.translate(Messages.reward + "$175.0"));
						}
					} else {
						depositMoney(killer, mobConfig, EntityType.ENDER_DRAGON);
						killer.sendMessage(MessageUtil.translate(Messages.reward + getDeposited(EntityType.ENDER_DRAGON)));
					}
					break;	
				case WITHER:
					if(mobConfig.getMobConfig().getBoolean("useDefaults")) {
						if(true) {
							economy.depositPlayer(killer, 200.0);
							killer.sendMessage(MessageUtil.translate(Messages.reward + "$200.0"));
						}
					} else {
						depositMoney(killer, mobConfig, EntityType.WITHER);
						killer.sendMessage(MessageUtil.translate(Messages.reward + getDeposited(EntityType.WITHER)));
					}
					break;	
				case GIANT:
					if(mobConfig.getMobConfig().getBoolean("useDefaults")) {
						if(true) {
							economy.depositPlayer(killer, 500.0);
							killer.sendMessage(MessageUtil.translate(Messages.reward + "$500.0"));
						}
					} else {
						depositMoney(killer, mobConfig, EntityType.GIANT);
						killer.sendMessage(MessageUtil.translate(Messages.reward + getDeposited(EntityType.GIANT)));
					}
					break;	
				default:
					break;
				}
			}		
		}			
	}
}

package com.evilplatypus.bukkit.light;

import java.util.logging.Logger;

import org.bukkit.event.Event;
import org.bukkit.event.Event.Priority;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * LightSwitch for Bukkit
 *
 * @author Jauneau Vincent
 */
public class LightSwitch extends JavaPlugin {
	LightSwitchBlockListener blockListener = new LightSwitchBlockListener();
	LightSwitchPlayerListener playerListener = new LightSwitchPlayerListener();
    public static Logger log;

	@Override
	public void onEnable() {
		log = Logger.getLogger("Minecraft");
		log.info("[" + this.getDescription().getName() + "]" + " version " + this.getDescription().getVersion() + " loaded.");
		
        // Register our events
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvent(Event.Type.PLAYER_INTERACT, playerListener, Priority.Normal, this);
        pm.registerEvent(Event.Type.REDSTONE_CHANGE, blockListener, Priority.Normal, this);
        pm.registerEvent(Event.Type.BLOCK_BREAK, blockListener, Priority.Normal, this);
	}

	@Override
	public void onDisable() {
		log.info("[" + this.getDescription().getName() + "]" + " version " + this.getDescription().getVersion() + " unloaded.");
	}


}

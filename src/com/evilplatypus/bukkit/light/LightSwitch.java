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
	LightSwitchListener listener = new LightSwitchListener();
    public static Logger log;

	@Override
	public void onEnable() {
		log = Logger.getLogger("Minecraft");
		log.info(this.getDescription().getName() + " version " + this.getDescription().getVersion() + " loaded.");
		
        // Register our events
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvent(Event.Type.BLOCK_INTERACT, listener, Priority.Normal, this);
        pm.registerEvent(Event.Type.REDSTONE_CHANGE, listener, Priority.Normal, this);
        pm.registerEvent(Event.Type.BLOCK_BREAK, listener, Priority.Normal, this);
	}

	@Override
	public void onDisable() {
		log.info(this.getDescription().getName() + " version " + this.getDescription().getVersion() + " unloaded.");
	}


}

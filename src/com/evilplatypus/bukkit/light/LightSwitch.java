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
<<<<<<< HEAD
	LightSwitchBlockListener blockListener = new LightSwitchBlockListener();
	LightSwitchPlayerListener playerListener = new LightSwitchPlayerListener();
=======
	LightSwitchListener listener = new LightSwitchListener();
>>>>>>> e79484b7b4210005e572a819f698014af4c04797
    public static Logger log;

	@Override
	public void onEnable() {
		log = Logger.getLogger("Minecraft");
<<<<<<< HEAD
		log.info("[" + this.getDescription().getName() + "]" + " version " + this.getDescription().getVersion() + " loaded.");
		
        // Register our events
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvent(Event.Type.PLAYER_INTERACT, playerListener, Priority.Normal, this);
        pm.registerEvent(Event.Type.REDSTONE_CHANGE, blockListener, Priority.Normal, this);
        pm.registerEvent(Event.Type.BLOCK_BREAK, blockListener, Priority.Normal, this);
=======
		log.info(this.getDescription().getName() + " version " + this.getDescription().getVersion() + " loaded.");
		
        // Register our events
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvent(Event.Type.BLOCK_INTERACT, listener, Priority.Normal, this);
        pm.registerEvent(Event.Type.REDSTONE_CHANGE, listener, Priority.Normal, this);
        pm.registerEvent(Event.Type.BLOCK_BREAK, listener, Priority.Normal, this);
>>>>>>> e79484b7b4210005e572a819f698014af4c04797
	}

	@Override
	public void onDisable() {
<<<<<<< HEAD
		log.info("[" + this.getDescription().getName() + "]" + " version " + this.getDescription().getVersion() + " unloaded.");
=======
		log.info(this.getDescription().getName() + " version " + this.getDescription().getVersion() + " unloaded.");
>>>>>>> e79484b7b4210005e572a819f698014af4c04797
	}


}

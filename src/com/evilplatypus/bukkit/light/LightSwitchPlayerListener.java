package com.evilplatypus.bukkit.light;

import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerListener;

public class LightSwitchPlayerListener extends PlayerListener{
	LightSwitchBlockListener blockListener = new LightSwitchBlockListener();
	
	public void onPlayerInteract(PlayerInteractEvent event) {
		if (event.isCancelled()) {
			return;
		}
		if (event.hasBlock()) {
			LightSwitchBlockListener.changePumpkinState(event.getClickedBlock());
		}
	}
}

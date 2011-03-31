package com.evilplatypus.bukkit.light;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockInteractEvent;
import org.bukkit.event.block.BlockListener;
import org.bukkit.event.block.BlockRedstoneEvent;

public class LightSwitchListener extends BlockListener {

    @Override
    public void onBlockInteract(BlockInteractEvent event) {
    	if (event.isCancelled()) return;
    	changePumpkinState(event.getBlock());
    }
    
    public void onBlockBreak(BlockBreakEvent event) {
    	System.out.println("destroyed");
    	changePumpkinState(event.getBlock(), true);
    }

    @Override
    public void onBlockRedstoneChange(BlockRedstoneEvent event) {
    	Block block = event.getBlock();
    	
    	BlockFace[] faces = {BlockFace.NORTH, BlockFace.SOUTH, BlockFace.EAST, BlockFace.WEST};
    	for (int i = 0; i < faces.length; i++) {
        	Block b = block.getFace(faces[i]);
        	changePumpkinState(b);
    	}
    }
    
    private void changePumpkinState(Block block) {
    	changePumpkinState(block, false);
    }
    
    private void changePumpkinState(Block block, boolean forceSwitchOff) {
    	BlockFace[] faces = {BlockFace.NORTH, BlockFace.SOUTH, BlockFace.EAST, BlockFace.WEST, BlockFace.UP, BlockFace.DOWN};
    	for (int i = 0; i < faces.length; i++) {
        	Block b = block.getFace(faces[i]);
        	if (b.getType() == Material.PUMPKIN) {
        		if (b.isBlockIndirectlyPowered() || b.isBlockPowered()) {
        			b.setType(Material.JACK_O_LANTERN);
        		}
        	}
        	if (b.getType() == Material.JACK_O_LANTERN) {
        		if ((!b.isBlockIndirectlyPowered() && !b.isBlockPowered()) || forceSwitchOff) {
        			b.setType(Material.PUMPKIN);
        		}
        	}
    	}
    }
}

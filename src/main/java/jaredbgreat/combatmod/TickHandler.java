package jaredbgreat.combatmod;

import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;


public final class TickHandler {
	private long counter = 0;
	
	TickHandler() {}
	
	@SubscribeEvent
	@EventHandler
	public void onPlayerTick(TickEvent.PlayerTickEvent event) {}
	
	
	@SubscribeEvent
	@EventHandler
	public void onClientTick(TickEvent.ClientTickEvent event) {}
	
	
	@SubscribeEvent
	@EventHandler
	public void onServerTick(TickEvent.ServerTickEvent event) {
		// TODO: Logic!!!!  (No, really call other logic.)
	}
	
	
	@SubscribeEvent
	@EventHandler
	public void onRenderTick(TickEvent.RenderTickEvent event) {}
	
	
	@SubscribeEvent
	@EventHandler
	public void onWorldTick(TickEvent.WorldTickEvent event) {}
}
package jaredbgreat.combatmod;

import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;


public final class TickHandler {
	private long counter = 0;
	
	TickHandler() {}
	
	@SubscribeEvent
	public void onPlayerTick(TickEvent.PlayerTickEvent event) {}
	
	
	@SubscribeEvent
	public void onClientTick(TickEvent.ClientTickEvent event) {}
	
	
	@SubscribeEvent
	public void onServerTick(TickEvent.ServerTickEvent event) {}
	
	
	@SubscribeEvent
	public void onRenderTick(TickEvent.RenderTickEvent event) {}
	
	
	@SubscribeEvent
	public void onWorldTick(TickEvent.WorldTickEvent event) {}
}
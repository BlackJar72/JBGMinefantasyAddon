package jaredbgreat.combatmod;

import jaredbgreat.combatmod.combat.PlayerHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public final class TickHandler {
	private static PlayerHandler playerHandler;
	
	TickHandler() {
		playerHandler = PlayerHandler.getPlayerHandler();
	}
	
	@SubscribeEvent
	public void onPlayerTick(TickEvent.PlayerTickEvent event) {}
	
	
	@SubscribeEvent
	public void onClientTick(TickEvent.ClientTickEvent event) {}
	
	
	@SubscribeEvent
	public void onServerTick(TickEvent.ServerTickEvent event) {
		playerHandler.update();
	}
	
	
	@SubscribeEvent
	public void onRenderTick(TickEvent.RenderTickEvent event) {}
	
	
	@SubscribeEvent
	public void onWorldTick(TickEvent.WorldTickEvent event) {}
}
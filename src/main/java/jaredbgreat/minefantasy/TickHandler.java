package jaredbgreat.minefantasy;

/* 
 * This mod is the creation and copyright (c) 2017 
 * of Jared Blackburn (JaredBGreat).
 * 
 * NO WARRANTEE, OF ANY KIND.  This is freely available, and offers
 * no warrantees or guarantees, not even merchantability or fitness 
 * for a particular purpose.  No liability is accepted by the author 
 * for any use, proper or improper, of this mod or any dirivative 
 * there of, or any damages resulting from its use.
 * 
 * It is licensed under the creative commons 4.0 attribution license:  
 * https://creativecommons.org/licenses/by/4.0/legalcode
*/

import jaredbgreat.minefantasy.blocks.tileentities.TwoWayBaseLogic;
import jaredbgreat.minefantasy.combat.PlayerHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.relauncher.Side;

/**
 * 
 * @author jared
 *
 */
public final class TickHandler {
	private static PlayerHandler playerHandler;
	
	TickHandler() {
		playerHandler = PlayerHandler.getPlayerHandler();
	}
	
	/**
	 * Uses a single subscription to sever ticks to drive all 
	 * per-update logic.
	 * 
	 * @param event
	 */
	@SubscribeEvent
	public void onServerTick(TickEvent.ServerTickEvent event) {
		if(event.side == Side.SERVER) {
			playerHandler.update();
			TwoWayBaseLogic.updateManager();
		}
	}
	
//	// Commented out to avoid wasting resources or unused calls, 
//	// but kepts as a reference.
//	@SubscribeEvent
//	public void onPlayerTick(TickEvent.PlayerTickEvent event) {}
//	@SubscribeEvent
//	public void onClientTick(TickEvent.ClientTickEvent event) {}
//	@SubscribeEvent
//	public void onRenderTick(TickEvent.RenderTickEvent event) {}
//	@SubscribeEvent
//	public void onWorldTick(TickEvent.WorldTickEvent event) {}
}
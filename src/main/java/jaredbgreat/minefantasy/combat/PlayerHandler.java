package jaredbgreat.minefantasy.combat;

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

import jaredbgreat.minefantasy.Info;

import java.util.HashSet;
import java.util.Set;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class PlayerHandler {	
	private static final Set<PlayerData> players = new HashSet<PlayerData>();
	private static final Set<PlayerData> removal = new HashSet<PlayerData>();
	static PlayerHandler instance;
	
	
	private PlayerHandler() {
		MinecraftForge.EVENT_BUS.register(this);
	}

	
	@SubscribeEvent
	public void onEntityConstruction(EntityConstructing event) {
		if(event.entity instanceof EntityPlayer) {
			PlayerData properties = (PlayerData)event.entity.getExtendedProperties(Info.ID);
			if(properties == null) {
				properties = new PlayerData((EntityPlayer)event.entity);
				event.entity.registerExtendedProperties(Info.ID, properties);
				players.add(properties);
			}
			properties.init(event.entity, event.entity.worldObj);
		}
	}
	
	
	public void update() {		
		for(PlayerData player : players) {
			if(player.update()) {
				removal.add(player);
			};
		}
		players.removeAll(removal);
		removal.clear();
	}
	
	
	void addPlayer(PlayerData player) {
		players.add(player);
	}


	public static PlayerHandler getPlayerHandler() {
		if(instance == null) instance = new PlayerHandler();
		return instance;
	}

}

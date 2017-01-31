package jaredbgreat.combatmod.combat;

import jaredbgreat.combatmod.Info;

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

package jaredbgreat.combatmod.combat;

import jaredbgreat.combatmod.Info;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class PlayerHandler {
	
	public PlayerHandler() {
		MinecraftForge.EVENT_BUS.register(this);
	}

	
	@SubscribeEvent
	public void onEntityConstruction(EntityConstructing event) {
		if(event.entity instanceof EntityPlayer) {
			PlayerData properties = (PlayerData)event.entity.getExtendedProperties(Info.ID);
			if(properties == null) {
				properties = new PlayerData();
				event.entity.registerExtendedProperties(Info.ID, properties);
			}
			properties.init(event.entity, event.entity.worldObj);
			System.out.println("Extra Player Data Initiated");
			System.out.println(properties);
		}
	}

}

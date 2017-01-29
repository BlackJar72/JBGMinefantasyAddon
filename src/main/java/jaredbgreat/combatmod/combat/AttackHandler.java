package jaredbgreat.combatmod.combat;

import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.player.AttackEntityEvent;

/**
 * A class to catch attacks and setup the basic logic -- hopefully.
 * 
 * @author JaredBGreat (Jared Blackburn)
 *
 */
public class AttackHandler {
	
	@SubscribeEvent
	@EventHandler
	public void onPlayerAttack(AttackEntityEvent event) {
		EntityPlayer player = event.entityPlayer;
		Entity target = event.target;
	}
}

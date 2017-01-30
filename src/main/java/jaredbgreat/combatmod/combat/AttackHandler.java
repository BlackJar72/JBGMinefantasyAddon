package jaredbgreat.combatmod.combat;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

/**
 * A class to catch attacks and setup the basic logic -- hopefully.
 * 
 * @author JaredBGreat (Jared Blackburn)
 *
 */
// See package minefantasy.mf2.mechanics for ideas on how to do this, partly.
public class AttackHandler {
	
	private static int MAX_DELAY = 20; // A temporary placeholder
	
	@SubscribeEvent
	@EventHandler
	public void onPlayerAttack(AttackEntityEvent event) {
		EntityPlayer player = event.entityPlayer;
		Entity target = event.target;
	}
	
	
	@SubscribeEvent
	@EventHandler
	public void onDamageTaken(LivingHurtEvent event) {
		DamageSource source = event.source;
		if(event.source instanceof EntityDamageSource) {
			Entity attacker = ((EntityDamageSource)event.source).getEntity();
			if(attacker instanceof EntityPlayer) {
				//attacker.getExtendedProperties(identifier)
				attacker.getEntityData();	
			}
			// TODO: Get if a cooldown is in effect and, if so call adjust damage
		}
	}
	
	
	private float adjustDamage(float baseDamage, int cooldown) {
		if(cooldown > 0) {
			// This is a bit of a mock-up for now, for the formula
			return baseDamage * 0.8f * ((MAX_DELAY - cooldown) / MAX_DELAY);
		} else {
			return baseDamage;
		}		
	}
}

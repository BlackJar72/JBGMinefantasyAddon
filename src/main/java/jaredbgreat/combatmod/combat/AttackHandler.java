package jaredbgreat.combatmod.combat;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraftforge.common.MinecraftForge;
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
	private static AttackHandler instance;
	
	private AttackHandler() {
		MinecraftForge.EVENT_BUS.register(this);		
	}
	
	
	@SubscribeEvent
	public void onDamageTaken(LivingHurtEvent event) {
		DamageSource source = event.source;
		if(event.source instanceof EntityDamageSource) {
			Entity attacker = ((EntityDamageSource)event.source).getEntity();
			if(attacker instanceof EntityPlayer) {
				System.out.print(event.ammount + " became ");
				PlayerData logic = (PlayerData)attacker.getExtendedProperties(PlayerData.COMPOUND);
				event.ammount = adjustDamage(logic,	event.ammount);
				logic.startCooldown();
				System.out.println(event.ammount);
			}
		}
	}
	
	
	private float adjustDamage(PlayerData logic, float baseDamage) {
		return logic.getModifiedDamage(baseDamage);
	}
	
	
	public static AttackHandler getAttackHandler() {
		if(instance == null) {
			instance = new AttackHandler();
		}
		return instance;
	}
}

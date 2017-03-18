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

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
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
	public void onPlayerAttack(AttackEntityEvent event) {
		PlayerData logic = (PlayerData)event.entityPlayer.getExtendedProperties(PlayerData.COMPOUND);
		logic.attack();
	}
	
	
	@SubscribeEvent
	public void onDamageTaken(LivingHurtEvent event) {
		DamageSource source = event.source;
		if(source instanceof EntityDamageSource) {
			Entity attacker = ((EntityDamageSource)source).getEntity();
			if(attacker instanceof EntityPlayer) {
				//System.out.print(event.ammount + " became ");
				PlayerData logic = (PlayerData)attacker.getExtendedProperties(PlayerData.COMPOUND);
				event.ammount = adjustDamage(logic,	event.ammount);
				//System.out.println(event.ammount);
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

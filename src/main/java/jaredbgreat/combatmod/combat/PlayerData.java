package jaredbgreat.combatmod.combat;

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

import jaredbgreat.combatmod.Info;

import java.util.List;
import java.util.UUID;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;


public class PlayerData implements IExtendedEntityProperties {
	
	static final String COMPOUND = Info.ID;
	static final String CD_TAG   = "cooldown";
	static final String PT_TAG   = "parrytime";
	
	private static final float PREMATURE_FACTOR = 0.9f;
	private static final byte MAX_COOLDOWN = 24; // Stand-in until weapons types
	
	// FIXME: Needed?  Useful?
	World world;
	UUID player;
	
	private byte cooldown  = 0;
	private boolean ready  = true;
	private boolean swing  = false;
	
	
	PlayerData(EntityPlayer entity) {
		world = entity.getEntityWorld();
		player = entity.getUniqueID();
	}
	
	
	public void attack() {
		swing = true;
		PlayerHandler.instance.addPlayer(this);
	}

	
	public void startCooldown() {
		cooldown = MAX_COOLDOWN;
		ready = false;
		swing = false;
	}
	
	public float getModifiedDamage(float in) {
		if(!ready) {
			float timeFactor = (((float)(MAX_COOLDOWN - cooldown)) 
					/  (float)MAX_COOLDOWN);
			//in *= 0.2 + (timeFactor *  timeFactor) * 0.8; // Vanilla 1.9+
			in *= (timeFactor *  timeFactor);
			in *= PREMATURE_FACTOR;
		} 
		return in;
	}	
	
	
	boolean update() {
		if(swing) {
			startCooldown();
		}
		if(cooldown > 0) {
			cooldown--;
			return false;
		} else {
			return (ready = true);
		}
	}
	
	
	/*------------------------------------------------------------------------*/
	/*                    INHERITED NBT PROCESSING                            */
	/*                     and supporting methods                            */
	/*------------------------------------------------------------------------*/
	
	
	@Override
	public void saveNBTData(NBTTagCompound compound) {
		NBTTagCompound baseTag = compound.getCompoundTag(COMPOUND);
		baseTag.setInteger(CD_TAG, cooldown);
	}

	@Override
	public void loadNBTData(NBTTagCompound compound) {
		NBTTagCompound baseTag = compound.getCompoundTag(COMPOUND);
		cooldown  = baseTag.getByte(CD_TAG);
	}

	@Override
	public void init(Entity entity, World world) {
		this.world = world;
		if(!(entity instanceof EntityPlayer) 
				|| entity.getEntityData().hasKey(COMPOUND)) {
			return;
		} else {
			loadNBTData(entity.getEntityData());
		}		
	}
	
	
	/*------------------------------------------------------------------------*/
	/*                                 Getters                                */
	/*------------------------------------------------------------------------*/
	
	
	public int getCooldown() {
		return cooldown;
	}
	
	
	public boolean active() {
		return ((cooldown <= 0) || ready);
	}
	

}

package jaredbgreat.combatmod.combat;

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
	
	private static final float PREMATURE_FACTOR = 0.8f;
	private static final byte MAX_COOLDOWN = 32; // Stand-in until weapons types
	
	World world;
	UUID player;
	
	private byte cooldown  = 0;
	private boolean ready  = true;
	
	
	PlayerData(EntityPlayer entity) {
		world = entity.getEntityWorld();
		player = entity.getUniqueID();
	}

	
	public void startCooldown() {
		cooldown = MAX_COOLDOWN;
		ready = false;
		PlayerHandler.instance.addPlayer(this);
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
		if(cooldown > 0) {
			cooldown--;
			return false;
		} else {
			return (ready = true);
		}
	}
	
	
	/*------------------------------------------------------------------------*/
	/*                    INHERITED NBT PROCESSING                            */
	/*                     and supporting methods                             */
	/*                    (This is very important)                            */
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

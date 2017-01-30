package jaredbgreat.combatmod.combat;

import jaredbgreat.combatmod.Info;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;


public class PlayerData implements IExtendedEntityProperties {
	
	private static final String COMPOUND = Info.ID;
	private static final String CD_TAG   = "cooldown";
	private static final String PT_TAG   = "parrytime";
	
	private static final float PREMATURE_FACTOR = 0.8f;
	private static final byte MAX_COOLDOWN = 20; // Stand-in until weapons types
	
	private byte cooldown  = 0;
	private byte parrytime = 0;

	
	public void startCooldown() {
		cooldown = MAX_COOLDOWN;
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	public float getModifiedDamage(float in) {
		if(cooldown > 0) {
			// This is a bit of a mock-up for now, for the formula
			return in * PREMATURE_FACTOR 
					* (((float)(MAX_COOLDOWN - cooldown)) / (float)MAX_COOLDOWN);
		} else {
			return in;
		}		
	}
	
	
	@SubscribeEvent // Not 100% sure this is the best way to do this
	public void update(TickEvent.PlayerTickEvent event) {
		if(cooldown > 0) {
			cooldown--;
		}
		if(parrytime > 0) {
			parrytime--;
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
		baseTag.setInteger(PT_TAG, parrytime);
	}

	@Override
	public void loadNBTData(NBTTagCompound compound) {
		NBTTagCompound baseTag = compound.getCompoundTag(COMPOUND);
		cooldown  = baseTag.getByte(CD_TAG);
		parrytime = baseTag.getByte(PT_TAG);
	}

	@Override
	public void init(Entity entity, World world) {
		if(!(entity instanceof EntityPlayer) 
				|| entity.getEntityData().hasKey(COMPOUND)) {
			return;
		} else {
			loadNBTData(entity.getEntityData());
		}		
	}
	
	@SubscribeEvent
	public static void onEntityConstruction(EntityConstructing event) {
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

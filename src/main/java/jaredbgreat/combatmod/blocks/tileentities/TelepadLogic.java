package jaredbgreat.combatmod.blocks.tileentities;

import jaredbgreat.combatmod.blocks.MF1Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TelepadLogic extends TelepadBaseLogic {
	
	@Override
	boolean inRange() {
		return true;
	}
	
}

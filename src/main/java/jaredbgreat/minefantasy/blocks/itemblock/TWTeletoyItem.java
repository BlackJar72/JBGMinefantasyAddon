package jaredbgreat.minefantasy.blocks.itemblock;

import jaredbgreat.minefantasy.blocks.tileentities.LandingpadLogic;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TWTeletoyItem extends AbstractTelepadItem {

	public TWTeletoyItem(Block block) {
		super(block);
	}
	
	
	@Override
	public boolean placeBlockAt(ItemStack stack, EntityPlayer player, World world, 
			                    int x, int y, int z, int side, float hitX, float hitY, float hitZ, 
			                    int metadata) {
			boolean out = super.placeBlockAt(stack, player, world, x, y, z, side, hitX, hitY, hitZ, metadata);
			if(out) {
				TileEntity te = world.getTileEntity(x, y, z);
				if(te instanceof LandingpadLogic) {
					LandingpadLogic logic = (LandingpadLogic)te;
					NBTTagCompound tag = stack.getTagCompound();
					if(tag == null) {
						return out;
					}
					System.out.println(tag);
					NBTTagCompound display;
					String name;
					if(tag != null) {
						display = tag.getCompoundTag("display");
						System.out.println(display);
						if(display != null) {
							name = display.getString("Name");
							System.out.println(name);
							if((name != null) && !name.isEmpty()) {
								logic.setName(name);
							}
						}
					}
				}
			}
		return out;
	}

}

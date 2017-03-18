package jaredbgreat.minefantasy.herbs;

import jaredbgreat.minefantasy.Info;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;

public class ItemPlantableHerb extends ItemHerb implements IPlantable   {
	private BlockHerb plant;

	public ItemPlantableHerb(EHerbs type, BlockHerb plant) {		
		super(type);
		this.plant = plant;
	}

	@Override
	public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z) {
		return EnumPlantType.Plains;
	}

	@Override
	public Block getPlant(IBlockAccess world, int x, int y, int z) {
		return plant;
	}

	@Override
	public int getPlantMetadata(IBlockAccess world, int x, int y, int z) {
		return 0;
	}
	
	
	@Override
	public boolean onItemUse(ItemStack item, EntityPlayer player, World world, 
							 int x, int y, int z, int what, float fx, float fy, float fz) {
		Block target = world.getBlock(x, y, z);
		if((target == Blocks.dirt) || (target == Blocks.grass) || (target == Blocks.farmland)) {
			if(world.isAirBlock(x, y + 1, z)) {
				world.setBlock(x, y + 1, z, plant);
				world.setBlockMetadataWithNotify(x, y + 1, z, 0, 2);
				item.stackSize--;
				return true;
			}
		}
		return false;
	}

}

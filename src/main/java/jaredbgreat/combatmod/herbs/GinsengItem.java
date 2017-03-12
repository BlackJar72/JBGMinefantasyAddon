package jaredbgreat.combatmod.herbs;

import jaredbgreat.combatmod.Info;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;

public class GinsengItem extends ItemFood implements IPlantable {

	public GinsengItem(int hunger, float saturation) {
		super(hunger, saturation, false);
        setPotionEffect("+0-1-2+3&4-4+13");
        //setPotionEffect("+4-5+6-7"); // This doe not work
        //setPotionEffect("+4"); // The netherwart value -- I *MAY* make a new, rarer herb for this!
        setUnlocalizedName(Info.ID + "-ginsingroot");
        setTextureName(Info.ID + ":Herb/ginseng");
	}

	@Override
	public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z) {
		return EnumPlantType.Plains;
	}

	@Override
	public Block getPlant(IBlockAccess world, int x, int y, int z) {
		return Herbs.ginseng;
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
				world.setBlock(x, y + 1, z, Herbs.ginseng);
				world.setBlockMetadataWithNotify(x, y + 1, z, 1, 2);
				item.stackSize--;
				return true;
			}
		}
		return false;
	}
	
}

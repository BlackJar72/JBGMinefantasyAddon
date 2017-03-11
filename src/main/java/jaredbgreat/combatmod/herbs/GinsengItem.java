package jaredbgreat.combatmod.herbs;

import jaredbgreat.combatmod.Info;
import net.minecraft.block.Block;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.PotionHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;

public class GinsengItem extends ItemFood implements IPlantable {

	public GinsengItem(int hunger, float saturation) {
		super(hunger, saturation, false);
        setPotionEffect(PotionHelper.blazePowderEffect);
        setUnlocalizedName(Info.ID + "-ginsingroot");
        this.setTextureName(Info.ID + ":Herb/ginseng");
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
	
}

package jaredbgreat.combatmod.herbs;

import net.minecraft.block.BlockBush;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.Explosion;

public abstract class BlockHerb extends BlockBush {

	public BlockHerb() {
		super(Material.plants);
		setHardness(0.1f);
		setStepSound(soundTypeGrass);
		setResistance(0.1f);		
	}
	
	
	@Override
    public boolean canDropFromExplosion(Explosion unimportant) {
		return false;
	}
	
	
	@Override
	public boolean canHarvestBlock(EntityPlayer player, int meta) {
		return false;
	}
}

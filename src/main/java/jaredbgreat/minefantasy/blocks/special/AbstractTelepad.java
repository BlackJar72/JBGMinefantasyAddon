package jaredbgreat.minefantasy.blocks.special;

import jaredbgreat.minefantasy.Info;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public abstract class AbstractTelepad extends BlockContainer {
	static final float HEIGHT = 0.0625f;
	public static final double LEVEL = 1.0d - HEIGHT;

	protected AbstractTelepad(String name) {
		super(Material.rock);
		this.setStepSound(Block.soundTypeStone);
		setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, HEIGHT, 1.0F);
        setCreativeTab(CreativeTabs.tabTransport);
        setHardness(5f);
        setResistance(50f);
        setHarvestLevel("pickaxe", 1);
        setBlockName(Info.ID + "-" + name);
        setBlockTextureName(Info.ID + ":Pads/" + name);
	}
	

    public boolean isOpaqueCube() {
        return false;
    }

    
    public boolean renderAsNormalBlock() {
        return false;
    }
    

    public void setBlockBoundsForItemRender()  {
    	setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, HEIGHT, 1.0F);
    }


    protected void func_150089_b(int number) {
    	// This would be called instead of duplicated if Java had inlining.
        setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, HEIGHT, 1.0F);
    }
	
	
	@Override
	public boolean canPlaceBlockAt(World world, int x, int y, int z) {
		return (super.canPlaceBlockAt(world, x, y, z) 
				&& (world.getBlock(x, y - 1, z).isBlockNormalCube()) 
					|| (world.getBlock(x, y - 1, z) instanceof Landingpad));		
	}
	
	
	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
		if(!world.getBlock(x, y - 1, z).isNormalCube()) {
			this.dropBlockAsItem(world, x, y, z, 0, 0);
			world.setBlockToAir(x, y, z);
		}
	}
	
	
	@Override
	public boolean canBeReplacedByLeaves(IBlockAccess world, int x, int y, int z) {
		return false;
	}

}

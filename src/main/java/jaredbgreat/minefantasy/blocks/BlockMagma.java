package jaredbgreat.minefantasy.blocks;

import jaredbgreat.minefantasy.Info;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockMagma extends Block {
	static final float RHEIGHT = 1.0f - 0.0625f;
	private static IIcon[] icons;

	protected BlockMagma() {
		super(Material.lava);
        setHardness(5f);
        setResistance(50f);
		setLightLevel(0.65F);
		setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, RHEIGHT, 1.0F);
		setBlockName(Info.ID + "-magma");
		disableStats();
		setBlockTextureName(Info.ID + ":" + "Basic/magma");
		setCreativeTab(CreativeTabs.tabBlock);
		setHarvestLevel("shovel", 3);		
	}
	

    public boolean isOpaqueCube() {
        return false;
    }

    
    public boolean renderAsNormalBlock() {
        return false;
    }
    

    public void setBlockBoundsForItemRender()  {
    	setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, RHEIGHT, 1.0F);
    }


    protected void func_150089_b(int number) {
        setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, RHEIGHT, 1.0F);
    }
	
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iReg) {
		icons = new IIcon[1];
		icons[0] = iReg.registerIcon(Info.ID + ":Basic/magma");
	}
	
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		return icons[0];
	}
	
	
    public boolean canCollideCheck(int p_149678_1_, boolean p_149678_2_) {
        return true;
    }

    /**
     * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
     * cleared to be reused)
     */
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
        float f = 0.5F;
        return AxisAlignedBB.getBoundingBox((double)x, (double)y, (double)z, (double)(x + 1), 
        		(double)((float)(y + 1) - f), (double)(z + 1));
    }
    
    
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block)
    {
        if (world.getBlock(x, y, z) == this) {
        	boolean flag = false;
        	
            if (flag || world.getBlock(x, y, z - 1).getMaterial() == Material.water) {
            	world.setBlock(x, y, z, AddonBlocks.doomed, 13, 2);
            	return;
            }
            if (flag || world.getBlock(x, y, z + 1).getMaterial() == Material.water) {
            	world.setBlock(x, y, z, AddonBlocks.doomed, 13, 2);
            	return;
            }
            if (flag || world.getBlock(x, y - 1, z).getMaterial() == Material.water) {
            	world.setBlock(x, y, z, AddonBlocks.doomed, 13, 2);
            	return;
            }
            if (flag || world.getBlock(x, y + 1, z).getMaterial() == Material.water) {
            	world.setBlock(x, y, z, AddonBlocks.doomed, 13, 2);
            	return;
            }
            if (flag || world.getBlock(x - 1, y, z).getMaterial() == Material.water) {
            	world.setBlock(x, y, z, AddonBlocks.doomed, 13, 2);
            	return;
            }
            if (flag || world.getBlock(x + 1, y, z).getMaterial() == Material.water) {
            	world.setBlock(x, y, z, AddonBlocks.doomed, 13, 2);
            	return;
            }
        }
    }

}

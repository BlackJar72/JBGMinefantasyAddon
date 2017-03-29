package jaredbgreat.minefantasy.herbs;

import jaredbgreat.minefantasy.ConfigHandler;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

public abstract class BlockHerb extends BlockBush {
	protected IIcon[] icons;

	public BlockHerb() {
		super(Material.plants);
		setHardness(0.1f);
		setStepSound(soundTypeGrass);
		setResistance(0.1f);
        setCreativeTab(CreativeTabs.tabDecorations);
	}
	
	
	@Override
    public boolean canDropFromExplosion(Explosion unimportant) {
		return false;
	}
	
	
	@Override
	public boolean canHarvestBlock(EntityPlayer player, int meta) {
		return false;
	}
	
	
	protected boolean beGathered(World world, int x, int y, int z, 
			EntityPlayer player, Item drop, Item tool, int max, boolean destroy) {

		if(world.isRemote) {
    		return false;
		}
    	if(isRightTool(player, tool)) {
    		return dropItem(world, x, y, z, drop, tool, max, destroy);
    	} else {
    		return false;
    	}
    }
	
	
	protected boolean dropItem(World world, int x, int y, int z, 
							   Item drop, Item tool, int max, boolean destroy) {
		ItemStack root;
		if(world.getBlockMetadata(x, y, z) == 1) {
			root = new ItemStack(drop, world.rand.nextInt(max) + 1, 1);
		} else {
			if(destroy) {
				root = new ItemStack(drop, 1, 0);
			} else {
				return false;
			}
		}
    	EntityItem roots = new EntityItem(world, x + 0.5, y + 0.5, z + 0.5, root);
    	roots.delayBeforeCanPickup = 10;
    	world.spawnEntityInWorld(roots);
    	if(destroy) {
    		world.setBlockToAir(x, y, z);
    	} else {
    		world.setBlockMetadataWithNotify(x, y, z, 0, 2);
    	}
		return true;
	}
	
	
	private boolean isRightTool(EntityPlayer player, Item tool) {
		ItemStack stackHeld = player.getEquipmentInSlot(0);
		if(stackHeld == null) {
			return tool == null;
		} else {
			Item held = stackHeld.getItem();
			return ((tool != null) 
					&& (held != null) // Shouldn't ever be -- failsafe 
					&&  tool.getClass().isAssignableFrom(held.getClass()));
		}
	}
    
    
    @Override
    public void updateTick(World world, int x, int y, int z, Random random) {
    	if((world.getBlockLightValue(x, y, z) >=9) && (world.getBlockMetadata(x, y, z) != 1) 
    			&& (random.nextInt(ConfigHandler.herbGrowChance) == 0)) {
    		world.setBlockMetadataWithNotify(x, y, z, 1, 2);
    	}
    }	
    
    
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int p1, int meta) {
    	if(meta == 1) {
    		return icons[0];
    	} else {
    		return icons[1];
    	}
    }
    
    
    protected void checkAndDropBlock(World world, int x, int y, int z) {
        if (ConfigHandler.transpantHerbs) {
        	super.checkAndDropBlock(world, x, y, z);
        } else {
        	world.setBlockToAir(x, y, z);
        }
    }
    

    abstract public boolean isRightSoil(Block ground);
    abstract public int getSizeFactor();
    abstract public boolean isGoodBiome(BiomeGenBase biome);
	
}

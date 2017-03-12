package jaredbgreat.combatmod.herbs;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

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
	
	
	protected boolean beGathered(World world, int x, int y, int z, 
			EntityPlayer player, Item drop, Item tool, int max, boolean destroy) {

		if(world.isRemote) {
    		return true;
		}
    	if(isRightTool(player, tool)) {
    		ItemStack root;
    		if(world.getBlockMetadata(x, y, z) == 0) {
    			root = new ItemStack(drop, world.rand.nextInt(max) + 1, 0);
    		} else {
    			root = new ItemStack(drop, 1, 0);
    		}
        	EntityItem roots = new EntityItem(world, x + 0.5, y + 0.5, z + 0.5, root);
        	roots.delayBeforeCanPickup = 10;
        	world.spawnEntityInWorld(roots);
        	if(destroy) {
        		world.setBlockToAir(x, y, z);
        	} else {
        		world.setBlockMetadataWithNotify(x, y, z, 1, 2);
        	}
    		return true;
    	} else {
    		return false;
    	}
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
    	if((world.getBlockLightValue(x, y, z) >=9) && (world.getBlockMetadata(x, y, z) != 0) 
    			&& (random.nextInt(16) == 0)) {
    		world.setBlockMetadataWithNotify(x, y, z, 0, 2);
    	}
    }	
    

    abstract public boolean isRightSoil(Block ground);
    abstract public int getSizeFactor();
    abstract public boolean isGoodBiome(BiomeGenBase biome);
	
}

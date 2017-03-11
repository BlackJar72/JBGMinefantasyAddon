package jaredbgreat.combatmod.herbs;

import jaredbgreat.combatmod.Info;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class GinsengPlant extends BlockHerb {

	protected GinsengPlant() {
		setBlockName(Info.ID + "-GinsengPlant");
		setBlockBounds(0.25f, 0f, 0.25f, 0.75f, 0.5f, 0.75f); // ???
        setBlockTextureName(Info.ID + ":Herb/Ginseng");
	}
    

    public void setBlockBoundsForItemRender()  {
    	setBlockBounds(0.25f, 0f, 0.25f, 0.75f, 0.5f, 0.75f);
    }


    protected void func_150089_b(int number) {
    	// This would be called instead of duplicated if Java had inlining.
        setBlockBounds(0.25f, 0f, 0.25f, 0.75f, 0.5f, 0.75f);
    }
    
    
    public boolean onBlockActivated(World world, int x, int y, int z, 
    								EntityPlayer player, int side, 
    								float fx, float fy, float fz) {
		world.setBlockToAir(x, y, z);
    	if(world.isRemote) {
    		return true;
    	} else {
    		ItemStack root = new ItemStack(Herbs.ginsengroot, world.rand.nextInt(3) + 1, 0);
        	EntityItem roots = new EntityItem(world, x + 0.5, y + 0.5, z + 0.5, root);
        	roots.delayBeforeCanPickup = 10;
        	world.spawnEntityInWorld(roots);
    		return true;
    	}
    }
    
    
}

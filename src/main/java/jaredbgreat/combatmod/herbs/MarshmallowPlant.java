package jaredbgreat.combatmod.herbs;

import jaredbgreat.combatmod.Info;

import java.util.Random;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MarshmallowPlant extends BlockHerb {
	private IIcon[] icons;

	protected MarshmallowPlant() {
		setBlockName(Info.ID + "-MarshmallowPlant");
		setBlockBounds(0.15f, 0f, 0.15f, 0.85f, 0.75f, 0.85f); // ???
        setBlockTextureName(Info.ID + ":Herb/Marshmallow");
        setLightOpacity(0);
	}
    

    public void setBlockBoundsForItemRender()  {
    	setBlockBounds(0.15f, 0f, 0.15f, 0.85f, 0.75f, 0.85f);
    }


    protected void func_150089_b(int number) {
    	// This would be called instead of duplicated if Java had inlining.
        setBlockBounds(0.15f, 0f, 0.15f, 0.85f, 0.75f, 0.85f);
    }
    
    
    public boolean onBlockActivated(World world, int x, int y, int z, 
    								EntityPlayer player, int side, 
    								float fx, float fy, float fz) {
    	if(player.getEquipmentInSlot(0) != null) {
    		return false;
    	}
		if(world.isRemote) {
    		return true;
    	} else {
    		ItemStack root;
    		if(world.getBlockMetadata(x, y, z) == 0) {
    			root = new ItemStack(Herbs.marshmallowroot, world.rand.nextInt(3) + 1, 0);
    		} else {
    			root = new ItemStack(Herbs.marshmallowroot, 1, 0);
    		}
        	EntityItem roots = new EntityItem(world, x + 0.5, y + 0.5, z + 0.5, root);
        	roots.delayBeforeCanPickup = 10;
        	world.spawnEntityInWorld(roots);
        	world.setBlockToAir(x, y, z);        	
    		return true;
    	}
    }
    
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister ico) {
    	icons = new IIcon[2];
    	icons[0] = ico.registerIcon(Info.ID + ":Herb/Marshmallow");
    	icons[1] = ico.registerIcon(Info.ID + ":Herb/Marshmallow_harvested");
    }
    
    
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int p1, int meta) {
    	if(meta < 0 || meta >= 2) {
    		return icons[0];
    	} else {
    		return icons[meta];
    	}
    }
    
    
    @Override
    public void updateTick(World world, int x, int y, int z, Random random) {
    	if((world.getBlockLightValue(x, y, z) >=9) && (world.getBlockMetadata(x, y, z) != 0) 
    			&& (random.nextInt(16) == 0)) {
    		world.setBlockMetadataWithNotify(x, y, z, 0, 2);
    	}
    }
}

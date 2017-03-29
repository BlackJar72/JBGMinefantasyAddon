package jaredbgreat.minefantasy.herbs;

import jaredbgreat.minefantasy.Info;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MarshmallowPlant extends BlockHerb {

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
    	return this.beGathered(world, x, y, z, player, Herbs.marshmallowroot, null, 2, true);
    }
    
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister ico) {
    	icons = new IIcon[2];
    	icons[0] = ico.registerIcon(Info.ID + ":Herb/Marshmallow");
    	icons[1] = ico.registerIcon(Info.ID + ":Herb/Marshmallow_harvested");
    }
    

    @Override
    public boolean isRightSoil(Block ground) {
    	return ((ground == Blocks.dirt) || (ground == Blocks.grass));
    }
    
    
    @Override
    public int getSizeFactor() {
    	return 4;
    }
    
    
    @Override
    public boolean isGoodBiome(BiomeGenBase biome) {
    	return ((biome.isHighHumidity()) && (biome.temperature > 0.2f) && (biome.temperature < 0.9))
    			|| (BiomeDictionary.isBiomeOfType(biome, Type.SWAMP)) 
    			|| (BiomeDictionary.isBiomeOfType(biome, Type.WET));
    }
    
    
    protected void checkAndDropBlock(World world, int x, int y, int z) {
        if (!canBlockStay(world, x, y, z)) {
        	dropItem(world, x, y, z, Herbs.marshmallowroot, null, world.rand.nextInt(2) + 1, true);
        }
    }
}

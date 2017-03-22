package jaredbgreat.minefantasy.herbs;

import jaredbgreat.minefantasy.Info;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
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

public class GinsengPlant extends BlockHerb {

	protected GinsengPlant() {
		setBlockName(Info.ID + "-GinsengPlant");
		setBlockBounds(0.25f, 0f, 0.25f, 0.75f, 0.5f, 0.75f); // ???
        setBlockTextureName(Info.ID + ":Herb/Ginseng");
        setLightOpacity(0);
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
    	return beGathered(world, x, y, z, player, Herbs.ginsengroot, null, 3, true);
    }
    
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister ico) {
    	icons = new IIcon[2];
    	icons[0] = ico.registerIcon(Info.ID + ":Herb/Ginseng");
    	icons[1] = ico.registerIcon(Info.ID + ":Herb/Ginseng_harvested");
    }
    

    @Override
    public boolean isRightSoil(Block ground) {
    	return ((ground == Blocks.dirt) || (ground == Blocks.grass));
    }
    
    
    @Override
    public int getSizeFactor() {
    	return 5;
    }
    
    
    @Override
    public boolean isGoodBiome(BiomeGenBase biome) {
    	return ((biome.rainfall >= 0.5f) && (biome.temperature > 0.2f) && (biome.temperature <= 0.5))
    				|| (BiomeDictionary.isBiomeOfType(biome, Type.FOREST)) 
    				|| (BiomeDictionary.isBiomeOfType(biome, Type.DENSE))
    				|| (BiomeDictionary.isBiomeOfType(biome, Type.CONIFEROUS));
    }
    
    
    protected void checkAndDropBlock(World world, int x, int y, int z)
    {
        if (!canBlockStay(world, x, y, z)) {
        	dropItem(world, x, y, z, Herbs.ginsengroot, null, 3, true);
        }
    }
    
}

package jaredbgreat.minefantasy.herbs;

import jaredbgreat.minefantasy.Info;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CamomilePlant extends BlockHerb {

	protected CamomilePlant() {
		setBlockName(Info.ID + "-Camomile");
		setBlockBounds(0.15f, 0f, 0.15f, 0.85f, 0.75f, 0.85f); // ???
        setBlockTextureName(Info.ID + ":Herb/Camomile");
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
    	return this.beGathered(world, x, y, z, player, Herbs.camomileherb, null, 3, false);
    }
    
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister ico) {
    	icons = new IIcon[2];
    	icons[0] = ico.registerIcon(Info.ID + ":Herb/Camomile");
    	icons[1] = ico.registerIcon(Info.ID + ":Herb/Camomile_harvested");
    }
    

    @Override
    public boolean isRightSoil(Block ground) {
    	return ((ground == Blocks.dirt) || (ground == Blocks.grass));
    }
    
    
    @Override
    public int getSizeFactor() {
    	return 3;
    }
    
    
    @Override
    public boolean isGoodBiome(BiomeGenBase biome) {
    	return ((biome.rainfall > 0.1f) && (biome.temperature > 0.2f) && (biome.temperature < 0.9));
    }

}

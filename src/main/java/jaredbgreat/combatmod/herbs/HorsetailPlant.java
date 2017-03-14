package jaredbgreat.combatmod.herbs;

import jaredbgreat.combatmod.Info;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class HorsetailPlant extends BlockHerb {
	
	protected HorsetailPlant() {
		setBlockName(Info.ID + "-Horsetail");
		setBlockBounds(0.35f, 0f, 0.35f, 0.65f, 0.85f, 0.65f); // ???
        setBlockTextureName(Info.ID + ":Herb/Horsetail");
        setLightOpacity(0);
	}
    

    public void setBlockBoundsForItemRender()  {
    	setBlockBounds(0.35f, 0f, 0.35f, 0.65f, 0.85f, 0.65f);
    }


    protected void func_150089_b(int number) {
    	// This would be called instead of duplicated if Java had inlining.
        setBlockBounds(0.35f, 0f, 0.35f, 0.65f, 0.85f, 0.65f);
    }
    
    
    public boolean onBlockActivated(World world, int x, int y, int z, 
    								EntityPlayer player, int side, 
    								float fx, float fy, float fz) {
    	return this.beGathered(world, x, y, z, player, Herbs.horsetailItem, Items.shears, 1, false);
    }
    
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister ico) {
    	icons = new IIcon[2];
    	icons[0] = ico.registerIcon(Info.ID + ":Herb/Horsetail");
    	icons[1] = ico.registerIcon(Info.ID + ":Herb/Horsetail_harvested");
    }	
    
    
    @Override
    public boolean isRightSoil(Block ground) {
    	return ((ground == Blocks.dirt) || (ground == Blocks.grass));
    }
    
    
    @Override
    public boolean canPlaceBlockOn(Block ground) {
    	return ((ground == Blocks.grass) || (ground == Blocks.dirt)
    		    || (ground == Blocks.farmland));
    }
    
    
    @Override
    public int getSizeFactor() {
    	return 4;
    }
    
    
    @Override
    public boolean isGoodBiome(BiomeGenBase biome) {
    	return ((BiomeDictionary.isBiomeOfType(biome, Type.SWAMP) 
    				|| BiomeDictionary.isBiomeOfType(biome, Type.WET)
    				|| BiomeDictionary.isBiomeOfType(biome, Type.RIVER)
    				|| biome.isHighHumidity())
    			&& (biome.temperature >= 0.2f));
    }
    
}

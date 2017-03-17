package jaredbgreat.minefantasy.blocks;

import jaredbgreat.minefantasy.Info;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStoneSlab;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


/**
 * This models a group of slabs.  No more the 8 slabs my in the the group, as the 8 bit hold
 * upper versus lower slab data.  Two blocks must still be create per group, as a separate 
 * block is still needed for the double slab.
 * 
 * @author JaredBGreat
 *
 */
public class BasicSlab extends BlockStoneSlab {
	private final String name;
	private final int number;
	private final Block singleSlab;
	@SideOnly(Side.CLIENT)
	private IIcon[] icons;
	

	public BasicSlab(String name, boolean fullOpaque, Block singelSlab, Material mat, int number, 
			float hardness, float resistance, Block.SoundType sound) {
		super(fullOpaque);
		this.name = name;
		this.number = number;
		setBlockName(Info.ID + "-" + name);
		setCreativeTab(CreativeTabs.tabBlock);
		setHardness(hardness);
		setResistance(resistance);
		setStepSound(sound);
		singleSlab = singelSlab;
	}
	

	public BasicSlab(String name, boolean fullOpaque, Material mat, int number, 
			float hardness, float resistance, Block.SoundType sound) {
		super(fullOpaque);
		this.name = name;
		this.number = number;
		setBlockName(Info.ID + "-" + name);
		setCreativeTab(CreativeTabs.tabBlock);
		setHardness(hardness);
		setResistance(resistance);
		setStepSound(sound);
		singleSlab = this;
	}
	
	
	@Override
	@SideOnly(Side.CLIENT)
	@SuppressWarnings({"unchecked", "rawtypes"})
	public void getSubBlocks(Item item, CreativeTabs tabs, List list) {
		if(singleSlab != this) return;
		for(int i = 0; i < number; i++) {
			list.add(new ItemStack(item, 1, i));
		}
	}

	
    protected ItemStack createStackedBlock(int meta)
    {
        return new ItemStack(Item.getItemFromBlock(singleSlab), 2, meta & 3);
    }

    
    public String func_150002_b(int meta)
    {
    	return super.getUnlocalizedName() + "-slab" + (meta & 7);
    }
	
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iReg) {
		icons = new IIcon[number];		
		for(int i=0; i < number; i++) {
			icons[i] = iReg.registerIcon(Info.ID + ":Basic/" + name + i);
		}
	}
	
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		return icons[meta & 7];
	}

	
    public Item getItemDropped(int meta, Random random, int fortune) {
        return Item.getItemFromBlock(singleSlab);
    }

}

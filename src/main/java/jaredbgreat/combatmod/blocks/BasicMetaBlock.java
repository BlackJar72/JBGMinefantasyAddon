package jaredbgreat.combatmod.blocks;

import jaredbgreat.combatmod.Info;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BasicMetaBlock extends Block {
	private final String name;
	private final int number;
	@SideOnly(Side.CLIENT)
	private IIcon[] icons;
	

	protected BasicMetaBlock(String name, Material mat, int number, 
			float hardness, float resistance, Block.SoundType sound) {
		super(mat);
		this.name = name;
		this.number = number;
		setBlockName(Info.ID + "-" + name);
		setCreativeTab(CreativeTabs.tabBlock);
		setHardness(hardness);
		setResistance(resistance);
		setStepSound(sound);
	}
	
	
	@Override
	@SideOnly(Side.CLIENT)
	@SuppressWarnings({"unchecked", "rawtypes"})
	public void getSubBlocks(Item item, CreativeTabs tabs, List list) {
		for(int i = 0; i < number; i++) {
			list.add(new ItemStack(item, 1, i));
		}
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
		return icons[meta];
	}
	
	
	@Override
	public int damageDropped(int meta) {
	    return meta;
	}
}

package jaredbgreat.combatmod.worldgen;

import jaredbgreat.combatmod.herbs.BlockHerb;
import jaredbgreat.combatmod.herbs.EHerbs;
import jaredbgreat.combatmod.herbs.Herbs;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;


public class GenerateHerbs extends WorldGenerator {

	@Override
	public boolean generate(World world, Random random, int ix, int iy, int iz) {
		BlockHerb type = getHerbType(world.getBiomeGenForCoords(ix, iz), random);
		int b = type.getSizeFactor();
		int a = b * 2;
		b++;
		int n = a + random.nextInt(b) + random.nextInt(b);
		
		int x, y, z;
		for(int i = 0; i <= n; i++) {
			x = ix + random.nextInt(8) - random.nextInt(8);
			y = iy + random.nextInt(4) - random.nextInt(4);
			z = iz + random.nextInt(8) - random.nextInt(8);
			if(isLocationValid(world, x, y, z, type)) {
				world.setBlock(x, y, z, type);
			}
		}		
		return true;
	}
	
	
	private BlockHerb getHerbType(BiomeGenBase biome, Random random) {
		switch (EHerbs.getAny(random)) { // Stand-in until biome specific selection
			case GINSENG:
				return Herbs.ginseng;
			case MARSHMALLOW:
				return Herbs.marshmallow;
			case CAMOMILE:
				return Herbs.camomile;
			case ALOE:
				return Herbs.aloevera;
			default:
				return Herbs.ginseng;
		}
	}
	
	
	private boolean isLocationValid(World world, int x, int y, int z, BlockHerb herb) {
		if(!world.isAirBlock(x, y, z)) {
			return false;
		}
		BiomeGenBase biome = world.getBiomeGenForCoords(x, z);
		Block ground = world.getBlock(x, y - 1, z);
		return herb.isRightSoil(ground) && herb.isGoodBiome(biome);
	}

}

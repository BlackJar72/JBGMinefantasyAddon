package jaredbgreat.combatmod.worldgen;

import static jaredbgreat.combatmod.herbs.Herbs.ginseng;
import jaredbgreat.combatmod.herbs.BlockHerb;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;


public class GenerateHerbs extends WorldGenerator {

	@Override
	public boolean generate(World world, Random random, int ix, int iy, int iz) {
		BlockHerb type = getHerbTyoe(world.getBiomeGenForCoords(ix, iz));
		int n = 8 + random.nextInt(5) + random.nextInt(5);
		
		int x, y, z;
		for(int i = 0; i <= n; i++) {
			x = ix + random.nextInt(8) - random.nextInt(8);
			y = iy + random.nextInt(4) - random.nextInt(4);
			z = iz + random.nextInt(8) - random.nextInt(8);
			if(isLocationValid(world, x, y, z)) {
				world.setBlock(x, y, z, type);
			}
		}		
		return true;
	}
	
	
	private BlockHerb getHerbTyoe(BiomeGenBase biome) {
		return ginseng;
	}
	
	
	private boolean isLocationValid(World world, int x, int y, int z) {
		if(!world.isAirBlock(x, y, z)) {
			return false; // false ???
		}
		Block ground = world.getBlock(x, y - 1, z);
		return ((ground == Blocks.dirt) || (ground == Blocks.grass));
	}

}

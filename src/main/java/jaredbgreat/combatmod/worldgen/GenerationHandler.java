package jaredbgreat.combatmod.worldgen;

import jaredbgreat.combatmod.blocks.MF1Blocks;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.common.BiomeDictionary;
import cpw.mods.fml.common.IWorldGenerator;

public class GenerationHandler implements IWorldGenerator {
	//long ot = 0, at = 0, on = 0, an = 0, gt = 0, gn = 0;
	private WorldGenMinable graniteGen1;
	private WorldGenMinable graniteGen2;
	private WorldGenMinable slateGen1;
	private WorldGenMinable slateGen2;
	
	public GenerationHandler() {
		graniteGen1 = new WorldGenMinable(MF1Blocks.granite, 64);
		slateGen1   = new WorldGenMinable(MF1Blocks.slate,   64);
		graniteGen2 = new WorldGenMinable(MF1Blocks.granite, 32);
		slateGen2   = new WorldGenMinable(MF1Blocks.slate,   32);
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		if(world.isRemote || world.provider.dimensionId == 1) {
			return;
		} else if(world.provider.dimensionId == -1) {
			netherGeneration(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
		} else {
			normalGeneration(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
		}
	}
	
	
	/**
	 * Generates ores for the overworld and most modded dimensions, but not in the nether.
	 */
	private void normalGeneration(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		
		if(random.nextInt(8) == 0) {
			addSlate(world, 2, 64, 0, 4, chunkX, chunkZ, random);
		}
		if(BiomeDictionary.isBiomeOfType(world.getBiomeGenForCoords((16 * chunkX + 8), (16 * chunkZ + 8)), BiomeDictionary.Type.MOUNTAIN) ||
				BiomeDictionary.isBiomeOfType(world.getBiomeGenForCoords((16 * chunkX + 8), (16 * chunkZ + 8)), BiomeDictionary.Type.HILLS)) {
			addGranite(world, 2, 96, true, 1, 1, chunkX, chunkZ, random);
			addGranite(world, 2, 64, false, 1, 8, chunkX, chunkZ, random);
		} else if (random.nextInt(16) == 0) {
			addGranite(world, 2, 64, true, 1, 1, chunkX, chunkZ, random);
		}
	}
	
	
	/**
	 * Adds generations for the nether (currently does nothing).
	 * 
	 * @param random
	 * @param chunkX
	 * @param chunkZ
	 * @param world
	 * @param chunkGenerator
	 * @param chunkProvider
	 */
	private void netherGeneration(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {/*For now, doing nothing*/}
	
	
	/**
	 * Like it says, add granite
	 * 
	 * @param world
	 * @param minY
	 * @param maxY
	 * @param big
	 * @param minTimes
	 * @param maxTimes
	 * @param chunkX
	 * @param chunkZ
	 * @param random
	 */
	private void addGranite(World world, int minY, int maxY, boolean big,
			int minTimes, int maxTimes, int chunkX, int chunkZ, Random random) 
	{
		int times = getRandomRange(minTimes, maxTimes, random);
		WorldGenMinable gen;
		if(big) {
			for(int i = 0; i < times; i++) {
				int x = random.nextInt(16) + (16 * chunkX);
				int y = getRandomRange(minY, maxY, random);
				int z = random.nextInt(16) + (16 * chunkZ); 
				graniteGen1.generate(world, random, x, y, z);
			}
		} else {
			for(int i = 0; i < times; i++) {
				int x = random.nextInt(16) + (16 * chunkX);
				int y = getRandomRange(minY, maxY, random);
				int z = random.nextInt(16) + (16 * chunkZ); 
				graniteGen2.generate(world, random, x, y, z);}
		}
	}
	
	
	/**
	 * Like it says, add slate
	 * @param world
	 * @param minY
	 * @param maxY
	 * @param minTimes
	 * @param maxTimes
	 * @param chunkX
	 * @param chunkZ
	 * @param random
	 */
	private void addSlate(World world, int minY, int maxY, 
			int minTimes, int maxTimes, int chunkX, int chunkZ, Random random) 
	{
		int times = getRandomRange(minTimes, maxTimes, random);
		WorldGenMinable gen;
		for(int i = 0; i < times; i++) {
			int x = random.nextInt(16) + (16 * chunkX);
			int y = getRandomRange(minY, maxY, random);
			int z = random.nextInt(16) + (16 * chunkZ); 
			slateGen1.generate(world, random, x, y, z);
		}
	}
	
	
	/**
	 * Places ores (etc.) the vanilla way.
	 * 
	 * @param world
	 * @param block
	 * @param meta
	 * @param replace
	 * @param minY
	 * @param maxY
	 * @param minSize
	 * @param maxSize
	 * @param minTimes
	 * @param maxTimes
	 * @param chunkX
	 * @param chunkZ
	 * @param random
	 */
	private void spawnBlockAsOre(World world, Block block, int meta, Block replace, 
			int minY, int maxY, int minSize, int maxSize, int minTimes, int maxTimes, 
			int chunkX, int chunkZ, Random random) 
	{
//		long time = System.nanoTime();
		int size = getRandomRange(minSize, maxSize, random);
		int times = getRandomRange(minTimes, maxTimes, random);
		WorldGenMinable gen;
		for(int i = 0; i < times; i++) {
			int x = random.nextInt(16) + (16 * chunkX);
			int y = getRandomRange(minY, maxY, random);
			int z = random.nextInt(16) + (16 * chunkZ);
			gen = new WorldGenMinable(block, meta, size, replace); 
			gen.generate(world, random, x, y, z);
		}
//		ot += (System.nanoTime() - time);
//		on++;
//		System.out.println("Generate as ORE averaging " + (ot / (1000 * on)) + " ms.");
	}
	
	
	/** Places ores (etc.) based using graph based cellular automata.  This can make interesting
	 * ore formation, but is slower (about twice the time) and should not be used excessively.  
	 * For some reason it does not seem to place ores and consistently or in as much quantity, which
	 * theoretically should not be true, so there is an apparent bug.
	 * 
	 * @param world
	 * @param block
	 * @param meta
	 * @param replace
	 * @param minY
	 * @param maxY
	 * @param minSize
	 * @param maxSize
	 * @param minTimes
	 * @param maxTimes
	 * @param chunkX
	 * @param chunkZ
	 * @param random
	 */
	private void spawnBlockAsAutomata(World world, Block block, int meta, Block replace, 
			int minY, int maxY, int minSize, int maxSize, int minTimes, int maxTimes, 
			int chunkX, int chunkZ, Random random) 
	{
//		long time = System.nanoTime();
		int size = getRandomRange(minSize, maxSize, random);
		int times = getRandomRange(minTimes, maxTimes, random);
		for(int i = 0; i < times; i++) {
			int x = random.nextInt(16);
			int y = random.nextInt(maxY - minY) + minY;
			int z = random.nextInt(16);
			int px, pz;
			Place current;			
			PlaceQueue placeQueue = new PlaceQueue(x, y, z, random);
			while(size > 0 && !placeQueue.isEmpty()) {
				current = placeQueue.getNext();
				px = current.x + (16 * chunkX);
				pz = current.z + (16 * chunkZ);
				if(world.getBlock(px, current.y, pz) == replace) {
					world.setBlock(px, current.y, pz, block, meta, 2);
				}
				size--;
			}
		}
//		at += (System.nanoTime() - time);
//		an++;
//		System.out.println("Generate as AUTOMATA averaging " + (at / (1000 * an)) + " ms.");
	}
	
	
	/**
	 * Turns the bottom of the world to black granite (the new bed-rock for low tier tools).
	 * 
	 * Its the results are good, but it lads the already laggy 1.7.10 too much, so not so good
	 * in actual use.
	 * 
	 * @param world
	 * @param chunkX
	 * @param chunkZ
	 * @param random
	 */
	private void granitize(World world, int chunkX, int chunkZ, Random random) {
//		long time = System.nanoTime();
		int sx = chunkX * 16;
		int sz = chunkZ * 16;
		int sy;
		for(int i = sx + 15; i >= sx; i--)
			for(int j = sz + 15; j >= sz; j--) {
				sy = 4 + (world.getHeightValue(sx, sz) / 8) + random.nextInt(2);
				for(int k = sy; k > 0; k--) {
					if(world.getBlock(i, k, j) == Blocks.stone) {
						world.setBlock(i, k, j, MF1Blocks.granite, 0, 2);
					}
				}
			}
//		gt += (System.nanoTime() - time);
//		gn++;
//		System.out.println("Generate as GRANITIZER averaging " + (gt / (1000 * gn)) + " ms.");
				
	}
	
	
	private class Place implements Comparable<Place> {
		public int x, y, z, w;
		public Place(int x, int y, int z, Random random) {
			this.x = Math.max(-15, Math.min(31, x));
			this.y = Math.max(0, Math.min(255, y));
			this.z = Math.max(-15, Math.min(31, z));
			w = random.nextInt();
		}
		@Override
		public int compareTo(Place o) {
			return w - o.w;
		}
		public boolean equals(Place o) {
			return (x == o.x && y == o.y && z == o.z);
		}
	}
	
	
	private class PlaceQueue extends PriorityQueue<Place> {
		Random random;
		Set used = new HashSet<Place>();
		public PlaceQueue(int x, int y, int z, Random random) {
			add(new Place(x, y, z, random));
			this.random = random;
		}
	    public Place getNext() {
	    	Place out = super.poll();
	    	used.add(out);
	    	this.add(new Place(out.x+1, out.y, out.z, random));
	    	this.add(new Place(out.x-1, out.y, out.z, random));
	    	this.add(new Place(out.x, out.y+1, out.z, random));
	    	this.add(new Place(out.x, out.y-1, out.z, random));
	    	this.add(new Place(out.x, out.y, out.z+1, random));
	    	this.add(new Place(out.x, out.y, out.z-1, random));
	    	return out;
	    }
	    public boolean add(Place place) {
	    	if(!used.contains(place) && validate(place)) return super.add(place);
	    	else return false;
	    }
	    private boolean validate(Place p) {
	    	// This prevents generation from moving between chunks (which creates lag spikes)
	    	return (p.x >= 0) && (p.x <=15)
	    			&& (p.y > 0) && (p.x < 256)
	    			&& (p.z >= 0) && (p.z <=15);
	    }
	    
	}
	
	
	public int getRandomRange(int min, int max, Random random) {
		if(min >= max) return max;
		else return random.nextInt(max - min + 1) + min;
	}

}

package jaredbgreat.combatmod.herbs;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import cpw.mods.fml.common.registry.GameRegistry;

public class Herbs {
	
	//Blocks
	public static final GinsengPlant ginseng = new GinsengPlant();
	public static final MarshmallowPlant marshmallow = new MarshmallowPlant();
	public static final CamomilePlant camomile = new CamomilePlant();
	public static final AloeVeraPlant aloevera = new AloeVeraPlant();
	
	//Items
	public static final GinsengItem ginsengroot = new GinsengItem(3, 2f);
	public static final MarshmallowItem marshmallowroot = new MarshmallowItem(3, 2f);
	public static final CamomileItem camomileherb = new CamomileItem();
	public static final AloeVeraItem aloe = new AloeVeraItem();
	
	
	public static void InitPlants() {
		GameRegistry.registerBlock(ginseng, "ginseng");
		GameRegistry.registerItem(ginsengroot, "ginsengRoot");
		GameRegistry.registerBlock(marshmallow, "marshmallow");
		GameRegistry.registerItem(marshmallowroot, "marshmallowRoot");
		GameRegistry.registerBlock(camomile, "camomile");
		GameRegistry.registerItem(camomileherb, "camomileHerb");
		GameRegistry.registerBlock(aloevera, "aloevera");
		GameRegistry.registerItem(aloe, "aloe");
	}
	
	
	//public static void InitRecipes() {}
	
	
	public static void generateHerbs(World world, Random random, int cx, int cy) {
		int bx = (cx * 16) + random.nextInt(16);
		int by = (cy * 16) + random.nextInt(16);
		int bz = world.getHeight() + 1;
		
		int x, y, z;
		
		BlockHerb type = ginseng; // TODO: Select herb
		
		int n = 3 + random.nextInt(6); // 3-8
		
		for(int i = 0; i <= n; i++) {
			z = bz + random.nextInt(4) - random.nextInt(4);
			x = bx + random.nextInt(5) - random.nextInt(5);
			y = by + random.nextInt(5) - random.nextInt(5);
			if(world.isAirBlock(x, y, z) 
					&& ((world.getBlock(x, y - 1, z) == Blocks.dirt) 
							|| (world.getBlock(x, y-1, z) == Blocks.grass))) {
				world.setBlock(x, y, z, type);
			}
		}
	}
}

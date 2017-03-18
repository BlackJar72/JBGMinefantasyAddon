package jaredbgreat.minefantasy.herbs;

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
	public static final HorsetailPlant horsetail = new HorsetailPlant();
	public static final CohoshPlant cohosh = new CohoshPlant();
	
	//Items
	public static final GinsengItem ginsengroot = new GinsengItem();
	public static final MarshmallowItem marshmallowroot = new MarshmallowItem();
	public static final ItemHerb camomileherb = new ItemHerb(EHerbs.CAMOMILE);
	public static final ItemHerb aloe = new ItemHerb(EHerbs.ALOE);
	public static final ItemHerb horsetailItem = new ItemHerb(EHerbs.HORSETAIL);
	public static final ItemHerb cohoshItem = new ItemHerb(EHerbs.COHOSH);
	
	
	public static void InitPlants() {
		GameRegistry.registerBlock(ginseng, "ginseng");
		GameRegistry.registerItem(ginsengroot, "ginsengRoot");
		GameRegistry.registerBlock(marshmallow, "marshmallow");
		GameRegistry.registerItem(marshmallowroot, "marshmallowRoot");
		GameRegistry.registerBlock(camomile, "camomile");
		GameRegistry.registerItem(camomileherb, "camomileHerb");
		GameRegistry.registerBlock(aloevera, "aloevera");
		GameRegistry.registerItem(aloe, "aloe");
		GameRegistry.registerBlock(horsetail, "horsetail");
		GameRegistry.registerItem(horsetailItem, "horsetailItem");
		GameRegistry.registerBlock(cohosh, "cohosh");
		GameRegistry.registerItem(cohoshItem, "cohoshItem");
	}
}

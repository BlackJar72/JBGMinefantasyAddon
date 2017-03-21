package jaredbgreat.minefantasy;

/* 
 * This mod is the creation and copyright (c) 2017 
 * of Jared Blackburn (JaredBGreat).
 * 
 * NO WARRANTEE, OF ANY KIND.  This is freely available, and offers
 * no warrantees or guarantees, not even merchantability or fitness 
 * for a particular purpose.  No liability is accepted by the author 
 * for any use, proper or improper, of this mod or any dirivative 
 * there of, or any damages resulting from its use.
 * 
 * It is licensed under the creative commons 4.0 attribution license:  
 * https://creativecommons.org/licenses/by/4.0/legalcode
*/

import java.io.File;

import jaredbgreat.minefantasy.blocks.AddonBlocks;
import jaredbgreat.minefantasy.combat.AttackHandler;
import jaredbgreat.minefantasy.combat.PlayerHandler;
import jaredbgreat.minefantasy.herbs.Herbs;
import jaredbgreat.minefantasy.recipes.BasicRecipes;
import jaredbgreat.minefantasy.recipes.CarpenterRecipes;
import jaredbgreat.minefantasy.recipes.ForgedRecipes;
import jaredbgreat.minefantasy.worldgen.GenerationHandler;
import net.minecraft.client.Minecraft;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.registry.GameRegistry;

/** A mod to eliminate spam-click combat, in a way similar to later vanilla. 
 *  game versions.
 * 
 * @author JaredBGreat (Jared Blackburn)
 */
@Mod(modid=Info.ID, name=Info.NAME, version=Info.VERSION, acceptableRemoteVersions=Info.VERSION, 
dependencies = "required-after:minefantasy2;after:dynamicswordskills;after:dldungeonsjbg")
public class JBGMinefantasyAddon {
	@Instance(Info.ID)
	private static JBGMinefantasyAddon instance;
	private static Minecraft game;
	private static TickHandler updater;
	private static PlayerHandler players;
	private static AttackHandler attackHandler;
	public static GenerationHandler generationHandler;
	

    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	ConfigHandler.findConfigDir(event.getModConfigurationDirectory());
    	ConfigHandler.init();
    	game = Minecraft.getMinecraft();
    	players = PlayerHandler.getPlayerHandler();
    	attackHandler = AttackHandler.getAttackHandler();
    	FMLCommonHandler.instance().bus().register(updater = new TickHandler());
    	BlockInit();
    }

    
    @EventHandler 
    public void init(FMLInitializationEvent event) {
    }
    
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {}
    
    
    @EventHandler
    public void serverLoad(FMLServerStartingEvent event) {}   
    
    
    private void BlockInit() {
		AddonBlocks.register();
		if(ConfigHandler.includeHerbs) {
			Herbs.InitPlants();
		}
		generationHandler = new GenerationHandler();
		GameRegistry.registerWorldGenerator(generationHandler, 64);
		BasicRecipes.register();
		CarpenterRecipes.register();
		ForgedRecipes.register();
	}
}

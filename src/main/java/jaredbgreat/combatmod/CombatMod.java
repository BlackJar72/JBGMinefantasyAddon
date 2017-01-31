package jaredbgreat.combatmod;

import jaredbgreat.combatmod.combat.AttackHandler;
import jaredbgreat.combatmod.combat.PlayerHandler;
import net.minecraft.client.Minecraft;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;


@Mod(modid=Info.ID, name=Info.NAME, version=Info.VERSION, acceptableRemoteVersions=Info.VERSION)
public class CombatMod {
	@Instance(Info.ID)
	private static CombatMod instance;
	private static Minecraft game;
	private static TickHandler updater;
	private static PlayerHandler players;
	private static AttackHandler attackHandler;
	

    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	//System.out.println(Info.NAME + " is in preInit, should now load config.");
    	game = Minecraft.getMinecraft();
    	players = PlayerHandler.getPlayerHandler();
    	attackHandler = AttackHandler.getAttackHandler();
    	FMLCommonHandler.instance().bus().register(updater = new TickHandler());
    	//MinecraftForge.EVENT_BUS.register(updater = new TickHandler());
    	// TODO: All this!
    }

    
    @EventHandler 
    public void init(FMLInitializationEvent event) {
    	// TODO: All this!
    }
    
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    	// TODO: All this!
    }
    
    
    @EventHandler
    public void serverLoad(FMLServerStartingEvent event) {
    }
    	

}

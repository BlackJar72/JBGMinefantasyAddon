package jaredbgreat.minefantasy;

import jaredbgreat.minefantasy.blocks.tileentities.TeletoyLogic;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class ConfigHandler {
	static File configDir;
	
	public static float DssFactor = -20f;
	public static int herbRarity = 4;
	
	public static boolean includeHerbs = true;
	public static boolean includeTPs = true;
	public static boolean craftTPs = true;
	public static boolean includeNoSpamAttack = true;
	public static boolean includeSlate = true;
	public static boolean includeGranite = true;
	
	
	public static void init() {
		File file = new File(ConfigHandler.configDir.toString() 
				+ File.separator + Info.CAMELID  + ".cfg");
		Configuration config = new Configuration(file);
		config.load();
		
		DssFactor = -config.getFloat("DssFactor", "Combat", 20f, 0f, 10000f, 
				"Determines how much Minefantasy stamina is used for Dynamic Sword Skill moves");
		
		includeNoSpamAttack = config.getBoolean("NoSpamAttack", "Combat", true, 
				"Determines if the anti-attack spamming mechanic "
				+ "in enabled (similar to Minecraft 1.9+)");
		
		includeHerbs = config.getBoolean("IncludeHerbs", "Herbs", true, 
				"Determines if herbs will be added to the game");
		
		herbRarity = config.getInt("HerbRarity", "Herbs", 4, 1, 65535, 
				"Determines how frequently herbs arpper; "
				+ "up to one in HerbRarity chunks may generate herbs.");
		
		includeTPs = config.getBoolean("TelepadsExist", "Teleportation", true, 
				"Determines if telepads (including teleport landing pads) exist");
		
		if(includeTPs) {
			craftTPs = config.getBoolean("TelepadsCraftable", "Teleportation", true,
				"Determines if telepads (including teleport landing pads) can be crafted");
		} else {
			craftTPs = false;
		}
				
		includeSlate = config.getBoolean("IncludeSlate", "WorldGen", true, 
				"Determines if slate will be added during world generation");
		
		includeGranite = config.getBoolean("IncludeGranite", "WorldGen", true, 
				"Determines if granite will be added during world generation");
		
		int ttr = config.getInt("TeletoyRange", "Teleportation", 256, 0, Integer.MAX_VALUE, 
				"The maximum range of a short range teleporter.");
		TeletoyLogic.setMaxRange(ttr);
		

		config.save();		
	}

	
	public static File findConfigDir(File fd) {
		File out = new File(fd.toString());
		if(!out.exists()) out.mkdir();		
		if(!out.exists()) {
			System.err.println("[DLDUNGEONS] ERROR: Could not create config directory");
		} else if(!out.isDirectory()) {
			System.err.println("[DLDUNGEONS] ERROR: Config directory is not a directory!");
		} else {
			configDir = out;
		}
		return out;
	}

}

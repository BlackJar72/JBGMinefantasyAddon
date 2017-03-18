package jaredbgreat.minefantasy.herbs;

import java.util.EnumSet;
import java.util.Random;

import net.minecraft.potion.PotionHelper;

public enum EHerbs {
	
	GINSENG (3, 2, "+4"),
	// Depending on another class that might not be loaded 
	// would be bad in some environments, but Minecraft and
	// Forge have to be loaded for this to load.
	MARSHMALLOW (3, 3, PotionHelper.glowstoneEffect),
	CAMOMILE (0, 0, PotionHelper.ghastTearEffect),
	ALOE (0, 0, PotionHelper.speckledMelonEffect),
	HORSETAIL (0, 0, PotionHelper.magmaCreamEffect),
	COHOSH (0, 0, PotionHelper.blazePowderEffect);
	
	public final int hunger;
	public final float saturation;
	public final String potion;
	
	private EHerbs(int h, float s, String p) {
		hunger = h;
		saturation = s;
		potion = p;
	}
	
	public static final EnumSet universal = EnumSet.allOf(EHerbs.class);
	
	
	public static EHerbs select(EnumSet<EHerbs> from, Random random) {
		if(from.isEmpty()) {
			return null;
		}
		int n = from.size();
		EHerbs[] ar = new EHerbs[n];
		from.toArray(ar);
		return ar[random.nextInt(n)];
	}
	
	
	public static EHerbs getAny(Random random) {
		return select(universal, random);
	}
}

package jaredbgreat.combatmod.herbs;

import java.util.EnumSet;
import java.util.Random;

public enum EHerbs {
	
	GINSENG,
	MARSHMALLOW,
	CAMOMILE,
	ALOE,
	HORSETAIL,
	COHOSH;
	
	
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

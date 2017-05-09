package jaredbgreat.minefantasy.mechanics;

import java.util.HashMap;
import java.util.HashSet;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;

public class TwoWayTeleportManager {
	
	private static class Count {
		int count;
		Count(int c) {
			count = c;
		}
	}
	
	private final HashSet<Entity> banned, removals;
	private final HashMap<Entity, Count> counter;
	
	
	public TwoWayTeleportManager() {
		banned    = new HashSet<Entity>();
		removals  = new HashSet<Entity>();
		counter   = new HashMap<Entity, Count>();
	}
	
	
	public boolean canTP(Entity e) {
		return !banned.contains(e);
	}
	
	
	public void add(Entity e) {
		if(e instanceof EntityLivingBase) {
			if(counter.containsKey(e)) {
				counter.get(e).count = 10;
			} else {
				counter.put(e, new Count(10));
			}
			banned.add(e);
		}
	}
	
	
	public void swap() {
		for(Entity e : banned) {
			if(counter.containsKey(e)) {
				if((--counter.get(e).count) < 1) {
					removals.add(e);
				}
			}
		}
		banned.removeAll(removals);
		removals.clear();
	}
}

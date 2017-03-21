package jaredbgreat.minefantasy.blocks.tileentities;


public class TeletoyLogic extends TelepadBaseLogic {
	private static double RANGESQ = 65536d; // 256 (maximum range) squared
	
	boolean inRange() {
		return (((targetX - xCoord) * (targetX - xCoord))  
			  + ((targetY - yCoord) * (targetY - yCoord))
			  + ((targetZ - zCoord) * (targetZ - zCoord)) <= RANGESQ);
	}
	
	public static void setMaxRange(int range) {
		long sqare = ((long)range) * ((long)range);
		RANGESQ = (double)(range * range);
	}
}

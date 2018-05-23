package net.minecraft.src;

import java.util.Random;

public class BlockBioMushroom extends BlockFlower {
	
	int tick;

	protected BlockBioMushroom(int i, int j) {
		super(i, j);
		float f = 0.2F;
		setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
		setTickOnLoad(true);
	}
	
	public void randomDisplayTick(World world, int i, int j, int k,
			Random random) {
		if(tick > 10){
			tick = 0;
		}
		else {
			tick++;
			return;
		}
		double d = (float) i + 0.5F;
		double d1 = (float) j + 0.2F;
		double d2 = (float) k + 0.5F;
		double d3 = 0.2199999988079071D;
		double d4 = 0.27000001072883606D;
		world.spawnParticle("spore", d, d1, d2, 0.0D, 0.0D, 0.0D);

	}
	
	protected boolean canThisPlantGrowOnThisBlockID(int i) {
		if(i == Block.leaves.blockID) return false;
		return Block.opaqueCubeLookup[i];
	}

}

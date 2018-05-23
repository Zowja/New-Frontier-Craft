package net.minecraft.src;

import java.util.Random;

public class BlockPebble extends BlockSand {

	public BlockPebble(int i, int j) {
		super(i, j);
	}
	
	public void updateTick(World world, int i, int j, int k, Random random) {
		if (random.nextInt(8) == 0)
		tryToFall(world, i, j, k);
	}

}

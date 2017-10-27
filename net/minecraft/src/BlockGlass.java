// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            BlockBreakable, Material

public class BlockGlass extends BlockBreakable {

	public BlockGlass(int i, int j, Material material, boolean flag) {
		super(i, j, material, flag);
	}
	
	public int getBlockTextureFromSideAndMetadata(int i, int j) {
		if (j == 1) {
			return 85;
		}
		else if (j == 2) {
			return 100;
		}
		else if (j == 3) {
			return 101;
		}
		return 49;
	}
	
	protected int damageDropped(int i) {
		return i;
	}

	public int getRenderBlockPass() {
		return 0;
	}
}

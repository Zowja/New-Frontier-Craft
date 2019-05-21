// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, Material

public class StoneBrick extends Block {
	public String detector;

	public StoneBrick(int i, int j) {
		super(i, j, Material.rock);
	}

	public int idDropped(int i, Random random) {
		return NFC.stoneBlock.blockID;
	}

	public String Version() {
		return "1.0";
	}
}

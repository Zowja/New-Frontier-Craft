// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, Material, Item, NFC

public class BlockOre extends Block {

	public BlockOre(int i, int j) {
		super(i, j, Material.rock);
	}

	public int idDropped(int i, Random random) {
		if (blockID == Block.oreCoal.blockID) {
			return Item.coal.shiftedIndex;
		}
		if (blockID == Block.oreDiamond.blockID) {
			return Item.diamond.shiftedIndex;
		}
		if (blockID == NFC.anthraciteore.blockID) {
			return NFC.anthracite.shiftedIndex;
		}
		if (blockID == NFC.sapphireore.blockID) {
			return NFC.sapphire.shiftedIndex;
		}
		if (blockID == NFC.rubyore.blockID) {
			return NFC.ruby.shiftedIndex;
		}
		if (blockID == NFC.emeraldore.blockID) {
			return NFC.emerald.shiftedIndex;
		}
		if (blockID == NFC.FakeBedrock.blockID) {
			return NFC.recordpleasedo.shiftedIndex;
		}
		if (blockID == NFC.mountainore.blockID) {
			return NFC.recordchant.shiftedIndex;
		}
		if (blockID == Block.oreLapis.blockID) {
			return Item.dyePowder.shiftedIndex;
		} else {
			return blockID;
		}
	}

	public int quantityDropped(Random random) {
		if (blockID == Block.oreLapis.blockID) {
			return 4 + random.nextInt(5);
		} else {
			return 1;
		}
	}

	protected int damageDropped(int i) {
		return blockID == Block.oreLapis.blockID ? 4 : 0;
	}
}

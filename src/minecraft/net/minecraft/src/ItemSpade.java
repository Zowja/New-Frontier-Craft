// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

// Referenced classes of package net.minecraft.src:
//            ItemTool, Block, EnumToolMaterial

public class ItemSpade extends ItemTool {

	public ItemSpade(int i, EnumToolMaterial enumtoolmaterial) {
		super(i, enumtoolmaterial, blocksEffectiveAgainst);
	}

	public boolean canHarvestBlock(Block block) {
		if (block == Block.snow) {
			return true;
		}
		return block == Block.blockSnow;
	}
	
	public float getStrVsBlock(ItemStack itemstack, Block block) {

		for (int i = 0; i < blocksEffectiveAgainst.length; i++) {
			if (blocksEffectiveAgainst[i] == block) {
				return efficiencyOnProperMaterial;
			}
		}
		if(block == NFC.pebble)
				return efficiencyOnProperMaterial;

		return 1.0F;
	}

	private static Block blocksEffectiveAgainst[];

	static {
		blocksEffectiveAgainst = (new Block[] { Block.grass, Block.dirt,
				Block.sand, Block.gravel, Block.snow, Block.blockSnow,
				Block.blockClay, Block.tilledField, NFC.pebble});
	}
}

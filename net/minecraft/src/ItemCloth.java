// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

// Referenced classes of package net.minecraft.src:
//            ItemBlock, Block, BlockCloth, ItemDye, 
//            ItemStack

public class ItemCloth extends ItemBlock {

	public ItemCloth(int i) {
		super(i);
		setMaxDamage(0);
		setHasSubtypes(true);
	}

	public int getIconFromDamage(int i) {
		return Block.cloth.getBlockTextureFromSideAndMetadata(2,
				BlockCloth.func_21034_c(i));
	}

	public int getPlacedBlockMetadata(int i) {
		return i;
	}

	public String getItemNameIS(ItemStack itemstack) {
		return (new StringBuilder())
				.append(dyeColors[BlockCloth.func_21034_c(itemstack
						.getItemDamage())])
						.append(" ")
		.append(super.getItemName()).toString();
	}
	
	public static final String dyeColors[] = { "Black", "Red", "Green",
		"Brown", "Blue", "Purple", "Cyan", "Light Gray", "Gray", "Pink",
		"Lime", "Yellow", "Light Blue", "Magenta", "Orange", "White" };
}

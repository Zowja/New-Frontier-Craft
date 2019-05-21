// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

// Referenced classes of package net.minecraft.src:
//            ItemTool, Block, EnumToolMaterial

public class ItemAxe extends ItemTool {

	protected ItemAxe(int i, EnumToolMaterial enumtoolmaterial) {
		super(i, enumtoolmaterial, blocksEffectiveAgainst);
	}

	private static Block blocksEffectiveAgainst[];

	static {
		blocksEffectiveAgainst = (new Block[] { Block.planks, Block.bookShelf,
				Block.wood, Block.chest, Block.doorWood, Block.pressurePlatePlanks, Block.stairCompactPlanks, 
				Block.fence, Block.trapdoor, Block.jukebox, Block.signPost, Block.signWall, Block.musicBlock,
				Block.ladder, Block.workbench});
	}
}

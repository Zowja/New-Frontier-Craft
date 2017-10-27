// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            BlockFlower, Block

public class BlockDeadBush extends BlockFlower
{

    protected BlockDeadBush(int i, int j)
    {
        super(i, j);
        float f = 0.4F;
        setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.8F, 0.5F + f);
    }

    protected boolean canThisPlantGrowOnThisBlockID(int i)
    {
        return Block.opaqueCubeLookup[i];
    }

    public int getBlockTextureFromSideAndMetadata(int i, int j)
    {
        return blockIndexInTexture;
    }

    public int idDropped(int i, Random random)
    {
        return Item.stick.shiftedIndex;
    }
    
    public void harvestBlock(World world, EntityPlayer entityplayer, int i,
			int j, int k, int l) {
		if (!world.multiplayerWorld
				&& entityplayer.getCurrentEquippedItem() != null
				&& entityplayer.getCurrentEquippedItem().itemID == Item.shears.shiftedIndex) {
			entityplayer.addStat(StatList.mineBlockStatArray[blockID], 1);
			dropBlockAsItem_do(world, i, j, k, new ItemStack(
					Block.deadBush, 1));
		} else {
			super.harvestBlock(world, entityplayer, i, j, k, l);
		}
	}
}

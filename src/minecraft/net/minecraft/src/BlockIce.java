// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            BlockBreakable, Material, World, Block, 
//            EnumSkyBlock, IBlockAccess, EntityPlayer

public class BlockIce extends BlockBreakable
{

    public BlockIce(int i, int j)
    {
        super(i, j, Material.ice, false);
        slipperiness = 0.98F;
        setTickOnLoad(true);
    }

    public int getRenderBlockPass()
    {
        return 1;
    }

    public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i, int j, int k, int l)
    {
        return super.shouldSideBeRendered(iblockaccess, i, j, k, 1 - l);
    }

    public int quantityDropped(Random random)
    {
        return 1;
    }
    
    protected int damageDropped(int i){
    	return 1;
    }

    public void updateTick(World world, int i, int j, int k, Random random)
    {
    	if( world.getBlockMetadata(i, j, k) != 1){
	        if(world.getSavedLightValue(EnumSkyBlock.Block, i, j, k) > 11 - Block.lightOpacity[blockID])
	        {
	            world.setBlockWithNotify(i, j, k, Block.waterStill.blockID);
	        }
    	} else {
        	if(world.getSavedLightValue(EnumSkyBlock.Block, i, j, k) > 14 - Block.lightOpacity[blockID])
	        {
	            world.setBlockWithNotify(i, j, k, 0);
	        }
        }
    }
    
    public void onBlockRemoval(World world, int i, int j, int k) {
    	super.onBlockRemoval(world, i, j, k);
    	if(world.getBlockMetadata(i, j, k) == 1){
    		return;
    	}
        Material material = world.getBlockMaterial(i, j - 1, k);
        if(material.getIsSolid() || material.getIsLiquid())
        {
            world.setBlockWithNotify(i, j, k, Block.waterMoving.blockID);
        }
	}

    public int getMobilityFlag()
    {
        return 0;
    }
}

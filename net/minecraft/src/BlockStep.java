// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.ArrayList;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, Material, World, IBlockAccess

public class BlockStep extends Block
{

    public BlockStep(int i, boolean flag)
    {
        super(i, 6, Material.rock);
        blockType = flag;
        setLightOpacity(255);
    }
    
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i, int j, int k)
    {
    	if(!blockType){
    		int l = world.getBlockMetadata(i, j, k);
    		if(l/8 == 0){
	    		setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
    		}
    		else {
    			setBlockBounds(0.0F, 0.5F, 0.0F, 1.0F, 1.0F, 1.0F);
    		}
    	}
    	else {
    		setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    	}
        return super.getCollisionBoundingBoxFromPool(world, i, j, k);
    }

    public int getBlockTextureFromSideAndMetadata(int i, int j)
    {
        if((j%8) == 0)
        {
            return i > 1 ? 5 : 6;
        }
        if((j%8) == 1)
        {
            if(i == 0)
            {
                return 208;
            }
            return i != 1 ? 192 : 176;
        }
        if((j%8) == 2)
        {
            return 4;
        }
        return (j%8) != 3 ? 6 : 16;
    }

    public int getBlockTextureFromSide(int i)
    {
        return getBlockTextureFromSideAndMetadata(i, 0);
    }

    public boolean isOpaqueCube()
    {
        return blockType;
    }
    
    public void onBlockPlacedBy(World world, int i, int j, int k,
			EntityLiving entityliving) {
    	 if(this != Block.stairSingle)
         {
             super.onBlockAdded(world, i, j, k);
         }
    	 if(entityliving.rotationPitch > 0F){
    		 int l = world.getBlockId(i, j - 1, k);
             int i1 = world.getBlockMetadata(i, j, k);
             int j1 = world.getBlockMetadata(i, j - 1, k);
             if(i1 != j1)
             {
                 return;
             }
             if(l == stairSingle.blockID)
             {
                 world.setBlockWithNotify(i, j, k, 0);
                 world.setBlockAndMetadataWithNotify(i, j - 1, k, getBlockIDfromMeta(j1), i1);
             }
    	 }
    	 else {
	         int l = world.getBlockId(i, j + 1, k);
	         int i1 = world.getBlockMetadata(i, j, k) + 8;
	         world.setBlockMetadata(i, j, k, i1);
	         int j1 = world.getBlockMetadata(i, j + 1, k);
	         if(i1 != j1)
	         {
	             return;
	         }
	         if(l == stairSingle.blockID)
	         {
	             world.setBlockWithNotify(i, j, k, 0);
	             world.setBlockAndMetadataWithNotify(i, j + 1, k, getBlockIDfromMeta(j1), i1);
	         }
    	 }
    }
    
    private int getBlockIDfromMeta(int i){
    	if(i%8 == 2){
    		return Block.planks.blockID;
    	}
    	else if(i%8 == 3){
    		return Block.cobblestone.blockID;
    	}
    	else if(i%8 == 0){
    		return Block.stairDouble.blockID;
    	}
    	else return Block.sandStone.blockID;
    }

    public int idDropped(int i, Random random)
    {
        return Block.stairSingle.blockID;
    }

    public int quantityDropped(Random random)
    {
        return !blockType ? 1 : 2;
    }

    protected int damageDropped(int i)
    {
        return i%8;
    }
    
    public boolean renderAsNormalBlock()
    {
        return blockType;
    }

    public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i, int j, int k, int l)
    {
        if(this != Block.stairSingle)
        {
            super.shouldSideBeRendered(iblockaccess, i, j, k, l);
        }
        if(l == 1)
        {
            return true;
        }
        if(!super.shouldSideBeRendered(iblockaccess, i, j, k, l))
        {
            return false;
        }
        if(l == 0)
        {
            return true;
        } else
        {
            return iblockaccess.getBlockId(i, j, k) != blockID;
        }
    }

    public static final String field_22037_a[] = {
        "Stone", "Sand", "Wood", "Cobble"
    };
    
    
    public void setBlockBoundsBasedOnState(IBlockAccess iblockaccess, int i, int j, int k)
    {
    	if(!blockType){
    		int l = iblockaccess.getBlockMetadata(i, j, k);
    		if(l/8 == 0){
    			setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
    		}
    		else {
    			setBlockBounds(0.0F, 0.5F, 0.0F, 1.0F, 1.0F, 1.0F);
    		}
    	}
    	else {
    		setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    	}
    }
    
    public void setBlockBoundsForItemRender() {
    	setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
    }
    
    private boolean blockType;

}

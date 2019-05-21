// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, Material, World, AxisAlignedBB

public class BlockLadder extends Block
{

    protected BlockLadder(int i, int j)
    {
        super(i, j, Material.circuits);
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i, int j, int k)
    {
        int l = world.getBlockMetadata(i, j, k);
        float f = 0.125F;
        if(l == 2)
        {
            setBlockBounds(0.0F, 0.0F, 1.0F - f, 1.0F, 1.0F, 1.0F);
        }
        if(l == 3)
        {
            setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, f);
        }
        if(l == 4)
        {
            setBlockBounds(1.0F - f, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        }
        if(l == 5)
        {
            setBlockBounds(0.0F, 0.0F, 0.0F, f, 1.0F, 1.0F);
        }
        return super.getCollisionBoundingBoxFromPool(world, i, j, k);
    }

    public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int i, int j, int k)
    {
        int l = world.getBlockMetadata(i, j, k);
        float f = 0.125F;
        if(l == 2)
        {
            setBlockBounds(0.0F, 0.0F, 1.0F - f, 1.0F, 1.0F, 1.0F);
        }
        if(l == 3)
        {
            setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, f);
        }
        if(l == 4)
        {
            setBlockBounds(1.0F - f, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        }
        if(l == 5)
        {
            setBlockBounds(0.0F, 0.0F, 0.0F, f, 1.0F, 1.0F);
        }
        return super.getSelectedBoundingBoxFromPool(world, i, j, k);
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }

    public int getRenderType()
    {
        return 8;
    }

    public boolean canPlaceBlockAt(World world, int i, int j, int k)
    {
        if(world.isBlockNormalCube(i - 1, j, k))
        {
            return true;
        }
        if(world.isBlockNormalCube(i + 1, j, k))
        {
            return true;
        }
        if(world.isBlockNormalCube(i, j, k - 1))
        {
            return true;
        }
        if(world.isBlockNormalCube(i, j, k + 1))
        {
            return true;
        }
        return world.getBlockId(i, j+1, k) == this.blockID;
    }

    public void onBlockPlaced(World world, int i, int j, int k, int l)
    {
        int i1 = world.getBlockMetadata(i, j, k);
        if((i1 == 0 || l == 2) && world.isBlockNormalCube(i, j, k + 1))
        {
            i1 = 2;
        }
        if((i1 == 0 || l == 3) && world.isBlockNormalCube(i, j, k - 1))
        {
            i1 = 3;
        }
        if((i1 == 0 || l == 4) && world.isBlockNormalCube(i + 1, j, k))
        {
            i1 = 4;
        }
        if((i1 == 0 || l == 5) && world.isBlockNormalCube(i - 1, j, k))
        {
            i1 = 5;
        }
        if(i1 == 0 && world.getBlockId(i, j+1, k) == this.blockID){
        	i1 = world.getBlockMetadata(i, j+1, k);
        }
        world.setBlockMetadataWithNotify(i, j, k, i1);
    }

    public void onNeighborBlockChange(World world, int i, int j, int k, int l)
    {
        int i1 = world.getBlockMetadata(i, j, k);
        boolean flag = false;
        if(i1 == 2 && world.isBlockNormalCube(i, j, k + 1))
        {
            flag = true;
        }
        if(i1 == 3 && world.isBlockNormalCube(i, j, k - 1))
        {
            flag = true;
        }
        if(i1 == 4 && world.isBlockNormalCube(i + 1, j, k))
        {
            flag = true;
        }
        if(i1 == 5 && world.isBlockNormalCube(i - 1, j, k))
        {
            flag = true;
        }
        if(world.getBlockId(i, j+1, k) == this.blockID){
        	flag = true;
        }
        if(!flag)
        {
            dropBlockAsItem(world, i, j, k, i1);
            world.setBlockWithNotify(i, j, k, 0);
        }
        super.onNeighborBlockChange(world, i, j, k, l);
    }

    public int quantityDropped(Random random)
    {
        return 1;
    }
}

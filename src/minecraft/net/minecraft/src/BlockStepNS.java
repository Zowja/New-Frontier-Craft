package net.minecraft.src;

import java.util.Random;

public class BlockStepNS extends Block {
	
	public BlockStepNS(int i) {
		super(i, 6, Material.slab);
        setStepSound(soundStoneFootstep);
		setLightOpacity(2);
	}
	
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i, int j, int k)
    {
    	if (world.getBlockMetadata(i, j, k)/8 == 0){
    		setBlockBounds(0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    	}
    	else {
    		setBlockBounds(0.0F, 0.0F, 0.0F, 0.5F, 1.0F, 1.0F);
    	}
		
        return super.getCollisionBoundingBoxFromPool(world, i, j, k);
    }
	
	public void setBlockBoundsForItemRender() {
    	setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.5F);
    }
	
	public int getBlockTextureFromSideAndMetadata(int i, int j)
    {
        if((j%8) == 0)
        {
            return i < 4 ? 148 : 6;
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
        if((j%8) == 3)
        {
            return 16;
        }
        return 7;
    }
    
	 public boolean renderAsNormalBlock()
	    {
	        return false;
	    }
	
	 public boolean isOpaqueCube()
	    {
	        return false;
	    }
	
	public void setBlockBoundsBasedOnState(IBlockAccess iblockaccess, int i, int j, int k)
    {
    	if (iblockaccess.getBlockMetadata(i, j, k)/8 == 0){
    		setBlockBounds(0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    	}
    	else {
    		setBlockBounds(0.0F, 0.0F, 0.0F, 0.5F, 1.0F, 1.0F);
    	}
    }
	
	protected int damageDropped(int i)
    {
        return i%8;
    }
	
	public int idDropped(int i, Random random)
    {
        return Block.stairSingle.blockID;
    }
	

}

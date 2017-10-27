package net.minecraft.src;

import java.util.Random;

public class BlockSidewaysStep extends Block {

	public BlockSidewaysStep(int i, boolean type) {
		super(i, 6, Material.rock);
		blockType = type;
		if(type) {
		setLightOpacity(255);
		} else {
		setLightOpacity(2);	
		}
	}
	
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i, int j, int k)
    {
		if(!blockType){
			int l = world.getBlockMetadata(i, j, k);
	    	if(l/4 == 3){
	    		setBlockBounds(0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
	    	}
	    	else if (l/4 == 1){
	    		setBlockBounds(0.0F, 0.0F, 0.0F, 0.5F, 1.0F, 1.0F);
	    	}
	    	else if (l/4 == 2){
	    		setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.5F);
	    	}
	    	else {
	    		setBlockBounds(0.0F, 0.0F, 0.5F, 1.0F, 1.0F, 1.0F);
	    	}
		}
    	else {
    		setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    	}
        return super.getCollisionBoundingBoxFromPool(world, i, j, k);
    }
	
	public void setBlockBoundsForItemRender() {
    	setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.5F);
    }
	
	public int getBlockTextureFromSideAndMetadata(int i, int j)
    {
		//148
        if((j%4) == 0)
        {
        	if((j+4)%8 == 0) {
                return i < 4 ? 148 : 6;
        	}
        	else {
                return i < 2 ? 5 : (i < 4 ? 6 : 148);
        	}
        }
        if((j%4) == 1)
        {
            if(i == 0)
            {
                return 208;
            }
            return i != 1 ? 192 : 176;
        }
        if((j%4) == 2)
        {
            return 4;
        }
        return (j%4) != 3 ? 6 : 16;
    }
    
	 public boolean renderAsNormalBlock()
	    {
	        return blockType;
	    }
	
	 public boolean isOpaqueCube()
	    {
	        return blockType;
	    }
	
	public void setBlockBoundsBasedOnState(IBlockAccess iblockaccess, int i, int j, int k)
    {
		if(!blockType){
	    	int l = iblockaccess.getBlockMetadata(i, j, k);
	    	if(l/4 == 3){
	    		setBlockBounds(0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
	    	}
	    	else if (l/4 == 1){
	    		setBlockBounds(0.0F, 0.0F, 0.0F, 0.5F, 1.0F, 1.0F);
	    	}
	    	else if (l/4 == 2){
	    		setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.5F);
	    	}
	    	else {
	    		setBlockBounds(0.0F, 0.0F, 0.5F, 1.0F, 1.0F, 1.0F);
	    	}
		}
		else {
    		setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    	}
    }
	
	public int quantityDropped(Random random)
    {
        return !blockType ? 1 : 2;
    }
	
	public void onBlockPlacedBy(World world, int i, int j, int k,
			EntityLiving entityliving) {
		
		if(this != NFC.SidewaysStep)
        {
            super.onBlockAdded(world, i, j, k);
        }
		
		int position = MathHelper.floor_double((double)((entityliving.rotationYaw * 4F) / 360F) + 0.5D) & 3;
		int blocktype = world.getBlockMetadata(i, j, k);
		System.out.println("Type: " + blocktype + " Position: " + position);
        int blockNear, blockNearMeta;
		
		if(position == 0){
			blockNear = world.getBlockId(i, j, k + 1);
	        blockNearMeta = world.getBlockMetadata(i, j, k + 1);
	        if(blockNear == NFC.SidewaysStep.blockID && blockNearMeta == (blocktype + (position*4))){
	        	world.setBlockWithNotify(i, j, k, 0);
	            world.setBlockAndMetadataWithNotify(i, j, k + 1, getBlockIDfromMeta(blocktype), blocktype + (position*4));
	        } else
	        world.setBlockMetadataWithNotify(i, j, k, blocktype + (position*4));
	        
		} else if (position == 1) {
			blockNear = world.getBlockId(i - 1, j, k);
	        blockNearMeta = world.getBlockMetadata(i - 1, j, k);
	        if(blockNear == NFC.SidewaysStep.blockID && blockNearMeta == (blocktype + (position*4))){
	        	world.setBlockWithNotify(i, j, k, 0);
	            world.setBlockAndMetadataWithNotify(i - 1, j, k, getBlockIDfromMeta(blocktype), blocktype + (position*4));
	        } else
	        world.setBlockMetadataWithNotify(i, j, k, blocktype + (position*4));
		} else if (position == 2) {
			blockNear = world.getBlockId(i, j, k - 1);
	        blockNearMeta = world.getBlockMetadata(i, j, k - 1);
	        if(blockNear == NFC.SidewaysStep.blockID && blockNearMeta == (blocktype + (position*4))){
	        	world.setBlockWithNotify(i, j, k, 0);
	            world.setBlockAndMetadataWithNotify(i, j, k - 1, getBlockIDfromMeta(blocktype), blocktype + (position*4));
	        } else
	        world.setBlockMetadataWithNotify(i, j, k, blocktype + (position*4));
		} else {
			blockNear = world.getBlockId(i + 1, j, k);
	        blockNearMeta = world.getBlockMetadata(i + 1, j, k);
	        if(blockNear == NFC.SidewaysStep.blockID && blockNearMeta == (blocktype + (position*4))){
	        	world.setBlockWithNotify(i, j, k, 0);
	            world.setBlockAndMetadataWithNotify(i + 1, j, k, getBlockIDfromMeta(blocktype), blocktype + (position*4));
	        } else
	        world.setBlockMetadataWithNotify(i, j, k, blocktype + (position*4));
		}
		System.out.println("Block: " + blockNear + " Meta: " + blockNearMeta + " This: " + (blocktype + (position*4)));
	}
	
	private int getBlockIDfromMeta(int i){
    	if(i%8 == 2){
    		return Block.planks.blockID;
    	}
    	else if(i%8 == 3){
    		return Block.cobblestone.blockID;
    	}
    	else if(i%8 == 0){
    		return NFC.DoubleSidewaysStep.blockID;
    	}
    	else return Block.sandStone.blockID;
    }
	
	protected int damageDropped(int i)
    {
        return i%4;
    }
	
	public int idDropped(int i, Random random)
    {
        return NFC.SidewaysStep.blockID;
    }
	
    private boolean blockType;
	
}

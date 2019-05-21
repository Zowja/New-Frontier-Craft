package net.minecraft.src;

import java.util.Random;

public class BlockDoubleStep extends Block {

	protected BlockDoubleStep(int i) {
		super(i, Material.slab);
		setStepSound(soundStoneFootstep);
	}
	
	public int quantityDropped(Random random)
    {
        return 2;
    }
	
	public int idDropped(int i, Random random)
    {
        return Block.stairSingle.blockID;
    }
	
	public int getBlockTextureFromSideAndMetadata(int i, int j)
    {
		if(j == 0){
			if(i < 2) return 6;
			else return 5;
		}
		if(j == 1)
        {
            if(i == 0)
            {
                return 208;
            }
            return i != 1 ? 192 : 176;
        }
		if(j == 2)
        {
            return 4;
        }
		if(j == 3)
        {
            return 16;
        }
		if(j == 1+3){
			if(i < 2) return 5;
			if(i < 4) return 6;
			else return 148;
		}
		if(i < 4) return 148;
		return 6;
    }
	
	public void onBlockPlacedBy(World world, int i, int j, int k, EntityLiving entityliving) {
		// Currently there are only 3 directions, but in the future there will be 6
		// The +3 is to show there needs to be a world conversion in the future to remove
		// The wooden, cobble, and sandstone double slabs
		if (entityliving.rotationPitch > 40F) {
			world.setBlockAndMetadataWithNotify(i, j, k, this.blockID, 0);
			return;
		}
		else if (entityliving.rotationPitch < -40F){
			world.setBlockAndMetadataWithNotify(i, j, k, this.blockID, 0);
			return;
		}
		else {
			int position = MathHelper.floor_double((double) ((entityliving.rotationYaw * 4F) / 360F) + 0.5D) & 3;
			if(position == 0){
				world.setBlockAndMetadataWithNotify(i, j, k, this.blockID, 1+3);
			}
			else if(position == 1){
				world.setBlockAndMetadataWithNotify(i, j, k, this.blockID, 2+3);
			}
			else if(position == 2){
				world.setBlockAndMetadataWithNotify(i, j, k, this.blockID, 1+3);
			}
			else {
				world.setBlockAndMetadataWithNotify(i, j, k, this.blockID, 2+3);
			}
		}
	}
	
	protected int damageDropped(int i)
    {
        if(i > 3){
        	return 0;
        }
        return i;
    }

}

// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.ArrayList;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, Material, World, IBlockAccess

public class BlockStepUD extends Block {

	public BlockStepUD(int i) {
		super(i, 6, Material.slab);
        setStepSound(soundStoneFootstep);
		setLightOpacity(2);
	}

	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i, int j, int k) {
		if (world.getBlockMetadata(i, j, k) / 8 == 0) {
			setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
		} else {
			setBlockBounds(0.0F, 0.5F, 0.0F, 1.0F, 1.0F, 1.0F);
		}
		return super.getCollisionBoundingBoxFromPool(world, i, j, k);
	}

	public int getBlockTextureFromSideAndMetadata(int i, int j) {
		if ((j % 8) == 0) {
			return i > 1 ? 5 : 6;
		}
		if ((j % 8) == 1) {
			if (i == 0) {
				return 208;
			}
			return i != 1 ? 192 : 176;
		}
		if ((j % 8) == 2) {
			return 4;
		}
		if ((j % 8) == 3) return 16;
		return 7;
	}

	public int getBlockTextureFromSide(int i) {
		return getBlockTextureFromSideAndMetadata(i, 0);
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public void onBlockPlacedBy(World world, int i, int j, int k, EntityLiving entityliving) {
		if (entityliving.rotationPitch > 40F) {
			int l = world.getBlockId(i, j - 1, k);
			int i1 = world.getBlockMetadata(i, j, k);
			int j1 = world.getBlockMetadata(i, j - 1, k);
			if (i1 != j1) {
				return;
			}
			if (l == stairSingle.blockID) {
				world.setBlockWithNotify(i, j, k, 0);
				world.setBlockAndMetadataWithNotify(i, j - 1, k, getBlockIDfromMeta(j1), 0);
			}
		} else if (entityliving.rotationPitch < -40F) {
			int l = world.getBlockId(i, j + 1, k);
			int i1 = world.getBlockMetadata(i, j, k) + 8;
			world.setBlockMetadata(i, j, k, i1);
			int j1 = world.getBlockMetadata(i, j + 1, k);
			if (i1 != j1) {
				return;
			}
			if (l == stairSingle.blockID) {
				world.setBlockWithNotify(i, j, k, 0);
				world.setBlockAndMetadataWithNotify(i, j + 1, k, getBlockIDfromMeta(j1), 0);
			}
		} else {
			int position = MathHelper.floor_double((double) ((entityliving.rotationYaw * 4F) / 360F) + 0.5D) & 3;
			int blocktype = world.getBlockMetadata(i, j, k);
			int blockNear, blockNearMeta;

			if (position == 0) {
				world.setBlockWithNotify(i, j, k, NFC.EWStep.blockID);
				blockNear = world.getBlockId(i, j, k + 1);
				blockNearMeta = world.getBlockMetadata(i, j, k + 1);
				if (blockNear == NFC.EWStep.blockID && blockNearMeta == blocktype) {
					world.setBlockWithNotify(i, j, k, 0);
					world.setBlockAndMetadataWithNotify(i, j, k + 1, getBlockIDfromMeta(blocktype),
							blocktype/2 == 0 ? 3+1 : 0);
				} else
					world.setBlockMetadataWithNotify(i, j, k, blocktype);

			} else if (position == 1) {
				world.setBlockWithNotify(i, j, k, NFC.NSStep.blockID);
				blockNear = world.getBlockId(i - 1, j, k);
				blockNearMeta = world.getBlockMetadata(i - 1, j, k);
				if (blockNear == NFC.NSStep.blockID && blockNearMeta == (blocktype + 8)) {
					world.setBlockWithNotify(i, j, k, 0);
					world.setBlockAndMetadataWithNotify(i - 1, j, k, getBlockIDfromMeta(blocktype),
							blocktype/2 == 0 ? 3+2 : 0);
				} else {
					world.setBlockMetadataWithNotify(i, j, k, blocktype + 8);
				}
			} else if (position == 2) {
				world.setBlockWithNotify(i, j, k, NFC.EWStep.blockID);
				blockNear = world.getBlockId(i, j, k - 1);
				blockNearMeta = world.getBlockMetadata(i, j, k - 1);
				if (blockNear == NFC.EWStep.blockID && blockNearMeta == (blocktype + 8)) {
					world.setBlockWithNotify(i, j, k, 0);
					world.setBlockAndMetadataWithNotify(i, j, k - 1, getBlockIDfromMeta(blocktype),
							blocktype/2 == 0 ? 3+1 : 0);
				} else
					world.setBlockMetadataWithNotify(i, j, k, blocktype + 8);
			} else {
				world.setBlockWithNotify(i, j, k, NFC.NSStep.blockID);
				blockNear = world.getBlockId(i + 1, j, k);
				blockNearMeta = world.getBlockMetadata(i + 1, j, k);
				if (blockNear == NFC.NSStep.blockID && blockNearMeta == blocktype) {
					world.setBlockWithNotify(i, j, k, 0);
					world.setBlockAndMetadataWithNotify(i + 1, j, k, getBlockIDfromMeta(blocktype),
							blocktype/2 == 0 ? 3+2 : 0);
				} else
					world.setBlockMetadataWithNotify(i, j, k, blocktype);
			}
		}
	}

	private int getBlockIDfromMeta(int i) {
		if (i % 8 == 2) {
			return Block.planks.blockID;
		} else if (i % 8 == 3) {
			return Block.cobblestone.blockID;
		} else if (i % 8 == 0) {
			return Block.stairDouble.blockID;
		} else if (i % 8 == 4) {
			return Block.brick.blockID;
		}else
			return Block.sandStone.blockID;
	}

	public int idDropped(int i, Random random) {
		return Block.stairSingle.blockID;
	}

	protected int damageDropped(int i) {
		return i % 8;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

	public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i, int j, int k, int l) {
		// l = side of current block, ijk = coords of block looked at beside current block
		if (this != Block.stairSingle) {
			return super.shouldSideBeRendered(iblockaccess, i, j, k, l);
		}
		else {
			// If we're looking at bottom side
			if(l == 0){
				// If it's the upper slab, always render the bottom
				if(iblockaccess.getBlockMetadata(i, j + 1, k)/8 == 1){
					return true;
				}
				// If it's the down slab, see if the block below is an upper slab. If so, don't render bottom
				else if (iblockaccess.getBlockId(i, j, k) == Block.stairSingle.blockID && iblockaccess.getBlockMetadata(i, j, k)/8 == 1){
					return false;
				}
				// Otherwise, use default logic
				else {
					return super.shouldSideBeRendered(iblockaccess, i, j, k, l);
				}
			}
			// If we're looking at top side
			else if(l == 1){
				// If it's the down slab, always render the top
				if(iblockaccess.getBlockMetadata(i, j - 1, k)/8 == 0){
					return true;
				}
				// If it's the upper slab, see if the block ontop is a down slab. If so, don't render top
				else if (iblockaccess.getBlockId(i, j, k) == Block.stairSingle.blockID && iblockaccess.getBlockMetadata(i, j, k)/8 == 0){
					return false;
				}
				// Otherwise, use default logic
				else {
					return super.shouldSideBeRendered(iblockaccess, i, j, k, l);
				}
			}
			// See if block beside is also an UD slab
			else if(iblockaccess.getBlockId(i, j, k) == Block.stairSingle.blockID){
				
				// If we're looking at e/w/n/s side (not in order)
				if(l == 2)
					// If it's the down slab, don't render side
					return (iblockaccess.getBlockMetadata(i, j, k+1)/8 != iblockaccess.getBlockMetadata(i, j, k)/8);
				else if(l == 3)
					// If it's the down slab, don't render side
					return (iblockaccess.getBlockMetadata(i, j, k-1)/8 != iblockaccess.getBlockMetadata(i, j, k)/8);
				else if(l == 4)
					// If it's the down slab, don't render side
					return (iblockaccess.getBlockMetadata(i + 1, j, k)/8 != iblockaccess.getBlockMetadata(i, j, k)/8);
				else 
					// If it's the down slab, don't render side
					return (iblockaccess.getBlockMetadata(i - 1, j, k)/8 != iblockaccess.getBlockMetadata(i, j, k)/8);
			}
			// If not, determine by default
			else {
				return super.shouldSideBeRendered(iblockaccess, i, j, k, l);
			}
		}
	}

	public static final String field_22037_a[] = { "Stone", "Sand", "Wood", "Cobble", "Brick" };

	public void setBlockBoundsBasedOnState(IBlockAccess iblockaccess, int i, int j, int k) {
		if (iblockaccess.getBlockMetadata(i, j, k) / 8 == 0) {
			setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
		} else {
			setBlockBounds(0.0F, 0.5F, 0.0F, 1.0F, 1.0F, 1.0F);
		}	
	}

	public void setBlockBoundsForItemRender() {
		setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
	}

}

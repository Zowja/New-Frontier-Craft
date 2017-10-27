// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, Material

public class BlockBookshelf extends BlockContainer {

	public BlockBookshelf(int i, int j) {
		super(i, j, Material.wood);
		random = new Random();
	}

	public int getBlockTextureFromSide(int i) {
		if (i <= 1) {
			return 4;
		} else {
			return blockIndexInTexture;
		}
	}

	public void onBlockRemoval(World world, int i, int j, int k) {
		TileEntityBookshelf tileentityBookshelf = (TileEntityBookshelf) world
				.getBlockTileEntity(i, j, k);
		label0: for (int l = 0; l < tileentityBookshelf.getSizeInventory(); l++) {
			ItemStack itemstack = tileentityBookshelf.getStackInSlot(l);
			if (itemstack == null) {
				continue;
			}
			float f = random.nextFloat() * 0.8F + 0.1F;
			float f1 = random.nextFloat() * 0.8F + 0.1F;
			float f2 = random.nextFloat() * 0.8F + 0.1F;
			do {
				if (itemstack.stackSize <= 0) {
					continue label0;
				}
				int i1 = random.nextInt(21) + 10;
				if (i1 > itemstack.stackSize) {
					i1 = itemstack.stackSize;
				}
				itemstack.stackSize -= i1;
				EntityItem entityitem = new EntityItem(world, (float) i + f,
						(float) j + f1, (float) k + f2, new ItemStack(
								itemstack.itemID, i1,
								itemstack.getItemDamage(),
								itemstack.getTagCompound()));
				float f3 = 0.05F;
				entityitem.motionX = (float) random.nextGaussian() * f3;
				entityitem.motionY = (float) random.nextGaussian() * f3 + 0.2F;
				entityitem.motionZ = (float) random.nextGaussian() * f3;
				world.entityJoinedWorld(entityitem);
			} while (true);
		}

		super.onBlockRemoval(world, i, j, k);
	}

	public boolean blockActivated(World world, int i, int j, int k,
			EntityPlayer entityplayer) {
		TileEntityBookshelf obj = (TileEntityBookshelf) world
				.getBlockTileEntity(i, j, k);
		if (world.multiplayerWorld) {
			return true;
		} else {
			entityplayer.displayGUIBookshelf(obj);
			return true;
		}
	}

	protected TileEntity getBlockEntity() {
		return new TileEntityBookshelf();
	}

	private Random random;
}

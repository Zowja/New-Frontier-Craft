// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

// Referenced classes of package net.minecraft.src:
//            TileEntity, IInventory, ItemStack, NBTTagCompound, 
//            NBTTagList, World, EntityPlayer

public class TileEntityBookshelf extends TileEntity implements IInventory {

	public TileEntityBookshelf() {
		shelfContents = new ItemStack[36];
	}

	public int getSizeInventory() {
		return 10;
	}

	public ItemStack getStackInSlot(int i) {
		return shelfContents[i];
	}

	public ItemStack decrStackSize(int i, int j) {
		if (shelfContents[i] != null) {
			if (shelfContents[i].stackSize <= j) {
				ItemStack itemstack = shelfContents[i];
				shelfContents[i] = null;
				onInventoryChanged();
				return itemstack;
			}
			ItemStack itemstack1 = shelfContents[i].splitStack(j);
			if (shelfContents[i].stackSize == 0) {
				shelfContents[i] = null;
			}
			onInventoryChanged();
			return itemstack1;
		} else {
			return null;
		}
	}

	public void setInventorySlotContents(int i, ItemStack itemstack) {
		shelfContents[i] = itemstack;
		if (itemstack != null && itemstack.stackSize > getInventoryStackLimit()) {
			itemstack.stackSize = getInventoryStackLimit();
		}
		onInventoryChanged();
	}

	public String getInvName() {
		return "Bookshelf";
	}

	public void readFromNBT(NBTTagCompound nbttagcompound) {
		super.readFromNBT(nbttagcompound);
		NBTTagList nbttaglist = nbttagcompound.getTagList("Items");
		shelfContents = new ItemStack[getSizeInventory()];
		for (int i = 0; i < nbttaglist.tagCount(); i++) {
			NBTTagCompound nbttagcompound1 = (NBTTagCompound) nbttaglist
					.tagAt(i);
			int j = nbttagcompound1.getByte("Slot") & 0xff;
			if (j >= 0 && j < shelfContents.length) {
				shelfContents[j] = new ItemStack(nbttagcompound1);
			}
		}

	}

	public void writeToNBT(NBTTagCompound nbttagcompound) {
		super.writeToNBT(nbttagcompound);
		NBTTagList nbttaglist = new NBTTagList();
		for (int i = 0; i < shelfContents.length; i++) {
			if (shelfContents[i] != null) {
				NBTTagCompound nbttagcompound1 = new NBTTagCompound();
				nbttagcompound1.setByte("Slot", (byte) i);
				shelfContents[i].writeToNBT(nbttagcompound1);
				nbttaglist.setTag(nbttagcompound1);
			}
		}

		nbttagcompound.setTag("Items", nbttaglist);
	}

	public int getInventoryStackLimit() {
		return 64;
	}

	public boolean canInteractWith(EntityPlayer entityplayer) {
		if (worldObj.getBlockTileEntity(xCoord, yCoord, zCoord) != this) {
			return false;
		}
		return entityplayer.getDistanceSq((double) xCoord + 0.5D,
				(double) yCoord + 0.5D, (double) zCoord + 0.5D) <= 64D;
	}

	private ItemStack shelfContents[];
}

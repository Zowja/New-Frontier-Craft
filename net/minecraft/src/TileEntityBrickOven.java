// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

// Referenced classes of package net.minecraft.src:
//            TileEntity, IInventory, ItemStack, NBTTagCompound, 
//            NBTTagList, World, Item, BlockFurnace, 
//            FurnaceRecipes, Block, Material, ModLoader, 
//            EntityPlayer

public class TileEntityBrickOven extends TileEntity implements IInventory {

	public TileEntityBrickOven() {
		furnaceItemStacks = new ItemStack[11];
		furnaceBurnTime = 0;
		currentItemBurnTime = 0;
		furnaceCookTime = 0;
	}

	public int getSizeInventory() {
		return furnaceItemStacks.length;
	}

	public ItemStack getStackInSlot(int i) {
		return furnaceItemStacks[i];
	}

	public ItemStack decrStackSize(int i, int j) {
		if (furnaceItemStacks[i] != null) {
			if (furnaceItemStacks[i].stackSize <= j) {
				ItemStack itemstack = furnaceItemStacks[i];
				furnaceItemStacks[i] = null;
				return itemstack;
			}
			ItemStack itemstack1 = furnaceItemStacks[i].splitStack(j);
			if (furnaceItemStacks[i].stackSize == 0) {
				furnaceItemStacks[i] = null;
			}
			return itemstack1;
		} else {
			return null;
		}
	}

	public void setInventorySlotContents(int i, ItemStack itemstack) {
		furnaceItemStacks[i] = itemstack;
		if (itemstack != null && itemstack.stackSize > getInventoryStackLimit()) {
			itemstack.stackSize = getInventoryStackLimit();
		}
	}

	public String getInvName() {
		return "Furnace";
	}

	public void readFromNBT(NBTTagCompound nbttagcompound) {
		super.readFromNBT(nbttagcompound);
		NBTTagList nbttaglist = nbttagcompound.getTagList("Items");
		furnaceItemStacks = new ItemStack[getSizeInventory()];
		for (int i = 0; i < nbttaglist.tagCount(); i++) {
			NBTTagCompound nbttagcompound1 = (NBTTagCompound) nbttaglist
					.tagAt(i);
			byte byte0 = nbttagcompound1.getByte("Slot");
			if (byte0 >= 0 && byte0 < furnaceItemStacks.length) {
				furnaceItemStacks[byte0] = new ItemStack(nbttagcompound1);
			}
		}

		furnaceBurnTime = nbttagcompound.getShort("BurnTime");
		furnaceCookTime = nbttagcompound.getShort("CookTime");
		currentItemBurnTime = getItemBurnTime(furnaceItemStacks[9]);
	}

	public void writeToNBT(NBTTagCompound nbttagcompound) {
		super.writeToNBT(nbttagcompound);
		nbttagcompound.setShort("BurnTime", (short) furnaceBurnTime);
		nbttagcompound.setShort("CookTime", (short) furnaceCookTime);
		NBTTagList nbttaglist = new NBTTagList();
		for (int i = 0; i < furnaceItemStacks.length; i++) {
			if (furnaceItemStacks[i] != null) {
				NBTTagCompound nbttagcompound1 = new NBTTagCompound();
				nbttagcompound1.setByte("Slot", (byte) i);
				furnaceItemStacks[i].writeToNBT(nbttagcompound1);
				nbttaglist.setTag(nbttagcompound1);
			}
		}

		nbttagcompound.setTag("Items", nbttaglist);
	}

	public int getInventoryStackLimit() {
		return 64;
	}

	public int getCookProgressScaled(int i) {
		return (furnaceCookTime * i) / requiredTime;
	}

	public int getBurnTimeRemainingScaled(int i) {
		if (currentItemBurnTime == 0) {
			currentItemBurnTime = 200;
		}
		return (furnaceBurnTime * i) / currentItemBurnTime;
	}

	public boolean isBurning() {
		return furnaceBurnTime > 0;
	}

	public void updateEntity() {
		boolean flag = furnaceBurnTime > 0;
		boolean flag1 = false;
		if (furnaceBurnTime > 0) {
			furnaceBurnTime--;
		}
		if (!worldObj.multiplayerWorld) {
			if (furnaceBurnTime == 0 && canSmelt()) {
				currentItemBurnTime = furnaceBurnTime = getItemBurnTime(furnaceItemStacks[9]);
				if (furnaceBurnTime > 0) {
					flag1 = true;
					if (furnaceItemStacks[9] != null) {
						if (furnaceItemStacks[9].getItem().hasContainerItem()) {
							furnaceItemStacks[9] = new ItemStack(
									furnaceItemStacks[9].getItem()
											.getContainerItem());
						} else {
							furnaceItemStacks[9].stackSize--;
						}
						if (furnaceItemStacks[9].stackSize == 0) {
							furnaceItemStacks[9] = null;
						}
					}
				}
			}
			if (isBurning() && canSmelt()) {
				furnaceCookTime++;
				if (furnaceCookTime == requiredTime) {
					furnaceCookTime = 0;
					smeltItem();
					flag1 = true;
				}
			} else {
				furnaceCookTime = 0;
			}
			if (flag != (furnaceBurnTime > 0)) {
				flag1 = true;
				BlockBrickOven.updateFurnaceBlockState(furnaceBurnTime > 0,
						worldObj, xCoord, yCoord, zCoord);
			}
		}
		if (flag1) {
			onInventoryChanged();
		}
	}

	private boolean canSmelt() {
		ItemStack itemstack = OvenManager.smelting().findMatchingRecipe(furnaceItemStacks, this);
		if (itemstack == null) {
			return false;
		}
		if (furnaceItemStacks[10] == null) {
			return true;
		}
		if (!furnaceItemStacks[10].isItemEqual(itemstack)) {
			return false;
		}
		if (furnaceItemStacks[10].stackSize < getInventoryStackLimit()
				&& furnaceItemStacks[10].stackSize + itemstack.stackSize < furnaceItemStacks[10]
						.getMaxStackSize()) {
			return true;
		}
		return furnaceItemStacks[10].stackSize + itemstack.stackSize < itemstack.getMaxStackSize();
	}

	public void smeltItem() {
		if (!canSmelt()) {
			return;
		}
		ItemStack itemstack = OvenManager.smelting().findMatchingRecipe(furnaceItemStacks, this);
		if (furnaceItemStacks[10] == null) {
			furnaceItemStacks[10] = itemstack.copy();
		} else if (furnaceItemStacks[10].itemID == itemstack.itemID) {
			furnaceItemStacks[10].stackSize += itemstack.stackSize;
		}
		
		//Removed container item code
		for(int i = 0; i < 9; i++)
		{
			if(furnaceItemStacks[i] != null){
				furnaceItemStacks[i].stackSize--;
				if (furnaceItemStacks[i].stackSize <= 0) {
				furnaceItemStacks[i] = null;
				}
			}
		}
	}
	
	private int getItemBurnTime(ItemStack itemstack) {
		if (itemstack == null) {
			return 0;
		}
		int i = itemstack.getItem().shiftedIndex;
		int j = itemstack.getItemDamage();
		if (i == Block.planks.blockID) {
			return 100;
		}
		if (i == Item.coal.shiftedIndex && j == 0) {
			return 1600;
		}
		if(i == Item.coal.shiftedIndex) {
			return 800;
		}
		if (i == NFC.anthracite.shiftedIndex) {
			return 6400;
		}

		return 0;

	}

	public boolean canInteractWith(EntityPlayer entityplayer) {
		if (worldObj.getBlockTileEntity(xCoord, yCoord, zCoord) != this) {
			return false;
		}
		return entityplayer.getDistanceSq((double) xCoord + 0.5D,
				(double) yCoord + 0.5D, (double) zCoord + 0.5D) <= 64D;
	}
	
	public void setTime(int i){
		requiredTime = i;
	}

	private ItemStack furnaceItemStacks[];
	public int furnaceBurnTime;
	public int currentItemBurnTime;
	public int furnaceCookTime;
	public int requiredTime = 200;
}

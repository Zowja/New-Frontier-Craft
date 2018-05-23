// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.List;

// Referenced classes of package net.minecraft.src:
//            Container, Slot, SlotFurnace, InventoryPlayer, 
//            ICrafting, TileEntityFurnace, ItemStack, EntityPlayer

public class ContainerBrickOven extends Container {

	public ContainerBrickOven(InventoryPlayer inventoryplayer,
			TileEntityBrickOven tileentityfurnace) {
		cookTime = 0;
		burnTime = 0;
		itemBurnTime = 0;
		furnace = tileentityfurnace;
		for (int i = 0; i < 3; i++) {
			for (int k = 0; k < 3; k++) {
		addSlot(new Slot(tileentityfurnace,  k + i*3, 38 + k*18, 17 + i*18));
			}
		}
		addSlot(new Slot(tileentityfurnace, 9, 56, 89));
		addSlot(new SlotFurnace(inventoryplayer.player, tileentityfurnace, 10, 116, 71));
		for (int i = 0; i < 3; i++) {
			for (int k = 0; k < 9; k++) {
				addSlot(new Slot(inventoryplayer, k + i * 9 + 9, 8 + k * 18,
						120 + i * 18));
			}

		}

		for (int j = 0; j < 9; j++) {
			addSlot(new Slot(inventoryplayer, j, 8 + j * 18, 178));
		}

	}

	public void updateCraftingResults() {
		super.updateCraftingResults();
		for (int i = 0; i < field_20121_g.size(); i++) {
			ICrafting icrafting = (ICrafting) field_20121_g.get(i);
			if (cookTime != furnace.furnaceCookTime) {
				icrafting.func_20158_a(this, 0, furnace.furnaceCookTime);
			}
			if (burnTime != furnace.furnaceBurnTime) {
				icrafting.func_20158_a(this, 1, furnace.furnaceBurnTime);
			}
			if (itemBurnTime != furnace.currentItemBurnTime) {
				icrafting.func_20158_a(this, 2, furnace.currentItemBurnTime);
			}
			if (requiredTime != furnace.requiredTime) {
				icrafting.func_20158_a(this, 3, furnace.requiredTime);
			}
		}

		cookTime = furnace.furnaceCookTime;
		burnTime = furnace.furnaceBurnTime;
		itemBurnTime = furnace.currentItemBurnTime;
		requiredTime = furnace.requiredTime;
	}

	public void func_20112_a(int i, int j) {
		if (i == 0) {
			furnace.furnaceCookTime = j;
		}
		if (i == 1) {
			furnace.furnaceBurnTime = j;
		}
		if (i == 2) {
			furnace.currentItemBurnTime = j;
		}
		if (i == 3) {
			furnace.requiredTime = j;
		}
	}

	public boolean isUsableByPlayer(EntityPlayer entityplayer) {
		return furnace.canInteractWith(entityplayer);
	}

	public ItemStack getStackInSlot(int i) {
		ItemStack itemstack = null;
		Slot slot = (Slot) slots.get(i);
		if (slot != null && slot.getHasStack()) {
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();
			if (i == 10) {
				func_28125_a(itemstack1, 11, 47, true);
			} else if (i >= 11 && i < 38) {
				func_28125_a(itemstack1, 38, 39, false);
			} else if (i >= 38 && i < 47) {
				func_28125_a(itemstack1, 11, 38, false);
			} else {
				func_28125_a(itemstack1, 11, 47, false);
			}
			if (itemstack1.stackSize == 0) {
				slot.putStack(null);
			} else {
				slot.onSlotChanged();
			}
			if (itemstack1.stackSize != itemstack.stackSize) {
				slot.onPickupFromSlot(itemstack1);
			} else {
				return null;
			}
		}
		return itemstack;
	}

	private TileEntityBrickOven furnace;
	private int cookTime;
	private int burnTime;
	private int itemBurnTime;
	private int requiredTime;
}

// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.List;

// Referenced classes of package net.minecraft.src:
//            Container, InventoryCrafting, InventoryCraftResult, SlotCrafting, 
//            InventoryPlayer, Slot, SlotArmor, CraftingManager, 
//            IInventory, EntityPlayer, ItemStack

public class ContainerPlayer extends Container
{

    public ContainerPlayer(InventoryPlayer inventoryplayer)
    {
        this(inventoryplayer, true);
    }

    public ContainerPlayer(InventoryPlayer inventoryplayer, boolean flag)
    {
        craftMatrix = new InventoryCrafting(this, 2, 2);
        craftResult = new InventoryCraftResult();
        isSinglePlayer = false;
        isSinglePlayer = flag;
        addSlot(new SlotCrafting(inventoryplayer.player, craftMatrix, craftResult, 0, 144, 36));
        for(int i = 0; i < 2; i++)
        {
            for(int i1 = 0; i1 < 2; i1++)
            {
                addSlot(new Slot(craftMatrix, i1 + i * 2, 88 + i1 * 18, 26 + i * 18));
            }

        }

        for(int j = 0; j < 4; j++)
        {
            int j1 = j;
            addSlot(new SlotArmor(this, inventoryplayer, inventoryplayer.getSizeInventory() - 1 - j, 8, 8 + j * 18, j1));
        }

        for(int k = 0; k < 3; k++)
        {
            for(int k1 = 0; k1 < 9; k1++)
            {
                addSlot(new Slot(inventoryplayer, k1 + (k + 1) * 9, 8 + k1 * 18, 84 + k * 18));
            }

        }

        for(int l = 0; l < 9; l++)
        {
            addSlot(new Slot(inventoryplayer, l, 8 + l * 18, 142));
        }

        onCraftMatrixChanged(craftMatrix);
    }

    public void onCraftMatrixChanged(IInventory iinventory)
    {
        craftResult.setInventorySlotContents(0, CraftingManager.getInstance().findMatchingRecipe(craftMatrix));
    }

    public void onCraftGuiClosed(EntityPlayer entityplayer)
    {
        super.onCraftGuiClosed(entityplayer);
        for(int i = 0; i < 4; i++)
        {
            ItemStack itemstack = craftMatrix.getStackInSlot(i);
            if(itemstack != null)
            {
                entityplayer.dropPlayerItem(itemstack);
                craftMatrix.setInventorySlotContents(i, null);
            }
        }

    }

    public boolean isUsableByPlayer(EntityPlayer entityplayer)
    {
        return true;
    }

    public ItemStack getStackInSlot(int i)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)slots.get(i);
        if(slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();
            if(i == 0)
            {
                func_28125_a(itemstack1, 9, 45, true);
            } else
            if(i >= 9 && i < 36)
            {
                func_28125_a(itemstack1, 36, 45, false);
            } else
            if(i >= 36 && i < 45)
            {
                func_28125_a(itemstack1, 9, 36, false);
            } else
            {
                func_28125_a(itemstack1, 9, 45, false);
            }
            if(itemstack1.stackSize == 0)
            {
                slot.putStack(null);
            } else
            {
                slot.onSlotChanged();
            }
            if(itemstack1.stackSize != itemstack.stackSize)
            {
                slot.onPickupFromSlot(itemstack1);
            } else
            {
                return null;
            }
        }
        return itemstack;
    }

    public InventoryCrafting craftMatrix;
    public IInventory craftResult;
    public boolean isSinglePlayer;
}

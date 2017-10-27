// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

// Referenced classes of package net.minecraft.src:
//            TileEntity, IInventory, ItemStack, NBTTagCompound, 
//            NBTTagList, World, EntityPlayer

public class TileEntityBookshelf extends TileEntityChest implements IInventory {

	public TileEntityBookshelf() {
		super();
	}

	public int getSizeInventory() {
		return 10;
	}


	public String getInvName() {
		return "Bookshelf";
	}

}

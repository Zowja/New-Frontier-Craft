package net.minecraft.src;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class ItemWrittenBook extends Item {
	private static final String __OBFID = "CL_00000077";

	public ItemWrittenBook(int i) {
		super(i);
		this.setMaxStackSize(1);
	}

	public static boolean validBookTagContents(NBTTagCompound par0NBTTagCompound)
			throws Exception {
		if (!ItemWritableBook.func_150930_a(par0NBTTagCompound)) {
			return false;
		} else if (!par0NBTTagCompound.func_150297_b("title", 8)) {
			return false;
		} else {
			String var1 = par0NBTTagCompound.getString("title");
			return var1 != null && var1.length() <= 16 ? par0NBTTagCompound
					.func_150297_b("author", 8) : false;
		}
	}

	/**
	 * allows items to add custom lines of information to the mouseover
	 * description
	 */

	/**
	 * Called whenever this item is equipped and the right mouse button is
	 * pressed. Args: itemStack, world, entityPlayer
	 */
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World,
			EntityPlayer par3EntityPlayer) {
		par3EntityPlayer.displayGUIBook(par1ItemStack, false);
		return par1ItemStack;
	}

	/**
	 * If this function returns true (or the item is damageable), the
	 * ItemStack's NBT tag will be sent to the client.
	 */
	public boolean getShareTag() {
		return true;
	}

	public boolean hasEffect(ItemStack par1ItemStack) {
		return true;
	}
}

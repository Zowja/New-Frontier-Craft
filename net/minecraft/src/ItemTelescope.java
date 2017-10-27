package net.minecraft.src;

public class ItemTelescope extends Item {

	protected ItemTelescope(int i) {
		super(i);
	}
	
	public ItemStack onItemRightClick(ItemStack itemstack, World world,
			EntityPlayer entityplayer) {
		if(EntityRenderer.isZooming()){
			EntityRenderer.setZoom(false);
		} else {
			EntityRenderer.setZoom(true);
		}
		return itemstack;
	}
	
	public int getItemStackLimit() {
		return 1;
	}

}

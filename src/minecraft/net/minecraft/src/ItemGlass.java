package net.minecraft.src;

public class ItemGlass extends ItemBlock {

	public ItemGlass(int i) {
		super(i);
		setMaxDamage(0);
		setHasSubtypes(true);
	}

	public int getIconFromDamage(int i) {
		return Block.glass.getBlockTextureFromSideAndMetadata(2,
				i);
	}

	public int getPlacedBlockMetadata(int i) {
		return i;
	}

	public String getItemNameIS(ItemStack itemstack) {
		int i = itemstack.getItemDamage();
		if(i == 0){
			return "Glass";
		}
		if(i == 1){
			return "Large Window";
		}
		if(i == 3){
			return "Window";
		}
		if(i == 2){
			return "Double Window";
		}
		return "Error";
	}
}
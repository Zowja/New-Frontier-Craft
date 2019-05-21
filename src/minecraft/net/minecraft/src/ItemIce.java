package net.minecraft.src;

public class ItemIce extends ItemBlock {
	
	public ItemIce(int i) {
		super(i);
	}
	
	public int getPlacedBlockMetadata(int i) {
		return 1;
	}

}

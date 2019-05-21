package net.minecraft.src;

public class ItemLadder extends ItemBlock {

	public ItemLadder(int i) {
		super(i);
		// TODO Auto-generated constructor stub
	}
	
	public boolean onItemUse(ItemStack itemstack, EntityPlayer entityplayer,
			World world, int i, int j, int k, int l) {
		if(super.onItemUse(itemstack, entityplayer, world, i, j, k, l)) return true;
		boolean loop = world.getBlockId(i, j, k) == Block.ladder.blockID;
		boolean found = false;
		int y = j;
		int id;
		while(loop){
			y = y-1;
			id = world.getBlockId(i, y, k);
			if(y <= 1){
				loop = false;
			}
			if(id == 0){
				loop = false;
				found = true;
			}
			else if(id != Block.ladder.blockID){
				loop = false;
			}
		}
		if(found){
			world.setBlockAndMetadataWithNotify(i, y, k, Block.ladder.blockID, 
					world.getBlockMetadata(i, y+1, k));
			itemstack.stackSize--;
			return true;
		}
		return false;
	}

}

package net.minecraft.src;

public class BlockScaffold extends Block {

	protected BlockScaffold(int i, Material material) {
		super(i, material);
	}
	
	public int getBlockTextureFromSideAndMetadata(int i, int j) {
		return i < 2 ? 4 : 226;
	}
	
	public boolean isOpaqueCube() {
		return false;
	}
	
	public boolean canPlaceBlockAt(World world, int i, int j, int k) {
		if(world.getBlockId(i, j-1, k) != this.blockID && world.isBlockNormalCube(i, j - 1, k)){
			return true;
		}
		else {
			return ((world.getBlockId(i, j-1, k) == this.blockID && world.getBlockMetadata(i, j-1, k) < 7) ||
					(world.getBlockId(i+1, j, k) == this.blockID && world.getBlockMetadata(i+1, j, k) < 7) || (world.getBlockId(i-1, j, k) == this.blockID && world.getBlockMetadata(i-1, j, k) < 7) ||
					(world.getBlockId(i, j, k+1) == this.blockID && world.getBlockMetadata(i, j, k+1) < 7) || (world.getBlockId(i, j, k-1) == this.blockID && world.getBlockMetadata(i, j, k-1) < 7));
		}
	}
	
	public void onNeighborBlockChange(World world, int i, int j, int k, int l) {
		if(world.isBlockNormalCube(i, j - 1, k)) return;
		if(world.getBlockId(i+1, j, k) == this.blockID && world.getBlockMetadata(i+1, j, k) < world.getBlockMetadata(i, j, k)) return;
		if(world.getBlockId(i-1, j, k) == this.blockID && world.getBlockMetadata(i-1, j, k) < world.getBlockMetadata(i, j, k)) return;
		if(world.getBlockId(i, j, k+1) == this.blockID && world.getBlockMetadata(i, j, k+1) < world.getBlockMetadata(i, j, k)) return;
		if(world.getBlockId(i, j, k-1) == this.blockID && world.getBlockMetadata(i, j, k-1) < world.getBlockMetadata(i, j, k)) return;
		dropBlockAsItem(world, i, j, k, 0);
		world.setBlockWithNotify(i, j, k, 0);
	}
	
	public void onBlockPlaced(World world, int i, int j, int k, int l)
    {
		if(world.getBlockId(i, j-1, k) != this.blockID){
			if(world.isBlockNormalCube(i, j - 1, k)){
				return;
			}
			int best = 6;
			if(world.getBlockId(i+1, j, k) == this.blockID && world.getBlockMetadata(i+1, j, k) < best){
				best = world.getBlockMetadata(i+1, j, k);
			}
			if(world.getBlockId(i-1, j, k) == this.blockID && world.getBlockMetadata(i-1, j, k) < best){
				best = world.getBlockMetadata(i-1, j, k);
			}
			if(world.getBlockId(i, j, k+1) == this.blockID && world.getBlockMetadata(i, j, k+1) < best){
				best = world.getBlockMetadata(i, j, k+1);
			} 
			if(world.getBlockId(i, j, k-1) == this.blockID && world.getBlockMetadata(i, j, k-1) < best){
				best = world.getBlockMetadata(i, j, k-1);
			}
			world.setBlockMetadata(i, j, k, best+1);
		} else {
			world.setBlockMetadata(i, j, k, world.getBlockMetadata(i, j-1, k) == 0 ? 0 : world.getBlockMetadata(i, j-1, k) + 1);
		}
    }

}

package net.minecraft.src;

import java.util.TreeMap;

public class ItemWrench extends Item {
	
	private TreeMap<Integer, Integer> conversion = new TreeMap<Integer, Integer>();

	protected ItemWrench(int i) {
		super(i);
		// Setup conversions
		setupStairs(Block.stairCompactPlanks.blockID);
		setupStairs(Block.stairCompactCobblestone.blockID);
		setupStairs(NFC.SandstoneStairs.blockID);
		setupStairs(NFC.BrickStairs.blockID);
		setupStairs(NFC.StoneStairs.blockID);
		// Slabs, this does account for future slabs
		for(int j = 0; j < 8; j++){
			add(Block.stairSingle.blockID, 0 + j, Block.stairSingle.blockID, 8 + j);
			add(Block.stairSingle.blockID, 8 + j, NFC.EWStep.blockID, 8 + j);
			add(NFC.EWStep.blockID, 8 + j, NFC.NSStep.blockID, 0 + j);
			add(NFC.NSStep.blockID, 0 + j, NFC.EWStep.blockID, 0 + j);
			add(NFC.EWStep.blockID, 0 + j, NFC.NSStep.blockID, 8 + j);
			add(NFC.NSStep.blockID, 8 + j, Block.stairSingle.blockID, 0 + j);
		}
		// Double stone slab
		add(Block.stairDouble.blockID, 0, Block.stairDouble.blockID, 1+3);
		add(Block.stairDouble.blockID, 1+3, Block.stairDouble.blockID, 2+3);
		add(Block.stairDouble.blockID, 2+3, Block.stairDouble.blockID, 0);
	}
	
	// Creates proper rotation conversion for stairs
	private void setupStairs(int id){
		add(id, 0, id, 2);
		add(id, 1, id, 7);
		add(id, 2, id, 1);
		add(id, 3, id, 0);
		add(id, 4, id, 6);
		add(id, 5, id, 3);
		add(id, 6, id, 5);
		add(id, 7, id, 4);
	}
	
	@Override
	public boolean onItemUse(ItemStack itemstack, EntityPlayer entityplayer,
			World world, int i, int j, int k, int l) {
		int newValue = get(world.getBlockId(i, j, k), world.getBlockMetadata(i, j, k));
		if(newValue == 0) return false;
		world.setBlockAndMetadataWithNotify(i, j, k, newValue/16, newValue%16);
		world.playSoundAtEntity(entityplayer, "random.wrench", 0.5F,
				0.825F + (itemRand.nextFloat() * 0.05f));
		return true;
	}
	
	private void add(int ID, int meta, int newID, int newMeta){
		conversion.put(ID * 16 + meta, newID * 16 + newMeta);
	}
	
	private int get(int ID, int meta){
		Integer get = conversion.get(ID * 16 + meta);
		if (get == null) return 0;
		return get.intValue();
	}

}

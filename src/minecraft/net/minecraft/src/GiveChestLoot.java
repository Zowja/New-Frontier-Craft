package net.minecraft.src;

import java.util.Random;

public class GiveChestLoot {
	
	public static void giveLoot(TileEntityChest tile, Random random, int i){
		if(i == 0){
			int k4 = 0;
			do {
				if (k4 >= 16) {
					break;
				}
				ItemStack itemstack = lootDWT(random);
				if (itemstack != null) {
					tile.setInventorySlotContents(random
							.nextInt(tile.getSizeInventory()),
							itemstack);
				}
				k4++;
			} while (true);
		}
		else if(i == 1){
			int k4 = 0;
			do {
				if (k4 >= 11) {
					break;
				}
				ItemStack itemstack = lootClassicDungeon(random);
				if (itemstack != null) {
					tile.setInventorySlotContents(random
							.nextInt(tile.getSizeInventory()),
							itemstack);
				}
				k4++;
			} while (true);
		}
		else {
			System.out.println("ERROR: Unknown Chest Loot ID.");
		}
	}
	
	
	
	private static ItemStack lootDWT(Random random) {
		int i = random.nextInt(12);
		if (i == 1 && random.nextInt(3) == 0) {
			return new ItemStack(NFC.brass, random.nextInt(4) + 1);
		}
		if (i == 2) {
			return new ItemStack(Item.bread);
		}
		if (i == 3) {
			return new ItemStack(Item.wheat, random.nextInt(4) + 1);
		}
		if (i == 5) {
			return new ItemStack(Block.stone, random.nextInt(4) + 3);
		}
		if (i == 6) {
			return new ItemStack(Item.bucketWater);
		}
		if (i == 7 && random.nextInt(20) == 0) {
			return new ItemStack(Block.jukebox);
		}
		if (i == 8 && random.nextInt(2) == 0) {
			return new ItemStack(Block.musicBlock);
		}
		if (i == 9) {
			return new ItemStack(Block.planks, random.nextInt(4) + 1);
		}
		if (i == 10) {
			return new ItemStack(Block.leaves, random.nextInt(4) + 1);
		} else {
			return new ItemStack(Block.sand, random.nextInt(random.nextInt(12)+1) + 1);
		}
	}
	
	private static ItemStack lootClassicDungeon(Random random) {
		int i = random.nextInt(14);
		if (i == 0) {
			return new ItemStack(Item.saddle);
		}
		if (i == 1 && random.nextInt(2) == 0) {
			return new ItemStack(NFC.boron, random.nextInt(4) + 1);
		}
		if (i == 2) {
			return new ItemStack(Item.bread);
		}
		if (i == 3) {
			return new ItemStack(Item.wheat, random.nextInt(4) + 1);
		}
		if (i == 4) {
			return new ItemStack(Item.gunpowder, random.nextInt(4) + 1);
		}
		if (i == 5) {
			return new ItemStack(Item.silk, random.nextInt(10) + 1);
		}
		if (i == 6) {
			return new ItemStack(Item.bucketEmpty);
		}
		if (i == 7 && random.nextInt(100) == 0) {
			return new ItemStack(Item.appleGold);
		}
		if (i == 8 && random.nextInt(2) == 0) {
			return new ItemStack(Item.redstone, random.nextInt(10) + 1);
		}
		if (i == 9 && random.nextInt(8) == 0) {
			return new ItemStack(Item.itemsList[Item.record13.shiftedIndex
					+ random.nextInt(2)]);
		}
		if (i == 10) {
			return new ItemStack(Item.dyePowder, random.nextInt(16) + 1, 3);
		}
		if (i == 11) {
			int j = random.nextInt(5);
			if(j == 0)
				return new ItemStack(NFC.emerald, 1);
			else if(j == 1)
				return new ItemStack(NFC.sapphire, 1);
			else if(j == 2)
				return new ItemStack(NFC.ruby, 1);
		}
		if (i == 12) {
			return new ItemStack(Item.arrow, random.nextInt(32) + 16);
		}
		if (i == 13) {
			return new ItemStack(Item.swordSteel, 1, random.nextInt(200) + 40);
		}
		else {
			return null;
		}
	}


}

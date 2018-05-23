package net.minecraft.src;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OvenRecipes {
	
	public OvenRecipes(ItemStack itemstack, List list, int time) {
		recipeOutput = itemstack;
		recipeItems = list;
		this.time = time;
	}

	public ItemStack getRecipeOutput() {
		return recipeOutput;
	}
	
	public int getTime(){
		return time;
	}

	public boolean matches(ItemStack[] itemstacks) {
		ArrayList arraylist = new ArrayList(recipeItems);
		int i = 0;
		do {
			if (i >= 3) {
				break;
			}
			for (int j = 0; j < 3; j++) {
				ItemStack itemstack = itemstacks[j + (i*3)];
				if (itemstack == null) {
					continue;
				}
				boolean flag = false;
				Iterator iterator = arraylist.iterator();
				do {
					if (!iterator.hasNext()) {
						break;
					}
					ItemStack itemstack1 = (ItemStack) iterator.next();
					if (itemstack.itemID != itemstack1.itemID
							|| itemstack1.getItemDamage() != -1
							&& itemstack.getItemDamage() != itemstack1
									.getItemDamage()) {
						continue;
					}
					flag = true;
					arraylist.remove(itemstack1);
					break;
				} while (true);
				if (!flag) {
					return false;
				}
			}

			i++;
		} while (true);
		return arraylist.isEmpty();
	}

	public ItemStack getCraftingResult() {
		return recipeOutput.copy();
	}

	public int getRecipeSize() {
		return recipeItems.size();
	}

	private final ItemStack recipeOutput;
	private final List recipeItems;
	private final int time;
}


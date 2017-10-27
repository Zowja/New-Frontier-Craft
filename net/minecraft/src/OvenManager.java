// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            IRecipe, InventoryCrafting, ItemStack

public class OvenManager{

	public OvenManager() {
		recipes = new ArrayList();
		addOvenRecipe(new ItemStack(NFC.brass, 6), new Object[] {new ItemStack(NFC.copper, 1),
				new ItemStack(NFC.copper, 1), new ItemStack(NFC.copper, 1), new	ItemStack(NFC.zinc, 1),	
				new ItemStack(NFC.zinc, 1), new ItemStack(NFC.zinc, 1)}, 1600);
		addOvenRecipe(new ItemStack(NFC.bronze, 6), new Object[] {new ItemStack(NFC.copper, 1),
				new ItemStack(NFC.copper, 1), new ItemStack(NFC.copper, 1), new	ItemStack(NFC.copper, 1),	
				new ItemStack(NFC.copper, 1), new ItemStack(NFC.tin, 1)}, 1600);
		addOvenRecipe(new ItemStack(NFC.steel, 8), new Object[] {new ItemStack(NFC.chrome, 1),
				new ItemStack(Item.ingotIron, 1), new ItemStack(Item.ingotIron, 1), new	ItemStack(Item.ingotIron, 1),	
				new ItemStack(Item.ingotIron, 1), new ItemStack(Item.ingotIron, 1), new ItemStack(Item.ingotIron, 1)
				, new ItemStack(Item.ingotIron, 1)}, 6400);
		addOvenRecipe(new ItemStack(NFC.tungsten, 1), new Object[] {new ItemStack(NFC.tungstenore, 1)}, 200);
		addOvenRecipe(new ItemStack(NFC.titanium, 1), new Object[] {new ItemStack(NFC.titaniumore, 1)}, 200);
	}

	void addOvenRecipe(ItemStack itemstack, Object aobj[], int time) {
		ArrayList arraylist = new ArrayList();
		Object aobj1[] = aobj;
		int i = aobj1.length;
		for (int j = 0; j < i; j++) {
			Object obj = aobj1[j];
			if (obj instanceof ItemStack) {
				arraylist.add(((ItemStack) obj).copy());
				continue;
			}
			if (obj instanceof Item) {
				arraylist.add(new ItemStack((Item) obj));
				continue;
			}
			if (obj instanceof Block) {
				arraylist.add(new ItemStack((Block) obj));
			} else {
				throw new RuntimeException("Invalid shapeless recipy!");
			}
		}

		recipes.add(new OvenRecipes(itemstack, arraylist, time));
	}

	public ItemStack findMatchingRecipe(ItemStack[] itemstacks, TileEntityBrickOven joe) {
		//removed a lot of extra stuff
			for (int var6 = 0; var6 < this.recipes.size(); ++var6) {
				OvenRecipes var12 = (OvenRecipes) this.recipes.get(var6);

				if (var12.matches(itemstacks)) {
					joe.setTime(var12.getTime());
					return var12.getCraftingResult();
				}
			}

			return null;
	}

	public List getRecipeList() {
		return recipes;
	}
	
	public static final OvenManager smelting() {
		return instance;
	}

	private static final OvenManager instance = new OvenManager();
	private List recipes;

}

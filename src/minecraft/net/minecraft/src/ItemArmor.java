// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

// Referenced classes of package net.minecraft.src:
//            Item
// i:itemid j:Level k:armormaterial l:armortype

public class ItemArmor extends Item {

	public ItemArmor(int i, int j, int k, int l) {
		super(i);
		armorLevel = j;
		armorType = l;
		renderIndex = k;
		damageReduceAmount = damageReduceAmountArray(l);
		setMaxDamage(maxDamageMaterialArray[j-1] * maxDamageArray[l] / 100);
		maxStackSize = 1;
	}

	private static int damageReduceAmountArray(int type) {
		/*if (level == 1) {
			if (type == 0) {
				return 1;
			}
			if (type == 1) {
				return 4;
			}
			if (type == 2) {
				return 2;
			}
			if (type == 3) {
				return 1;
			}
		} else if (level == 2) {
			if (type == 0) {
				return 2;
			}
			if (type == 1) {
				return 4;
			}
			if (type == 2) {
				return 3;
			}
			if (type == 3) {
				return 1;
			}
		} else if (level == 3) {
			if (type == 0) {
				return 2;
			}
			if (type == 1) {
				return 5;
			}
			if (type == 2) {
				return 3;
			}
			if (type == 3) {
				return 2;
			}
		} else if (level == 4) {
			if (type == 0) {
				return 2;
			}
			if (type == 1) {
				return 6;
			}
			if (type == 2) {
				return 4;
			}
			if (type == 3) {
				return 2;
			}
		} else if (level == 5) {
			if (type == 0) {
				return 2;
			}
			if (type == 1) {
				return 7;
			}
			if (type == 2) {
				return 5;
			}
			if (type == 3) {
				return 2;
			}
		} else if (level == 6) {
			if (type == 0) {
				return 3;
			}
			if (type == 1) {
				return 7;
			}
			if (type == 2) {
				return 5;
			}
			if (type == 3) {
				return 3;
			}
		} else if (level == 7) {
		*/
			if (type == 0) {
				return 3;
			}
			if (type == 1) {
				return 8;
			}
			if (type == 2) {
				return 6;
			}
			if (type == 3) {
				return 3;
			}
		//}
		return 0;
	}

	private static final int maxDamageArray[] = { 130, 160, 150, 110 };

	private static final int maxDamageMaterialArray[] = { 30, 60, 120, 250, 500 };

	public final int armorLevel;
	public final int armorType;
	public final int damageReduceAmount;
	public final int renderIndex;

}

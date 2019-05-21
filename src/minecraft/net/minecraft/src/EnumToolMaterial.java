// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

// (nothing), (nothing), tier, durability, speed, damage

public enum EnumToolMaterial {
	WOOD("WOOD", 0, 0, 30, 2F, 2), STONE("STONE", 0, 0, 40, 2.5F, 2),

	ALUMINUM("ALUMINUM", 1, 1, 35, 5F, 3), TIN("TIN", 1, 1, 40, 4.5F, 3), ZINC(
			"ZINC", 1, 1, 80, 3F, 3), BISMUTH("BISMUTH", 1, 1, 65, 3.5F, 3), COPPER(
			"COPPER", 1, 1, 50, 4F, 3), LEAD("LEAD", 1, 1, 115, 2.5F, 3), GOLD(
					"GOLD", 2, 2, 20, 8F, 3),

	BRASS("BRASS", 2, 2, 180, 4F, 4), BRONZE("BRONZE", 2, 2, 125, 5F, 4), SILVER(
			"SILVER", 2, 2, 260, 3F, 4), BORON("BORON", 2, 2, 50, 10F, 4), 
	NICKEL("NICKEL", 2, 2, 85, 7F, 4), PLATINUM ("PLATINUM", 2, 2, 215, 3.5F, 4), 

	IRON("IRON", 3, 3, 300, 6F, 6), COBALT("COBALT", 3, 3, 700, 4F, 6),
	CHROME("CHROME", 3, 3, 200, 8F, 6), SILICON("SILICON", 3, 3, 150, 10F, 6), 
	
	STEEL("STEEL", 4, 4, 700, 8F, 10), TUNGSTEN("TUNGSTEN", 4, 4, 1100, 6F, 10), 
	TITANIUM("TITANIUM", 4, 4, 350, 14F, 10),
	
	GEM("GEM", 4, 4, 1000, 10F, 20),

	DIAMOND("DIAMOND", 5, 5, 2000, 10F, 20), OSMIUM("OSMIUM", 5, 5, 5000, 5F, 20);
	/*
	 * public static EnumToolMaterial[] values() { return
	 * (EnumToolMaterial[])field_21209_j.clone(); }
	 * 
	 * public static EnumToolMaterial valueOf(String s) { return
	 * (EnumToolMaterial)Enum.valueOf(net.minecraft.src.EnumToolMaterial.class,
	 * s); }
	 */
	private EnumToolMaterial(String s, int i, int j, int k, float f, int l) {
		// super(s, i);
		harvestLevel = j;
		maxUses = k - 1;
		efficiencyOnProperMaterial = f;
		damageVsEntity = l;
	}

	public int getMaxUses() {
		return maxUses;
	}

	public float getEfficiencyOnProperMaterial() {
		return efficiencyOnProperMaterial;
	}

	public int getDamageVsEntity() {
		return damageVsEntity;
	}

	public int getHarvestLevel() {
		return harvestLevel;
	}

	/*
	 * public static final EnumToolMaterial WOOD; public static final
	 * EnumToolMaterial STONE; public static final EnumToolMaterial IRON; public
	 * static final EnumToolMaterial EMERALD; public static final
	 * EnumToolMaterial GOLD;
	 */
	private final int harvestLevel;
	private final int maxUses;
	private final float efficiencyOnProperMaterial;
	private final int damageVsEntity;
	private static final EnumToolMaterial field_21209_j[]; /* synthetic field */

	static {
		/*
		 * WOOD = new EnumToolMaterial("WOOD", 0, 0, 59, 2.0F, 0); STONE = new
		 * EnumToolMaterial("STONE", 1, 1, 131, 4F, 1); IRON = new
		 * EnumToolMaterial("IRON", 2, 2, 250, 6F, 2); EMERALD = new
		 * EnumToolMaterial("EMERALD", 3, 3, 1561, 8F, 3); GOLD = new
		 * EnumToolMaterial("GOLD", 4, 0, 32, 12F, 0);
		 */
		field_21209_j = (new EnumToolMaterial[] { WOOD, STONE,

		ALUMINUM, TIN, ZINC, BISMUTH, COPPER, LEAD,

		BRASS, BRONZE, SILVER, BORON, GOLD,

		IRON, COBALT, PLATINUM, NICKEL,

		CHROME, SILICON, STEEL,

		TUNGSTEN, TITANIUM,

		DIAMOND, OSMIUM });
	}
}

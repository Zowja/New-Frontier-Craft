// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.io.PrintStream;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            ItemStack, StatCollector, ItemSpade, EnumToolMaterial, 
//            ItemPickaxe, ItemAxe, ItemFlintAndSteel, ItemFood, 
//            ItemBow, ItemCoal, ItemSword, ItemSoup, 
//            ItemHoe, ItemSeeds, Block, ItemArmor, 
//            ItemPainting, ItemSign, ItemDoor, Material, 
//            ItemBucket, ItemMinecart, ItemSaddle, ItemRedstone, 
//            ItemSnowball, ItemBoat, ItemReed, ItemEgg, 
//            ItemFishingRod, ItemDye, ItemBed, ItemCookie, 
//            ItemMap, ItemShears, ItemRecord, StatList, 
//            EntityPlayer, World, EntityLiving, Entity

public class Item {

	protected Item(int i) {
		maxStackSize = 64;
		maxDamage = 0;
		bFull3D = false;
		hasSubtypes = false;
		containerItem = null;
		shiftedIndex = 256 + i;
		if (itemsList[256 + i] != null) {
			System.out.println((new StringBuilder()).append("CONFLICT @ ")
					.append(i).toString());
		}
		itemsList[256 + i] = this;
	}

	public Item setIconIndex(int i) {
		iconIndex = i;
		return this;
	}

	public Item setMaxStackSize(int i) {
		maxStackSize = i;
		return this;
	}

	public Item setIconCoord(int i, int j) {
		iconIndex = i + j * 16;
		return this;
	}

	public int getIconFromDamage(int i) {
		return iconIndex;
	}

	public final int getIconIndex(ItemStack itemstack) {
		return getIconFromDamage(itemstack.getItemDamage());
	}

	public boolean onItemUse(ItemStack itemstack, EntityPlayer entityplayer,
			World world, int i, int j, int k, int l) {
		return false;
	}

	public float getStrVsBlock(ItemStack itemstack, Block block) {
		return 1.0F;
	}

	public ItemStack onItemRightClick(ItemStack itemstack, World world,
			EntityPlayer entityplayer) {
		return itemstack;
	}

	public int getItemStackLimit() {
		return maxStackSize;
	}

	public int getPlacedBlockMetadata(int i) {
		return 0;
	}

	public boolean getHasSubtypes() {
		return hasSubtypes;
	}

	protected Item setHasSubtypes(boolean flag) {
		hasSubtypes = flag;
		return this;
	}

	public int getMaxDamage() {
		return maxDamage;
	}

	protected Item setMaxDamage(int i) {
		maxDamage = i;
		return this;
	}

	public boolean isDamagable() {
		return maxDamage > 0 && !hasSubtypes;
	}

	public boolean hitEntity(ItemStack itemstack, EntityLiving entityliving,
			EntityLiving entityliving1) {
		return false;
	}

	public boolean onBlockDestroyed(ItemStack itemstack, int i, int j, int k,
			int l, EntityLiving entityliving) {
		return false;
	}

	public int getDamageVsEntity(Entity entity) {
		return 1;
	}

	public boolean canHarvestBlock(Block block) {
		return false;
	}

	public void saddleEntity(ItemStack itemstack, EntityLiving entityliving) {
	}

	public Item setFull3D() {
		bFull3D = true;
		return this;
	}

	public boolean isFull3D() {
		return bFull3D;
	}

	public boolean shouldRotateAroundWhenRendering() {
		return false;
	}

	public Item setItemName(String s) {
		itemName = s;
		return this;
	}

	public String getItemName() {
		return itemName;
	}

	public String getItemNameIS(ItemStack itemstack) {
		return itemName;
	}

	public Item setContainerItem(Item item) {
		if (maxStackSize > 1) {
			throw new IllegalArgumentException(
					"Max stack size must be 1 for items with crafting results");
		} else {
			containerItem = item;
			return this;
		}
	}

	public Item getContainerItem() {
		return containerItem;
	}

	public boolean hasContainerItem() {
		return containerItem != null;
	}

	public String getStatName() {
		return StatCollector.translateToLocal((new StringBuilder())
				.append(getItemName()).append(".name").toString());
	}

	public int getColorFromDamage(int i) {
		return 0xffffff;
	}

	public void onUpdate(ItemStack itemstack, World world, Entity entity,
			int i, boolean flag) {
	}

	public void onCreated(ItemStack itemstack, World world,
			EntityPlayer entityplayer) {
	}

	protected static Random itemRand = new Random();
	public static Item itemsList[] = new Item[32000];
	public static Item shovelSteel;
	public static Item pickaxeSteel;
	public static Item axeSteel;
	public static Item flintAndSteel = (new ItemFlintAndSteel(3)).setIconCoord(
			5, 0).setItemName("Flint and Steel");
	public static Item appleRed = (new ItemFood(4, 4, false)).setIconCoord(10,
			0).setItemName("Apple");
	public static Item bow = (new ItemBow(5)).setIconCoord(5, 1).setItemName(
			"Bow");
	public static Item arrow = (new Item(6)).setIconCoord(5, 2).setItemName(
			"Arrow");
	public static Item coal = (new ItemCoal(7)).setIconCoord(7, 0).setItemName(
			"Coal");
	public static Item diamond = (new Item(8)).setIconCoord(7, 3).setItemName(
			"Diamond");
	public static Item ingotIron = (new Item(9)).setIconCoord(7, 1)
			.setItemName("Iron Ingot");
	public static Item ingotGold = (new Item(10)).setIconCoord(7, 2)
			.setItemName("Gold Ingot");
	public static Item swordSteel;
	public static Item swordWood;
	public static Item shovelWood;
	public static Item pickaxeWood;
	public static Item axeWood;
	public static Item swordStone;
	public static Item shovelStone;
	public static Item pickaxeStone;
	public static Item axeStone;
	public static Item swordDiamond;
	public static Item shovelDiamond;
	public static Item pickaxeDiamond;
	public static Item axeDiamond;
	public static Item stick = (new Item(24)).setIconCoord(5, 3).setFull3D()
			.setItemName("Stick");
	public static Item bowlEmpty = (new Item(25)).setIconCoord(7, 4)
			.setItemName("Bowl");
	public static Item bowlSoup = (new ItemSoup(26, 10)).setIconCoord(8, 4)
			.setItemName("Mushroom Stew");
	public static Item swordGold;
	public static Item shovelGold;
	public static Item pickaxeGold;
	public static Item axeGold;
	public static Item silk = (new Item(31)).setIconCoord(8, 0).setItemName(
			"String");
	public static Item feather = (new Item(32)).setIconCoord(8, 1).setItemName(
			"Feather");
	public static Item gunpowder = (new Item(33)).setIconCoord(8, 2)
			.setItemName("Gunpowder");
	public static Item hoeWood;
	public static Item hoeStone;
	public static Item hoeSteel;
	public static Item hoeDiamond;
	public static Item hoeGold;
	public static Item seeds;
	public static Item wheat = (new Item(40)).setIconCoord(9, 1).setItemName(
			"Wheat");
	public static Item bread = (new ItemFood(41, 5, false)).setIconCoord(9, 2)
			.setItemName("Bread");
	public static Item helmetLeather = (new ItemArmor(42, 1, 0, 0))
			.setIconCoord(0, 0).setItemName("Leather Helmet");
	public static Item plateLeather = (new ItemArmor(43, 1, 0, 1))
			.setIconCoord(0, 1).setItemName("Leather Tunic");
	public static Item legsLeather = (new ItemArmor(44, 1, 0, 2)).setIconCoord(
			0, 2).setItemName("Leather Leggings");
	public static Item bootsLeather = (new ItemArmor(45, 1, 0, 3))
			.setIconCoord(0, 3).setItemName("Leather Boots");
	public static Item helmetChain = (new ItemArmor(46, 2, 1, 0)).setIconCoord(
			1, 0).setItemName("Chainmail Helmet");
	public static Item plateChain = (new ItemArmor(47, 2, 1, 1)).setIconCoord(
			1, 1).setItemName("Chainmail Helmet");
	public static Item legsChain = (new ItemArmor(48, 2, 1, 2)).setIconCoord(1,
			2).setItemName("Chainmail Leggings");
	public static Item bootsChain = (new ItemArmor(49, 2, 1, 3)).setIconCoord(
			1, 3).setItemName("Chainmail Boots");
	public static Item helmetSteel = (new ItemArmor(50, 3, 2, 0)).setIconCoord(
			2, 0).setItemName("Iron Helmet");
	public static Item plateSteel = (new ItemArmor(51, 3, 2, 1)).setIconCoord(
			2, 1).setItemName("Iron Chestplate");
	public static Item legsSteel = (new ItemArmor(52, 3, 2, 2)).setIconCoord(2,
			2).setItemName("Iron Leggings");
	public static Item bootsSteel = (new ItemArmor(53, 3, 2, 3)).setIconCoord(
			2, 3).setItemName("Iron Boots");
	public static Item helmetDiamond = (new ItemArmor(54, 5, 3, 0))
			.setIconCoord(3, 0).setItemName("Diamond Helmets");
	public static Item plateDiamond = (new ItemArmor(55, 5, 3, 1))
			.setIconCoord(3, 1).setItemName("Diamond Chestplate");
	public static Item legsDiamond = (new ItemArmor(56, 5, 3, 2)).setIconCoord(
			3, 2).setItemName("Diamond Leggings");
	public static Item bootsDiamond = (new ItemArmor(57, 5, 3, 3))
			.setIconCoord(3, 3).setItemName("Diamond Boots");
	public static Item helmetGold = (new ItemArmor(58, 1, 4, 0)).setIconCoord(
			4, 0).setItemName("Gold Helmet");
	public static Item plateGold = (new ItemArmor(59, 1, 4, 1)).setIconCoord(4,
			1).setItemName("Gold Chestplate");
	public static Item legsGold = (new ItemArmor(60, 1, 4, 2)).setIconCoord(4,
			2).setItemName("Gold Leggings");
	public static Item bootsGold = (new ItemArmor(61, 1, 4, 3)).setIconCoord(4,
			3).setItemName("Gold Boots");
	public static Item flint = (new Item(62)).setIconCoord(6, 0).setItemName(
			"Flint");
	public static Item porkRaw = (new ItemFood(63, 3, true)).setIconCoord(7, 5)
			.setItemName("Raw Porkchop");
	public static Item porkCooked = (new ItemFood(64, 8, true)).setIconCoord(8,
			5).setItemName("Cooked Porkchop");
	public static Item painting = (new ItemPainting(65)).setIconCoord(10, 1)
			.setItemName("Painting");
	public static Item appleGold = (new ItemFood(66, 42, false)).setIconCoord(
			11, 0).setItemName("Golden Apple");
	public static Item sign = (new ItemSign(67)).setIconCoord(10, 2)
			.setItemName("Sign");
	public static Item doorWood;
	public static Item bucketEmpty;
	public static Item bucketWater;
	public static Item bucketLava;
	public static Item minecartEmpty = (new ItemMinecart(72, 0)).setIconCoord(
			7, 8).setItemName("Minecart");
	public static Item saddle = (new ItemSaddle(73)).setIconCoord(8, 6)
			.setItemName("Saddle");
	public static Item doorSteel;
	public static Item redstone = (new ItemRedstone(75)).setIconCoord(8, 3)
			.setItemName("Redstone");
	public static Item snowball = (new ItemSnowball(76)).setIconCoord(14, 0)
			.setItemName("Snowball");
	public static Item boat = (new ItemBoat(77)).setIconCoord(8, 8)
			.setItemName("Boat");
	public static Item leather = (new Item(78)).setIconCoord(7, 6).setItemName(
			"Leather");
	public static Item bucketMilk;
	public static Item brick = (new Item(80)).setIconCoord(6, 1).setItemName(
			"Brick");
	public static Item clay = (new Item(81)).setIconCoord(9, 3).setItemName(
			"Clay");
	public static Item reed;
	public static Item paper = (new Item(83)).setIconCoord(10, 3).setItemName(
			"Paper");
	public static Item book = (new Item(84)).setIconCoord(11, 3).setItemName(
			"Book");
	public static Item slimeBall = (new Item(85)).setIconCoord(14, 1)
			.setItemName("Slimeball");
	public static Item minecartCrate = (new ItemMinecart(86, 1)).setIconCoord(
			7, 9).setItemName("Chest Minecart");
	public static Item minecartPowered = (new ItemMinecart(87, 2))
			.setIconCoord(7, 10).setItemName("Furnace Minecart");
	public static Item egg = (new ItemEgg(88)).setIconCoord(12, 0).setItemName(
			"Egg");
	public static Item compass = (new Item(89)).setIconCoord(6, 3).setItemName(
			"Compass");
	public static Item fishingRod = (new ItemFishingRod(90)).setIconCoord(5, 4)
			.setItemName("Fishing Rod");
	public static Item pocketSundial = (new Item(91)).setIconCoord(6, 4)
			.setItemName("Clock");
	public static Item lightStoneDust = (new Item(92)).setIconCoord(9, 4)
			.setItemName("Glowstone Dust");
	public static Item fishRaw = (new ItemFood(93, 2, false))
			.setIconCoord(9, 5).setItemName("Raw Fish");
	public static Item fishCooked = (new ItemFood(94, 5, false)).setIconCoord(
			10, 5).setItemName("Cooked fish");
	public static Item dyePowder = (new ItemDye(95)).setIconCoord(14, 4)
			.setItemName("Dye");
	public static Item bone = (new Item(96)).setIconCoord(12, 1)
			.setItemName("Bone").setFull3D();
	public static Item sugar = (new Item(97)).setIconCoord(13, 0)
			.setItemName("Sugar").setFull3D();
	public static Item cake;
	public static Item bed = (new ItemBed(99)).setMaxStackSize(1)
			.setIconCoord(13, 2).setItemName("Bed");
	public static Item redstoneRepeater;
	public static Item cookie = (new ItemCookie(101, 1, false, 8))
			.setIconCoord(12, 5).setItemName("Cookie");
	public static ItemMap mapItem = (ItemMap) (new ItemMap(102)).setIconCoord(
			12, 3).setItemName("Map");
	public static ItemShears shears = (ItemShears) (new ItemShears(103))
			.setIconCoord(13, 5).setItemName("Shears");
	public static Item record13 = (new ItemRecord(2000, "%13")).setIconCoord(13,
			3).setItemName("Music Disc");
	public static Item recordCat = (new ItemRecord(2001, "%cat")).setIconCoord(
			14, 2).setItemName("Music Disc");
	public final int shiftedIndex;
	protected int maxStackSize;
	private int maxDamage;
	protected int iconIndex;
	protected boolean bFull3D;
	protected boolean hasSubtypes;
	private Item containerItem;
	private String itemName;

	static {
		shovelSteel = (new ItemSpade(0, EnumToolMaterial.IRON)).setIconCoord(2,
				5).setItemName("Iron Shovel");
		pickaxeSteel = (new ItemPickaxe(1, EnumToolMaterial.IRON))
				.setIconCoord(2, 6).setItemName("Iron Pickaxe");
		axeSteel = (new ItemAxe(2, EnumToolMaterial.IRON)).setIconCoord(2, 7)
				.setItemName("Iron Axe");
		swordSteel = (new ItemSword(11, EnumToolMaterial.IRON)).setIconCoord(2,
				4).setItemName("Iron Sword");
		swordWood = (new ItemSword(12, EnumToolMaterial.WOOD)).setIconCoord(0,
				4).setItemName("Wood Sword");
		shovelWood = (new ItemSpade(13, EnumToolMaterial.WOOD)).setIconCoord(0,
				5).setItemName("Wood Shovel");
		pickaxeWood = (new ItemPickaxe(14, EnumToolMaterial.WOOD))
				.setIconCoord(0, 6).setItemName("Wood Pickaxe");
		axeWood = (new ItemAxe(15, EnumToolMaterial.WOOD)).setIconCoord(0, 7)
				.setItemName("Wood Axe");
		swordStone = (new ItemSword(16, EnumToolMaterial.STONE)).setIconCoord(
				1, 4).setItemName("Stone Sword");
		shovelStone = (new ItemSpade(17, EnumToolMaterial.STONE)).setIconCoord(
				1, 5).setItemName("Stone Shovel");
		pickaxeStone = (new ItemPickaxe(18, EnumToolMaterial.STONE))
				.setIconCoord(1, 6).setItemName("Stone Pickaxe");
		axeStone = (new ItemAxe(19, EnumToolMaterial.STONE)).setIconCoord(1, 7)
				.setItemName("Stone Axe");
		swordDiamond = (new ItemSword(20, EnumToolMaterial.DIAMOND))
				.setIconCoord(3, 4).setItemName("Diamond Sword");
		shovelDiamond = (new ItemSpade(21, EnumToolMaterial.DIAMOND))
				.setIconCoord(3, 5).setItemName("Diamond Shovel");
		pickaxeDiamond = (new ItemPickaxe(22, EnumToolMaterial.DIAMOND))
				.setIconCoord(3, 6).setItemName("Diamond Pickaxe");
		axeDiamond = (new ItemAxe(23, EnumToolMaterial.DIAMOND)).setIconCoord(
				3, 7).setItemName("Diamond Axe");
		swordGold = (new ItemSword(27, EnumToolMaterial.GOLD)).setIconCoord(4,
				4).setItemName("Gold Sword");
		shovelGold = (new ItemSpade(28, EnumToolMaterial.GOLD)).setIconCoord(4,
				5).setItemName("Gold Shovel");
		pickaxeGold = (new ItemPickaxe(29, EnumToolMaterial.GOLD))
				.setIconCoord(4, 6).setItemName("Gold Pickaxe");
		axeGold = (new ItemAxe(30, EnumToolMaterial.GOLD)).setIconCoord(4, 7)
				.setItemName("Gold Axe");
		hoeWood = (new ItemHoe(34, EnumToolMaterial.WOOD)).setIconCoord(0, 8)
				.setItemName("Wood Hoe");
		hoeStone = (new ItemHoe(35, EnumToolMaterial.STONE)).setIconCoord(1, 8)
				.setItemName("Stone Hoe");
		hoeSteel = (new ItemHoe(36, EnumToolMaterial.IRON)).setIconCoord(2, 8)
				.setItemName("Iron Hoe");
		hoeDiamond = (new ItemHoe(37, EnumToolMaterial.DIAMOND)).setIconCoord(
				3, 8).setItemName("Diamond Hoe");
		hoeGold = (new ItemHoe(38, EnumToolMaterial.GOLD)).setIconCoord(4, 8)
				.setItemName("Gold Hoe");
		seeds = (new ItemSeeds(39, Block.crops.blockID)).setIconCoord(9, 0)
				.setItemName("Seeds");
		doorWood = (new ItemDoor(68, Material.wood)).setIconCoord(11, 2)
				.setItemName("Wood Door");
		bucketEmpty = (new ItemBucket(69, 0)).setIconCoord(10, 4).setItemName(
				"Bucket");
		bucketWater = (new ItemBucket(70, Block.waterMoving.blockID))
				.setIconCoord(11, 4).setItemName("Water Bucket")
				.setContainerItem(bucketEmpty);
		bucketLava = (new ItemBucket(71, Block.lavaMoving.blockID))
				.setIconCoord(12, 4).setItemName("Lava Bucket")
				.setContainerItem(bucketEmpty);
		doorSteel = (new ItemDoor(74, Material.iron)).setIconCoord(12, 2)
				.setItemName("Iron Door");
		bucketMilk = (new ItemBucket(79, -1)).setIconCoord(13, 4)
				.setItemName("Milk").setContainerItem(bucketEmpty);
		reed = (new ItemReed(82, Block.reed)).setIconCoord(11, 1).setItemName(
				"Reeds");
		cake = (new ItemReed(98, Block.cake)).setMaxStackSize(1)
				.setIconCoord(13, 1).setItemName("Cake");
		redstoneRepeater = (new ItemReed(100, Block.redstoneRepeaterIdle))
				.setIconCoord(6, 5).setItemName("Repeater");
		StatList.func_25151_b();
	}
}

package net.minecraft.src;

public class NFC {

	public static void addRecipies(CraftingManager craftmng) {

		Item.itemsList[EWStep.blockID] = (new ItemSlab(
				EWStep.blockID - 256)).setItemName("Stone Slab");
		Item.itemsList[NSStep.blockID] = (new ItemSlab(
				NSStep.blockID - 256)).setItemName("Stone Slab");
		
		// For derp crafting
		//craftmng.addRecipe(new ItemStack(Block.tallGrass, 2, 2), new Object[] { "X", ('X'), Block.dirt });
		
		for (int i = 0; i < 256; i++) {
			if (Block.blocksList[i] != null && Item.itemsList[i] == null) {
				Item.itemsList[i] = new ItemBlock(i - 256);
				Block.blocksList[i].initializeBlock();
			}
		}
		
		craftmng.addRecipe(new ItemStack(Scaffold, 10), new Object[] {
	            "###", "XXX", "XXX", Character.valueOf('#'), Block.planks, Character.valueOf('X'), Block.ladder
	        });
		
		craftmng.addRecipe(new ItemStack(Block.stairSingle, 6, 4), new Object[] {
	            "###", Character.valueOf('#'), Block.brick
	        });
		craftmng.addRecipe(new ItemStack(BrickStairs, 4), new Object[] {
	            "#  ", "## ", "###", Character.valueOf('#'), Block.brick
	        });
		craftmng.addRecipe(new ItemStack(SandstoneStairs, 4), new Object[] {
	            "#  ", "## ", "###", Character.valueOf('#'), Block.sandStone
	        });
		craftmng.addRecipe(new ItemStack(StoneStairs, 4), new Object[] {
	            "#  ", "## ", "###", Character.valueOf('#'), stoneBlock
	        });
		
		craftmng.addShapelessRecipe(new ItemStack(Block.stairDouble.blockID, 1, 0),
				new Object[] { new ItemStack(Block.stairSingle, 1, 0),
						new ItemStack(Block.stairSingle, 1, 0) });
		
		craftmng.addRecipe(new ItemStack(Telescope, 1), new Object[] { "XO ", "OH ", "  O",
				('X'), Block.glass, ('H'), Item.leather, ('O'), brass });
		craftmng.addRecipe(new ItemStack(Wrench, 1), new Object[] { " O ", "OH ", "  O",
				('H'), Item.leather, ('O'), Item.ingotIron });
		
		craftmng.addRecipe(new ItemStack(BrickOvenIdle, 1), new Object[] { "XXX", "X X", "XXX",
			('X'), Block.brick });
		
		craftmng.addRecipe(new ItemStack(Block.torchWood, 8), new Object[] { "X", "O",
			('X'), anthracite, ('O'), Item.stick  });

		craftmng.addShapelessRecipe(new ItemStack(writableBook, 1),
				new Object[] { new ItemStack(Item.book, 1),
						new ItemStack(Item.feather, 1),
						new ItemStack(Item.dyePowder, 1, 0) });
		craftmng.addShapelessRecipe(new ItemStack(dynamite, 1),
				new Object[] { new ItemStack(Item.clay, 1), new ItemStack(Block.sand, 1),
						new ItemStack(Item.gunpowder, 1), new ItemStack(Item.gunpowder, 1), new ItemStack(Item.gunpowder, 1),
						new ItemStack(Item.silk, 1), new ItemStack(Item.redstone, 1) });
		craftmng.addRecipe(new ItemStack(stoneBlock, 1), new Object[] { "X",
				('X'), Block.stone });
		craftmng.addRecipe(new ItemStack(stoneBlockoffxy, 4), new Object[] {
				"XX", "XX", ('X'), stoneBlock });
		craftmng.addRecipe(new ItemStack(stoneBlockoffx, 2), new Object[] {
				"XX", ('X'), stoneBlock });
		craftmng.addRecipe(new ItemStack(stoneBlockoffy, 2), new Object[] {
				"X", "X", ('X'), stoneBlock });
		craftmng.addRecipe(new ItemStack(stoneBlockSmall, 9), new Object[] {
				"XXX", "XXX", "XXX", ('X'), stoneBlock });
		craftmng.addShapelessRecipe(new ItemStack(stoneBricks, 3),
				new Object[] { new ItemStack(stoneBlock, 1), new ItemStack(stoneBlock, 1), new ItemStack(stoneBlock, 1) });
		craftmng.addRecipe(new ItemStack(platedStone, 4), new Object[] {
	            "##", "##", Character.valueOf('#'), Block.stone
	        });
		
		craftmng.addShapelessRecipe(new ItemStack(Block.glass, 2, 1),
				new Object[] { Block.glass, Block.planks });
		craftmng.addRecipe(new ItemStack(Block.glass, 4, 2), new Object[] { " X ",
				"XOX", " X ", ('X'), Block.planks, ('O'), Block.glass });
		craftmng.addRecipe(new ItemStack(Block.glass, 3, 3), new Object[] { "XOX",
				('X'), Block.planks, ('O'), Block.glass });

		craftmng.addRecipe(new ItemStack(writtenBook, 1), new Object[] { "XO",
				Character.valueOf('X'), writtenBook, Character.valueOf('O'),
				writableBook });
		craftmng.addRecipe(new ItemStack(writtenBook, 1), new Object[] { "OX",
				Character.valueOf('X'), writtenBook, Character.valueOf('O'),
				writableBook });

		craftmng.addShapelessRecipe(new ItemStack(coloredseeds, 1),
				new Object[] { Item.seeds, new ItemStack(Item.dyePowder, 1, 1),
						new ItemStack(Item.dyePowder, 1, 0),
						new ItemStack(Item.dyePowder, 1, 2),
						new ItemStack(Item.dyePowder, 1, 3),
						new ItemStack(Item.dyePowder, 1, 4),
						new ItemStack(Item.dyePowder, 1, 15),
						new ItemStack(Item.dyePowder, 1, 11), });

		craftmng.addRecipe(new ItemStack(recorddroopylikesyourface, 1),
				new Object[] { "XXX", "XOX", "XXX", Character.valueOf('X'),
						Block.obsidian, Character.valueOf('O'),
						sapphire });

		craftmng.addRecipe(new ItemStack(fakecobbleitem1, 1), new Object[] {
				"XXX", "XXX", "XXX", ('X'), Block.cobblestone });
		craftmng.addRecipe(new ItemStack(fakecobbleitem2, 1), new Object[] {
				"XXX", "XXX", "XXX", ('X'), fakecobbleitem1 });
		craftmng.addRecipe(new ItemStack(fakecobbleitem3, 1), new Object[] {
				"XXX", "XXX", "XXX", ('X'), fakecobbleitem2 });
		craftmng.addRecipe(new ItemStack(recordilackanemotion, 1),
				new Object[] { "XXX", "XXX", "XXX", ('X'), fakecobbleitem3 });

		craftmng.addRecipe(new ItemStack(aluminumblock, 1), new Object[] {
				"XX", "XX", ('X'), aluminum });
		craftmng.addRecipe(new ItemStack(bismuthblock, 1), new Object[] { "XX",
				"XX", ('X'), bismuth });
		craftmng.addRecipe(new ItemStack(boronblock, 1), new Object[] { "XX",
				"XX", ('X'), boron });
		craftmng.addRecipe(new ItemStack(chromeblock, 1), new Object[] { "XX",
				"XX", ('X'), chrome });
		craftmng.addRecipe(new ItemStack(cobaltblock, 1), new Object[] { "XX",
				"XX", ('X'), cobalt });
		craftmng.addRecipe(new ItemStack(copperblock, 1), new Object[] { "XX",
				"XX", ('X'), copper });
		craftmng.addRecipe(new ItemStack(emeraldblock, 1), new Object[] { "XX",
				"XX", ('X'), emerald });
		craftmng.addRecipe(new ItemStack(leadblock, 1), new Object[] { "XX",
				"XX", ('X'), lead });
		craftmng.addRecipe(new ItemStack(magnetiteblock, 1), new Object[] {
				"XX", "XX", ('X'), magnet });
		craftmng.addRecipe(new ItemStack(nickelblock, 1), new Object[] { "XX",
				"XX", ('X'), nickel });
		craftmng.addRecipe(new ItemStack(platinumblock, 1), new Object[] {
				"XX", "XX", ('X'), platinum });
		craftmng.addRecipe(new ItemStack(rubyblock, 1), new Object[] { "XX",
				"XX", ('X'), ruby });
		craftmng.addRecipe(new ItemStack(sapphireblock, 1), new Object[] {
				"XX", "XX", ('X'), sapphire });
		craftmng.addRecipe(new ItemStack(siliconblock, 1), new Object[] { "XX",
				"XX", ('X'), silicon });
		craftmng.addRecipe(new ItemStack(silverblock, 1), new Object[] { "XX",
				"XX", ('X'), silver });
		craftmng.addRecipe(new ItemStack(tinblock, 1), new Object[] { "XX",
				"XX", ('X'), tin });
		craftmng.addRecipe(new ItemStack(titaniumblock, 1), new Object[] {
				"XX", "XX", ('X'), titanium });
		craftmng.addRecipe(new ItemStack(tungstenblock, 1), new Object[] {
				"XX", "XX", ('X'), tungsten });
		craftmng.addRecipe(new ItemStack(uraniumblock, 1), new Object[] { "XX",
				"XX", ('X'), uranium });
		craftmng.addRecipe(new ItemStack(zincblock, 1), new Object[] { "XX",
				"XX", ('X'), zinc });
		craftmng.addRecipe(new ItemStack(brassblock, 1), new Object[] { "XX",
				"XX", ('X'), brass });
		craftmng.addRecipe(new ItemStack(bronzeblock, 1), new Object[] { "XX",
				"XX", ('X'), bronze });
		craftmng.addRecipe(new ItemStack(steelblock, 1), new Object[] { "XX",
				"XX", ('X'), steel });

		craftmng.addRecipe(new ItemStack(aluminumhelmet, 1), new Object[] {
				"XXX", "X X", ('X'), aluminum });
		craftmng.addRecipe(new ItemStack(bismuthhelmet, 1), new Object[] {
				"XXX", "X X", ('X'), bismuth });
		craftmng.addRecipe(new ItemStack(boronhelmet, 1), new Object[] { "XXX",
				"X X", ('X'), boron });
		craftmng.addRecipe(new ItemStack(chromehelmet, 1), new Object[] {
				"XXX", "X X", ('X'), chrome });
		craftmng.addRecipe(new ItemStack(cobalthelmet, 1), new Object[] {
				"XXX", "X X", ('X'), cobalt });
		craftmng.addRecipe(new ItemStack(copperhelmet, 1), new Object[] {
				"XXX", "X X", ('X'), copper });
		craftmng.addRecipe(new ItemStack(emeraldhelmet, 1), new Object[] {
				"XXX", "X X", ('X'), emerald });
		craftmng.addRecipe(new ItemStack(nickelhelmet, 1), new Object[] {
				"XXX", "X X", ('X'), nickel });
		craftmng.addRecipe(new ItemStack(platinumhelmet, 1), new Object[] {
				"XXX", "X X", ('X'), platinum });
		craftmng.addRecipe(new ItemStack(rubyhelmet, 1), new Object[] {
				"XXX", "X X", ('X'), ruby });
		craftmng.addRecipe(new ItemStack(sapphirehelmet, 1), new Object[] {
				"XXX", "X X", ('X'), sapphire });
		craftmng.addRecipe(new ItemStack(siliconhelmet, 1), new Object[] {
				"XXX", "X X", ('X'), silicon });
		craftmng.addRecipe(new ItemStack(silverhelmet, 1), new Object[] {
				"XXX", "X X", ('X'), silver });
		craftmng.addRecipe(new ItemStack(tinhelmet, 1), new Object[] { "XXX",
				"X X", ('X'), tin });
		craftmng.addRecipe(new ItemStack(titaniumhelmet, 1), new Object[] {
				"XXX", "X X", ('X'), titanium });
		craftmng.addRecipe(new ItemStack(tungstenhelmet, 1), new Object[] {
				"XXX", "X X", ('X'), tungsten });
		craftmng.addRecipe(new ItemStack(zinchelmet, 1), new Object[] { "XXX",
				"X X", ('X'), zinc });
		craftmng.addRecipe(new ItemStack(brasshelmet, 1), new Object[] { "XXX",
				"X X", ('X'), brass });
		craftmng.addRecipe(new ItemStack(bronzehelmet, 1), new Object[] {
				"XXX", "X X", ('X'), bronze });
		craftmng.addRecipe(new ItemStack(steelhelmet, 1), new Object[] { "XXX",
				"X X", ('X'), steel });
		craftmng.addRecipe(new ItemStack(osmiumhelmet, 1), new Object[] { "XXX",
			"X X", ('X'), osmium });

		craftmng.addRecipe(new ItemStack(aluminumchestplate, 1), new Object[] {
				"X X", "XXX", "XXX", ('X'), aluminum });
		craftmng.addRecipe(new ItemStack(bismuthchestplate, 1), new Object[] {
				"X X", "XXX", "XXX", ('X'), bismuth });
		craftmng.addRecipe(new ItemStack(boronchestplate, 1), new Object[] {
				"X X", "XXX", "XXX", ('X'), boron });
		craftmng.addRecipe(new ItemStack(chromechestplate, 1), new Object[] {
				"X X", "XXX", "XXX", ('X'), chrome });
		craftmng.addRecipe(new ItemStack(cobaltchestplate, 1), new Object[] {
				"X X", "XXX", "XXX", ('X'), cobalt });
		craftmng.addRecipe(new ItemStack(copperchestplate, 1), new Object[] {
				"X X", "XXX", "XXX", ('X'), copper });
		craftmng.addRecipe(new ItemStack(emeraldchestplate, 1), new Object[] {
				"X X", "XXX", "XXX", ('X'), emerald });
		craftmng.addRecipe(new ItemStack(nickelchestplate, 1), new Object[] {
				"X X", "XXX", "XXX", ('X'), nickel });
		craftmng.addRecipe(new ItemStack(platinumchestplate, 1), new Object[] {
				"X X", "XXX", "XXX", ('X'), platinum });
		craftmng.addRecipe(new ItemStack(rubychestplate, 1), new Object[] {
				"X X", "XXX", "XXX", ('X'), ruby });
		craftmng.addRecipe(new ItemStack(sapphirechestplate, 1), new Object[] {
				"X X", "XXX", "XXX", ('X'), sapphire });
		craftmng.addRecipe(new ItemStack(siliconchestplate, 1), new Object[] {
				"X X", "XXX", "XXX", ('X'), silicon });
		craftmng.addRecipe(new ItemStack(silverchestplate, 1), new Object[] {
				"X X", "XXX", "XXX", ('X'), silver });
		craftmng.addRecipe(new ItemStack(tinchestplate, 1), new Object[] {
				"X X", "XXX", "XXX", ('X'), tin });
		craftmng.addRecipe(new ItemStack(titaniumchestplate, 1), new Object[] {
				"X X", "XXX", "XXX", ('X'), titanium });
		craftmng.addRecipe(new ItemStack(tungstenchestplate, 1), new Object[] {
				"X X", "XXX", "XXX", ('X'), tungsten });
		craftmng.addRecipe(new ItemStack(zincchestplate, 1), new Object[] {
				"X X", "XXX", "XXX", ('X'), zinc });
		craftmng.addRecipe(new ItemStack(brasschestplate, 1), new Object[] {
				"X X", "XXX", "XXX", ('X'), brass });
		craftmng.addRecipe(new ItemStack(bronzechestplate, 1), new Object[] {
				"X X", "XXX", "XXX", ('X'), bronze });
		craftmng.addRecipe(new ItemStack(steelchestplate, 1), new Object[] {
				"X X", "XXX", "XXX", ('X'), steel });
		craftmng.addRecipe(new ItemStack(osmiumchestplate, 1), new Object[] {
			"X X", "XXX", "XXX", ('X'), osmium });

		craftmng.addRecipe(new ItemStack(aluminumleggings, 1), new Object[] {
				"XXX", "X X", "X X", ('X'), aluminum });
		craftmng.addRecipe(new ItemStack(bismuthleggings, 1), new Object[] {
				"XXX", "X X", "X X", ('X'), bismuth });
		craftmng.addRecipe(new ItemStack(boronleggings, 1), new Object[] {
				"XXX", "X X", "X X", ('X'), boron });
		craftmng.addRecipe(new ItemStack(chromeleggings, 1), new Object[] {
				"XXX", "X X", "X X", ('X'), chrome });
		craftmng.addRecipe(new ItemStack(cobaltleggings, 1), new Object[] {
				"XXX", "X X", "X X", ('X'), cobalt });
		craftmng.addRecipe(new ItemStack(copperleggings, 1), new Object[] {
				"XXX", "X X", "X X", ('X'), copper });
		craftmng.addRecipe(new ItemStack(emeraldleggings, 1), new Object[] {
				"XXX", "X X", "X X", ('X'), emerald });
		craftmng.addRecipe(new ItemStack(nickelleggings, 1), new Object[] {
				"XXX", "X X", "X X", ('X'), nickel });
		craftmng.addRecipe(new ItemStack(platinumleggings, 1), new Object[] {
				"XXX", "X X", "X X", ('X'), platinum });
		craftmng.addRecipe(new ItemStack(rubyleggings, 1), new Object[] {
				"XXX", "X X", "X X", ('X'), ruby });
		craftmng.addRecipe(new ItemStack(sapphireleggings, 1), new Object[] {
				"XXX", "X X", "X X", ('X'), sapphire });
		craftmng.addRecipe(new ItemStack(siliconleggings, 1), new Object[] {
				"XXX", "X X", "X X", ('X'), silicon });
		craftmng.addRecipe(new ItemStack(silverleggings, 1), new Object[] {
				"XXX", "X X", "X X", ('X'), silver });
		craftmng.addRecipe(new ItemStack(tinleggings, 1), new Object[] { "XXX",
				"X X", "X X", ('X'), tin });
		craftmng.addRecipe(new ItemStack(titaniumleggings, 1), new Object[] {
				"XXX", "X X", "X X", ('X'), titanium });
		craftmng.addRecipe(new ItemStack(tungstenleggings, 1), new Object[] {
				"XXX", "X X", "X X", ('X'), tungsten });
		craftmng.addRecipe(new ItemStack(zincleggings, 1), new Object[] {
				"XXX", "X X", "X X", ('X'), zinc });
		craftmng.addRecipe(new ItemStack(brassleggings, 1), new Object[] {
				"XXX", "X X", "X X", ('X'), brass });
		craftmng.addRecipe(new ItemStack(bronzeleggings, 1), new Object[] {
				"XXX", "X X", "X X", ('X'), bronze });
		craftmng.addRecipe(new ItemStack(steelleggings, 1), new Object[] {
				"XXX", "X X", "X X", ('X'), steel });
		craftmng.addRecipe(new ItemStack(osmiumleggings, 1), new Object[] {
			"XXX", "X X", "X X", ('X'), osmium });

		craftmng.addRecipe(new ItemStack(aluminumboots, 1), new Object[] {
				"X X", "X X", ('X'), aluminum });
		craftmng.addRecipe(new ItemStack(bismuthboots, 1), new Object[] {
				"X X", "X X", ('X'), bismuth });
		craftmng.addRecipe(new ItemStack(boronboots, 1), new Object[] { "X X",
				"X X", ('X'), boron });
		craftmng.addRecipe(new ItemStack(chromeboots, 1), new Object[] { "X X",
				"X X", ('X'), chrome });
		craftmng.addRecipe(new ItemStack(cobaltboots, 1), new Object[] { "X X",
				"X X", ('X'), cobalt });
		craftmng.addRecipe(new ItemStack(copperboots, 1), new Object[] { "X X",
				"X X", ('X'), copper });
		craftmng.addRecipe(new ItemStack(emeraldboots, 1), new Object[] {
				"X X", "X X", ('X'), emerald });
		craftmng.addRecipe(new ItemStack(nickelboots, 1), new Object[] { "X X",
				"X X", ('X'), nickel });
		craftmng.addRecipe(new ItemStack(platinumboots, 1), new Object[] {
				"X X", "X X", ('X'), platinum });
		craftmng.addRecipe(new ItemStack(rubyboots, 1), new Object[] { "X X",
				"X X", ('X'), ruby });
		craftmng.addRecipe(new ItemStack(sapphireboots, 1), new Object[] {
				"X X", "X X", ('X'), sapphire });
		craftmng.addRecipe(new ItemStack(siliconboots, 1), new Object[] {
				"X X", "X X", ('X'), silicon });
		craftmng.addRecipe(new ItemStack(silverboots, 1), new Object[] { "X X",
				"X X", ('X'), silver });
		craftmng.addRecipe(new ItemStack(tinboots, 1), new Object[] { "X X",
				"X X", ('X'), tin });
		craftmng.addRecipe(new ItemStack(titaniumboots, 1), new Object[] {
				"X X", "X X", ('X'), titanium });
		craftmng.addRecipe(new ItemStack(tungstenboots, 1), new Object[] {
				"X X", "X X", ('X'), tungsten });
		craftmng.addRecipe(new ItemStack(zincboots, 1), new Object[] { "X X",
				"X X", ('X'), zinc });
		craftmng.addRecipe(new ItemStack(brassboots, 1), new Object[] { "X X",
				"X X", ('X'), brass });
		craftmng.addRecipe(new ItemStack(bronzeboots, 1), new Object[] { "X X",
				"X X", ('X'), bronze });
		craftmng.addRecipe(new ItemStack(steelboots, 1), new Object[] { "X X",
				"X X", ('X'), steel });
		craftmng.addRecipe(new ItemStack(osmiumboots, 1), new Object[] { "X X",
			"X X", ('X'), osmium });

		craftmng.addRecipe(new ItemStack(aluminum, 4), new Object[] { "X",
				('X'), aluminumblock });
		craftmng.addRecipe(new ItemStack(bismuth, 4), new Object[] { "X",
				('X'), bismuthblock });
		craftmng.addRecipe(new ItemStack(boron, 4), new Object[] { "X", ('X'),
				boronblock });
		craftmng.addRecipe(new ItemStack(chrome, 4), new Object[] { "X", ('X'),
				chromeblock });
		craftmng.addRecipe(new ItemStack(cobalt, 4), new Object[] { "X", ('X'),
				cobaltblock });
		craftmng.addRecipe(new ItemStack(copper, 4), new Object[] { "X", ('X'),
				copperblock });
		craftmng.addRecipe(new ItemStack(emerald, 4), new Object[] { "X",
				('X'), emeraldblock });
		craftmng.addRecipe(new ItemStack(lead, 4), new Object[] { "X", ('X'),
				leadblock });
		craftmng.addRecipe(new ItemStack(nickel, 4), new Object[] { "X", ('X'),
				nickelblock });
		craftmng.addRecipe(new ItemStack(platinum, 4), new Object[] { "X",
				('X'), platinumblock });
		craftmng.addRecipe(new ItemStack(ruby, 4), new Object[] { "X", ('X'),
				rubyblock });
		craftmng.addRecipe(new ItemStack(sapphire, 4), new Object[] { "X",
				('X'), sapphireblock });
		craftmng.addRecipe(new ItemStack(silicon, 4), new Object[] { "X",
				('X'), siliconblock });
		craftmng.addRecipe(new ItemStack(silver, 4), new Object[] { "X", ('X'),
				silverblock });
		craftmng.addRecipe(new ItemStack(tin, 4), new Object[] { "X", ('X'),
				tinblock });
		craftmng.addRecipe(new ItemStack(titanium, 4), new Object[] { "X",
				('X'), titaniumblock });
		craftmng.addRecipe(new ItemStack(tungsten, 4), new Object[] { "X",
				('X'), tungstenblock });
		craftmng.addRecipe(new ItemStack(zinc, 4), new Object[] { "X", ('X'),
				zincblock });
		craftmng.addRecipe(new ItemStack(brass, 4), new Object[] { "X", ('X'),
				brassblock });
		craftmng.addRecipe(new ItemStack(bronze, 4), new Object[] { "X", ('X'),
				bronzeblock });
		craftmng.addRecipe(new ItemStack(steel, 4), new Object[] { "X", ('X'),
				steelblock });
		craftmng.addRecipe(new ItemStack(uranium, 4), new Object[] { "X", ('X'),
				uraniumblock });

		craftmng.addRecipe(new ItemStack(aluminumpick, 1), new Object[] {
				"XXX", " O ", " O ", ('O'), Item.stick, ('X'), aluminum });
		craftmng.addRecipe(new ItemStack(bismuthpick, 1), new Object[] { "XXX",
				" O ", " O ", ('O'), Item.stick, ('X'), bismuth });
		craftmng.addRecipe(new ItemStack(boronpick, 1), new Object[] { "XXX",
				" O ", " O ", ('O'), Item.stick, ('X'), boron });
		craftmng.addRecipe(new ItemStack(chromepick, 1), new Object[] { "XXX",
				" O ", " O ", ('O'), Item.stick, ('X'), chrome });
		craftmng.addRecipe(new ItemStack(cobaltpick, 1), new Object[] { "XXX",
				" O ", " O ", ('O'), Item.stick, ('X'), cobalt });
		craftmng.addRecipe(new ItemStack(copperpick, 1), new Object[] { "XXX",
				" O ", " O ", ('O'), Item.stick, ('X'), copper });
		craftmng.addRecipe(new ItemStack(leadpick, 1), new Object[] { "XXX",
				" O ", " O ", ('O'), Item.stick, ('X'), lead });
		craftmng.addRecipe(new ItemStack(nickelpick, 1), new Object[] { "XXX",
				" O ", " O ", ('O'), Item.stick, ('X'), nickel });
		craftmng.addRecipe(new ItemStack(platinumpick, 1), new Object[] {
				"XXX", " O ", " O ", ('O'), Item.stick, ('X'), platinum });
		craftmng.addRecipe(new ItemStack(rubypick, 1), new Object[] { "XXX",
				" O ", " O ", ('O'), Item.stick, ('X'), ruby });
		craftmng.addRecipe(new ItemStack(sapphirepick, 1), new Object[] {
				"XXX", " O ", " O ", ('O'), Item.stick, ('X'), sapphire });
		craftmng.addRecipe(new ItemStack(emeraldpick, 1), new Object[] { "XXX",
				" O ", " O ", ('O'), Item.stick, ('X'), emerald });
		craftmng.addRecipe(new ItemStack(siliconpick, 1), new Object[] { "XXX",
				" O ", " O ", ('O'), Item.stick, ('X'), silicon });
		craftmng.addRecipe(new ItemStack(silverpick, 1), new Object[] { "XXX",
				" O ", " O ", ('O'), Item.stick, ('X'), silver });
		craftmng.addRecipe(new ItemStack(tinpick, 1), new Object[] { "XXX",
				" O ", " O ", ('O'), Item.stick, ('X'), tin });
		craftmng.addRecipe(new ItemStack(titaniumpick, 1), new Object[] {
				"XXX", " O ", " O ", ('O'), Item.stick, ('X'), titanium });
		craftmng.addRecipe(new ItemStack(tungstenpick, 1), new Object[] {
				"XXX", " O ", " O ", ('O'), Item.stick, ('X'), tungsten });
		craftmng.addRecipe(new ItemStack(zincpick, 1), new Object[] { "XXX",
				" O ", " O ", ('O'), Item.stick, ('X'), zinc });
		craftmng.addRecipe(new ItemStack(brasspick, 1), new Object[] { "XXX",
				" O ", " O ", ('O'), Item.stick, ('X'), brass });
		craftmng.addRecipe(new ItemStack(bronzepick, 1), new Object[] { "XXX",
				" O ", " O ", ('O'), Item.stick, ('X'), bronze });
		craftmng.addRecipe(new ItemStack(steelpick, 1), new Object[] { "XXX",
				" O ", " O ", ('O'), Item.stick, ('X'), steel });
		craftmng.addRecipe(new ItemStack(osmiumpick, 1), new Object[] { "XXX",
			" O ", " O ", ('O'), Item.stick, ('X'), osmium });

		craftmng.addRecipe(new ItemStack(aluminumshovel, 1), new Object[] {
				"X", "O", "O", ('O'), Item.stick, ('X'), aluminum });
		craftmng.addRecipe(new ItemStack(bismuthshovel, 1), new Object[] { "X",
				"O", "O", ('O'), Item.stick, ('X'), bismuth });
		craftmng.addRecipe(new ItemStack(boronshovel, 1), new Object[] { "X",
				"O", "O", ('O'), Item.stick, ('X'), boron });
		craftmng.addRecipe(new ItemStack(chromeshovel, 1), new Object[] { "X",
				"O", "O", ('O'), Item.stick, ('X'), chrome });
		craftmng.addRecipe(new ItemStack(cobaltshovel, 1), new Object[] { "X",
				"O", "O", ('O'), Item.stick, ('X'), cobalt });
		craftmng.addRecipe(new ItemStack(coppershovel, 1), new Object[] { "X",
				"O", "O", ('O'), Item.stick, ('X'), copper });
		craftmng.addRecipe(new ItemStack(leadshovel, 1), new Object[] { "X",
				"O", "O", ('O'), Item.stick, ('X'), lead });
		craftmng.addRecipe(new ItemStack(nickelshovel, 1), new Object[] { "X",
				"O", "O", ('O'), Item.stick, ('X'), nickel });
		craftmng.addRecipe(new ItemStack(platinumshovel, 1), new Object[] {
				"X", "O", "O", ('O'), Item.stick, ('X'), platinum });
		craftmng.addRecipe(new ItemStack(rubyshovel, 1), new Object[] { "X",
				"O", "O", ('O'), Item.stick, ('X'), ruby });
		craftmng.addRecipe(new ItemStack(sapphireshovel, 1), new Object[] {
				"X", "O", "O", ('O'), Item.stick, ('X'), sapphire });
		craftmng.addRecipe(new ItemStack(emeraldshovel, 1), new Object[] { "X",
				"O", "O", ('O'), Item.stick, ('X'), emerald });
		craftmng.addRecipe(new ItemStack(siliconshovel, 1), new Object[] { "X",
				"O", "O", ('O'), Item.stick, ('X'), silicon });
		craftmng.addRecipe(new ItemStack(silvershovel, 1), new Object[] { "X",
				"O", "O", ('O'), Item.stick, ('X'), silver });
		craftmng.addRecipe(new ItemStack(tinshovel, 1), new Object[] { "X",
				"O", "O", ('O'), Item.stick, ('X'), tin });
		craftmng.addRecipe(new ItemStack(titaniumshovel, 1), new Object[] {
				"X", "O", "O", ('O'), Item.stick, ('X'), titanium });
		craftmng.addRecipe(new ItemStack(tungstenshovel, 1), new Object[] {
				"X", "O", "O", ('O'), Item.stick, ('X'), tungsten });
		craftmng.addRecipe(new ItemStack(zincshovel, 1), new Object[] { "X",
				"O", "O", ('O'), Item.stick, ('X'), zinc });
		craftmng.addRecipe(new ItemStack(brassshovel, 1), new Object[] { "X",
				"O", "O", ('O'), Item.stick, ('X'), brass });
		craftmng.addRecipe(new ItemStack(bronzeshovel, 1), new Object[] { "X",
				"O", "O", ('O'), Item.stick, ('X'), bronze });
		craftmng.addRecipe(new ItemStack(steelshovel, 1), new Object[] { "X",
				"O", "O", ('O'), Item.stick, ('X'), steel });
		craftmng.addRecipe(new ItemStack(osmiumshovel, 1), new Object[] { "X",
			"O", "O", ('O'), Item.stick, ('X'), osmium });

		craftmng.addRecipe(new ItemStack(aluminumhoe, 1), new Object[] { "XX",
				" O", " O", ('O'), Item.stick, ('X'), aluminum });
		craftmng.addRecipe(new ItemStack(bismuthhoe, 1), new Object[] { "XX",
				" O", " O", ('O'), Item.stick, ('X'), bismuth });
		craftmng.addRecipe(new ItemStack(boronhoe, 1), new Object[] { "XX",
				" O", " O", ('O'), Item.stick, ('X'), boron });
		craftmng.addRecipe(new ItemStack(chromehoe, 1), new Object[] { "XX",
				" O", " O", ('O'), Item.stick, ('X'), chrome });
		craftmng.addRecipe(new ItemStack(cobalthoe, 1), new Object[] { "XX",
				" O", " O", ('O'), Item.stick, ('X'), cobalt });
		craftmng.addRecipe(new ItemStack(copperhoe, 1), new Object[] { "XX",
				" O", " O", ('O'), Item.stick, ('X'), copper });
		craftmng.addRecipe(new ItemStack(leadhoe, 1), new Object[] { "XX",
				" O", " O", ('O'), Item.stick, ('X'), lead });
		craftmng.addRecipe(new ItemStack(nickelhoe, 1), new Object[] { "XX",
				" O", " O", ('O'), Item.stick, ('X'), nickel });
		craftmng.addRecipe(new ItemStack(platinumhoe, 1), new Object[] { "XX",
				" O", " O", ('O'), Item.stick, ('X'), platinum });
		craftmng.addRecipe(new ItemStack(rubyhoe, 1), new Object[] { "XX",
				" O", " O", ('O'), Item.stick, ('X'), ruby });
		craftmng.addRecipe(new ItemStack(sapphirehoe, 1), new Object[] { "XX",
				" O", " O", ('O'), Item.stick, ('X'), sapphire });
		craftmng.addRecipe(new ItemStack(emeraldhoe, 1), new Object[] { "XX",
				" O", " O", ('O'), Item.stick, ('X'), emerald });
		craftmng.addRecipe(new ItemStack(siliconhoe, 1), new Object[] { "XX",
				" O", " O", ('O'), Item.stick, ('X'), silicon });
		craftmng.addRecipe(new ItemStack(silverhoe, 1), new Object[] { "XX",
				" O", " O", ('O'), Item.stick, ('X'), silver });
		craftmng.addRecipe(new ItemStack(tinhoe, 1), new Object[] { "XX", " O",
				" O", ('O'), Item.stick, ('X'), tin });
		craftmng.addRecipe(new ItemStack(titaniumhoe, 1), new Object[] { "XX",
				" O", " O", ('O'), Item.stick, ('X'), titanium });
		craftmng.addRecipe(new ItemStack(tungstenhoe, 1), new Object[] { "XX",
				" O", " O", ('O'), Item.stick, ('X'), tungsten });
		craftmng.addRecipe(new ItemStack(zinchoe, 1), new Object[] { "XX",
				" O", " O", ('O'), Item.stick, ('X'), zinc });
		craftmng.addRecipe(new ItemStack(brasshoe, 1), new Object[] { "XX",
				" O", " O", ('O'), Item.stick, ('X'), brass });
		craftmng.addRecipe(new ItemStack(bronzehoe, 1), new Object[] { "XX",
				" O", " O", ('O'), Item.stick, ('X'), bronze });
		craftmng.addRecipe(new ItemStack(steelhoe, 1), new Object[] { "XX",
				" O", " O", ('O'), Item.stick, ('X'), steel });
		craftmng.addRecipe(new ItemStack(osmiumhoe, 1), new Object[] { "XX",
			" O", " O", ('O'), Item.stick, ('X'), osmium });

		craftmng.addRecipe(new ItemStack(aluminumsword, 1), new Object[] { "X",
				"X", "O", ('O'), Item.stick, ('X'), aluminum });
		craftmng.addRecipe(new ItemStack(bismuthsword, 1), new Object[] { "X",
				"X", "O", ('O'), Item.stick, ('X'), bismuth });
		craftmng.addRecipe(new ItemStack(boronsword, 1), new Object[] { "X",
				"X", "O", ('O'), Item.stick, ('X'), boron });
		craftmng.addRecipe(new ItemStack(chromesword, 1), new Object[] { "X",
				"X", "O", ('O'), Item.stick, ('X'), chrome });
		craftmng.addRecipe(new ItemStack(cobaltsword, 1), new Object[] { "X",
				"X", "O", ('O'), Item.stick, ('X'), cobalt });
		craftmng.addRecipe(new ItemStack(coppersword, 1), new Object[] { "X",
				"X", "O", ('O'), Item.stick, ('X'), copper });
		craftmng.addRecipe(new ItemStack(leadsword, 1), new Object[] { "X",
				"X", "O", ('O'), Item.stick, ('X'), lead });
		craftmng.addRecipe(new ItemStack(nickelsword, 1), new Object[] { "X",
				"X", "O", ('O'), Item.stick, ('X'), nickel });
		craftmng.addRecipe(new ItemStack(platinumsword, 1), new Object[] { "X",
				"X", "O", ('O'), Item.stick, ('X'), platinum });
		craftmng.addRecipe(new ItemStack(rubysword, 1), new Object[] { "X",
				"X", "O", ('O'), Item.stick, ('X'), ruby });
		craftmng.addRecipe(new ItemStack(sapphiresword, 1), new Object[] { "X",
				"X", "O", ('O'), Item.stick, ('X'), sapphire });
		craftmng.addRecipe(new ItemStack(emeraldsword, 1), new Object[] { "X",
				"X", "O", ('O'), Item.stick, ('X'), emerald });
		craftmng.addRecipe(new ItemStack(siliconsword, 1), new Object[] { "X",
				"X", "O", ('O'), Item.stick, ('X'), silicon });
		craftmng.addRecipe(new ItemStack(silversword, 1), new Object[] { "X",
				"X", "O", ('O'), Item.stick, ('X'), silver });
		craftmng.addRecipe(new ItemStack(tinsword, 1), new Object[] { "X", "X",
				"O", ('O'), Item.stick, ('X'), tin });
		craftmng.addRecipe(new ItemStack(titaniumsword, 1), new Object[] { "X",
				"X", "O", ('O'), Item.stick, ('X'), titanium });
		craftmng.addRecipe(new ItemStack(tungstensword, 1), new Object[] { "X",
				"X", "O", ('O'), Item.stick, ('X'), tungsten });
		craftmng.addRecipe(new ItemStack(zincsword, 1), new Object[] { "X",
				"X", "O", ('O'), Item.stick, ('X'), zinc });
		craftmng.addRecipe(new ItemStack(brasssword, 1), new Object[] { "X",
				"X", "O", ('O'), Item.stick, ('X'), brass });
		craftmng.addRecipe(new ItemStack(bronzesword, 1), new Object[] { "X",
				"X", "O", ('O'), Item.stick, ('X'), bronze });
		craftmng.addRecipe(new ItemStack(steelsword, 1), new Object[] { "X",
				"X", "O", ('O'), Item.stick, ('X'), steel });
		craftmng.addRecipe(new ItemStack(osmiumsword, 1), new Object[] { "X",
			"X", "O", ('O'), Item.stick, ('X'), osmium });

		craftmng.addRecipe(new ItemStack(aluminumaxe, 1), new Object[] { "XX",
				"XO", " O", ('O'), Item.stick, ('X'), aluminum });
		craftmng.addRecipe(new ItemStack(bismuthaxe, 1), new Object[] { "XX",
				"XO", " O", ('O'), Item.stick, ('X'), bismuth });
		craftmng.addRecipe(new ItemStack(boronaxe, 1), new Object[] { "XX",
				"XO", " O", ('O'), Item.stick, ('X'), boron });
		craftmng.addRecipe(new ItemStack(chromeaxe, 1), new Object[] { "XX",
				"XO", " O", ('O'), Item.stick, ('X'), chrome });
		craftmng.addRecipe(new ItemStack(cobaltaxe, 1), new Object[] { "XX",
				"XO", " O", ('O'), Item.stick, ('X'), cobalt });
		craftmng.addRecipe(new ItemStack(copperaxe, 1), new Object[] { "XX",
				"XO", " O", ('O'), Item.stick, ('X'), copper });
		craftmng.addRecipe(new ItemStack(leadaxe, 1), new Object[] { "XX",
				"XO", " O", ('O'), Item.stick, ('X'), lead });
		craftmng.addRecipe(new ItemStack(nickelaxe, 1), new Object[] { "XX",
				"XO", " O", ('O'), Item.stick, ('X'), nickel });
		craftmng.addRecipe(new ItemStack(platinumaxe, 1), new Object[] { "XX",
				"XO", " O", ('O'), Item.stick, ('X'), platinum });
		craftmng.addRecipe(new ItemStack(rubyaxe, 1), new Object[] { "XX",
				"XO", " O", ('O'), Item.stick, ('X'), ruby });
		craftmng.addRecipe(new ItemStack(sapphireaxe, 1), new Object[] { "XX",
				"XO", " O", ('O'), Item.stick, ('X'), sapphire });
		craftmng.addRecipe(new ItemStack(emeraldaxe, 1), new Object[] { "XX",
				"XO", " O", ('O'), Item.stick, ('X'), emerald });
		craftmng.addRecipe(new ItemStack(siliconaxe, 1), new Object[] { "XX",
				"XO", " O", ('O'), Item.stick, ('X'), silicon });
		craftmng.addRecipe(new ItemStack(silveraxe, 1), new Object[] { "XX",
				"XO", " O", ('O'), Item.stick, ('X'), silver });
		craftmng.addRecipe(new ItemStack(tinaxe, 1), new Object[] { "XX", "XO",
				" O", ('O'), Item.stick, ('X'), tin });
		craftmng.addRecipe(new ItemStack(titaniumaxe, 1), new Object[] { "XX",
				"XO", " O", ('O'), Item.stick, ('X'), titanium });
		craftmng.addRecipe(new ItemStack(tungstenaxe, 1), new Object[] { "XX",
				"XO", " O", ('O'), Item.stick, ('X'), tungsten });
		craftmng.addRecipe(new ItemStack(zincaxe, 1), new Object[] { "XX",
				"XO", " O", ('O'), Item.stick, ('X'), zinc });
		craftmng.addRecipe(new ItemStack(brassaxe, 1), new Object[] { "XX",
				"XO", " O", ('O'), Item.stick, ('X'), brass });
		craftmng.addRecipe(new ItemStack(bronzeaxe, 1), new Object[] { "XX",
				"XO", " O", ('O'), Item.stick, ('X'), bronze });
		craftmng.addRecipe(new ItemStack(steelaxe, 1), new Object[] { "XX",
				"XO", " O", ('O'), Item.stick, ('X'), steel });
		craftmng.addRecipe(new ItemStack(osmiumaxe, 1), new Object[] { "XX",
			"XO", " O", ('O'), Item.stick, ('X'), osmium });

		craftmng.addRecipe(new ItemStack(aluminumaxe, 1), new Object[] { "XX",
				"OX", "O", ('O'), Item.stick, ('X'), aluminum });
		craftmng.addRecipe(new ItemStack(bismuthaxe, 1), new Object[] { "XX",
				"OX", "O", ('O'), Item.stick, ('X'), bismuth });
		craftmng.addRecipe(new ItemStack(boronaxe, 1), new Object[] { "XX",
				"OX", "O", ('O'), Item.stick, ('X'), boron });
		craftmng.addRecipe(new ItemStack(chromeaxe, 1), new Object[] { "XX",
				"OX", "O", ('O'), Item.stick, ('X'), chrome });
		craftmng.addRecipe(new ItemStack(cobaltaxe, 1), new Object[] { "XX",
				"OX", "O", ('O'), Item.stick, ('X'), cobalt });
		craftmng.addRecipe(new ItemStack(copperaxe, 1), new Object[] { "XX",
				"OX", "O", ('O'), Item.stick, ('X'), copper });
		craftmng.addRecipe(new ItemStack(leadaxe, 1), new Object[] { "XX",
				"OX", "O", ('O'), Item.stick, ('X'), lead });
		craftmng.addRecipe(new ItemStack(nickelaxe, 1), new Object[] { "XX",
				"OX", "O", ('O'), Item.stick, ('X'), nickel });
		craftmng.addRecipe(new ItemStack(platinumaxe, 1), new Object[] { "XX",
				"OX", "O", ('O'), Item.stick, ('X'), platinum });
		craftmng.addRecipe(new ItemStack(rubyaxe, 1), new Object[] { "XX",
				"OX", "O", ('O'), Item.stick, ('X'), ruby });
		craftmng.addRecipe(new ItemStack(sapphireaxe, 1), new Object[] { "XX",
				"OX", "O", ('O'), Item.stick, ('X'), sapphire });
		craftmng.addRecipe(new ItemStack(emeraldaxe, 1), new Object[] { "XX",
				"OX", "O", ('O'), Item.stick, ('X'), emerald });
		craftmng.addRecipe(new ItemStack(siliconaxe, 1), new Object[] { "XX",
				"OX", "O", ('O'), Item.stick, ('X'), silicon });
		craftmng.addRecipe(new ItemStack(silveraxe, 1), new Object[] { "XX",
				"OX", "O", ('O'), Item.stick, ('X'), silver });
		craftmng.addRecipe(new ItemStack(tinaxe, 1), new Object[] { "XX", "OX",
				"O", ('O'), Item.stick, ('X'), tin });
		craftmng.addRecipe(new ItemStack(titaniumaxe, 1), new Object[] { "XX",
				"OX", "O", ('O'), Item.stick, ('X'), titanium });
		craftmng.addRecipe(new ItemStack(tungstenaxe, 1), new Object[] { "XX",
				"OX", "O", ('O'), Item.stick, ('X'), tungsten });
		craftmng.addRecipe(new ItemStack(zincaxe, 1), new Object[] { "XX",
				"OX", "O", ('O'), Item.stick, ('X'), zinc });
		craftmng.addRecipe(new ItemStack(brassaxe, 1), new Object[] { "XX",
				"OX", "O", ('O'), Item.stick, ('X'), brass });
		craftmng.addRecipe(new ItemStack(bronzeaxe, 1), new Object[] { "XX",
				"OX", "O", ('O'), Item.stick, ('X'), bronze });
		craftmng.addRecipe(new ItemStack(steelaxe, 1), new Object[] { "XX",
				"OX", "O", ('O'), Item.stick, ('X'), steel });
		craftmng.addRecipe(new ItemStack(osmiumaxe, 1), new Object[] { "XX",
			"OX", "O", ('O'), Item.stick, ('X'), osmium });
	}
	
	public static final Block BrickOvenIdle = (new BlockBrickOven(230, false)).setHardness(5F)
			.setStepSound(Block.soundStoneFootstep).setBlockName("Brick Oven")
			.disableNeighborNotifyOnMetadataChange();
	public static final Block BrickOvenActive = (new BlockBrickOven(231, true)).setHardness(5F)
			.setStepSound(Block.soundStoneFootstep).setBlockName("Brick Oven").setLightValue(0.875F)
			.disableNeighborNotifyOnMetadataChange();
	public static final Block FakeBedrock = (new BlockOre(99, 17))
			.setHardness(1F).setResistance(10F).setBlockName("Fake Bedrock");
	public static final Block RecordCrop = (new BlockRecordCrops(98, 227))
			.setHardness(2F).setResistance(10F).setBlockName("Record Plant");
	public static final Block pebble = (new BlockPebble(227, 54))
			.setHardness(3F).setResistance(3F).setStepSound(Block.soundGravelFootstep).setBlockName("Pebble");
	public static final Block AlphaGrass = (new BlockGrass(97))
			.setHardness(1.2F).setStepSound(Block.soundGrassFootstep).setBlockName("Grass");
	public static final Block EWStep = (new BlockStepEW(101)).setHardness(1.2F)
			.setResistance(10F).setStepSound(Block.soundStoneFootstep)
			.setBlockName("Stone Slab");
	public static final Block NSStep = (new BlockStepNS(102)).setHardness(1.2F)
			.setResistance(10F).setStepSound(Block.soundStoneFootstep)
			.setBlockName("Stone Slab");
	
	public static final Block stoneBlock = (new StoneBrick(150, 30))
			.setHardness(1F).setResistance(10F).setBlockName("Stone Brick");
	public static final Block stoneBlockoffxy = (new StoneBrick(151, 77))
			.setHardness(1F).setResistance(10F).setBlockName("Stone Brick");
	public static final Block stoneBlockoffy = (new StoneBrick(152, 76))
			.setHardness(1F).setResistance(10F).setBlockName("Stone Brick");
	public static final Block stoneBlockoffx = (new StoneBrick(153, 78))
			.setHardness(1F).setResistance(10F).setBlockName("Stone Brick");
	public static final Block stoneBlockSmall = (new StoneBrick(225, 211))
			.setHardness(1F).setResistance(10F).setBlockName("Stone Brick");
	public static final Block stoneBricks = (new StoneBrick(228, 196))
			.setHardness(1F).setResistance(10F).setBlockName("Stone Brick");
	public static final Block platedStone = (new Block(100, 6, Material.rock))
			.setHardness(1F).setResistance(10F).setBlockName("Plated Stone");

	public static final Block BrickStairs = (new BlockStairs(103, Block.brick)).setBlockName("Brick Stairs").disableNeighborNotifyOnMetadataChange();
	public static final Block SandstoneStairs = (new BlockStairs(104, Block.sandStone)).setBlockName("Sandstone Stairs").disableNeighborNotifyOnMetadataChange();
	public static final Block StoneStairs = (new BlockStairs(105, stoneBricks)).setBlockName("Stone Stairs").disableNeighborNotifyOnMetadataChange();
	
	public static final Block Scaffold = (new BlockScaffold(106, Material.wood)).setHardness(0.2F).setBlockName("Scaffolding");

	public static final Block aluminumore = (new BlockOre(154, 139))
			.setHardness(3F).setResistance(500F).setBlockName("Aluminum Ore");
	public static final Block copperore = (new BlockOre(155, 186))
			.setHardness(3F).setResistance(500F).setBlockName("Copper Ore");
	public static final Block tinore = (new BlockOre(156, 168))
			.setHardness(3F).setResistance(500F).setBlockName("Tin Ore");
	public static final Block zincore = (new BlockOre(157, 153))
			.setHardness(3F).setResistance(500F).setBlockName("Zinc Ore");
	public static final Block nickelore = (new BlockOre(158, 183))
			.setHardness(3.5F).setResistance(500F).setBlockName("Nickel Ore");
	public static final Block bismuthore = (new BlockOre(159, 138))
			.setHardness(3F).setResistance(500F).setBlockName("Bismuth Ore");
	public static final Block cobaltore = (new BlockOre(149, 202))
			.setHardness(4F).setResistance(500F).setBlockName("Cobalt Ore");
	public static final Block tungstenore = (new BlockOre(161, 155))
			.setHardness(6F).setResistance(500F).setBlockName("Tungsten Ore");
	public static final Block magnetiteore = (new BlockOre(162, 184))
			.setHardness(4F).setResistance(500F).setBlockName("Magnetite Ore");
	public static final Block silverore = (new BlockOre(163, 167))
			.setHardness(3.5F).setResistance(500F).setBlockName("Silver Ore");
	public static final Block leadore = (new BlockOre(164, 185))
			.setHardness(3F).setResistance(500F).setBlockName("Lead Ore");
	public static final Block siliconore = (new BlockOre(165, 169))
			.setHardness(4F).setResistance(500F).setBlockName("Silicon Ore");
	public static final Block chromeore = (new BlockOre(166, 203))
			.setHardness(4F).setResistance(500F).setBlockName("Chrome Ore");
	public static final Block anthraciteore = (new BlockOre(167, 137))
			.setHardness(4F).setResistance(500F).setBlockName("Anthracite Ore");
	public static final Block titaniumore = (new BlockOre(168, 166))
			.setHardness(6F).setResistance(500F).setBlockName("Titanium Ore");
	public static final Block uranite = (new BlockOre(169, 154))
			.setHardness(8F).setResistance(500F).setBlockName("Uranite");
	public static final Block rubyore = (new BlockOre(170, 171))
			.setHardness(8F).setResistance(500F).setBlockName("Ruby Ore");
	public static final Block sapphireore = (new BlockOre(172, 170))
			.setHardness(8F).setResistance(500F).setBlockName("Sapphire Ore");
	public static final Block emeraldore = (new BlockOre(173, 187))
			.setHardness(8F).setResistance(500F).setBlockName("Emerald Ore");
	public static final Block boronore = (new BlockOre(174, 136))
			.setHardness(3.5F).setResistance(500F).setBlockName("Boron Ore");
	public static final Block platinumore = (new BlockOre(175, 182))
			.setHardness(3.5F).setResistance(500F).setBlockName("Platinum Ore");
	public static final Block osmiumore = (new BlockOre(160, 200))
			.setHardness(10F).setResistance(500F).setBlockName("Osmium Ore");

	public static final Block aluminumblock = (new BlockOreStorage(176, 142))
			.setHardness(2F).setResistance(10F)
			.setStepSound(Block.soundMetalFootstep)
			.setBlockName("Aluminum Block");
	public static final Block copperblock = (new BlockOreStorage(177, 220))
			.setHardness(2F).setResistance(10F)
			.setStepSound(Block.soundMetalFootstep)
			.setBlockName("Copper Block");
	public static final Block tinblock = (new BlockOreStorage(178, 156))
			.setHardness(2F).setResistance(10F)
			.setStepSound(Block.soundMetalFootstep).setBlockName("Tin Block");
	public static final Block zincblock = (new BlockOreStorage(179, 157))
			.setHardness(2F).setResistance(10F)
			.setStepSound(Block.soundMetalFootstep).setBlockName("Zinc Block");
	public static final Block nickelblock = (new BlockOreStorage(180, 190))
			.setHardness(2.5F).setResistance(20F)
			.setStepSound(Block.soundMetalFootstep)
			.setBlockName("Nickel Block");
	public static final Block bismuthblock = (new BlockOreStorage(181, 111))
			.setHardness(2F).setResistance(10F)
			.setStepSound(Block.soundMetalFootstep)
			.setBlockName("Bismuth Block");
	public static final Block cobaltblock = (new BlockOreStorage(183, 221))
			.setHardness(3F).setResistance(40F)
			.setStepSound(Block.soundMetalFootstep)
			.setBlockName("Cobalt Block");
	public static final Block tungstenblock = (new BlockOreStorage(184, 127))
			.setHardness(3.5F).setResistance(80F)
			.setStepSound(Block.soundMetalFootstep)
			.setBlockName("Tungsten Block");
	public static final Block magnetiteblock = (new BlockOreStorage(185, 189))
			.setHardness(3F).setResistance(40F)
			.setStepSound(Block.soundMetalFootstep)
			.setBlockName("Magnetic Block");
	public static final Block silverblock = (new BlockOreStorage(186, 175))
			.setHardness(2.5F).setResistance(20F)
			.setStepSound(Block.soundMetalFootstep)
			.setBlockName("Silver Block");
	public static final Block leadblock = (new BlockOreStorage(187, 188))
			.setHardness(2F).setResistance(10F)
			.setStepSound(Block.soundMetalFootstep).setBlockName("Lead Block");
	public static final Block siliconblock = (new BlockOreStorage(188, 174))
			.setHardness(3F).setResistance(40F)
			.setStepSound(Block.soundMetalFootstep)
			.setBlockName("Silicon Block");
	public static final Block chromeblock = (new BlockOreStorage(189, 219))
			.setHardness(3F).setResistance(40F)
			.setStepSound(Block.soundMetalFootstep)
			.setBlockName("Chrome Block");
	public static final Block titaniumblock = (new BlockOreStorage(190, 143))
			.setHardness(3.5F).setResistance(80F)
			.setStepSound(Block.soundMetalFootstep)
			.setBlockName("Titanium Block");
	public static final Block uraniumblock = (new BlockOreStorage(191, 158))
			.setHardness(3.5F).setResistance(160F)
			.setStepSound(Block.soundMetalFootstep).setBlockName("Uranite");
	public static final Block rubyblock = (new BlockOreStorage(192, 191))
			.setHardness(4F).setResistance(160F)
			.setStepSound(Block.soundMetalFootstep).setBlockName("Ruby Block");
	public static final Block sapphireblock = (new BlockOreStorage(193, 173))
			.setHardness(4F).setResistance(160F)
			.setStepSound(Block.soundMetalFootstep)
			.setBlockName("Sapphire Block");
	public static final Block emeraldblock = (new BlockOreStorage(194, 204))
			.setHardness(4F).setResistance(160F)
			.setStepSound(Block.soundMetalFootstep)
			.setBlockName("Emerald Block");
	public static final Block boronblock = (new BlockOreStorage(195, 141))
			.setHardness(2.5F).setResistance(20F)
			.setStepSound(Block.soundMetalFootstep).setBlockName("Boron Block");
	public static final Block platinumblock = (new BlockOreStorage(196, 172))
			.setHardness(2.5F).setResistance(20F)
			.setStepSound(Block.soundMetalFootstep)
			.setBlockName("Platinum Block");
	public static final Block brassblock = (new BlockOreStorage(223, 126))
			.setHardness(2.5F).setResistance(20F)
			.setStepSound(Block.soundMetalFootstep).setBlockName("Brass Block");
	public static final Block bronzeblock = (new BlockOreStorage(224, 125))
			.setHardness(2.5F).setResistance(20F)
			.setStepSound(Block.soundMetalFootstep)
			.setBlockName("Bronze Block");
	public static final Block steelblock = (new BlockOreStorage(199, 159))
			.setHardness(3.5F).setResistance(80F)
			.setStepSound(Block.soundMetalFootstep).setBlockName("Steel Block");

	public static final Item aluminum = (new Item(200)).setIconCoord(8, 11)
			.setItemName("Aluminum Ingot");
	public static final Item anthracite = (new Item(201)).setIconCoord(15, 13)
			.setItemName("Anthracite");
	public static final Item copper = (new Item(202)).setIconCoord(7, 11)
			.setItemName("Copper Ingot");
	public static final Item tin = (new Item(203)).setIconCoord(6, 6)
			.setItemName("Tin Ingot");
	public static final Item bismuth = (new Item(204)).setIconCoord(15, 12)
			.setItemName("Bismuth Ingot");
	public static final Item zinc = (new Item(205)).setIconCoord(15, 15)
			.setItemName("Zinc Ingot");
	public static final Item nickel = (new Item(206)).setIconCoord(5, 10)
			.setItemName("Nickel Ingot");
	public static final Item cobalt = (new Item(207)).setIconCoord(7, 7)
			.setItemName("Cobalt Ingot");
	public static final Item tungsten = (new Item(208)).setIconCoord(3, 12)
			.setItemName("Tungsten Ingot");
	public static final Item magnet = (new Item(209)).setIconCoord(5, 11)
			.setItemName("Magnet");
	public static final Item silver = (new Item(210)).setIconCoord(6, 7)
			.setItemName("Silver Ingot");
	public static final Item lead = (new Item(211)).setIconCoord(6, 11)
			.setItemName("Lead Ingot");
	public static final Item silicon = (new Item(212)).setIconCoord(5, 8)
			.setItemName("Silicon Ingot");
	public static final Item chrome = (new Item(213)).setIconCoord(8, 7)
			.setItemName("Chrome Ingot");
	public static final Item titanium = (new Item(198)).setIconCoord(5, 6)
			.setItemName("Titanium Ingot");
	public static final Item uranium = (new Item(215)).setIconCoord(14, 3)
			.setItemName("Uranium Ingot");
	public static final Item ruby = (new Item(216)).setIconCoord(6, 9)
			.setItemName("Ruby");
	public static final Item sapphire = (new Item(217)).setIconCoord(6, 8)
			.setItemName("Sapphire");
	public static final Item emerald = (new Item(218)).setIconCoord(6, 10)
			.setItemName("Emerald");
	public static final Item platinum = (new Item(219)).setIconCoord(5, 9)
			.setItemName("Platinum Ingot");
	public static final Item boron = (new Item(220)).setIconCoord(8, 10)
			.setItemName("Boron Ingot");
	public static final Item brass = (new Item(221)).setIconCoord(8, 9)
			.setItemName("Brass Ingot");
	public static final Item bronze = (new Item(222)).setIconCoord(15, 14)
			.setItemName("Bronze Ingot");
	public static final Item steel = (new Item(199)).setIconCoord(5, 7)
			.setItemName("Steel Ingot");
	public static final Item osmium = (new Item(434)).setIconCoord(5, 6)
			.setItemName("Osmium Ingot");

	public static final Item aluminumpick = (new ItemPickaxe(223,
			EnumToolMaterial.ALUMINUM)).setIconCoord(1, 15).setItemName(
			"Aluminum Pickaxe");
	public static final Item copperpick = (new ItemPickaxe(225,
			EnumToolMaterial.COPPER)).setIconCoord(11, 12).setItemName(
			"Copper Pickaxe");
	public static final Item tinpick = (new ItemPickaxe(226,
			EnumToolMaterial.TIN)).setIconCoord(1, 11).setItemName(
			"Tin Pickaxe");
	public static final Item bismuthpick = (new ItemPickaxe(227,
			EnumToolMaterial.BISMUTH)).setIconCoord(6, 15).setItemName(
			"Bismuth Pickaxe");
	public static final Item zincpick = (new ItemPickaxe(228,
			EnumToolMaterial.ZINC)).setIconCoord(11, 15).setItemName(
			"Zinc Pickaxe");
	public static final Item nickelpick = (new ItemPickaxe(229,
			EnumToolMaterial.NICKEL)).setIconCoord(10, 10).setItemName(
			"Nickel Pickaxe");
	public static final Item cobaltpick = (new ItemPickaxe(230,
			EnumToolMaterial.COBALT)).setIconCoord(6, 12).setItemName(
			"Cobalt Pickaxe");
	public static final Item tungstenpick = (new ItemPickaxe(231,
			EnumToolMaterial.TUNGSTEN)).setIconCoord(1, 9).setItemName(
			"Tungsten Pickaxe");
	public static final Item silverpick = (new ItemPickaxe(233,
			EnumToolMaterial.SILVER)).setIconCoord(1, 13).setItemName(
			"Silver Pickaxe");
	public static final Item leadpick = (new ItemPickaxe(234,
			EnumToolMaterial.LEAD)).setIconCoord(10, 11).setItemName(
			"Lead Pickaxe");
	public static final Item siliconpick = (new ItemPickaxe(235,
			EnumToolMaterial.SILICON)).setIconCoord(1, 14).setItemName(
			"Silicon Pickaxe");
	public static final Item chromepick = (new ItemPickaxe(236,
			EnumToolMaterial.CHROME)).setIconCoord(6, 13).setItemName(
			"Chrome Pickaxe");
	public static final Item titaniumpick = (new ItemPickaxe(237,
			EnumToolMaterial.TITANIUM)).setIconCoord(1, 10).setItemName(
			"Titanium Pickaxe");
	public static final Item rubypick = (new ItemPickaxe(239,
			EnumToolMaterial.GEM)).setIconCoord(10, 7).setItemName(
			"Ruby Pickaxe");
	public static final Item sapphirepick = (new ItemPickaxe(240,
			EnumToolMaterial.GEM)).setIconCoord(10, 6).setItemName(
			"Sapphire Pickaxe");
	public static final Item emeraldpick = (new ItemPickaxe(241,
			EnumToolMaterial.GEM)).setIconCoord(10, 8).setItemName(
			"Emerald Pickaxe");
	public static final Item platinumpick = (new ItemPickaxe(242,
			EnumToolMaterial.PLATINUM)).setIconCoord(10, 9).setItemName(
			"Platinum Pickaxe");
	public static final Item boronpick = (new ItemPickaxe(243,
			EnumToolMaterial.BORON)).setIconCoord(6, 14).setItemName(
			"Boron Pickaxe");
	public static final Item brasspick = (new ItemPickaxe(244,
			EnumToolMaterial.BRASS)).setIconCoord(11, 14).setItemName(
			"Brass Pickaxe");
	public static final Item bronzepick = (new ItemPickaxe(245,
			EnumToolMaterial.BRONZE)).setIconCoord(11, 13).setItemName(
			"Bronze Pickaxe");
	public static final Item steelpick = (new ItemPickaxe(238,
			EnumToolMaterial.STEEL)).setIconCoord(1, 12).setItemName(
			"Steel Pickaxe");
	public static final Item osmiumpick = (new ItemPickaxe(435,
			EnumToolMaterial.OSMIUM)).setIconCoord(8, 6).setItemName(
			"Osmium Pickaxe");

	public static final Item aluminumshovel = (new ItemSpade(246,
			EnumToolMaterial.ALUMINUM)).setIconCoord(0, 15).setItemName(
			"Aluminum Shovel");
	public static final Item coppershovel = (new ItemSpade(247,
			EnumToolMaterial.COPPER)).setIconCoord(10, 12).setItemName(
			"Copper Shovel");
	public static final Item tinshovel = (new ItemSpade(248,
			EnumToolMaterial.TIN)).setIconCoord(0, 11)
			.setItemName("Tin Shovel");
	public static final Item bismuthshovel = (new ItemSpade(249,
			EnumToolMaterial.BISMUTH)).setIconCoord(5, 15).setItemName(
			"Bismuth Shovel");
	public static final Item zincshovel = (new ItemSpade(250,
			EnumToolMaterial.ZINC)).setIconCoord(10, 15).setItemName(
			"Zinc Shovel");
	public static final Item nickelshovel = (new ItemSpade(251,
			EnumToolMaterial.NICKEL)).setIconCoord(9, 10).setItemName(
			"Nickel Shovel");
	public static final Item cobaltshovel = (new ItemSpade(252,
			EnumToolMaterial.COBALT)).setIconCoord(5, 12).setItemName(
			"Cobalt Shovel");
	public static final Item tungstenshovel = (new ItemSpade(253,
			EnumToolMaterial.TUNGSTEN)).setIconCoord(0, 9).setItemName(
			"Tungsten Shovel");
	public static final Item silvershovel = (new ItemSpade(254,
			EnumToolMaterial.SILVER)).setIconCoord(0, 13).setItemName(
			"Silver Shovel");
	public static final Item leadshovel = (new ItemSpade(255,
			EnumToolMaterial.LEAD)).setIconCoord(9, 11).setItemName(
			"Lead Shovel");
	public static final Item siliconshovel = (new ItemSpade(256,
			EnumToolMaterial.SILICON)).setIconCoord(0, 14).setItemName(
			"Silicon Shovel");
	public static final Item chromeshovel = (new ItemSpade(257,
			EnumToolMaterial.CHROME)).setIconCoord(5, 13).setItemName(
			"Chrome Shovel");
	public static final Item titaniumshovel = (new ItemSpade(258,
			EnumToolMaterial.TITANIUM)).setIconCoord(0, 10).setItemName(
			"Titanium Shovel");
	public static final Item rubyshovel = (new ItemSpade(259,
			EnumToolMaterial.GEM)).setIconCoord(9, 7).setItemName(
			"Ruby Shovel");
	public static final Item sapphireshovel = (new ItemSpade(260,
			EnumToolMaterial.GEM)).setIconCoord(9, 6).setItemName(
			"Sapphire Shovel");
	public static final Item emeraldshovel = (new ItemSpade(261,
			EnumToolMaterial.GEM)).setIconCoord(9, 8).setItemName(
			"Emerald Shovel");
	public static final Item platinumshovel = (new ItemSpade(262,
			EnumToolMaterial.PLATINUM)).setIconCoord(9, 9).setItemName(
			"Platinum Shovel");
	public static final Item boronshovel = (new ItemSpade(263,
			EnumToolMaterial.BORON)).setIconCoord(5, 14).setItemName(
			"Boron Shovel");
	public static final Item brassshovel = (new ItemSpade(264,
			EnumToolMaterial.BRASS)).setIconCoord(10, 14).setItemName(
			"Brass Shovel");
	public static final Item bronzeshovel = (new ItemSpade(265,
			EnumToolMaterial.BRONZE)).setIconCoord(10, 13).setItemName(
			"Bronze Shovel");
	public static final Item steelshovel = (new ItemSpade(326,
			EnumToolMaterial.STEEL)).setIconCoord(0, 12).setItemName(
			"Steel Shovel");
	public static final Item osmiumshovel = (new ItemSpade(438,
			EnumToolMaterial.OSMIUM)).setIconCoord(7, 6).setItemName(
			"Osmium Shovel");

	public static final Item aluminumsword = (new ItemSword(266,
			EnumToolMaterial.ALUMINUM)).setIconCoord(3, 15).setItemName(
			"Aluminum Sword");
	public static final Item coppersword = (new ItemSword(267,
			EnumToolMaterial.COPPER)).setIconCoord(13, 12).setItemName(
			"Copper Sword");
	public static final Item tinsword = (new ItemSword(268,
			EnumToolMaterial.TIN)).setIconCoord(3, 11).setItemName("Tin Sword");
	public static final Item bismuthsword = (new ItemSword(269,
			EnumToolMaterial.BISMUTH)).setIconCoord(8, 15).setItemName(
			"Bismuth Sword");
	public static final Item zincsword = (new ItemSword(270,
			EnumToolMaterial.ZINC)).setIconCoord(13, 15).setItemName(
			"Zinc Sword");
	public static final Item nickelsword = (new ItemSword(271,
			EnumToolMaterial.NICKEL)).setIconCoord(12, 10).setItemName(
			"Nickel Sword");
	public static final Item cobaltsword = (new ItemSword(272,
			EnumToolMaterial.COBALT)).setIconCoord(8, 12).setItemName(
			"Cobalt Sword");
	public static final Item tungstensword = (new ItemSword(273,
			EnumToolMaterial.TUNGSTEN)).setIconCoord(3, 9).setItemName(
			"Tungsten Sword");
	public static final Item silversword = (new ItemSword(274,
			EnumToolMaterial.SILVER)).setIconCoord(3, 13).setItemName(
			"Silver Sword");
	public static final Item leadsword = (new ItemSword(275,
			EnumToolMaterial.LEAD)).setIconCoord(12, 11).setItemName(
			"Lead Sword");
	public static final Item siliconsword = (new ItemSword(276,
			EnumToolMaterial.SILICON)).setIconCoord(3, 14).setItemName(
			"Silicon Sword");
	public static final Item chromesword = (new ItemSword(277,
			EnumToolMaterial.CHROME)).setIconCoord(8, 13).setItemName(
			"Chrome Sword");
	public static final Item titaniumsword = (new ItemSword(278,
			EnumToolMaterial.TITANIUM)).setIconCoord(3, 10).setItemName(
			"Titanium Sword");
	public static final Item rubysword = (new ItemSword(279,
			EnumToolMaterial.GEM)).setIconCoord(12, 7).setItemName(
			"Ruby Sword");
	public static final Item sapphiresword = (new ItemSword(280,
			EnumToolMaterial.GEM)).setIconCoord(12, 6).setItemName(
			"Sapphire Sword");
	public static final Item emeraldsword = (new ItemSword(281,
			EnumToolMaterial.GEM)).setIconCoord(12, 8).setItemName(
			"Emerald Sword");
	public static final Item platinumsword = (new ItemSword(282,
			EnumToolMaterial.PLATINUM)).setIconCoord(12, 9).setItemName(
			"Platinum Sword");
	public static final Item boronsword = (new ItemSword(283,
			EnumToolMaterial.BORON)).setIconCoord(8, 14).setItemName(
			"Boron Sword");
	public static final Item brasssword = (new ItemSword(284,
			EnumToolMaterial.BRASS)).setIconCoord(13, 14).setItemName(
			"Brass Sword");
	public static final Item bronzesword = (new ItemSword(285,
			EnumToolMaterial.BRONZE)).setIconCoord(13, 13).setItemName(
			"Bronze Sword");
	public static final Item steelsword = (new ItemSword(421,
			EnumToolMaterial.STEEL)).setIconCoord(4, 6).setItemName(
			"Steel Sword");
	public static final Item osmiumsword = (new ItemSword(439,
			EnumToolMaterial.OSMIUM)).setIconCoord(10, 6).setItemName(
			"Osmium Sword");

	public static final Item aluminumhoe = (new ItemHoe(286,
			EnumToolMaterial.ALUMINUM)).setIconCoord(4, 15).setItemName(
			"Aluminum Hoe");
	public static final Item copperhoe = (new ItemHoe(287,
			EnumToolMaterial.COPPER)).setIconCoord(14, 12).setItemName(
			"Copper Hoe");
	public static final Item tinhoe = (new ItemHoe(288, EnumToolMaterial.TIN))
			.setIconCoord(4, 11).setItemName("Tin Hoe");
	public static final Item bismuthhoe = (new ItemHoe(289,
			EnumToolMaterial.BISMUTH)).setIconCoord(9, 15).setItemName(
			"Bismuth Hoe");
	public static final Item zinchoe = (new ItemHoe(290, EnumToolMaterial.ZINC))
			.setIconCoord(14, 15).setItemName("Zinc Hoe");
	public static final Item nickelhoe = (new ItemHoe(291,
			EnumToolMaterial.NICKEL)).setIconCoord(13, 10).setItemName(
			"Nickel Hoe");
	public static final Item cobalthoe = (new ItemHoe(292,
			EnumToolMaterial.COBALT)).setIconCoord(9, 12).setItemName(
			"Cobalt Hoe");
	public static final Item tungstenhoe = (new ItemHoe(293,
			EnumToolMaterial.TUNGSTEN)).setIconCoord(4, 9).setItemName(
			"Tungsten Hoe");
	public static final Item silverhoe = (new ItemHoe(294,
			EnumToolMaterial.SILVER)).setIconCoord(4, 13).setItemName(
			"Silver Hoe");
	public static final Item leadhoe = (new ItemHoe(295, EnumToolMaterial.LEAD))
			.setIconCoord(13, 11).setItemName("Lead Hoe");
	public static final Item siliconhoe = (new ItemHoe(296,
			EnumToolMaterial.SILICON)).setIconCoord(4, 14).setItemName(
			"Silicon Hoe");
	public static final Item chromehoe = (new ItemHoe(297,
			EnumToolMaterial.CHROME)).setIconCoord(9, 13).setItemName(
			"Chrome Hoe");
	public static final Item titaniumhoe = (new ItemHoe(298,
			EnumToolMaterial.TITANIUM)).setIconCoord(4, 10).setItemName(
			"Titanium Hoe");
	public static final Item rubyhoe = (new ItemHoe(299, EnumToolMaterial.GEM))
			.setIconCoord(13, 7).setItemName("Ruby Hoe");
	public static final Item sapphirehoe = (new ItemHoe(300,
			EnumToolMaterial.GEM)).setIconCoord(13, 6).setItemName(
			"Sapphire Hoe");
	public static final Item emeraldhoe = (new ItemHoe(301,
			EnumToolMaterial.GEM)).setIconCoord(13, 8).setItemName(
			"Emerald Hoe");
	public static final Item platinumhoe = (new ItemHoe(302,
			EnumToolMaterial.PLATINUM)).setIconCoord(13, 9).setItemName(
			"Platinum Hoe");
	public static final Item boronhoe = (new ItemHoe(303,
			EnumToolMaterial.BORON)).setIconCoord(9, 14).setItemName(
			"Boron Hoe");
	public static final Item brasshoe = (new ItemHoe(304,
			EnumToolMaterial.BRASS)).setIconCoord(14, 14).setItemName(
			"Brass Hoe");
	public static final Item bronzehoe = (new ItemHoe(305,
			EnumToolMaterial.BRONZE)).setIconCoord(14, 13).setItemName(
			"Bronze Hoe");
	public static final Item steelhoe = (new ItemHoe(327,
			EnumToolMaterial.STEEL)).setIconCoord(4, 12).setItemName(
			"Steel Hoe");
	public static final Item osmiumhoe = (new ItemHoe(437,
			EnumToolMaterial.OSMIUM)).setIconCoord(11, 6).setItemName(
			"Osmium Hoe");


	public static final Item aluminumaxe = (new ItemAxe(306,
			EnumToolMaterial.ALUMINUM)).setIconCoord(2, 15).setItemName(
			"Aluminum Axe");
	public static final Item copperaxe = (new ItemAxe(307,
			EnumToolMaterial.COPPER)).setIconCoord(12, 12).setItemName(
			"Copper Axe");
	public static final Item tinaxe = (new ItemAxe(308, EnumToolMaterial.TIN))
			.setIconCoord(2, 11).setItemName("Tin Axe");
	public static final Item bismuthaxe = (new ItemAxe(309,
			EnumToolMaterial.BISMUTH)).setIconCoord(7, 15).setItemName(
			"Bismuth Axe");
	public static final Item zincaxe = (new ItemAxe(310, EnumToolMaterial.ZINC))
			.setIconCoord(12, 15).setItemName("Zinc Axe");
	public static final Item nickelaxe = (new ItemAxe(311,
			EnumToolMaterial.NICKEL)).setIconCoord(11, 10).setItemName(
			"Nickel Axe");
	public static final Item cobaltaxe = (new ItemAxe(312,
			EnumToolMaterial.COBALT)).setIconCoord(7, 12).setItemName(
			"Cobalt Axe");
	public static final Item tungstenaxe = (new ItemAxe(313,
			EnumToolMaterial.TUNGSTEN)).setIconCoord(2, 9).setItemName(
			"Tungsten Axe");
	public static final Item silveraxe = (new ItemAxe(314,
			EnumToolMaterial.SILVER)).setIconCoord(2, 13).setItemName(
			"Silver Axe");
	public static final Item leadaxe = (new ItemAxe(315, EnumToolMaterial.LEAD))
			.setIconCoord(11, 11).setItemName("Lead Axe");
	public static final Item siliconaxe = (new ItemAxe(316,
			EnumToolMaterial.SILICON)).setIconCoord(2, 14).setItemName(
			"Silicon Axe");
	public static final Item chromeaxe = (new ItemAxe(317,
			EnumToolMaterial.CHROME)).setIconCoord(7, 13).setItemName(
			"Chrome Axe");
	public static final Item titaniumaxe = (new ItemAxe(318,
			EnumToolMaterial.TITANIUM)).setIconCoord(2, 10).setItemName(
			"Titanium Axe");
	public static final Item rubyaxe = (new ItemAxe(319, EnumToolMaterial.GEM))
			.setIconCoord(11, 7).setItemName("Ruby Axe");
	public static final Item sapphireaxe = (new ItemAxe(320,
			EnumToolMaterial.GEM)).setIconCoord(11, 6).setItemName(
			"Sapphire Axe");
	public static final Item emeraldaxe = (new ItemAxe(321,
			EnumToolMaterial.GEM)).setIconCoord(11, 8).setItemName(
			"Emerald Axe");
	public static final Item platinumaxe = (new ItemAxe(322,
			EnumToolMaterial.PLATINUM)).setIconCoord(11, 9).setItemName(
			"Platinum Axe");
	public static final Item boronaxe = (new ItemAxe(323,
			EnumToolMaterial.BORON)).setIconCoord(7, 14).setItemName(
			"Boron Axe");
	public static final Item brassaxe = (new ItemAxe(324,
			EnumToolMaterial.BRASS)).setIconCoord(12, 14).setItemName(
			"Brass Axe");
	public static final Item bronzeaxe = (new ItemAxe(325,
			EnumToolMaterial.BRONZE)).setIconCoord(12, 13).setItemName(
			"Bronze Axe");
	public static final Item steelaxe = (new ItemAxe(328,
			EnumToolMaterial.STEEL)).setIconCoord(2, 12).setItemName(
			"Steel Axe");
	public static final Item osmiumaxe = (new ItemAxe(440,
			EnumToolMaterial.OSMIUM)).setIconCoord(9, 6).setItemName(
			"Osmium Axe");

	public static final Item aluminumhelmet = (new ItemArmor(329, 1, 5, 0))
			.setIconCoord(0, 0).setItemName("Aluminum Helmet");
	public static final Item copperhelmet = (new ItemArmor(330, 1, 12, 0))
			.setIconCoord(7, 0).setItemName("Copper Helmet");
	public static final Item tinhelmet = (new ItemArmor(331, 1, 18, 0))
			.setIconCoord(15, 0).setItemName("Tin Helmet");
	public static final Item bismuthhelmet = (new ItemArmor(332, 1, 6, 0))
			.setIconCoord(1, 0).setItemName("Bismuth Helmet");
	public static final Item zinchelmet = (new ItemArmor(333, 1, 21, 0))
			.setIconCoord(2, 4).setItemName("Zinc Helmet");
	public static final Item nickelhelmet = (new ItemArmor(334, 2, 13, 0))
			.setIconCoord(9, 0).setItemName("Nickel Helmet");
	public static final Item cobalthelmet = (new ItemArmor(335, 3, 11, 0))
			.setIconCoord(6, 0).setItemName("Cobalt Helmet");
	public static final Item tungstenhelmet = (new ItemArmor(336, 4, 20, 0))
			.setIconCoord(1, 4).setItemName("Tungsten Helmet");
	public static final Item silverhelmet = (new ItemArmor(337, 2, 16, 0))
			.setIconCoord(13, 0).setItemName("Silver Helmet");
	public static final Item siliconhelmet = (new ItemArmor(338, 3, 15, 0))
			.setIconCoord(3, 4).setItemName("Silicon Helmet");
	public static final Item chromehelmet = (new ItemArmor(339, 3, 10, 0))
			.setIconCoord(5, 0).setItemName("Chrome Helmet");
	public static final Item titaniumhelmet = (new ItemArmor(340, 4, 19, 0))
			.setIconCoord(0, 4).setItemName("Titanium Helmet");
	public static final Item rubyhelmet = (new ItemArmor(341, 4, 23, 0))
			.setIconCoord(11, 0).setItemName("Ruby Helmet");
	public static final Item sapphirehelmet = (new ItemArmor(342, 4, 24, 0))
			.setIconCoord(12, 0).setItemName("Sapphire Helmet");
	public static final Item emeraldhelmet = (new ItemArmor(343, 4, 25, 0))
			.setIconCoord(8, 0).setItemName("Emerald Helmet");
	public static final Item platinumhelmet = (new ItemArmor(344, 2, 14, 0))
			.setIconCoord(10, 0).setItemName("Platinum Helmet");
	public static final Item boronhelmet = (new ItemArmor(345, 2, 7, 0))
			.setIconCoord(2, 0).setItemName("Boron Helmet");
	public static final Item brasshelmet = (new ItemArmor(346, 2, 8, 0))
			.setIconCoord(3, 0).setItemName("Brass Helmet");
	public static final Item bronzehelmet = (new ItemArmor(347, 2, 9, 0))
			.setIconCoord(4, 0).setItemName("Bronze Helmet");
	public static final Item steelhelmet = (new ItemArmor(348, 4, 17, 0))
			.setIconCoord(14, 0).setItemName("Steel Helmet");
	public static final Item osmiumhelmet = (new ItemArmor(441, 5, 22, 0))
			.setIconCoord(15, 4).setItemName("Osmium Helmet");

	public static final Item aluminumchestplate = (new ItemArmor(349, 1, 5, 1))
			.setIconCoord(0, 1).setIconCoord(0, 1)
			.setItemName("Aluminum Chestplate");
	public static final Item copperchestplate = (new ItemArmor(350, 1, 12, 1))
			.setIconCoord(7, 1).setItemName("Copper Chestplate");
	public static final Item tinchestplate = (new ItemArmor(351, 1, 18, 1))
			.setIconCoord(15, 1).setItemName("Tin Chestplate");
	public static final Item bismuthchestplate = (new ItemArmor(352, 1, 6, 1))
			.setIconCoord(1, 1).setItemName("Bismuth Chestplate");
	public static final Item zincchestplate = (new ItemArmor(353, 1, 21, 1))
			.setIconCoord(2, 5).setItemName("Zinc Chestplate");
	public static final Item nickelchestplate = (new ItemArmor(354, 2, 13, 1))
			.setIconCoord(9, 1).setItemName("Nickel Chestplate");
	public static final Item cobaltchestplate = (new ItemArmor(355, 3, 11, 1))
			.setIconCoord(6, 1).setItemName("Cobalt Chestplate");
	public static final Item tungstenchestplate = (new ItemArmor(356, 4, 20, 1))
			.setIconCoord(1, 5).setItemName("Tungsten Chestplate");
	public static final Item silverchestplate = (new ItemArmor(357, 2, 16, 1))
			.setIconCoord(13, 1).setItemName("Silver Chestplate");
	public static final Item siliconchestplate = (new ItemArmor(358, 3, 15, 1))
			.setIconCoord(3, 5).setItemName("Silicon Chestplate");
	public static final Item chromechestplate = (new ItemArmor(359, 3, 10, 1))
			.setIconCoord(5, 1).setItemName("Chrome Chestplate");
	public static final Item titaniumchestplate = (new ItemArmor(360, 4, 19, 1))
			.setIconCoord(0, 5).setItemName("Titanium Chestplate");
	public static final Item rubychestplate = (new ItemArmor(361, 4, 23, 1))
			.setIconCoord(11, 1).setItemName("Ruby Chestplate");
	public static final Item sapphirechestplate = (new ItemArmor(362, 4, 24, 1))
			.setIconCoord(12, 1).setItemName("Sapphire Chestplate");
	public static final Item emeraldchestplate = (new ItemArmor(363, 4, 25, 1))
			.setIconCoord(8, 1).setItemName("Emerald Chestplate");
	public static final Item platinumchestplate = (new ItemArmor(364, 2, 14, 1))
			.setIconCoord(10, 1).setItemName("Platinum Chestplate");
	public static final Item boronchestplate = (new ItemArmor(365, 2, 7, 1))
			.setIconCoord(2, 1).setItemName("Boron Chestplate");
	public static final Item brasschestplate = (new ItemArmor(366, 2, 8, 1))
			.setIconCoord(3, 1).setItemName("Brass Chestplate");
	public static final Item bronzechestplate = (new ItemArmor(367, 2, 9, 1))
			.setIconCoord(4, 1).setItemName("Bronze Chestplate");
	public static final Item steelchestplate = (new ItemArmor(368, 4, 17, 1))
			.setIconCoord(14, 1).setItemName("Steel Chestplate");
	public static final Item osmiumchestplate = (new ItemArmor(442, 5, 22, 1))
			.setIconCoord(15, 5).setItemName("Osmium Chestplate");

	public static final Item aluminumleggings = (new ItemArmor(369, 1, 5, 2))
			.setIconCoord(0, 2).setItemName("Aluminum Leggings");
	public static final Item copperleggings = (new ItemArmor(380, 1, 12, 2))
			.setIconCoord(7, 2).setItemName("Copper Leggings");
	public static final Item tinleggings = (new ItemArmor(381, 1, 18, 2))
			.setIconCoord(15, 2).setItemName("Tin Leggings");
	public static final Item bismuthleggings = (new ItemArmor(382, 1, 6, 2))
			.setIconCoord(1, 2).setItemName("Bismuth Leggings");
	public static final Item zincleggings = (new ItemArmor(383, 1, 21, 2))
			.setIconCoord(2, 6).setItemName("Zinc Leggings");
	public static final Item nickelleggings = (new ItemArmor(384, 2, 13, 2))
			.setIconCoord(9, 2).setItemName("Nickel Leggings");
	public static final Item cobaltleggings = (new ItemArmor(385, 3, 11, 2))
			.setIconCoord(6, 2).setItemName("Cobalt Leggings");
	public static final Item tungstenleggings = (new ItemArmor(386, 4, 20, 2))
			.setIconCoord(1, 6).setItemName("Tungsten Leggings");
	public static final Item silverleggings = (new ItemArmor(387, 2, 16, 2))
			.setIconCoord(13, 2).setItemName("Silver Leggings");
	public static final Item siliconleggings = (new ItemArmor(388, 3, 15, 2))
			.setIconCoord(3, 6).setItemName("Silicon Leggings");
	public static final Item chromeleggings = (new ItemArmor(389, 3, 10, 2))
			.setIconCoord(5, 2).setItemName("Chrome Leggings");
	public static final Item titaniumleggings = (new ItemArmor(390, 4, 19, 2))
			.setIconCoord(0, 6).setItemName("Titanium Leggings");
	public static final Item rubyleggings = (new ItemArmor(391, 4, 23, 2))
			.setIconCoord(11, 2).setItemName("Ruby Leggings");
	public static final Item sapphireleggings = (new ItemArmor(392, 4, 24, 2))
			.setIconCoord(12, 2).setItemName("Sapphire Leggings");
	public static final Item emeraldleggings = (new ItemArmor(393, 4, 25, 2))
			.setIconCoord(8, 2).setItemName("Emerald Leggings");
	public static final Item platinumleggings = (new ItemArmor(394, 2, 14, 2))
			.setIconCoord(10, 2).setItemName("Platinum Leggings");
	public static final Item boronleggings = (new ItemArmor(395, 2, 7, 2))
			.setIconCoord(2, 2).setItemName("Boron Leggings");
	public static final Item brassleggings = (new ItemArmor(396, 2, 8, 2))
			.setIconCoord(3, 2).setItemName("Brass Leggings");
	public static final Item bronzeleggings = (new ItemArmor(397, 2, 9, 2))
			.setIconCoord(4, 2).setItemName("Bronze Leggings");
	public static final Item steelleggings = (new ItemArmor(398, 4, 17, 2))
			.setIconCoord(14, 2).setItemName("Steel Leggings");
	public static final Item osmiumleggings = (new ItemArmor(443, 5, 22, 2))
			.setIconCoord(15, 6).setItemName("Osmium Leggings");

	public static final Item aluminumboots = (new ItemArmor(399, 1, 5, 3))
			.setIconCoord(0, 3).setItemName("Aluminum Boots");
	public static final Item copperboots = (new ItemArmor(400, 1, 12, 3))
			.setIconCoord(7, 3).setItemName("Copper Boots");
	public static final Item tinboots = (new ItemArmor(401, 1, 18, 3))
			.setIconCoord(15, 3).setItemName("Tin Boots");
	public static final Item bismuthboots = (new ItemArmor(402, 1, 6, 3))
			.setIconCoord(1, 3).setItemName("Bismuth Boots");
	public static final Item zincboots = (new ItemArmor(403, 1, 21, 3))
			.setIconCoord(2, 7).setItemName("Zinc Boots");
	public static final Item nickelboots = (new ItemArmor(404, 2, 13, 3))
			.setIconCoord(9, 3).setItemName("Nickel Boots");
	public static final Item cobaltboots = (new ItemArmor(405, 3, 11, 3))
			.setIconCoord(6, 3).setItemName("Cobalt Boots");
	public static final Item tungstenboots = (new ItemArmor(406, 4, 20, 3))
			.setIconCoord(1, 7).setItemName("Tungsten Boots");
	public static final Item silverboots = (new ItemArmor(407, 2, 16, 3))
			.setIconCoord(13, 3).setItemName("Silver Boots");
	public static final Item siliconboots = (new ItemArmor(408, 3, 15, 3))
			.setIconCoord(3, 7).setItemName("Silicon Boots");
	public static final Item chromeboots = (new ItemArmor(409, 3, 10, 3))
			.setIconCoord(5, 3).setItemName("Chrome Boots");
	public static final Item titaniumboots = (new ItemArmor(410, 4, 19, 3))
			.setIconCoord(0, 7).setItemName("Titanium Boots");
	public static final Item rubyboots = (new ItemArmor(411, 4, 23, 3))
			.setIconCoord(11, 3).setItemName("Ruby Boots");
	public static final Item sapphireboots = (new ItemArmor(412, 4, 24, 3))
			.setIconCoord(12, 3).setItemName("Sapphire Boots");
	public static final Item emeraldboots = (new ItemArmor(413, 4, 25, 3))
			.setIconCoord(8, 3).setItemName("Emerald Boots");
	public static final Item platinumboots = (new ItemArmor(414, 2, 14, 3))
			.setIconCoord(10, 3).setItemName("Platinum Boots");
	public static final Item boronboots = (new ItemArmor(415, 2, 7, 3))
			.setIconCoord(2, 3).setItemName("Boron Boots");
	public static final Item brassboots = (new ItemArmor(416, 2, 8, 3))
			.setIconCoord(3, 3).setItemName("Brass Boots");
	public static final Item bronzeboots = (new ItemArmor(417, 2, 9, 3))
			.setIconCoord(4, 3).setItemName("Bronze Boots");
	public static final Item steelboots = (new ItemArmor(418, 4, 17, 3))
			.setIconCoord(14, 3).setItemName("Steel Boots");
	public static final Item osmiumboots = (new ItemArmor(444, 5, 22, 3))
			.setIconCoord(15, 7).setItemName("Osmium Boots");

	public static final Item cookedegg = (new ItemFood(214, 4, false))
			.setItemName("Cooked Egg").setIconCoord(11, 5);
	
	public static final Item tallgrassitem = (new ItemTallGrass(446));
	
	public static final Item dynamite = (new Item(419).setIconCoord(14,
			4).setItemName("Dynamite"));
	/*
	public static final Item rawcheese = (new ItemFood(419, 2, false))
			.setIconCoord(4, 4).setItemName("Moldy Cheese");
			*/
	public static final Item cheese = (new ItemFood(420, 5, false))
			.setIconCoord(4, 5).setItemName("Cheese");


	public static final Item record26 = (new ItemRecord(422, "c418 - 26")
			.setIconCoord(5, 4).setItemName("Music Disc"));
	public static final Item recordilackanemotion = (new ItemRecord(423,
			"c418 - i lack an emotion").setIconCoord(6, 4).setItemName("Music Disc"));
	public static final Item recordinberlinpeopleactdifferently = (new ItemRecord(
			424, "c418 - in berlin people act differently").setIconCoord(7, 4)
			.setItemName("Music Disc"));
	public static final Item recordpleasedo = (new ItemRecord(425, "c418 - please do")
			.setIconCoord(8, 4).setItemName("Music Disc"));
	public static final Item recorddroopylikesyourface = (new ItemRecord(426,
			"c418 - droopy likes your face").setIconCoord(9, 4)
			.setItemName("Music Disc"));
	public static final Item recordchant = (new ItemRecord(433,
			"c418 - chant").setIconCoord(5, 5)
			.setItemName("Music Disc"));
	public static final Item recordseaweed = (new ItemRecord(448,
			"snuppeluppen - new frontier").setIconCoord(6, 5)
			.setItemName("Music Disc"));
	
	public static final Item coloredseeds = (new ItemSeeds(427, 98))
			.setIconCoord(11, 4);
	public static final Item fakecobbleitem1 = (new Item(428).setIconCoord(10,
			4).setItemName("?"));
	public static final Item fakecobbleitem2 = (new Item(429).setIconCoord(10,
			4).setItemName("Seriously what are you doing?"));
	public static final Item fakecobbleitem3 = (new Item(430).setIconCoord(10,
			4).setItemName("Please stop."));
	
	public static final Block Oil = (new BlockFlowing(200, Material.oil)).setHardness(100F)
	.setBlockName("Oil").disableStats().setLightOpacity(3)
	.disableNeighborNotifyOnMetadataChange();
	
	public static final Block OilStill = (new BlockStationary(201, Material.oil)).setHardness(100F)
	.setBlockName("Oil").disableStats().setLightOpacity(3)
	.disableNeighborNotifyOnMetadataChange();
	
	public static final Block mountainore = (new BlockOre(226, 201))
			.setHardness(2F).setResistance(4F).setBlockName("Mystery Ore");
	
	public static final Block biolumMushroom = (new BlockBioMushroom(229, 197)).setLightValue(0.625F)
			.setHardness(0.1F).setResistance(0.5F).setBlockName("Blue Mushroom");
	
	public static Block NFCblocksEffectiveAgainst[];
	
	static 
    {
        NFCblocksEffectiveAgainst = (new Block[] {
        		Block.mobSpawner, Block.doorSteel,
        			BrickOvenActive, BrickOvenIdle,
        		  aluminumore,  anthraciteore,  bismuthore,  boronore,  osmiumore,
                  chromeore,  cobaltore,  copperore,  emeraldore,  leadore,  magnetiteore,  nickelore,  platinumore,  rubyore,  sapphireore,
                  siliconore,  silverore,  titaniumore, tinore,  tungstenore,  zincore, uranite,
                  aluminumblock,  bismuthblock,  boronblock,
                  chromeblock,  cobaltblock,  copperblock,  emeraldblock,  leadblock,  magnetiteblock,  nickelblock,  platinumblock,  rubyblock,  sapphireblock,
                  siliconblock,  silverblock,  titaniumblock, tinblock,  tungstenblock,  zincblock, steelblock, bronzeblock, brassblock, uraniumblock,
                  stoneBricks, stoneBlock, stoneBlockoffy, stoneBlockoffx, stoneBlockoffxy, NSStep, EWStep, BrickStairs, StoneStairs, SandstoneStairs, 
                  platedStone, stoneBlockSmall
        });
    }


	public static final Item writableBook = (new ItemWritableBook(431)
			.setIconCoord(12, 4).setItemName("Writable Book"));
	public static final Item writtenBook = (new ItemEditableBook(432)
			.setIconCoord(13, 4).setItemName("Written Book"));
	
	public static final Item bucketOil = (new ItemBucket(445, Oil.blockID))
			.setIconCoord(6, 6).setItemName("Oil Bucket")
			.setContainerItem(Item.bucketEmpty);
	
	public static final Item Telescope = (new ItemTelescope(447)).setIconCoord(6, 7).setItemName("Telescope");
	
	public static final Item Wrench = (new ItemWrench(449)).setIconCoord(7, 7).setItemName("Wrench");
	
	public static void addSmelting(FurnaceRecipes fr) {
		fr.addSmelting(Item.egg.shiftedIndex, new ItemStack(cookedegg, 1));
		fr.addSmelting(aluminumore.blockID, new ItemStack(aluminum, 1));
		fr.addSmelting(copperore.blockID, new ItemStack(copper, 1));
		fr.addSmelting(tinore.blockID, new ItemStack(tin, 1));
		fr.addSmelting(zincore.blockID, new ItemStack(zinc, 1));
		fr.addSmelting(bismuthore.blockID, new ItemStack(bismuth, 1));
		fr.addSmelting(cobaltore.blockID, new ItemStack(cobalt, 1));

		fr.addSmelting(nickelore.blockID, new ItemStack(nickel, 1));
		fr.addSmelting(magnetiteore.blockID, new ItemStack(magnet, 1));
		fr.addSmelting(silverore.blockID, new ItemStack(silver, 1));
		fr.addSmelting(leadore.blockID, new ItemStack(lead, 1));
		fr.addSmelting(chromeore.blockID, new ItemStack(chrome, 1));
		fr.addSmelting(siliconore.blockID, new ItemStack(silicon, 1));

		fr.addSmelting(uranite.blockID, new ItemStack(uranium, 1));
		fr.addSmelting(platinumore.blockID, new ItemStack(platinum, 1));
		fr.addSmelting(boronore.blockID, new ItemStack(boron, 1));
		fr.addSmelting(osmiumore.blockID, new ItemStack(osmium, 1));
	}
	
	//ITEM IDS 193-197 EMPTY
	
	public static int rawVersion = 18604;
	public static String Version = "New Frontier Craft 1.8.6_02";

}

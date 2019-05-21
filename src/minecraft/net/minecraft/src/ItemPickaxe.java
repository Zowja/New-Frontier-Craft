// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

// Referenced classes of package net.minecraft.src:
//            ItemTool, Block, EnumToolMaterial, Material

public class ItemPickaxe extends ItemTool {

	protected ItemPickaxe(int i, EnumToolMaterial enumtoolmaterial) {
		super(i, enumtoolmaterial, blocksEffectiveAgainst);
	}

	public boolean canHarvestBlock(Block block) {
		if (block == Block.obsidian) {
			return toolMaterial.getHarvestLevel() >= 3;
		}
		if (block == Block.blockDiamond || block == Block.oreDiamond) {
			return toolMaterial.getHarvestLevel() >= 4;
		}
		if (block == Block.blockSteel || block == Block.oreIron) {
			return toolMaterial.getHarvestLevel() >= 2;
		}
		if (block == Block.blockLapis || block == Block.oreLapis) {
			return toolMaterial.getHarvestLevel() >= 1;
		}
		if (block == Block.oreRedstone || block == Block.oreRedstoneGlowing) {
			return toolMaterial.getHarvestLevel() >= 3;
		}

		if (block == NFC.boronblock || block == NFC.boronore) {
			return toolMaterial.getHarvestLevel() >= 1;
		}
		if (block == NFC.silverblock || block == NFC.silverore) {
			return toolMaterial.getHarvestLevel() >= 1;
		}
		if (block == NFC.brassblock) {
			return toolMaterial.getHarvestLevel() >= 1;
		}
		if (block == NFC.bronzeblock) {
			return toolMaterial.getHarvestLevel() >= 1;
		}

		if (block == NFC.cobaltblock || block == NFC.cobaltore) {
			return toolMaterial.getHarvestLevel() >= 2;
		}
		if (block == NFC.platinumblock || block == NFC.platinumore) {
			return toolMaterial.getHarvestLevel() >= 1;
		}
		if (block == NFC.nickelblock || block == NFC.nickelore) {
			return toolMaterial.getHarvestLevel() >= 1;
		}

		if (block == NFC.chromeblock || block == NFC.chromeore) {
			return toolMaterial.getHarvestLevel() >= 2;
		}
		if (block == NFC.siliconblock || block == NFC.siliconore) {
			return toolMaterial.getHarvestLevel() >= 2;
		}
		if (block == NFC.steelblock) {
			return toolMaterial.getHarvestLevel() >= 3;
		}
		
		if (block == NFC.osmiumore) {
			return toolMaterial.getHarvestLevel() >= 4;
		}

		if (block == NFC.tungstenblock || block == NFC.tungstenore) {
			return toolMaterial.getHarvestLevel() >= 3;
		}
		if (block == NFC.titaniumblock || block == NFC.titaniumore) {
			return toolMaterial.getHarvestLevel() >= 3;
		}

		if (block == NFC.rubyblock || block == NFC.rubyore) {
			return toolMaterial.getHarvestLevel() >= 3;
		}
		if (block == NFC.sapphireblock || block == NFC.sapphireore) {
			return toolMaterial.getHarvestLevel() >= 3;
		}
		if (block == NFC.emeraldblock || block == NFC.emeraldore) {
			return toolMaterial.getHarvestLevel() >= 3;
		}

		if (block.blockMaterial == Material.rock || block.blockMaterial == Material.ice) {
			return true;
		}
		return block.blockMaterial == Material.iron;
	}

	public static Block blocksEffectiveAgainst[];
	
	public float getStrVsBlock(ItemStack itemstack, Block block) {

		for (int i = 0; i < blocksEffectiveAgainst.length; i++) {
			if (blocksEffectiveAgainst[i] == block) {
				return efficiencyOnProperMaterial;
			}
		}
		for (int i = 0; i < NFC.NFCblocksEffectiveAgainst.length; i++) {
			if (NFC.NFCblocksEffectiveAgainst[i] == block) {
				return efficiencyOnProperMaterial;
			}
		}

		return 1.0F;
	}
	
	static 
    {
        blocksEffectiveAgainst = (new Block[] {
            Block.cobblestone, Block.stairDouble, Block.stairSingle, Block.stone, Block.sandStone, Block.cobblestoneMossy, Block.oreIron, Block.blockSteel, Block.oreCoal, Block.blockGold, 
            Block.oreGold, Block.oreDiamond, Block.blockDiamond, Block.ice, Block.netherrack, Block.oreLapis, Block.blockLapis, Block.oreRedstone, Block.oreRedstoneGlowing,
            Block.stairCompactCobblestone, Block.brick, Block.stoneOvenIdle, Block.stoneOvenActive, Block.dispenser, Block.rail, Block.railPowered, Block.railDetector 
        });
    }

	
}

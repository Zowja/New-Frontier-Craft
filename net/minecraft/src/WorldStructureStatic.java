package net.minecraft.src;

import java.util.Random;

public class WorldStructureStatic{
	
	private void setupChest(int i, int j, int k, int num, Random random, World world){
		world.setBlockWithNotify(i, j, k, Block.chest.blockID);
		TileEntityChest tileentitychest = (TileEntityChest) world
				.getBlockTileEntity(i, j, k);
		GiveDungeonLoot.giveChestLoot(tileentitychest, random, num);
	}
	
	private boolean isBuildableBlock(int i){
		return ((i == 1)||(i == 2)||(i == 3)||(i == 12)||(i == 13)||(i == 227));
	}
	
	private void setupMobSpawner(int i, int j, int k, int num, World world){
		world.setBlockWithNotify(i, j, k, Block.mobSpawner.blockID);
		TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner) world
				.getBlockTileEntity(i, j, k);
		String mobID;
		if(num == 0) mobID = "Zombie";
		else if(num == 1) mobID = "Skeleton";
		else if(num == 2) mobID = "Spider";
		else mobID = "Pig";
		tileentitymobspawner.setMobID(mobID);
	}
	
	public boolean initCheck(int checkArray[][], World world, int i, int j, int k, boolean flippedx){
		int xFlip = (flippedx) ? -1 : 1;
		for(int g = 0; g < checkArray[0].length; g++){
			if(checkArray[3][g] == -2){
				if(!isBuildableBlock(world.getBlockId(i+(checkArray[0][g]*xFlip), j+checkArray[1][g], k+checkArray[2][g])))return false;
			}
			else if(checkArray[3][g] == -3){
				if(!world.getBlockMaterial(i+(checkArray[0][g]*xFlip), j+checkArray[1][g], k+checkArray[2][g]).getIsSolid()) return false;
			}
			else if(world.getBlockId(i+(checkArray[0][g]*xFlip), j+checkArray[1][g], k+checkArray[2][g]) != checkArray[3][g]) return false;
		}
		return true;
	}
	
	public boolean fullCheck(int reqArray[][][], World world, int i, int j, int k, boolean flippedx){
		int xFlip = (flippedx) ? -1 : 1;
		for(int a = 0; a < reqArray.length; a++)
			for(int b = 0; b < reqArray[a].length; b++)
				for(int c = 0; c < reqArray[a][b].length; c++)
					if(reqArray[a][b][c] == -2){
						if(!isBuildableBlock(world.getBlockId(i+(b*xFlip), j+a, k+c))) return false;
					}
					else if(reqArray[a][b][c] == -1){
						// -1 means the block does not matter
					}
					else if(reqArray[a][b][c] == -3){
						if(!world.getBlockMaterial(i+(b*xFlip), j+a, k+c).getIsSolid()) return false;
					}
					else if(world.getBlockId(i+(b*xFlip), j+a, k+c) != reqArray[a][b][c]) return false;
		return true;
	}

	public boolean generate(int genArray[][][], int specialArray[][], World world, Random random, int i, int j, int k, boolean flippedx) {
		int xFlip = (flippedx) ? -1 : 1;
		for(int a = 0; a < genArray.length; a++)
				for(int b = 0; b < genArray[a].length; b++)
					for(int c = 0; c < genArray[a][b].length; c++){
						if(genArray[a][b][c] != -1)
						world.setBlock(i+(b*xFlip), j+a, c+k,
								genArray[a][b][c]);
					}
		if(specialArray != null)
		for(int g = 0; g < specialArray[0].length; g++){
			if(specialArray[3][g] > 0){
				world.setBlockMetadata(i+(specialArray[0][g]*xFlip), j+specialArray[1][g], k+specialArray[2][g], specialArray[3][g]);
			}
			else if (specialArray[3][g] == 0)
				setupChest(i + (specialArray[0][g]*xFlip), j + specialArray[1][g], k + specialArray[2][g], genArray[specialArray[1][g]][specialArray[0][g]][specialArray[2][g]], random, world);
			else if (specialArray[3][g] == -1)
				setupMobSpawner(i + (specialArray[0][g]*xFlip), j + specialArray[1][g], k + specialArray[2][g], genArray[specialArray[1][g]][specialArray[0][g]][specialArray[2][g]], world);
		}
		return true;
	}

}

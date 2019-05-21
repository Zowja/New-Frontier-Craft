package net.minecraft.src;

import java.util.ArrayList;

public class Structure {
	
	public Structure(){
		chests = new ArrayList<lootChest>();
		randoms = new ArrayList<randomNumberSet>();
		spawners = new ArrayList<Spawner>();
		multiChecks = new ArrayList<short[]>();
	}
	
	public short[][] initialCheck, metadata;
	public short[][][] deepCheck, structure;
	public double topTemp, lowTemp, topHumidity, lowHumidity, commonality;
	public boolean hasBiome = true, hasInitial = true, hasDeep = true, hasMeta = true;
	public short yTop, yBottom;
	public ArrayList<lootChest> chests;
	public ArrayList<randomNumberSet> randoms;
	public ArrayList<Spawner> spawners;
	public ArrayList<short[]> multiChecks;
	public short type;
	public long random;
	
	public lootChest getNewChest(){
		chests.add(new lootChest());
		return chests.get(chests.size() - 1);
	}
	
	public Spawner getNewSpawner(){
		spawners.add(new Spawner());
		return spawners.get(spawners.size() - 1);
	}
	
	public void createNewRandom(int[] number, int[] weight, int totalweight){
		randoms.add(new randomNumberSet(weight, number, totalweight));
	}
	
	class lootChest {
		
		public lootChest(){
			loot = new ArrayList<lootItem>();
		}
		
		public void addLoot(short item, short meta, short num, short weight){
			lootItem loot = new lootItem();
			loot.itemID = item;
			loot.metadata = meta;
			loot.numberInStack = num;
			loot.weight = weight;
			totalweight += weight;
			this.loot.add(loot);
		}
		
		int totalweight;
		public short numOfLoot;
		public ArrayList<lootItem> loot;
	}
	
	class lootItem {
		public short itemID, metadata, numberInStack, weight;
	}
	
	class Spawner {
		
		public Spawner(){
			mobIDs = new ArrayList<String>();
			weights = new ArrayList<Short>();
		}
		
		public ArrayList<String> mobIDs;
		public ArrayList<Short> weights;
		public int totalweight;
	}
	
	class randomNumberSet {
		
		public randomNumberSet(int[] weight, int[] number, int totalWeight){
			this.weight = weight;
			this.number = number;
			totalRandomWeight = totalWeight;
		}
		
		int[] weight, number;
		int totalRandomWeight;
	}

}

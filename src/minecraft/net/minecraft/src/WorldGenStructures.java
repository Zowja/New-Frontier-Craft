package net.minecraft.src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import net.minecraft.client.Minecraft;

public class WorldGenStructures extends WorldGenerator {
	
	public WorldGenStructures(World world){
		loadStructures(world);
	}
	
	private LinkedList<Structure> list = new LinkedList<Structure>();

	@Override
	public boolean generate(World world, Random r, int i, int dimension, int k) {
		Random rand;
		int x, z, y;
		double temp = 100, humidity = 100;
		//If the world type does not have biome data
		if(world.getWorldChunkManager() != null){
			world.getWorldChunkManager().func_4069_a(i, k, 1, 1);
			temp = world.getWorldChunkManager().temperature[0] * 100;
			humidity = world.getWorldChunkManager().humidity[0] * 100;
		}
		//TODO: DUM
		int count = -1;
		for (Structure structure : list) {
			count++;
			if(structure.type != dimension){
				continue;
			}
			if (structure.hasBiome && (temp > structure.topTemp || temp < structure.lowTemp
					|| humidity > structure.topHumidity || humidity < structure.lowHumidity)) {
				continue;
			}
			double spawnAttempts = structure.commonality;
			//Reset seed so that the individual structures are consistent across a seed.
			rand = new Random(world.getRandomSeed()+((i%256)*256)+(k%256)+structure.random);
			attempt: while (spawnAttempts > 0) {
				double random = rand.nextDouble();
				if (random > spawnAttempts) {
					break attempt;
				}
				y = structure.yBottom + rand.nextInt(structure.yTop - structure.yBottom + 1);
				x = rand.nextInt(16) + i;
				z = rand.nextInt(16) + k;
				spawnAttempts--;
				if (structure.hasInitial) {
					for (short[] check : structure.initialCheck)
						if (check[3] > -1) {
							if (world.getBlockId(x + check[0], y + check[1], z + check[2]) != check[3])
								continue attempt;
							else if(check[4] >= 0 && (world.getBlockId(x + check[0], y + check[1], z + check[2]) == (byte)check[4])){
								continue attempt;
							}
						} else if (check[3] < -31) {
							short[] checks = structure.multiChecks.get(-check[3] - 32);
							boolean checked = false;
							int blockID = world.getBlockId(x + check[0], y + check[1], z + check[2]);
							for (int innerCheck : checks) {
								if (innerCheck == blockID) {
									checked = true;
									break;
								}
							}
							if (!checked)
								continue attempt;
						}
				}
				if (structure.hasDeep) {
					for (int xx = 0; xx < structure.deepCheck.length; xx++) {
						for (int yy = 0; yy < structure.deepCheck[xx].length; yy++) {
							for (int zz = 0; zz < structure.deepCheck[xx][yy].length; zz++) {
								if (structure.deepCheck[xx][yy][zz] > -1) {
									if (world.getBlockId(x + xx, y + yy, z + zz) != structure.deepCheck[xx][yy][zz]) {
										continue attempt;
									}
								} else if (structure.deepCheck[xx][yy][zz] < -31) {
									short[] checks = structure.multiChecks.get(-structure.deepCheck[xx][yy][zz] - 32);
									boolean checked = false;
									int blockID = world.getBlockId(x + xx, y + yy, z + zz);
									for (int innerCheck : checks) {
										if (innerCheck == blockID) {
											checked = true;
											break;
										}
									}
									if (!checked)
										continue attempt;
								}
							}
						}
					}
				}
				//TODO: DUM
				names.get(count).count++;
				System.out.println(names.get(count).name + ": " + names.get(count).count);
				for (int xx = 0; xx < structure.structure.length; xx++) {
					for (int yy = 0; yy < structure.structure[xx].length; yy++) {
						for (int zz = 0; zz < structure.structure[xx][yy].length; zz++) {
							if (structure.structure[xx][yy][zz] > -1)
								world.setBlockWithNotify(x + xx, y + yy, z + zz, structure.structure[xx][yy][zz]);

							else if (structure.structure[xx][yy][zz] < -31) {
								if (structure.structure[xx][yy][zz] > -structure.randoms.size() - 32) {
									Structure.randomNumberSet randomNumSet = structure.randoms
											.get(-structure.structure[xx][yy][zz] - 32);
									int roll = rand.nextInt(randomNumSet.totalRandomWeight);
									int total = 0, result = 0;
									for (int loop = 0; loop < randomNumSet.number.length; loop++) {
										result = randomNumSet.number[loop];
										if (total + randomNumSet.weight[loop] > roll) {
											break;
										}
										total += randomNumSet.weight[loop];
									}
									if (result > -1) {
										world.setBlockWithNotify(x + xx, y + yy, z + zz, result);
									} else if (result > -structure.chests.size() - structure.randoms.size() - 32) {
										generateChest(x + xx, y + yy, z + zz, result, rand, structure, world);
									} else if (result > -structure.spawners.size() - structure.chests.size()
											- structure.randoms.size() - 32) {
										generateSpawner(x + xx, y + yy, z + zz, result, rand, structure, world);
									}
								} else if (structure.structure[xx][yy][zz] > -structure.chests.size()
										- structure.randoms.size() - 32) {
									generateChest(x + xx, y + yy, z + zz, structure.structure[xx][yy][zz], rand,
											structure, world);
								} else if (structure.structure[xx][yy][zz] > -structure.spawners.size()
										- structure.chests.size() - structure.randoms.size() - 32) {
									generateSpawner(x + xx, y + yy, z + zz, structure.structure[xx][yy][zz], rand,
											structure, world);
								}
							}
						}
					}
				}
				if (structure.hasMeta) {
					for (short[] meta : structure.metadata) {
						world.setBlockMetadataWithNotify(x + meta[0], meta[1] + y, z + meta[2], (byte) meta[3]);
						//702547062650587714
					}
				}
			}
		}
		return true;
	}
	
	public void generateChest(int x, int y, int z, int id, Random rand, Structure structure, World world) {
		world.setBlockWithNotify(x, y, z, 54);
		TileEntityChest inventory = (TileEntityChest) world.getBlockTileEntity(x, y, z);
		int l2 = 0;
		Structure.lootChest chest = structure.chests.get(-id - structure.randoms.size() - 32);
		ArrayList<Integer> openSlots = new ArrayList<Integer>();
		for (int slots = 0; slots < inventory.getSizeInventory(); slots++) {
			openSlots.add(slots);
		}
		while (true) {
			if (l2 >= chest.numOfLoot) {
				break;
			}
			int roll = rand.nextInt(chest.totalweight);
			int total = 0;
			Structure.lootItem item = null;
			for (int loop = 0; loop < chest.loot.size(); loop++) {
				item = chest.loot.get(loop);
				if (total + item.weight > roll) {
					break;
				}
				total += item.weight;
			}
			if (item != null) {
				int slot = rand.nextInt(openSlots.size());
				inventory.setInventorySlotContents(openSlots.get(slot),
						new ItemStack(item.itemID, rand.nextInt(item.numberInStack) + 1, item.metadata));
				openSlots.remove(slot);
			}

			++l2;
		}
	}

	public void generateSpawner(int x, int y, int z, int id, Random rand, Structure structure, World world) {
		world.setBlockWithNotify(x, y, z, 52);
		Structure.Spawner spawner = structure.spawners.get(-id - structure.chests.size() - structure.randoms.size() - 32);
		int roll = rand.nextInt(spawner.totalweight);
		int total = 0;
		String mobID = null;
		for (int loop = 0; loop < spawner.mobIDs.size(); loop++) {
			mobID = spawner.mobIDs.get(loop);
			if (total + spawner.weights.get(loop) > roll) {
				break;
			}
			total += spawner.weights.get(loop);
		}
		((TileEntityMobSpawner) world.getBlockTileEntity(x, y, z)).setMobID(mobID);
		
	}
	
	// Loading
	//TODO: DUM
	private class mini {
		
		public mini(String name, int count){
			this.name = name;
			this.count = count;
		}
		
		public String name;
		public int count;
	}
	private LinkedList<mini> names = new LinkedList<mini>();
	
	public void loadStructures(World world) {
		File structDir = new File(((SaveHandler)world.saveHandler).getSaveDirectory(), "/structures/");
		File[] structureFiles = structDir.listFiles();
		if (structureFiles == null) {
			return;
		}
		for (File file : structureFiles) {

			// Skips errors file if it exists
			if (file.getName().endsWith(".zip")){
				
				try {

					ZipFile zipfile = new ZipFile(file);
					for(Enumeration<? extends ZipEntry> entries = zipfile.entries();
					        entries.hasMoreElements();){

					Structure loadingStruct = new Structure();
					short worldType;
					ZipEntry zipEntry = entries.nextElement();
					//TODO: DUM
					names.add(new mini(zipEntry.getName(), 0));
					
					// Setup random
					loadingStruct.random = (((long)file.getName().substring(0, 5).hashCode()) << 32) + zipEntry.getName().hashCode();
					
					// Read version
					Scanner lineReader = new Scanner(zipfile.getInputStream(zipEntry));
					if (!lineReader.hasNextLine()) {
						error(file.getName() + "/" + zipEntry.getName(), "There is nothing in the file.");
						continue;
					}
					worldType = lineReader.nextShort();
					if (worldType < 1 || worldType > 3) {
						error(file.getName() + "/" + zipEntry.getName(), "This version of CustomStructure can only read structures of versions 1, 2, and 3.");
						continue;
					}
					loadingStruct.type = worldType;
					lineReader.nextLine();

					// Read Biome
					if (!lineReader.hasNextLine()) {
						error(file.getName() + "/" + zipEntry.getName(), "File is incomplete. Stops at: Biome check.");
						continue;
					}
					String line = lineReader.nextLine();
					Scanner scnr;
					if (line.equals("x")) {
						loadingStruct.hasBiome = false;
					} else {
						scnr = new Scanner(line);
						for (int i = 0; i < 4; i++) {
							if (!scnr.hasNextDouble()) {
								error(file.getName() + "/" + zipEntry.getName(), "Biome detection does not contain all decimals.");
								scnr.close();
								continue;
							}
						}
						scnr.close();
						scnr = new Scanner(line);
						loadingStruct.topTemp = scnr.nextDouble();
						loadingStruct.lowTemp = scnr.nextDouble();
						loadingStruct.topHumidity = scnr.nextDouble();
						loadingStruct.lowHumidity = scnr.nextDouble();
						scnr.close();
					}

					// Read Commonality
					if (!lineReader.hasNextLine()) {
						error(file.getName() + "/" + zipEntry.getName(), "File is incomplete. Stops at: Commonality.");
						continue;
					}
					scnr = new Scanner(lineReader.nextLine());
					if (!scnr.hasNextDouble()) {
						error(file.getName() + "/" + zipEntry.getName(), "Commonality is not a decimal");
						continue;
					}
					loadingStruct.commonality = scnr.nextDouble();
					scnr.close();

					// Read y coordinates
					if (!lineReader.hasNextLine()) {
						error(file.getName() + "/" + zipEntry.getName(), "File is incomplete. Stops at: Size read.");
						continue;
					}
					scnr = new Scanner(lineReader.nextLine());
					if (scnr.hasNextShort()) {
						loadingStruct.yTop = scnr.nextShort();
					} else {
						error(file.getName() + "/" + zipEntry.getName(), "Y coordinates are not two integers");
						continue;
					}
					if (scnr.hasNextShort()) {
						loadingStruct.yBottom = scnr.nextShort();
					} else {
						error(file.getName() + "/" + zipEntry.getName(), "Y coordinates are not two integers");
						continue;
					}
					scnr.close();
					if(loadingStruct.yTop < loadingStruct.yBottom){
						short temp = loadingStruct.yTop;
						loadingStruct.yTop = loadingStruct.yBottom;
						loadingStruct.yBottom = temp;
					}

					// Read size
					if (!lineReader.hasNextLine()) {
						error(file.getName() + "/" + zipEntry.getName(), "File is incomplete. Stops at: Size read.");
						continue;
					}
					scnr = new Scanner(lineReader.nextLine());
					short[] size = new short[3];
					for (int i = 0; i < 3; i++) {
						if (scnr.hasNextShort()) {
							size[i] = scnr.nextShort();
						} else {
							error(file.getName() + "/" + zipEntry.getName(), "Size read is not all integers or is lacking numbers");
							continue;
						}
					}
					scnr.close();

					// Read initial check
					if (!lineReader.hasNextLine()) {
						error(file.getName() + "/" + zipEntry.getName(), "File is incomplete. Stops at: Initial check.");
						continue;
					}
					line = "";
					short numberOfChecks = 0;
						while (lineReader.hasNextLine()) {
							String temp = lineReader.nextLine();
							if (temp.equals("")) {
								break;
							}
							line += temp + "\n";
							numberOfChecks++;
						}
					if(numberOfChecks == 0){
						loadingStruct.hasInitial = false;
					}
					loadingStruct.initialCheck = new short[numberOfChecks][5];
					scnr = new Scanner(line);
					for (int i = 0; i < numberOfChecks; i++) {
						Scanner set = new Scanner(scnr.nextLine());
						for (int j = 0; j < 4; j++) {
							if (!set.hasNextShort()) {
								error(file.getName() + "/" + zipEntry.getName(), "Initial check is not all integers or is lacking numbers");
								continue;
							}
							loadingStruct.initialCheck[i][j] = set.nextShort();
						}
						if (set.hasNextShort()) {
							loadingStruct.initialCheck[i][4] = set.nextShort();
						} else {
							loadingStruct.initialCheck[i][4] = -1;
						}
						set.close();

					}
					scnr.close();

					// Read deep check
					if (!lineReader.hasNextLine()) {
						error(file.getName() + "/" + zipEntry.getName(), "File is incomplete. Stops at: Deep check.");
						continue;
					}
					if (lineReader.hasNextShort()) {
						loadingStruct.deepCheck = new short[size[0]][size[1]][size[2]];
						try {
							for (int y = 0; y < size[1]; y++) {
								for (int z = 0; z < size[2]; z++) {
									for (int x = 0; x < size[0]; x++) {
										loadingStruct.deepCheck[x][y][z] = lineReader.nextShort();
									}
								}
							}
						} catch (Exception e) {
							error(file.getName() + "/" + zipEntry.getName(),
									"There was an error in reading the deep check. This could be from there being a non-integer object or the array of numbers is the wrong size.");
							continue;
						}
					} else {
						loadingStruct.hasDeep = false;
					}
					lineReader.nextLine();

					// Read structure
					if (!lineReader.hasNextLine()) {
						error(file.getName() + "/" + zipEntry.getName(), "File is incomplete. Stops at: structure read.");
						continue;
					}
					loadingStruct.structure = new short[size[0]][size[1]][size[2]];
					try {
						for (int y = 0; y < size[1]; y++) {
							for (int z = 0; z < size[2]; z++) {
								for (int x = 0; x < size[0]; x++) {
									loadingStruct.structure[x][y][z] = lineReader.nextShort();
								}
							}
						}
					} catch (Exception e) {
						error(file.getName() + "/" + zipEntry.getName(),
								"There was an error in reading the structure. This could be from there being a non-integer object or the array of numbers is the wrong size.");
						continue;
					}

					// Read Metadata
					if (lineReader.hasNextShort()) {
						lineReader.nextLine();
						lineReader.nextLine();
						line = lineReader.nextLine();
						numberOfChecks = 1;
						while (lineReader.hasNextLine()) {
							String temp = lineReader.nextLine();
							if (temp.equals("")) {
								break;
							}
							line += "\n" + temp;
							numberOfChecks++;
						}
						loadingStruct.metadata = new short[numberOfChecks][4];
						scnr = new Scanner(line);
						for (int i = 0; i < numberOfChecks; i++) {
							for (int j = 0; j < 4; j++) {
								if (!scnr.hasNextShort()) {
									error(file.getName() + "/" + zipEntry.getName(), "Metadata is not all integers or you are missing numbers");
									continue;
								}
								loadingStruct.metadata[i][j] = scnr.nextShort();
							}
	
						}
					}
					else {
						loadingStruct.hasMeta = false;
					}
					scnr.close();

					while (lineReader.hasNext()) {
						String input = lineReader.next();
						if (input.equals("chest")) {
							readChest(lineReader, loadingStruct);
						} else if (input.equals("spawner")) {
							readSpawner(lineReader, loadingStruct);
						} else if (input.equals("random")) {
							readRandom(lineReader, loadingStruct);
						} else if (input.equals("check")) {
							readMultiChecks(lineReader, loadingStruct);
						} else {
							error(file.getName() + "/" + zipEntry.getName(), "Attmepted to read a custom chest or random number but failed. Input was: "
									+ input);
							break;
						}
					}

					lineReader.close();
					list.add(loadingStruct);
					}
					zipfile.close();
				} catch (FileNotFoundException e) {
					error(file.getName(), "File was detected yet not readable.");
					break;
				} catch (Exception e) {
					error(file.getName(), e.getMessage());
					e.printStackTrace();
					break;
				}
				
			}
		}
	}
	
	public static void readMultiChecks(Scanner scnr, Structure structure) throws Exception {
		try {
			Stack<Short> inputs = new Stack<Short>();
			while (scnr.hasNextShort()) {
				inputs.push(scnr.nextShort());
			}
			short[] checks = new short[inputs.size()];
			for (int i = 0; i < checks.length; i++) {
				checks[i] = inputs.pop();
			}
			structure.multiChecks.add(checks);
		} catch (Exception e) {
			throw new Exception("Check was not able to be read.");
		}
	}

	public static void readRandom(Scanner scnr, Structure structure) throws Exception {
		try {
			while (scnr.hasNextShort()) {
				Stack<Short> IDInputs = new Stack<Short>();
				Stack<Short> weightInputs = new Stack<Short>();
				while (scnr.hasNextShort()) {
					IDInputs.push(scnr.nextShort());
					weightInputs.push(scnr.nextShort());
				}
				int[] IDs = new int[IDInputs.size()];
				int[] weights = new int[weightInputs.size()];
				int totalWeight = 0;
				for (int i = 0; i < IDs.length; i++) {
					IDs[i] = IDInputs.pop();
					weights[i] = weightInputs.pop();
					totalWeight += weights[i];
				}
				structure.createNewRandom(IDs, weights, totalWeight);
			}
		} catch (Exception e) {
			throw new Exception("Random was not able to be read.");
		}
	}

	public static void readChest(Scanner scnr, Structure structure) throws Exception {
		Structure.lootChest chest = structure.getNewChest();
		try {
			chest.numOfLoot = scnr.nextShort();
			short[] data = new short[4];
			byte loops = 0;
			while (scnr.hasNextShort()) {
				Scanner line = new Scanner(scnr.nextLine());
				while(line.hasNextShort()){
					data[loops] = line.nextShort();
					loops++;
				}
				if(loops > 3)
					chest.addLoot(data[0], data[1], data[2], data[3]);
				else {
					chest.addLoot(data[0], (short) 0, data[1], data[2]);
				}
				line.close();
				loops = 0;
			}
		} catch (Exception e) {
			throw new Exception("Chest was not able to be read.");
		}
	}

	public static void readSpawner(Scanner scnr, Structure structure) throws Exception {
		Structure.Spawner spawner = structure.getNewSpawner();
		scnr.nextLine();
		try {
			while (scnr.hasNextLine()) {
				String line = scnr.nextLine();
				if (line.equals("")) {
					break;
				}
				Scanner inner = new Scanner(line);
				spawner.mobIDs.add(inner.next());
				short weight = inner.nextShort();
				spawner.weights.add(weight);
				spawner.totalweight += weight;
				inner.close();
			}
		} catch (Exception e) {
			throw new Exception("Spawner was not able to be read.");
		}
	}
	
	public static void error(String file, String string) {
		System.err.println("Structure Loader: Error at file " + file);
		System.err.println(string);
	}

}

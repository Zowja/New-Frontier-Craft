package net.minecraft.src;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class EntityScore {
	
	public static Map<Class, Integer> staticScores = new HashMap<Class, Integer>();
	public static Map<Class, Integer> baseScores = new HashMap<Class, Integer>();
	
	
	public static int getScore(Entity entity, EntityPlayer player)
	{
		if(staticScore(entity))
		{
			return staticScores.get(entity.getClass());
		} else			
		return calculateScore(entity, player);		
	}
	
	private static int calculateScore(Entity entity, EntityPlayer player)
	{
		Random random = new Random();
		if(entity instanceof EntityMob || entity instanceof EntityGhast || entity instanceof EntitySlime)
		{
			return baseScores.get(entity.getClass()) - random.nextInt(5 + random.nextInt(5));
		} else
		return 0;
	}
	
	static boolean staticScore(Entity entity)
	{
		return staticScores.containsKey(entity.getClass());
	}
	
	static
	{
		staticScores.put(EntityPig.class, 20);
		staticScores.put(EntitySheep.class, 20);
		staticScores.put(EntityChicken.class, 20);
		staticScores.put(EntityCow.class, 20);
		staticScores.put(EntitySquid.class, 25);
		staticScores.put(EntityWolf.class, 30);
		baseScores.put(EntityCreeper.class, 300);
		baseScores.put(EntitySkeleton.class, 300);
		baseScores.put(EntitySpider.class, 250);
		baseScores.put(EntityZombie.class, 150);
		baseScores.put(EntitySlime.class, 400);
		baseScores.put(EntityGhast.class, 1000);
		baseScores.put(EntityPigZombie.class, 500);
	}

}

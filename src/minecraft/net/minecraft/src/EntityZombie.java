// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            EntityMob, World, MathHelper, Item

public class EntityZombie extends EntityMob {

	public EntityZombie(World world) {
		super(world);
		texture = "/mob/zombie.png";
		moveSpeed = 0.5F;
		attackStrength = 5;
	}

	public void onLivingUpdate() {
		if (worldObj.isDaytime()) {
			float f = getEntityBrightness(1.0F);
			if (f > 0.5F
					&& worldObj.canBlockSeeTheSky(
							MathHelper.floor_double(posX),
							MathHelper.floor_double(posY),
							MathHelper.floor_double(posZ))
					&& rand.nextFloat() * 30F < (f - 0.4F) * 2.0F) {
				fire = 300;
			}
		}
		super.onLivingUpdate();
	}

	protected String getLivingSound() {
		return "mob.zombie";
	}

	protected String getHurtSound() {
		return "mob.zombiehurt";
	}

	protected String getDeathSound() {
		return "mob.zombiedeath";
	}

	protected int getDropItemId() {
		int r = this.rand.nextInt(32);
		if (r == 16) {
			return Item.legsLeather.shiftedIndex;
		} else if (r == 8) {
			return Item.plateLeather.shiftedIndex;
		}
		return 0;
	}
	
	protected void dropFewItems() {
		int i = getDropItemId();
		if (i > 0) {
			int j = rand.nextInt(2);
			for (int k = 0; k < j; k++) {
				dropItem(i, 1);
			}

		}
	}
}

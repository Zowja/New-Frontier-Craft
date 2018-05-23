// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Entity, MathHelper, World, Material, 
//            AxisAlignedBB, Block, NBTTagCompound, ItemStack, 
//            EntityPlayer, InventoryPlayer, AchievementList, Item, 
//            ModLoader

public class EntityItem extends Entity {

	public EntityItem(World world, double d, double d1, double d2,
			ItemStack itemstack) {
		super(world);
		age = 0;
		health = 5;
		field_804_d = (float) (Math.random() * 3.1415926535897931D * 2D);
		setSize(0.25F, 0.25F);
		yOffset = height / 2.0F;
		setPosition(d, d1, d2);
		item = itemstack;
		rotationYaw = (float) (Math.random() * 360D);
		motionX = (float) (Math.random() * 0.20000000298023221D - 0.10000000149011611D);
		motionY = 0.20000000298023221D;
		motionZ = (float) (Math.random() * 0.20000000298023221D - 0.10000000149011611D);
	}

	protected boolean canTriggerWalking() {
		return false;
	}

	public EntityItem(World world) {
		super(world);
		age = 0;
		health = 5;
		field_804_d = (float) (Math.random() * 3.1415926535897931D * 2D);
		setSize(0.25F, 0.25F);
		yOffset = height / 2.0F;
	}

	protected void entityInit() {
	}

	public void onUpdate() {
		super.onUpdate();
		if (delayBeforeCanPickup > 0) {
			delayBeforeCanPickup--;
		}
		prevPosX = posX;
		prevPosY = posY;
		prevPosZ = posZ;
		motionY -= 0.039999999105930328D;
		if (worldObj.getBlockMaterial(MathHelper.floor_double(posX),
				MathHelper.floor_double(posY), MathHelper.floor_double(posZ)) == Material.lava) {
			motionY = 0.20000000298023221D;
			motionX = (rand.nextFloat() - rand.nextFloat()) * 0.2F;
			motionZ = (rand.nextFloat() - rand.nextFloat()) * 0.2F;
			worldObj.playSoundAtEntity(this, "random.fizz", 0.4F,
					2.0F + rand.nextFloat() * 0.4F);
		}
		pushOutOfBlocks(posX, (boundingBox.minY + boundingBox.maxY) / 2D, posZ);
		moveEntity(motionX, motionY, motionZ);
		float f = 0.98F;
		if (onGround) {
			f = 0.5880001F;
			int i = worldObj.getBlockId(MathHelper.floor_double(posX),
					MathHelper.floor_double(boundingBox.minY) - 1,
					MathHelper.floor_double(posZ));
			if (i > 0) {
				f = Block.blocksList[i].slipperiness * 0.98F;
			}
		}
		motionX *= f;
		motionY *= 0.98000001907348633D;
		motionZ *= f;
		if (onGround) {
			motionY *= -0.5D;
		}
		field_803_e++;
		age++;
		if (age >= 6000) {
			setEntityDead();
		}
	}

	public boolean handleWaterMovement() {
		return worldObj.handleMaterialAcceleration(boundingBox, Material.water,
				this);
	}

	protected void dealFireDamage(int i) {
		attackEntityFrom(null, i);
		if (item.itemID == 2256) {
			item.itemID = 678;
		}
	}

	public boolean attackEntityFrom(Entity entity, int i) {
		setBeenAttacked();
		health -= i;
		if (health <= 0) {
			setEntityDead();
		}
		return false;
	}

	public void writeEntityToNBT(NBTTagCompound nbttagcompound) {
		nbttagcompound.setShort("Health", (byte) health);
		nbttagcompound.setShort("Age", (short) age);
		nbttagcompound.setCompoundTag("Item",
				item.writeToNBT(new NBTTagCompound()));
	}

	public void readEntityFromNBT(NBTTagCompound nbttagcompound) {
		health = nbttagcompound.getShort("Health") & 0xff;
		age = nbttagcompound.getShort("Age");
		NBTTagCompound var2 = nbttagcompound.getCompoundTag("Item");
		item = new ItemStack(var2);
	}
	
	public void onCollideWithPlayer(EntityPlayer entityplayer) {
		if (worldObj.multiplayerWorld) {
			return;
		}
		int i = item.stackSize;
		if (delayBeforeCanPickup == 0
				&& entityplayer.inventory.addItemStackToInventory(item)) {
			if (item.itemID == Block.wood.blockID) {
				entityplayer.triggerAchievement(AchievementList.mineWood);
			}
			if (item.itemID == Item.leather.shiftedIndex) {
				entityplayer.triggerAchievement(AchievementList.killCow);
			}
			worldObj.playSoundAtEntity(
					this,
					"random.pop",
					0.2F,
					((rand.nextFloat() - rand.nextFloat()) * 0.7F + 1.0F) * 2.0F);
			entityplayer.onItemPickup(this, i);
			if (item.stackSize <= 0) {
				setEntityDead();
			}
		}
	}

	public ItemStack item;
	private int field_803_e;
	public int age;
	public int delayBeforeCanPickup;
	private int health;
	public float field_804_d;
}

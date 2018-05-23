package net.minecraft.src;

public class EntityBlueSporeFX extends EntityFX {

	public EntityBlueSporeFX(World world, double d, double d1, double d2,
			double d3, double d4, double d5) {
		super(world, d, d1, d2, d3, d4, d5);
		motionX = d3 + (double) ((float) (Math.random() * 2D - 1.0D) * 0.025F);
		motionY = d4 + (double) ((float) (Math.random() * 2D - 1.0D) * 0.015F);
		motionZ = d5 + (double) ((float) (Math.random() * 2D - 1.0D) * 0.025F);
		particleScale = 1.0F;
		particleTextureIndex = 0;
		particleRed *= 0.78F;
		particleGreen *= 0.98F;
		particleMaxAge = ((int) (100D / ((double) rand.nextFloat() * rand.nextFloat() * .40000000000000004D + 0.20000000000000001D)) + 2);
	}
	public void onUpdate() {
		prevPosX = posX;
		prevPosY = posY;
		prevPosZ = posZ;
		if (particleAge++ >= particleMaxAge) {
			setEntityDead();
		}
		motionY += 0.0004D;
		moveEntity(motionX, motionY, motionZ);
		motionX *= 0.8125D;
		motionY *= 0.8125D;
		motionZ *= 0.8125D;
		if (onGround) {
			motionX *= 0.69999998807907104D;
			motionZ *= 0.69999998807907104D;
		}
	}
	
	public void renderParticle(Tessellator tessellator, float f, float f1,
			float f2, float f3, float f4, float f5) {
		float f6 = (float) (particleTextureIndex % 16) / 16F;
		float f7 = f6 + 0.0624375F;
		float f8 = (float) (particleTextureIndex / 16) / 16F;
		float f9 = f8 + 0.0624375F;
		float f10 = 0.1F * particleScale;
		float f11 = (float) ((prevPosX + (posX - prevPosX) * (double) f) - interpPosX);
		float f12 = (float) ((prevPosY + (posY - prevPosY) * (double) f) - interpPosY);
		float f13 = (float) ((prevPosZ + (posZ - prevPosZ) * (double) f) - interpPosZ);
		float f14 = getEntityBrightness(f) * 1.25F;
		tessellator.setColorOpaque_F(particleRed * f14, particleGreen * f14,
				particleBlue * f14);
		tessellator.addVertexWithUV(f11 - f1 * f10 - f4 * f10, f12 - f2 * f10,
				f13 - f3 * f10 - f5 * f10, f7, f9);
		tessellator.addVertexWithUV((f11 - f1 * f10) + f4 * f10,
				f12 + f2 * f10, (f13 - f3 * f10) + f5 * f10, f7, f8);
		tessellator.addVertexWithUV(f11 + f1 * f10 + f4 * f10, f12 + f2 * f10,
				f13 + f3 * f10 + f5 * f10, f6, f8);
		tessellator.addVertexWithUV((f11 + f1 * f10) - f4 * f10,
				f12 - f2 * f10, (f13 + f3 * f10) - f5 * f10, f6, f9);
	}
}

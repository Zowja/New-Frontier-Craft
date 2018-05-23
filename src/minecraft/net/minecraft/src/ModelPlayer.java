package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class ModelPlayer extends ModelBiped {
	
	public ModelPlayer(float f){
		this(f, 0.0F);
	}
	
	public ModelPlayer(float f, float f1){
		field_1279_h = false;
		field_1278_i = false;
		isSneak = false;
		bipedCloak = new ModelRenderer(0, 0, 64, 64);
		bipedCloak.addBox(-5F, 0.0F, -1F, 10, 16, 1, f);
		bipedEars = new ModelRenderer(24, 0, 64, 64);
		bipedEars.addBox(-3F, -6F, -1F, 6, 6, 1, f);
		field_178734_a = new ModelRenderer(48, 48, 64, 64);
        field_178734_a.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, f + 0.25F);
        field_178734_a.setRotationPoint(5.0F, 2.0F, 0.0F);
        field_178732_b = new ModelRenderer(40, 32, 64, 64);
        field_178732_b.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, f + 0.25F);
        field_178732_b.setRotationPoint(-5.0F, 2.0F, 10.0F);
		field_178733_c = new ModelRenderer(0, 48, 64, 64);
        field_178733_c.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, f + 0.25F);
        field_178733_c.setRotationPoint(1.9F, 12.0F, 0.0F);
        field_178731_d = new ModelRenderer(0, 32, 64, 64);
        field_178731_d.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, f + 0.25F);
        field_178731_d.setRotationPoint(-1.9F, 12.0F, 0.0F);
        field_178730_v = new ModelRenderer(16, 32, 64, 64);
        field_178730_v.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, f + 0.25F);
        field_178730_v.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bipedLeftArm = new ModelRenderer(32, 48, 64, 64);
        this.bipedLeftArm.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, f);
        this.bipedLeftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
        this.bipedLeftLeg = new ModelRenderer(16, 48, 64, 64);
        this.bipedLeftLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, f);
        this.bipedLeftLeg.setRotationPoint(1.9F, 12.0F, 0.0F);
		bipedHead = new ModelRenderer(0, 0, 64, 64);
		bipedHead.addBox(-4F, -8F, -4F, 8, 8, 8, f);
		bipedHead.setRotationPoint(0.0F, 0.0F + f1, 0.0F);
		bipedHeadwear = new ModelRenderer(32, 0, 64, 64);
		bipedHeadwear.addBox(-4F, -8F, -4F, 8, 8, 8, f + 0.5F);
		bipedHeadwear.setRotationPoint(0.0F, 0.0F + f1, 0.0F);
		bipedBody = new ModelRenderer(16, 16, 64, 64);
		bipedBody.addBox(-4F, 0.0F, -2F, 8, 12, 4, f);
		bipedBody.setRotationPoint(0.0F, 0.0F + f1, 0.0F);
		bipedRightArm = new ModelRenderer(40, 16, 64, 64);
		bipedRightArm.addBox(-3F, -2F, -2F, 4, 12, 4, f);
		bipedRightArm.setRotationPoint(-5F, 2.0F + f1, 0.0F);
		bipedRightLeg = new ModelRenderer(0, 16, 64, 64);
		bipedRightLeg.addBox(-2F, 0.0F, -2F, 4, 12, 4, f);
		bipedRightLeg.setRotationPoint(-2F, 12F + f1, 0.0F);
	}
	
	public void render(float f, float f1, float f2, float f3, float f4, float f5){
		super.render(f, f1, f2, f3, f4, f5);
		GL11.glPushMatrix();
		field_178734_a.render(f5);
		field_178732_b.render(f5);
		field_178733_c.render(f5);
		field_178731_d.render(f5);
		field_178730_v.render(f5);
		GL11.glPopMatrix();
	}
	
	public void setRotationAngles(float f, float f1, float f2, float f3,
			float f4, float f5){
		super.setRotationAngles(f, f1, f2, f3, f4, f5);
		func_178685_a(this.bipedLeftLeg, this.field_178733_c);
	     func_178685_a(this.bipedRightLeg, this.field_178731_d);
	      func_178685_a(this.bipedLeftArm, this.field_178734_a);
	       func_178685_a(this.bipedRightArm, this.field_178732_b);
	        func_178685_a(this.bipedBody, this.field_178730_v);
	}
	
	public static void func_178685_a(ModelRenderer p_178685_0_, ModelRenderer p_178685_1_)
    {
        p_178685_1_.rotateAngleX = p_178685_0_.rotateAngleX;
        p_178685_1_.rotateAngleY = p_178685_0_.rotateAngleY;
        p_178685_1_.rotateAngleZ = p_178685_0_.rotateAngleZ;
        p_178685_1_.rotationPointX = p_178685_0_.rotationPointX;
        p_178685_1_.rotationPointY = p_178685_0_.rotationPointY;
        p_178685_1_.rotationPointZ = p_178685_0_.rotationPointZ;
    }
	
	
	 public ModelRenderer field_178734_a;
	 public ModelRenderer field_178732_b;
	 public ModelRenderer field_178733_c;
	 public ModelRenderer field_178731_d;
	 public ModelRenderer field_178730_v;

}

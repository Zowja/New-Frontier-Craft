package net.minecraft.src;

public class ModelPlayerAlex extends ModelPlayer {
	
	public ModelPlayerAlex(float f) {
		this(f, 0f);
	}

	public ModelPlayerAlex(float f, float f1){
		super(f, f1);
		field_178734_a = new ModelRenderer(48, 48, 64, 64);
        field_178734_a.addBox(-1.0F, -2.0F, -2.0F, 3, 12, 4, f + 0.25F);
        field_178734_a.setRotationPoint(5.0F, 2.5F, 0.0F);
        field_178732_b = new ModelRenderer(40, 32, 64, 64);
        field_178732_b.addBox(-2.0F, -2.0F, -2.0F, 3, 12, 4, f + 0.25F);
        field_178732_b.setRotationPoint(-5.0F, 2.5F, 10.0F);
        bipedLeftArm = new ModelRenderer(32, 48, 64, 64);
        bipedLeftArm.addBox(-1.0F, -2.0F, -2.0F, 3, 12, 4, f);
        bipedLeftArm.setRotationPoint(5.0F, 2.5F, 0.0F);
        bipedRightArm = new ModelRenderer(40, 16, 64, 64);
		bipedRightArm.addBox(-2F, -2F, -2F, 3, 12, 4, f);
		bipedRightArm.setRotationPoint(-5F, 2.5F + f1, 0.0F);

	}

}

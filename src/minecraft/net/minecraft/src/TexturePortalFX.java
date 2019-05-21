// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import net.minecraft.client.Minecraft;

// Referenced classes of package net.minecraft.src:
//            TextureFX, Block, BlockPortal, MathHelper

public class TexturePortalFX extends TextureFX {
	
	public TexturePortalFX(){
		this(16);
	}
	
	public TexturePortalFX(int r) {
		super(Block.portal.blockIndexInTexture);
		this.res = r;
		imageData = new byte[r * r * 4];
		portalTickCounter = 0;
		portalTextureData = new byte[32][r * r * 4];
		Random random = new Random(100L);
		for (int i = 0; i < 32; i++) {
			for (int j = 0; j < r; j++) {
				for (int k = 0; k < r; k++) {
					float f = 0.0F;
					for (int l = 0; l < 2; l++) {
						float f1 = l * (r / 2);
						float f2 = l * (r / 2);
						float f3 = (((float) j - f1) / r) * 2.0F;
						float f4 = (((float) k - f2) / r) * 2.0F;
						if (f3 < -1F) {
							f3 += 2.0F;
						}
						if (f3 >= 1.0F) {
							f3 -= 2.0F;
						}
						if (f4 < -1F) {
							f4 += 2.0F;
						}
						if (f4 >= 1.0F) {
							f4 -= 2.0F;
						}
						float f5 = f3 * f3 + f4 * f4;
						float f6 = (float) Math.atan2(f4, f3)
								+ ((((float) i / 32F) * 3.141593F * 2.0F - f5 * 10F) + (float) (l * 2))
										* (float) (l * 2 - 1);
						f6 = (MathHelper.sin(f6) + 1.0F) / 2.0F;
						f6 /= f5 + 1.0F;
						f += f6 * 0.5F;
					}

					f += random.nextFloat() * 0.1F;
					int i1 = (int) (f * 100F + 155F);
					int j1 = (int) (f * f * 200F + 55F);
					int k1 = (int) (f * f * f * f * 255F);
					int l1 = (int) (f * 100F + 155F);
					int i2 = k * r + j;
					portalTextureData[i][i2 * 4 + 0] = (byte) j1;
					portalTextureData[i][i2 * 4 + 1] = (byte) k1;
					portalTextureData[i][i2 * 4 + 2] = (byte) i1;
					portalTextureData[i][i2 * 4 + 3] = (byte) l1;
				}

			}

		}
	}

	public TexturePortalFX(Minecraft mc, int res) {
		this(res);
		init(mc);
	}

	public void onTick() {
		portalTickCounter++;
		if(isCustom)
        {
        	System.arraycopy(allImages[portalTickCounter%allImages.length], 0, imageData, 0, allImages[portalTickCounter%allImages.length].length);
        	return;
        }
		byte abyte0[] = portalTextureData[portalTickCounter & 0x1f];
		for (int i = 0; i < res * res; i++) {
			int j = abyte0[i * 4 + 0] & 0xff;
			int k = abyte0[i * 4 + 1] & 0xff;
			int l = abyte0[i * 4 + 2] & 0xff;
			int i1 = abyte0[i * 4 + 3] & 0xff;
			if (anaglyphEnabled) {
				int j1 = (j * 30 + k * 59 + l * 11) / 100;
				int k1 = (j * 30 + k * 70) / 100;
				int l1 = (j * 30 + l * 70) / 100;
				j = j1;
				k = k1;
				l = l1;
			}
			imageData[i * 4 + 0] = (byte) j;
			imageData[i * 4 + 1] = (byte) k;
			imageData[i * 4 + 2] = (byte) l;
			imageData[i * 4 + 3] = (byte) i1;
		}

	}

	public void init(Minecraft mc) {
		try {
        	if(mc.texturePackList.selectedTexturePack.getResourceAsStream("/custom_portal.png") != null)
        	{
        		BufferedImage b = ImageIO.read(mc.texturePackList.selectedTexturePack.getResourceAsStream("/custom_portal.png"));
        		imageData = new byte[b.getWidth()*b.getWidth()*4];
        		allImages = new byte[b.getHeight()/b.getWidth()][b.getWidth()*b.getWidth()*4];
        		for(int i = 0; i < b.getHeight()/b.getWidth(); i++)
        		{
        			int[] tmp = new int[b.getWidth()*b.getWidth()];
        			b.getRGB(0, i*b.getWidth(), b.getWidth(), b.getWidth(), tmp, 0, b.getWidth());
        			for(int i1 = 0; i1 < tmp.length; i1++)
        			{
        				allImages[i][i1 * 4 + 0] = (byte)((tmp[i1] >> 16) & 0xff);
        				allImages[i][i1 * 4 + 1] = (byte)((tmp[i1] >> 8) & 0xff);
        				allImages[i][i1 * 4 + 2] = (byte)((tmp[i1]) & 0xff);
        				allImages[i][i1 * 4 + 3] = (byte)((tmp[i1] >> 24) & 0xff);
        			}
        		}
        		
        		res = b.getWidth();
        		isCustom = true;
        		return;
        	}
        } catch (IOException e) { }
	}

	private int portalTickCounter;
	private byte portalTextureData[][];
}

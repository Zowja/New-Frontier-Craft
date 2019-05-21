// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import net.minecraft.client.Minecraft;

// Referenced classes of package net.minecraft.src:
//            TextureFX, Block, BlockFire

public class TextureFlamesFX extends TextureFX
{

	public TextureFlamesFX(int i)
    {
        this(i, 16);
    }

    public TextureFlamesFX(int i, int r)
    {
        super(Block.fire.blockIndexInTexture + i * 16);
    	res = r;
        imageData = new byte[r*r*4];
        field_1133_g = new float[r*(r+(r/4))];
        field_1132_h = new float[r*(r+(r/4))];
        loops = res/16;
        tick = 0;
    }
    
    public TextureFlamesFX(Minecraft mc, int i, int j){
    	this(i, j);
    	init(mc, i);
    }
    
    public void init(Minecraft mc, int texture)
    {
    	try {
    		String textureName = texture == 0 ? "/custom_fire_n_s.png" : "/custom_fire_e_w.png";
        	if(mc.texturePackList.selectedTexturePack.getResourceAsStream(textureName) != null)
        	{
        		BufferedImage b = ImageIO.read(mc.texturePackList.selectedTexturePack.getResourceAsStream(textureName));
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
    
    public void onTick()
    {
    	if(isCustom)
        {
        	tick++;
        	System.arraycopy(allImages[tick%allImages.length], 0, imageData, 0, allImages[tick%allImages.length].length);
        	return;
        }
    	int h = res+(res/4);
    	//Ticks multiple times to make the flames go faster
    	loop = 0; 

        do {
        for(int i = 0; i < res; i++)
        {
            for(int j = 0; j < h; j++)
            {
                int l = h-(res/8);
                float f1 = field_1133_g[i + ((j + 1) % h) * res] * (float)l;
                
                for(int i1 = i - 1; i1 <= i + 1; i1++)
                {
                    for(int k1 = j; k1 <= j + 1; k1++)
                    {
                        int i2 = i1;
                        int k2 = k1;
                        if(i2 >= 0 && k2 >= 0 && i2 < res && k2 < h)
                        {
                            f1 += field_1133_g[i2 + k2 * res];
                        }
                        l++;
                    }

                }
                
                field_1132_h[i + j * res] = f1 / ((float)l * (1.01F+0.8F/res));
                if(j >= h - (res/16))
                {
                    field_1132_h[i + j * res] = (float)(Math.random() * Math.random() * Math.random() * (3F+(float)res/16F) + Math.random() * 0.10000000149011612D + 0.20000000298023224D);
                }
            }

        }
	
        float af[] = field_1132_h;
        field_1132_h = field_1133_g;
        field_1133_g = af;
        for(int k = 0; k < res*res; k++)
        {
            float f = field_1133_g[k] * 1.8F;
            if(f > 1.0F)
            {
                f = 1.0F;
            }
            if(f < 0.0F)
            {
                f = 0.0F;
            }
            float f2 = f;
            int j1 = (int)(f2 * 155F + 100F);
            int l1 = (int)(f2 * f2 * 255F);
            int j2 = (int)(f2 * f2 * f2 * f2 * f2 * f2 * f2 * f2 * f2 * f2 * 255F);
            char c = '\377';
            if(f2 < 0.5F)
            {
                c = '\0';
            }
            f2 = (f2 - 0.5F) * 2.0F;
            if(anaglyphEnabled)
            {
                int l2 = (j1 * 30 + l1 * 59 + j2 * 11) / 100;
                int i3 = (j1 * 30 + l1 * 70) / 100;
                int j3 = (j1 * 30 + j2 * 70) / 100;
                j1 = l2;
                l1 = i3;
                j2 = j3;
            }
            imageData[k * 4 + 0] = (byte)j1;
            imageData[k * 4 + 1] = (byte)l1;
            imageData[k * 4 + 2] = (byte)j2;
            imageData[k * 4 + 3] = (byte)c;
        }
        loop++;
        } while (loop < loops);

    }
    
    int loop, loops, tick;
    protected float field_1133_g[];
    protected float field_1132_h[];
}

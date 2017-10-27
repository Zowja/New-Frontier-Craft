// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.IntBuffer;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            GLAllocation, RenderEngine, Tessellator, GameSettings, 
//            ChatAllowedCharacters

public class FontRenderer
{

    public FontRenderer(GameSettings gamesettings, String s, RenderEngine renderengine)
    {
    	FONT_HEIGHT = 9;
        charWidth = new int[256];
        fontTextureName = 0;
        buffer = GLAllocation.createDirectIntBuffer(1024 /*GL_FRONT_LEFT*/);
        BufferedImage bufferedimage;
        try
        {
            bufferedimage = ImageIO.read((net.minecraft.src.RenderEngine.class).getResourceAsStream(s));
        }
        catch(IOException ioexception)
        {
            throw new RuntimeException(ioexception);
        }
        int i = bufferedimage.getWidth();
        int j = bufferedimage.getHeight();
        int ai[] = new int[i * j];
        bufferedimage.getRGB(0, 0, i, j, ai, 0, i);
        for(int k = 0; k < 256; k++)
        {
            int l = k % 16;
            int k1 = k / 16;
            int j2 = 7;
            do
            {
                if(j2 < 0)
                {
                    break;
                }
                int i3 = l * 8 + j2;
                boolean flag = true;
                for(int l3 = 0; l3 < 8 && flag; l3++)
                {
                    int i4 = (k1 * 8 + l3) * i;
                    int k4 = ai[i3 + i4] & 0xff;
                    if(k4 > 0)
                    {
                        flag = false;
                    }
                }

                if(!flag)
                {
                    break;
                }
                j2--;
            } while(true);
            if(k == 32)
            {
                j2 = 2;
            }
            charWidth[k] = j2 + 2;
        }

        fontTextureName = renderengine.allocateAndSetupTexture(bufferedimage);
        fontDisplayLists = GLAllocation.generateDisplayLists(288);
        Tessellator tessellator = Tessellator.instance;
        for(int i1 = 0; i1 < 256; i1++)
        {
            GL11.glNewList(fontDisplayLists + i1, 4864 /*GL_COMPILE*/);
            tessellator.startDrawingQuads();
            int l1 = (i1 % 16) * 8;
            int k2 = (i1 / 16) * 8;
            float f = 7.99F;
            float f1 = 0.0F;
            float f2 = 0.0F;
            tessellator.addVertexWithUV(0.0D, 0.0F + f, 0.0D, (float)l1 / 128F + f1, ((float)k2 + f) / 128F + f2);
            tessellator.addVertexWithUV(0.0F + f, 0.0F + f, 0.0D, ((float)l1 + f) / 128F + f1, ((float)k2 + f) / 128F + f2);
            tessellator.addVertexWithUV(0.0F + f, 0.0D, 0.0D, ((float)l1 + f) / 128F + f1, (float)k2 / 128F + f2);
            tessellator.addVertexWithUV(0.0D, 0.0D, 0.0D, (float)l1 / 128F + f1, (float)k2 / 128F + f2);
            tessellator.draw();
            GL11.glTranslatef(charWidth[i1], 0.0F, 0.0F);
            GL11.glEndList();
        }

        for(int j1 = 0; j1 < 32; j1++)
        {
            int i2 = (j1 >> 3 & 1) * 85;
            int l2 = (j1 >> 2 & 1) * 170 + i2;
            int j3 = (j1 >> 1 & 1) * 170 + i2;
            int k3 = (j1 >> 0 & 1) * 170 + i2;
            if(j1 == 6)
            {
                l2 += 85;
            }
            boolean flag1 = j1 >= 16;
            if(gamesettings.anaglyph)
            {
                int j4 = (l2 * 30 + j3 * 59 + k3 * 11) / 100;
                int l4 = (l2 * 30 + j3 * 70) / 100;
                int i5 = (l2 * 30 + k3 * 70) / 100;
                l2 = j4;
                j3 = l4;
                k3 = i5;
            }
            if(flag1)
            {
                l2 /= 4;
                j3 /= 4;
                k3 /= 4;
            }
            GL11.glNewList(fontDisplayLists + 256 + j1, 4864 /*GL_COMPILE*/);
            GL11.glColor3f((float)l2 / 255F, (float)j3 / 255F, (float)k3 / 255F);
            GL11.glEndList();
        }

    }

    public void drawStringWithShadow(String s, int i, int j, int k)
    {
        renderString(s, i + 1, j + 1, k, true);
        drawString(s, i, j, k);
    }

    public void drawString(String s, int i, int j, int k)
    {
        renderString(s, i, j, k, false);
    }

    public void renderString(String s, int i, int j, int k, boolean flag)
    {
        if(s == null)
        {
            return;
        }
        if(flag)
        {
            int l = k & 0xff000000;
            k = (k & 0xfcfcfc) >> 2;
            k += l;
        }
        GL11.glBindTexture(3553 /*GL_TEXTURE_2D*/, fontTextureName);
        float f = (float)(k >> 16 & 0xff) / 255F;
        float f1 = (float)(k >> 8 & 0xff) / 255F;
        float f2 = (float)(k & 0xff) / 255F;
        float f3 = (float)(k >> 24 & 0xff) / 255F;
        if(f3 == 0.0F)
        {
            f3 = 1.0F;
        }
        GL11.glColor4f(f, f1, f2, f3);
        buffer.clear();
        GL11.glPushMatrix();
        GL11.glTranslatef(i, j, 0.0F);
        for(int i1 = 0; i1 < s.length(); i1++)
        {
            for(; s.length() > i1 + 1 && s.charAt(i1) == '\247'; i1 += 2)
            {
                int j1 = "0123456789abcdef".indexOf(s.toLowerCase().charAt(i1 + 1));
                if(j1 < 0 || j1 > 15)
                {
                    j1 = 15;
                }
                buffer.put(fontDisplayLists + 256 + j1 + (flag ? 16 : 0));
                if(buffer.remaining() == 0)
                {
                    buffer.flip();
                    GL11.glCallLists(buffer);
                    buffer.clear();
                }
            }

            if(i1 < s.length())
            {
                int k1 = ChatAllowedCharacters.allowedCharacters.indexOf(s.charAt(i1));
                if(k1 >= 0)
                {
                    buffer.put(fontDisplayLists + k1 + 32);
                }
            }
            if(buffer.remaining() == 0)
            {
                buffer.flip();
                GL11.glCallLists(buffer);
                buffer.clear();
            }
        }

        buffer.flip();
        GL11.glCallLists(buffer);
        GL11.glPopMatrix();
    }

    public static int getStringWidth(String s)
    {
        if(s == null)
        {
            return 0;
        }
        int i = 0;
        for(int j = 0; j < s.length(); j++)
        {
            if(s.charAt(j) == '\247')
            {
                j++;
                continue;
            }
            int k = ChatAllowedCharacters.allowedCharacters.indexOf(s.charAt(j));
            if(k >= 0)
            {
                i += charWidth[k + 32];
            }
        }

        return i;
    }

    public void func_27278_a(String s, int i, int j, int k, int l)
    {
        String as[] = s.split("\n");
        if(as.length > 1)
        {
            for(int i1 = 0; i1 < as.length; i1++)
            {
                func_27278_a(as[i1], i, j, k, l);
                j += func_27277_a(as[i1], k);
            }

            return;
        }
        String as1[] = s.split(" ");
        int j1 = 0;
        do
        {
            if(j1 >= as1.length)
            {
                break;
            }
            String s1;
            for(s1 = (new StringBuilder()).append(as1[j1++]).append(" ").toString(); j1 < as1.length && getStringWidth((new StringBuilder()).append(s1).append(as1[j1]).toString()) < k; s1 = (new StringBuilder()).append(s1).append(as1[j1++]).append(" ").toString()) { }
            int k1;
            for(; getStringWidth(s1) > k; s1 = s1.substring(k1))
            {
                for(k1 = 0; getStringWidth(s1.substring(0, k1 + 1)) <= k; k1++) { }
                if(s1.substring(0, k1).trim().length() > 0)
                {
                    drawString(s1.substring(0, k1), i, j, l);
                    j += 8;
                }
            }

            if(s1.trim().length() > 0)
            {
                drawString(s1, i, j, l);
                j += 8;
            }
        } while(true);
    }

    public int func_27277_a(String s, int i)
    {
        String as[] = s.split("\n");
        if(as.length > 1)
        {
            int j = 0;
            for(int k = 0; k < as.length; k++)
            {
                j += func_27277_a(as[k], i);
            }

            return j;
        }
        String as1[] = s.split(" ");
        int l = 0;
        int i1 = 0;
        do
        {
            if(l >= as1.length)
            {
                break;
            }
            String s1;
            for(s1 = (new StringBuilder()).append(as1[l++]).append(" ").toString(); l < as1.length && getStringWidth((new StringBuilder()).append(s1).append(as1[l]).toString()) < i; s1 = (new StringBuilder()).append(s1).append(as1[l++]).append(" ").toString()) { }
            int j1;
            for(; getStringWidth(s1) > i; s1 = s1.substring(j1))
            {
                for(j1 = 0; getStringWidth(s1.substring(0, j1 + 1)) <= i; j1++) { }
                if(s1.substring(0, j1).trim().length() > 0)
                {
                    i1 += 8;
                }
            }

            if(s1.trim().length() > 0)
            {
                i1 += 8;
            }
        } while(true);
        if(i1 < 8)
        {
            i1 += 8;
        }
        return i1;
    }
    
    public int splitStringWidth(String par1Str, int par2) {
		return this.listFormattedStringToWidth(par1Str, par2).size();
	}

	public void drawSplitString(String par1Str, int par2, int par3, int par4,
			int par5) {
		par1Str = this.trimStringNewline(par1Str);
		this.renderSplitString(par1Str, par2, par3, par4, false);
	}
	
	public void drawSplitStringCentered(String par1Str, int par2, int par3, int par4,
			int par5) {
		par1Str = this.trimStringNewline(par1Str);
		this.renderSplitStringCentered(par1Str, par2, par3, par4, false);
	}

	private String trimStringNewline(String par1Str) {
		while (par1Str != null && par1Str.endsWith("\n")) {
			par1Str = par1Str.substring(0, par1Str.length() - 1);
		}

		return par1Str;
	}

	private void renderSplitString(String par1Str, int par2, int par3,
			int par4, boolean par5) {
		List var6 = this.listFormattedStringToWidth(par1Str, par4);

		for (Iterator var7 = var6.iterator(); var7.hasNext(); par3 += 8) {
			String var8 = (String) var7.next();
			this.renderString(var8, par2, par3, 0, par5);
		}
	}
	
	private void renderSplitStringCentered(String par1Str, int par2, int par3,
			int par4, boolean par5) {
		List var6 = this.listFormattedStringToWidth(par1Str, par4);

		for (Iterator var7 = var6.iterator(); var7.hasNext(); par3 += 8) {
			String var8 = (String) var7.next();
			int length = getStringWidth(var8);
			System.out.println(length);
			this.renderString(var8, par2 - (length/2), par3, 0, par5);
		}
	}

	public List listFormattedStringToWidth(String par1Str, int par2) {
		return Arrays.asList(this.wrapFormattedStringToWidth(par1Str, par2)
				.split("\n"));
	}

	String wrapFormattedStringToWidth(String par1Str, int par2) {
		int var3 = this.sizeStringToWidth(par1Str, par2);

		if (par1Str.length() <= var3) {
			return par1Str;
		} else {
			String var4 = par1Str.substring(0, var3);
			char var5 = par1Str.charAt(var3);
			boolean var6 = var5 == 32 || var5 == 10;
			String var7 = getFormatFromString(var4)
					+ par1Str.substring(var3 + (var6 ? 1 : 0));
			return var4 + "\n" + this.wrapFormattedStringToWidth(var7, par2);

		}
	}

	private static String getFormatFromString(String par0Str) {
		String var1 = "";
		int var2 = -1;
		int var3 = par0Str.length();

		while ((var2 = par0Str.indexOf(167, var2 + 1)) != -1) {
			if (var2 < var3 - 1) {
				char var4 = par0Str.charAt(var2 + 1);

			}
		}

		return var1;
	}

	private int sizeStringToWidth(String par1Str, int par2) {
		int var3 = par1Str.length();
		int var4 = 0;
		int var5 = 0;
		int var6 = -1;

		for (boolean var7 = false; var5 < var3; ++var5) {
			char var8 = par1Str.charAt(var5);

			switch (var8) {
			case 10:
				--var5;
				break;

			case 167:
				if (var5 < var3 - 1) {
					++var5;
					char var9 = par1Str.charAt(var5);

					if (var9 != 108 && var9 != 76) {
						if (var9 == 114 || var9 == 82) {
							var7 = false;
						}
					} else {
						var7 = true;
					}
				}

				break;

			case 32:
				var6 = var5;

			default:
				var4 += this.getCharWidth(var8);

				if (var7) {
					++var4;
				}
			}

			if (var8 == 10) {
				++var5;
				var6 = var5;
				break;
			}

			if (var4 > par2) {
				break;
			}
		}

		return var5 != var3 && var6 != -1 && var6 < var5 ? var6 : var5;
	}

	public int getCharWidth(char par1) {
		if (par1 == 167) {
			return -1;
		} else if (par1 == 32) {
			return 4;
		} else {
			int var2 = "\u00c0\u00c1\u00c2\u00c8\u00ca\u00cb\u00cd\u00d3\u00d4\u00d5\u00da\u00df\u00e3\u00f5\u011f\u0130\u0131\u0152\u0153\u015e\u015f\u0174\u0175\u017e\u0207\u0000\u0000\u0000\u0000\u0000\u0000\u0000 !\"#$%&\'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~\u0000\u00c7\u00fc\u00e9\u00e2\u00e4\u00e0\u00e5\u00e7\u00ea\u00eb\u00e8\u00ef\u00ee\u00ec\u00c4\u00c5\u00c9\u00e6\u00c6\u00f4\u00f6\u00f2\u00fb\u00f9\u00ff\u00d6\u00dc\u00f8\u00a3\u00d8\u00d7\u0192\u00e1\u00ed\u00f3\u00fa\u00f1\u00d1\u00aa\u00ba\u00bf\u00ae\u00ac\u00bd\u00bc\u00a1\u00ab\u00bb\u2591\u2592\u2593\u2502\u2524\u2561\u2562\u2556\u2555\u2563\u2551\u2557\u255d\u255c\u255b\u2510\u2514\u2534\u252c\u251c\u2500\u253c\u255e\u255f\u255a\u2554\u2569\u2566\u2560\u2550\u256c\u2567\u2568\u2564\u2565\u2559\u2558\u2552\u2553\u256b\u256a\u2518\u250c\u2588\u2584\u258c\u2590\u2580\u03b1\u03b2\u0393\u03c0\u03a3\u03c3\u03bc\u03c4\u03a6\u0398\u03a9\u03b4\u221e\u2205\u2208\u2229\u2261\u00b1\u2265\u2264\u2320\u2321\u00f7\u2248\u00b0\u2219\u00b7\u221a\u207f\u00b2\u25a0\u0000"
					.indexOf(par1);

			if (par1 > 0 && var2 != -1) {
				return charWidth[var2];
			} else {
				return 0;
			}
		}
	}

    private static int charWidth[];
    public int fontTextureName;
    private int fontDisplayLists;
    private IntBuffer buffer;
    public int FONT_HEIGHT;
}

// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import net.minecraft.client.Minecraft;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            GuiContainer, ContainerBookshelf, IInventory, FontRenderer, 
//            RenderEngine

public class GuiBookshelf extends GuiContainer {

	public GuiBookshelf(IInventory iinventory, TileEntityBookshelf iinventory1) {
		super(new ContainerBookshelf(iinventory, iinventory1));
		inventoryRows = 0;
		upperBookshelfInventory = iinventory;
		lowerBookshelfInventory = iinventory1;
		field_948_f = false;
		char c = '\336';
		int i = c - 108;
		inventoryRows = iinventory1.getSizeInventory() / 5;
		ySize = i + inventoryRows * 18;
	}

	protected void drawGuiContainerForegroundLayer() {
		fontRenderer.drawString(lowerBookshelfInventory.getInvName(), 8, 6,
				0x404040);
		fontRenderer.drawString(upperBookshelfInventory.getInvName(), 8,
				(ySize - 96) + 2, 0x404040);
	}

	protected void drawGuiContainerBackgroundLayer(float f) {
		int i = mc.renderEngine.getTexture("/NFC/shelf.png");
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		mc.renderEngine.bindTexture(i);
		int j = (width - xSize) / 2;
		int k = (height - ySize) / 2;
		drawTexturedModalRect(j, k, 0, 0, xSize, inventoryRows * 18 + 17);
		drawTexturedModalRect(j, k + inventoryRows * 18 + 17, 0, 126, xSize, 96);
	}

	private IInventory upperBookshelfInventory;
	private IInventory lowerBookshelfInventory;
	private int inventoryRows;
}

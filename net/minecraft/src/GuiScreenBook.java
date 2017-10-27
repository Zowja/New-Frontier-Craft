package net.minecraft.src;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import net.minecraft.client.Minecraft;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

public class GuiScreenBook extends GuiScreen {
	private static final Logger logger = LogManager.getLogger();
	private final EntityPlayer field_146468_g;
	private final ItemStack bookData;
	private final boolean isWritable;
	private boolean field_146481_r;
	private boolean field_146480_s;
	private int field_146479_t;
	private int field_146478_u = 192;
	private int field_146477_v = 192;
	private int pages = 1;
	private int currentPage;
	private NBTTagList pageStrings;
	private GuiScreenBook.NextPageButton field_146470_A;
	private GuiScreenBook.NextPageButton field_146471_B;
	private GuiButton field_146472_C;
	private GuiButton field_146469_F;
	private String date = "", author = "", title = "", origin = "";
	private static final String __OBFID = "CL_00000744";

	public GuiScreenBook(EntityPlayer par1EntityPlayer,
			ItemStack par2ItemStack, boolean writable) {
		this.field_146468_g = par1EntityPlayer;
		this.bookData = par2ItemStack;
		this.isWritable = writable;

		if (par2ItemStack.hasTagCompound()) {
			NBTTagCompound var4 = par2ItemStack.getTagCompound();
			
			if(var4.hasKey("book")){
				var4 = processBook(var4);
				this.bookData.setTagCompound(var4);
			}
			
			try {
				this.pageStrings = var4.getTagList("pages", 8);
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (!this.isWritable) {
				author = var4.getString("author");
				date = var4.getString("date");
				title = var4.getString("title");
				origin = var4.getString("origin");
			}

			if (this.pageStrings != null) {
				this.pages = this.pageStrings.tagCount();
				// Removed copying itself, appeared pointless
				if (this.pages < 1) {
					this.pages = 1;
				}
			}
		}

		if (this.pageStrings == null && writable) {
			this.pageStrings = new NBTTagList();
			this.pageStrings.appendTag(new NBTTagString(""));
			this.pages = 1;
		}
	}

	/**
	 * Called from the main game loop to update the screen.
	 */
	public void updateScreen() {
		super.updateScreen();
		++this.field_146479_t;
	}

	protected void mouseClicked(int i, int j, int k) {
		if (k == 0) {
			for (int l = 0; l < controlList.size(); l++) {
				GuiButton guibutton = (GuiButton) controlList.get(l);
				if (guibutton.mousePressed(mc, i, j)) {
					if (l == 0 || l == 1) {
						mc.sndManager.playSoundFX("random.page", 1.0F, 1.0F);
					} else {
						mc.sndManager.playSoundFX("random.click", 1.0F, 1.0F);
					}
					actionPerformed(guibutton);
				}
			}

		}
	}

	/**
	 * Adds the buttons (and other controls) to the screen in question.
	 */
	public void initGui() {
		this.controlList.clear();
		Keyboard.enableRepeatEvents(true);

		int var1 = (this.width - this.field_146478_u) / 2;
		byte var2 = 2;
		this.controlList
				.add(this.field_146470_A = new GuiScreenBook.NextPageButton(1,
						var1 + 120, var2 + 154, true));
		this.controlList
				.add(this.field_146471_B = new GuiScreenBook.NextPageButton(2,
						var1 + 38, var2 + 154, false));

		if (this.isWritable) {
			this.controlList
					.add(this.field_146472_C = new GuiButton(0,
							this.width / 2 + 2, 4 + this.field_146477_v, 98,
							20, "Done"));
			this.controlList.add(this.field_146469_F = new GuiButton(3,
					this.width / 2 - 100, 4 + this.field_146477_v, 98, 20,
					"Sign"));
		} else {
			this.currentPage = -1;
			this.controlList.add(this.field_146472_C = new GuiButton(0,
					this.width / 2 - 100, 4 + this.field_146477_v, "Done"));
		}
		this.func_146464_h();
	}

	/**
	 * "Called when the screen is unloaded. Used to disable keyboard repeat events."
	 */
	public void onGuiClosed() {
		Keyboard.enableRepeatEvents(false);
	}

	private void func_146464_h() {
		this.field_146470_A.field_146125_m = !this.field_146480_s
				&& (this.currentPage < this.pages - 1 || this.isWritable);
		this.field_146471_B.field_146125_m = !this.field_146480_s
				&& this.currentPage > 0;
		this.field_146472_C.field_146125_m = !this.isWritable
				|| !this.field_146480_s;

		if (this.isWritable) {
			this.field_146469_F.field_146125_m = this.field_146480_s;
			if (this.field_146480_s)
				this.field_146469_F.enabled = this.title.trim().length() > 0;
		}
	}

	protected void actionPerformed(GuiButton p_146284_1_) {
		if (p_146284_1_.enabled) {
			if (p_146284_1_.id == 0 && !this.field_146480_s) {
				this.mc.displayGuiScreen((GuiScreen) null);
				this.func_146462_a(false);
			} else if (p_146284_1_.id == 3 && this.isWritable
					&& !this.field_146480_s) {
				this.field_146480_s = true;
				this.field_146472_C.displayString = "Cancel";
				this.field_146469_F.displayString = "Sign and Finish";
			} else if (p_146284_1_.id == 1) {
				if (this.currentPage < this.pages - 1) {
					++this.currentPage;
				} else if (this.isWritable) {
					this.func_146461_i();

					if (this.currentPage < this.pages - 1) {
						++this.currentPage;
					}
				}
			} else if (p_146284_1_.id == 2) {
				if (this.currentPage > 0) {
					--this.currentPage;
				}
			} else if (p_146284_1_.id == 3 && this.field_146480_s) {
				this.func_146462_a(true);
				this.mc.displayGuiScreen((GuiScreen) null);
			} else if (p_146284_1_.id == 0 && this.field_146480_s) {
				this.field_146480_s = false;
				this.field_146472_C.displayString = "Done";
				this.field_146469_F.displayString = "Sign";
			}

			this.func_146464_h();
		}
	}

	private void func_146461_i() {
		if (this.pageStrings != null && this.pageStrings.tagCount() < 100) {
			this.pageStrings.appendTag(new NBTTagString(""));
			++this.pages;
			this.field_146481_r = true;
		}
	}

	/**
	 * Fired when a key is typed. This is the equivalent of
	 * KeyListener.keyTyped(KeyEvent e).
	 */
	protected void keyTyped(char par1, int par2) {
		super.keyTyped(par1, par2);

		if (this.isWritable) {
			if (this.field_146480_s) {
				this.func_146460_c(par1, par2);
			} else {
				this.func_146463_b(par1, par2);
			}
		}
	}

	private void func_146463_b(char p_146463_1_, int p_146463_2_) {
		switch (p_146463_1_) {
		case 22:
			this.tryAddingString(GuiScreen.getClipboardString());
			return;

		default:
			switch (p_146463_2_) {
			case 14:
				String var3 = this.func_146456_p();

				if (var3.length() > 0) {
					this.func_146457_a(var3.substring(0, var3.length() - 1));
				}

				return;

			case 28:
			case 156:
				this.tryAddingString("\n");
				return;

			default:
				if (ChatAllowedCharacters.isAllowedCharacter(p_146463_1_)) {
					this.tryAddingString(Character.toString(p_146463_1_));
				}
			}
		}
	}

	private void func_146460_c(char p_146460_1_, int p_146460_2_) {
		switch (p_146460_2_) {
		case 14:
			if (!this.title.isEmpty()) {
				this.title = this.title.substring(0, this.title.length() - 1);
				this.func_146464_h();
			}

			return;

		case 28:
		case 156:
			if (!this.title.isEmpty()) {
				this.func_146462_a(true);
				this.mc.displayGuiScreen((GuiScreen) null);
			}

			return;

		default:
			if (this.title.length() < 60
					&& ChatAllowedCharacters.isAllowedCharacter(p_146460_1_)) {
				this.title = this.title + Character.toString(p_146460_1_);
				this.func_146464_h();
				this.field_146481_r = true;
			} else if (this.title.length() < 20
					&& ChatAllowedCharacters.isAllowedCharacter(p_146460_1_)) {

			}
		}
	}

	private String func_146456_p() {
		return this.pageStrings != null && this.currentPage >= 0
				&& this.currentPage < this.pageStrings.tagCount() ? this.pageStrings
				.getStringTagAt(this.currentPage) : "";
	}

	private void func_146457_a(String p_146457_1_) {
		if (this.pageStrings != null && this.currentPage >= 0
				&& this.currentPage < this.pageStrings.tagCount()) {
			this.pageStrings.func_150304_a(this.currentPage,
					new NBTTagString(p_146457_1_));
			this.field_146481_r = true;
		}
	}

	/**
	 * Will add the string to the page if it does not go over the 15th line.
	 */
	private boolean tryAddingString(String newString) {
		String pageString = this.func_146456_p() + newString;
		int line = this.fontRenderer.splitStringWidth(pageString, 116);
		if (line <= 15) {
			this.func_146457_a(pageString);
			return true;
		}
		return false;
	}

	/**
	 * Draws the screen and all the components in it.
	 */
	public void drawScreen(int par1, int par2, float par3) {
		int i = mc.renderEngine.getTexture("/NFC/book.png");
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		mc.renderEngine.bindTexture(i);
		int var4 = (this.width - this.field_146478_u) / 2;
		byte var5 = 2;
		this.drawTexturedModalRect(var4, var5, 0, 0, this.field_146478_u,
				this.field_146477_v);
		String var6;
		String var7;
		int var8;

		if (this.field_146480_s) {
			var6 = this.title;

			if (this.isWritable) {
				if (this.field_146479_t / 6 % 2 == 0) {
					var6 = var6 + "_";
				}
			}
			
			this.fontRenderer.drawSplitStringCentered(var6, var4 + 36, var5 + 48, 116, 0);
			String var10 = this.field_146468_g.getCommandSenderName();
			int var11 = FontRenderer.getStringWidth(var10);
			this.fontRenderer.drawString(var10, var4 + 36 + (116 - var11) / 2,
					var5 + 100 + 10, 0);
			this.fontRenderer.drawSplitString("Signed By:", var4 + 68,
					var5 + 80, 116, 0);
			this.fontRenderer.drawSplitString("Title:", var4 + 82, var5 + 30,
					116, 0);
		} else if (this.currentPage < 0) {
			this.fontRenderer.drawSplitString("Signed By:", var4 + 69,
					var5 + 80, 116, 0);
			this.fontRenderer.drawSplitString("Title:", var4 + 82, var5 + 30,
					116, 0);
			int var11 = FontRenderer.getStringWidth(author);
			this.fontRenderer.drawString(author, var4 + 36 + (116 - var11) / 2,
					var5 + 100, 0);
			int var12 = FontRenderer.getStringWidth(date);
			this.fontRenderer.drawString(date, var4 + 36 + (116 - var12) / 2,
					var5 + 112, 0);
			int var13 = FontRenderer.getStringWidth(origin);
			this.fontRenderer.drawString(origin, var4 + 36 + (116 - var13) / 2,
					var5 + 134, 0);
			this.fontRenderer.drawSplitStringCentered(title, var4 + 94, var5 + 48, 116, 0);
		} else {
			var6 = "Page " + (this.currentPage + 1);
			var7 = "";

			if (this.pageStrings != null && this.currentPage >= 0
					&& this.currentPage < this.pageStrings.tagCount()) {
				var7 = this.pageStrings.getStringTagAt(this.currentPage);
			}

			if (this.isWritable) {
				if (this.field_146479_t / 6 % 2 == 0) {
					var7 = var7 + "_";
				}
			}

			var8 = this.fontRenderer.getStringWidth(var6);
			this.fontRenderer.drawString(var6, var4 - var8
					+ this.field_146478_u - 44, var5 + 16, 0);
			this.fontRenderer.drawSplitString(var7, var4 + 36, var5 + 16 + 16,
					116, 0);
		}

		super.drawScreen(par1, par2, par3);
	}

	private String getTitlePiece(String a, byte b) {
		if (b == 0) {
			if (a.length() > 19) {
				String s = a.substring(0, 19);
				return s.trim();
			} else {
				return a;
			}
		}
		if (b == 1) {
			if (a.length() > 39) {
				String s = a.substring(19, 39);
				return s.trim();
			} else if (a.length() < 20) {
				return "";
			} else {
				return a.substring(19, a.length());
			}

		}
		if (b == 2) {
			if (a.length() > 40) {
				String s = a.substring(40, a.length());
				return s.trim();
			} else {
				return "";
			}
		}
		return "String Get Failure";
	}

	public boolean doesGuiPauseGame() {
		return false;
	}

	private void func_146462_a(boolean p_146462_1_) {
		if (this.isWritable && this.field_146481_r) {
			if (this.pageStrings != null) {
				String var2;

				while (this.pageStrings.tagCount() > 1) {
					var2 = this.pageStrings
							.getStringTagAt(this.pageStrings.tagCount() - 1);

					if (var2.length() != 0) {
						break;
					}

					this.pageStrings.removeTag(this.pageStrings
							.tagCount() - 1);
				}

				if (this.bookData.hasTagCompound()) {
					NBTTagCompound var10 = this.bookData.getTagCompound();
					var10.setTag("pages", this.pageStrings);
				} else {
					this.bookData
							.setTagInfo("pages", this.pageStrings);
				}

				boolean sign = false;

				if (p_146462_1_) {
					sign = true;
					this.bookData.setTagInfo("author", new NBTTagString(
							this.field_146468_g.getCommandSenderName()));
					this.bookData.setTagInfo("title", new NBTTagString(
							this.title.trim()));
					String timeStamp = new SimpleDateFormat("MMMM d, yyyy")
							.format(Calendar.getInstance().getTime());
					this.bookData.setTagInfo("date", new NBTTagString(
							timeStamp));
					this.bookData.setTagInfo("origin", new NBTTagString(
							"Original"));
					this.bookData.func_150996_a(NFC.WrittenBook);
				}

				if(mc.isMultiplayerWorld())
				try {
					this.mc.getSendQueue().addToSendQueue(
							new Packet300CustomBook(sign, this.bookData
									.getTagCompound()));
				} catch (Exception var8) {
					logger.error("Couldn\'t send book info", var8);
				}

			}
		}
	}

	static class NextPageButton extends GuiButton {
		private final boolean field_146151_o;
		private static final String __OBFID = "CL_00000745";

		public NextPageButton(int par1, int par2, int par3, boolean par4) {
			super(par1, par2, par3, 23, 13, "");
			this.field_146151_o = par4;
		}

		public void drawButton(Minecraft p_146112_1_, int p_146112_2_,
				int p_146112_3_) {
			if (this.field_146125_m) {
				boolean var4 = p_146112_2_ >= this.xPosition
						&& p_146112_3_ >= this.yPosition
						&& p_146112_2_ < this.xPosition + 23
						&& p_146112_3_ < this.yPosition + 13;
				int i = p_146112_1_.renderEngine.getTexture("/NFC/book.png");
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
				p_146112_1_.renderEngine.bindTexture(i);
				int var5 = 0;
				int var6 = 192;

				if (var4) {
					var5 += 23;

				}

				if (!this.field_146151_o) {
					var6 += 13;
				}

				this.drawTexturedModalRect(this.xPosition, this.yPosition,
						var5, var6, 23, 13);
			}
		}
	}
	
	private NBTTagCompound processBook(NBTTagCompound tag){
		NBTTagCompound processed = new NBTTagCompound();
		processed.setTag("author", new NBTTagString(tag.getString("author")));
		processed.setTag("date", new NBTTagString(tag.getString("date")));
		processed.setTag("title", new NBTTagString(tag.getString("title")));
		processed.setTag("origin", new NBTTagString(tag.getString("origin")));
		
		String text = tag.getString("book");
		NBTTagList pages = new NBTTagList();
		int page = 1;
		int line = 0;
		String pageInProgress = "";
		
		while((line < text.length()) && (page <= 100)){
			if(text.charAt(line) == '\t'){
				pages.appendTag(new NBTTagString(pageInProgress));
				page++;
				pageInProgress = "";
				line++;
			}
			else if(text.charAt(line) == ' '){
				pageInProgress += " ";
				line++;
			} 
			else if(text.charAt(line) == '\n'){
				pageInProgress += "\n";
				line++;
			}
			else
			{
				String nextWord = "";
				if(text.charAt(line) == ' '){
					nextWord = " ";
					line++;
				} else
				while(line < text.length() && text.charAt(line) != ' ' && text.charAt(line) != '\t' && text.charAt(line) != '\n'){
					nextWord += text.charAt(line);
					line++;
				}
				String temp = pageInProgress + nextWord;
				System.out.println(temp);
				int lines = Minecraft.fontRenderer.splitStringWidth(temp, 116);
				if(lines >= 16){
					pages.appendTag(new NBTTagString(pageInProgress));
					page++;
					pageInProgress = "";
					line -= nextWord.length();
				}
				else {
					pageInProgress = temp;
				}
			}
		}
		pages.appendTag(new NBTTagString(pageInProgress));
		
		processed.setTag("pages", pages);
		
		return processed;
	}
}
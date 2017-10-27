// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.mojang.authlib.GameProfile;
import com.mojang.util.UUIDTypeAdapter;

// Referenced classes of package net.minecraft.src:
//            Block

public class Session {

	public Session(String s, String s1, String s2) {
		username = s;
		token = s1;
		uuid = s2;
		System.out.println("User: " + s + " Session: " + s1 + ":" + s2);
	}

	public String getSessionID() {
		return "token:" + this.token + ":" + this.uuid;
	}
	
	 public GameProfile getProfile()
	    {
	        try
	        {
	            UUID uuidhax = UUIDTypeAdapter.fromString(uuid);
	            return new GameProfile(uuidhax, username);
	        }
	        catch (IllegalArgumentException var2)
	        {
	            return new GameProfile((UUID)null, username);
	        }
	    }

	public static List registeredBlocksList;
	public String username;
	public String token;
	public String uuid;
	public String mpPassParameter;

	static {
		registeredBlocksList = new ArrayList();
		registeredBlocksList.add(Block.stone);
		registeredBlocksList.add(Block.cobblestone);
		registeredBlocksList.add(Block.brick);
		registeredBlocksList.add(Block.dirt);
		registeredBlocksList.add(Block.planks);
		registeredBlocksList.add(Block.wood);
		registeredBlocksList.add(Block.leaves);
		registeredBlocksList.add(Block.torchWood);
		registeredBlocksList.add(Block.stairSingle);
		registeredBlocksList.add(Block.glass);
		registeredBlocksList.add(Block.cobblestoneMossy);
		registeredBlocksList.add(Block.sapling);
		registeredBlocksList.add(Block.plantYellow);
		registeredBlocksList.add(Block.plantRed);
		registeredBlocksList.add(Block.mushroomBrown);
		registeredBlocksList.add(Block.mushroomRed);
		registeredBlocksList.add(Block.sand);
		registeredBlocksList.add(Block.gravel);
		registeredBlocksList.add(Block.sponge);
		registeredBlocksList.add(Block.cloth);
		registeredBlocksList.add(Block.oreCoal);
		registeredBlocksList.add(Block.oreIron);
		registeredBlocksList.add(Block.oreGold);
		registeredBlocksList.add(Block.blockSteel);
		registeredBlocksList.add(Block.blockGold);
		registeredBlocksList.add(Block.bookShelf);
		registeredBlocksList.add(Block.tnt);
		registeredBlocksList.add(Block.obsidian);
	}
}

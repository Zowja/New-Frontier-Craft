package net.minecraft.src;

import java.util.Map;
import com.google.common.collect.Maps;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.minecraft.InsecureTextureException;
import com.mojang.authlib.minecraft.MinecraftProfileTexture;
import com.mojang.authlib.minecraft.MinecraftProfileTexture.Type;
import com.mojang.authlib.properties.PropertyMap;

import net.minecraft.client.Minecraft;

public class SkinManager {
	
	static Minecraft mc;
	
	public SkinManager(Minecraft mc){
		SkinManager.mc = mc;
	}
	
	public static void getSkin(final GameProfile profile, EntityPlayer player){
		final Map<Type, MinecraftProfileTexture> map = Maps.<Type, MinecraftProfileTexture>newHashMap();
		
            profile.getProperties().clear();
            profile.getProperties().putAll(getProfileProperties(profile));
            map.putAll(mc.sessionService.getTextures(profile, false));
            
            //Removed "secure" textures grab
		
		
		 if (map.containsKey(Type.SKIN))
         {
			 MinecraftProfileTexture texture = (MinecraftProfileTexture)map.get(Type.SKIN);
             player.skinUrl = texture.getUrl();
             String grab = texture.getMetadata("model");
             // Currently returns null for steve skin
             player.modelAlex = !(grab == null);
         }
		 
	 }
	
	public static PropertyMap getProfileProperties(GameProfile profile)
    {
			profileProperties.clear();
            GameProfile gameprofile = mc.sessionService.fillProfileProperties(profile, false);
            profileProperties.putAll(gameprofile.getProperties());
            return profileProperties;
    }
	
	private static PropertyMap profileProperties = new PropertyMap();

}

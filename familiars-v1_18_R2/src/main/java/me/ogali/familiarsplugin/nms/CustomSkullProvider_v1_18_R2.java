package me.ogali.familiarsplugin.nms;


import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import me.ogali.familiarsplugin.exceptions.ExistingSkullException;
import me.ogali.familiarsplugin.utils.TextureUtils;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.lang.reflect.Field;
import java.util.Base64;
import java.util.UUID;

public class CustomSkullProvider_v1_18_R2 extends CustomSkullProvider {

    @Override
    public ItemStack createAndGetCustomSkull(EntityType entityType) {
        GameProfile gameProfile = new GameProfile(UUID.randomUUID(), null);

        ItemStack skullItem = new ItemStack(Material.PLAYER_HEAD);

        try {
            byte[] base64EncodedByteArray = Base64.getEncoder().encode(String.format("{textures:{SKIN:{url:\"%s\"}}}",
                    new Object[]{TextureUtils.getMinecrafTextureUrlByEntityType(entityType)}).getBytes());
            gameProfile.getProperties().put("textures", new Property("textures", new String(base64EncodedByteArray)));
        } catch (ExistingSkullException e) {
            skullItem = new ItemStack(TextureUtils.getSkullByEntityType(entityType));
        }

        SkullMeta skullItemMeta = (SkullMeta) skullItem.getItemMeta();

        try {
            Field profileField = skullItemMeta.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(skullItemMeta, gameProfile);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        skullItem.setItemMeta(skullItemMeta);
        return skullItem;
    }

}

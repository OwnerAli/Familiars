package me.ogali.familiarsplugin.nms;

import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;

import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;

public abstract class CustomSkullProvider {

    private static CustomSkullProvider instance;

    static {
        try {
            final String internalVersionName = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
            final String packageName = CustomCreatureProvider.class.getPackage().getName();
            instance = (CustomSkullProvider) Class.forName(packageName + ".CustomSkullProvider_" + internalVersionName).getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException |
                 NoSuchMethodException e) {
            Bukkit.getLogger().log(Level.SEVERE, "Error while loading: familiars doesn't support your minecraft server version yet! " +
                    "Do you want support that to change? Let me know on discord!");
        }
    }

    public abstract ItemStack createAndGetCustomSkull(EntityType entityType);

    public static ItemStack getCustomSkull(EntityType entityType) {
        return instance.createAndGetCustomSkull(entityType);
    }

}

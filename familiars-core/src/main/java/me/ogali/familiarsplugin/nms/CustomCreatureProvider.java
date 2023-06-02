package me.ogali.familiarsplugin.nms;

import me.ogali.familiarsplugin.familiars.impl.TamedFamiliar;
import me.ogali.familiarsplugin.familiars.impl.UntamedFamiliar;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;

public abstract class CustomCreatureProvider {

    private static CustomCreatureProvider instance;

    static {
        try {
            final String internalVersionName = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
            final String packageName = CustomCreatureProvider.class.getPackage().getName();
            instance = (CustomCreatureProvider) Class.forName(packageName + ".CustomCreatureProvider_" + internalVersionName).getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException |
                 NoSuchMethodException e) {
            Bukkit.getLogger().log(Level.SEVERE, "Error while loading: familiars doesn't support your minecraft server version yet! " +
                    "Do you want support that to change? Let me know on discord!");
        }
    }

    public abstract void spawnCustomMobInCraftWorld(Player owner, Location location);

    public abstract TamedFamiliar spawnCustomMobInCraftWorldWithPetPathfinderGoals(Player owner, UntamedFamiliar untamedFamiliar);

    public static void spawnUntamedFamiliar(Player owner, Location location) {
        instance.spawnCustomMobInCraftWorld(owner, location);
    }

    public static TamedFamiliar spawnTamedFamiliar(Player owner, UntamedFamiliar untamedFamiliar) {
        return instance.spawnCustomMobInCraftWorldWithPetPathfinderGoals(owner, untamedFamiliar);
    }

}

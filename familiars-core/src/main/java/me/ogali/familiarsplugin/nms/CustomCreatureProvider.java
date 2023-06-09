package me.ogali.familiarsplugin.nms;

import me.ogali.familiarsplugin.familiars.impl.Familiar;
import me.ogali.familiarsplugin.familiars.impl.impl.TamedLivingFamiliar;
import me.ogali.familiarsplugin.familiars.impl.impl.UntamedLivingFamiliar;
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

    public abstract void spawnCustomMobInCraftWorld(Familiar familiar, Location location);

    public abstract TamedLivingFamiliar spawnCustomMobInCraftWorldWithPetPathfinderGoals(Player owner, UntamedLivingFamiliar untamedFamiliar);

    public static void spawnUntamedFamiliar(Familiar familiar, Location location) {
        instance.spawnCustomMobInCraftWorld(familiar, location);
    }

    public static TamedLivingFamiliar spawnTamedFamiliar(Player owner, UntamedLivingFamiliar untamedFamiliar) {
        return instance.spawnCustomMobInCraftWorldWithPetPathfinderGoals(owner, untamedFamiliar);
    }

}

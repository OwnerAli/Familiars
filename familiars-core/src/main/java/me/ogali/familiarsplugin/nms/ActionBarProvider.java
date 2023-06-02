package me.ogali.familiarsplugin.nms;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;

public abstract class ActionBarProvider {

    private static ActionBarProvider instance;

    static {
        try {
            final String internalVersionName = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
            final String packageName = ActionBarProvider.class.getPackage().getName();
            instance = (ActionBarProvider) Class.forName(packageName + ".ActionBarProvider_" + internalVersionName).getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException |
                 NoSuchMethodException e) {
            Bukkit.getLogger().log(Level.SEVERE, "Error while loading: familiars doesn't support your minecraft server version yet! " +
                    "Do you want support that to change? Let me know on discord!");
        }
    }

    public abstract void sendActionBarPacket(final Player player, final String message);

    public static void sendActionBar(Player player, String message) {
        instance.sendActionBarPacket(player, message);
    }

}

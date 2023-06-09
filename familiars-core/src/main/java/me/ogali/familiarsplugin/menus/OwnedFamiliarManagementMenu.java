package me.ogali.familiarsplugin.menus;

import me.despical.inventoryframework.Gui;
import me.despical.inventoryframework.pane.StaticPane;
import me.ogali.familiarsplugin.FamiliarsPlugin;
import me.ogali.familiarsplugin.familiars.impl.impl.TamedLivingFamiliar;
import me.ogali.familiarsplugin.menus.items.InfoDisplayHeadItem;
import me.ogali.familiarsplugin.utils.Chat;
import org.bukkit.entity.Player;

public class OwnedFamiliarManagementMenu {

    public void show(Player player, TamedLivingFamiliar familiar) {
        Gui gui = new Gui(FamiliarsPlugin.getInstance(), 3, Chat.colorizeHex("&8Manage " + familiar.getLivingEntity().getCustomName()));
        StaticPane staticPane = new StaticPane(0, 0, 9, 3);
        gui.setOnGlobalClick(click -> click.setCancelled(true));

        staticPane.addItem(new InfoDisplayHeadItem(familiar), 4, 1);

        gui.addPane(staticPane);
        gui.show(player);
    }

}

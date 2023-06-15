package me.ogali.familiarsplugin.menus;

import me.despical.inventoryframework.Gui;
import me.despical.inventoryframework.pane.StaticPane;
import me.ogali.familiarsplugin.FamiliarsPlugin;
import me.ogali.familiarsplugin.familiars.impl.Familiar;
import me.ogali.familiarsplugin.familiars.impl.LivingFamiliar;
import me.ogali.familiarsplugin.menus.items.InfoDisplayHeadItem;
import me.ogali.familiarsplugin.menus.items.settings.familiars.DisplayEditNameItem;
import me.ogali.familiarsplugin.utils.Chat;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;

public class FamiliarEffectsMenu {

    public void show(Player player, LivingFamiliar familiar) {
        Gui gui = new Gui(FamiliarsPlugin.getInstance(), 3, Chat.colorizeHex("&8Effects Of " + familiar.getLivingEntity().getCustomName()));
        StaticPane staticPane = new StaticPane(0, 0, 9, 3);
        gui.setOnGlobalClick(click -> click.setCancelled(true));

        staticPane.addItem(new DisplayEditNameItem(familiar), 2, 1);
        staticPane.addItem(new InfoDisplayHeadItem(familiar), 4, 1);

        gui.addPane(staticPane);
        gui.show(player);
    }

    public void show(HumanEntity player, Familiar familiar) {
        Gui gui = new Gui(FamiliarsPlugin.getInstance(), 3, Chat.colorizeHex("&8Effects Of " + familiar.getDisplayName()));
        StaticPane staticPane = new StaticPane(0, 0, 9, 3);
        gui.setOnGlobalClick(click -> click.setCancelled(true));

        staticPane.addItem(new DisplayEditNameItem(familiar), 2, 1);
        staticPane.addItem(new InfoDisplayHeadItem(familiar), 4, 1);

        gui.addPane(staticPane);
        gui.show(player);
    }

}

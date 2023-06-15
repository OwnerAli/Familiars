package me.ogali.familiarsplugin.menus.taming;

import me.despical.inventoryframework.Gui;
import me.despical.inventoryframework.pane.StaticPane;
import me.ogali.familiarsplugin.FamiliarsPlugin;
import me.ogali.familiarsplugin.menus.items.settings.taming.DamageTimedTamingProcessSelectorItem;
import me.ogali.familiarsplugin.menus.items.settings.taming.DistanceTimedTamingProcessSelectorItem;
import me.ogali.familiarsplugin.menus.items.settings.taming.TimedTamingProcessSelectorItem;
import me.ogali.familiarsplugin.utils.Chat;
import org.bukkit.entity.HumanEntity;

public class TamingProcessTypeSelectMenu {

    public void show(HumanEntity player, String id) {
        Gui gui = new Gui(FamiliarsPlugin.getInstance(), 3, Chat.colorize("&8Create New Taming Process."));
        StaticPane staticPane = new StaticPane(0, 0, 9, 3);
        gui.setOnGlobalClick(click -> click.setCancelled(true));

        staticPane.addItem(new TimedTamingProcessSelectorItem(id), 1, 1);
        staticPane.addItem(new DistanceTimedTamingProcessSelectorItem(id), 3, 1);
        staticPane.addItem(new DamageTimedTamingProcessSelectorItem(id), 5, 1);

        gui.addPane(staticPane);
        gui.show(player);
    }

}

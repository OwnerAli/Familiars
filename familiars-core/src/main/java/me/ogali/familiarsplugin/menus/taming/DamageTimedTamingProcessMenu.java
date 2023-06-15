package me.ogali.familiarsplugin.menus.taming;

import me.despical.inventoryframework.Gui;
import me.despical.inventoryframework.pane.StaticPane;
import me.ogali.familiarsplugin.FamiliarsPlugin;
import me.ogali.familiarsplugin.menus.items.settings.taming.TamingProcessSetFirstValueItem;
import me.ogali.familiarsplugin.processes.taming.impl.impl.DamageTimedTamingProcess;
import me.ogali.familiarsplugin.utils.Chat;
import org.bukkit.entity.HumanEntity;

public class DamageTimedTamingProcessMenu {

    public void show(HumanEntity player, DamageTimedTamingProcess damageTimedTamingProcess) {
        Gui gui = new Gui(FamiliarsPlugin.getInstance(), 3, Chat.colorize("&8Set Taming Process Values"));
        StaticPane staticPane = new StaticPane(0, 0, 9, 3);
        gui.setOnGlobalClick(click -> click.setCancelled(true));

        staticPane.addItem(new TamingProcessSetFirstValueItem(damageTimedTamingProcess), 1, 1);

        gui.addPane(staticPane);
        gui.show(player);
    }

}

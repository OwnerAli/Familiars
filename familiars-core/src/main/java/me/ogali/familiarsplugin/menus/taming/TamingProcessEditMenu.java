package me.ogali.familiarsplugin.menus.taming;

import me.despical.inventoryframework.Gui;
import me.despical.inventoryframework.GuiItem;
import me.despical.inventoryframework.pane.StaticPane;
import me.ogali.familiarsplugin.FamiliarsPlugin;
import me.ogali.familiarsplugin.menus.items.TamingProcessSelectItem;
import me.ogali.familiarsplugin.menus.items.settings.taming.TamingProcessSetFirstValueItem;
import me.ogali.familiarsplugin.processes.taming.AbstractTamingProcess;
import me.ogali.familiarsplugin.processes.taming.impl.impl.DamageTimedTamingProcess;
import me.ogali.familiarsplugin.processes.taming.impl.impl.DistanceTimedTamingProcess;
import me.ogali.familiarsplugin.utils.Chat;
import me.ogali.familiarsplugin.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;

public class TamingProcessEditMenu {

    public void show(HumanEntity player, AbstractTamingProcess abstractTamingProcess, String id) {
        Gui gui = new Gui(FamiliarsPlugin.getInstance(), 3, Chat.colorize("&8Create New Taming Process."));
        StaticPane staticPane = new StaticPane(0, 0, 9, 3);
        gui.setOnGlobalClick(click -> click.setCancelled(true));

        staticPane.addItem(new TamingProcessSelectItem(abstractTamingProcess, id), 1, 1);

        if (abstractTamingProcess == null) {
            staticPane.addItem(new GuiItem(new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName("&4Select Process Type!").build()), 3, 1);
            staticPane.addItem(new GuiItem(new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName("&4Select Process Type!").build()), 5, 1);
        }

        if (abstractTamingProcess instanceof DistanceTimedTamingProcess distanceTimedTamingProcess) {
            staticPane.addItem(new TamingProcessSetFirstValueItem(distanceTimedTamingProcess), 3, 1);
            staticPane.removeItem(5, 1);
        } else if (abstractTamingProcess instanceof DamageTimedTamingProcess damageTimedTamingProcess) {
            staticPane.addItem(new TamingProcessSetFirstValueItem(damageTimedTamingProcess), 3, 1);
            staticPane.removeItem(5, 1);
        }

        gui.addPane(staticPane);
        gui.show(player);
    }

}

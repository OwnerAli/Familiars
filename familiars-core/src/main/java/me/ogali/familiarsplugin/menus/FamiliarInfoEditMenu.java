package me.ogali.familiarsplugin.menus;

import me.despical.inventoryframework.Gui;
import me.despical.inventoryframework.pane.StaticPane;
import me.ogali.familiarsplugin.FamiliarsPlugin;
import me.ogali.familiarsplugin.familiars.impl.Familiar;
import me.ogali.familiarsplugin.familiars.impl.impl.TamedLivingFamiliar;
import me.ogali.familiarsplugin.menus.items.InfoDisplayHeadItem;
import me.ogali.familiarsplugin.menus.items.settings.DisplayNameItem;
import me.ogali.familiarsplugin.menus.items.settings.EffectItem;
import me.ogali.familiarsplugin.utils.Chat;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;

public class FamiliarInfoEditMenu {

    public void show(Player player, TamedLivingFamiliar familiar) {
        Gui gui = new Gui(FamiliarsPlugin.getInstance(), 3, Chat.colorizeHex("&8Edit " + familiar.getLivingEntity().getCustomName()));
        StaticPane staticPane = new StaticPane(0, 0, 9, 3);
        gui.setOnGlobalClick(click -> click.setCancelled(true));

        staticPane.addItem(new DisplayNameItem(familiar), 2, 1);
        staticPane.addItem(new InfoDisplayHeadItem(familiar), 4, 1);
        staticPane.addItem(new EffectItem(familiar), 6, 1);

        gui.addPane(staticPane);
        gui.show(player);
    }

    public void show(HumanEntity player, Familiar familiar) {
        Gui gui = new Gui(FamiliarsPlugin.getInstance(), 6, Chat.colorizeHex("&8Edit Your New Familiar!"));
        StaticPane staticPane = new StaticPane(0, 0, 9, 6);
        gui.setOnGlobalClick(click -> click.setCancelled(true));

        staticPane.addItem(new DisplayNameItem(familiar), 1, 2);
        staticPane.addItem(new InfoDisplayHeadItem(familiar), 4, 2);

        gui.addPane(staticPane);
        gui.show(player);
    }

}

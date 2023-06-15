package me.ogali.familiarsplugin.menus;

import me.despical.inventoryframework.Gui;
import me.despical.inventoryframework.GuiItem;
import me.despical.inventoryframework.pane.StaticPane;
import me.ogali.familiarsplugin.FamiliarsPlugin;
import me.ogali.familiarsplugin.familiars.impl.Familiar;
import me.ogali.familiarsplugin.familiars.impl.LivingFamiliar;
import me.ogali.familiarsplugin.menus.items.FinishButton;
import me.ogali.familiarsplugin.menus.items.InfoDisplayHeadItem;
import me.ogali.familiarsplugin.menus.items.settings.familiars.*;
import me.ogali.familiarsplugin.utils.Chat;
import me.ogali.familiarsplugin.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;

public class FamiliarInfoEditMenu {

    public void show(Player player, LivingFamiliar familiar) {
        Gui gui = new Gui(FamiliarsPlugin.getInstance(), 3, Chat.colorizeHex("&8Edit " + familiar.getLivingEntity().getCustomName()));
        StaticPane staticPane = new StaticPane(0, 0, 9, 3);
        gui.setOnGlobalClick(click -> click.setCancelled(true));

        staticPane.addItem(new DisplayEditNameItem(familiar), 2, 1);
        staticPane.addItem(new InfoDisplayHeadItem(familiar), 4, 1);
        staticPane.addItem(new EffectEditItem(familiar), 6, 1);

        gui.addPane(staticPane);
        gui.show(player);
    }

    public void show(HumanEntity player, Familiar familiar) {
        Gui gui = new Gui(FamiliarsPlugin.getInstance(), 5, Chat.colorizeHex("&8Edit Your New Familiar!"));
        StaticPane staticPane = new StaticPane(0, 0, 9, 5);
        gui.setOnGlobalClick(click -> click.setCancelled(true));

        staticPane.addItem(new DisplayEditNameItem(familiar), 1, 1);
        staticPane.addItem(new SpeedEditItem(familiar), 2, 1);
        staticPane.addItem(new GuiItem(new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName("").build()), 1, 2);
        staticPane.addItem(new GuiItem(new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName("").build()), 2, 2);
        staticPane.addItem(new HealthEditItem(familiar), 1, 3);
        staticPane.addItem(new SpawnChanceEditItem(familiar), 2, 3);

        staticPane.addItem(new InfoDisplayHeadItem(familiar), 4, 1);
        staticPane.addItem(new FinishButton(click -> FamiliarsPlugin.getInstance().getFamiliarRegistry()
                .registerFamiliar(familiar)), 4, 3);

        staticPane.addItem(new TamingProcessEditItem(familiar), 6, 1);
        staticPane.addItem(new DisplayEditNameItem(familiar), 7, 1);
        staticPane.addItem(new GuiItem(new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName("").build()), 6, 2);
        staticPane.addItem(new GuiItem(new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName("").build()), 7, 2);
        staticPane.addItem(new DisplayEditNameItem(familiar), 6, 3);
        staticPane.addItem(new DisplayEditNameItem(familiar), 7, 3);

        gui.addPane(staticPane);
        gui.show(player);
    }

}

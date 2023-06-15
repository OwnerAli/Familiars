package me.ogali.familiarsplugin.menus.taming;

import me.despical.inventoryframework.Gui;
import me.despical.inventoryframework.GuiItem;
import me.despical.inventoryframework.pane.PaginatedPane;
import me.ogali.familiarsplugin.FamiliarsPlugin;
import me.ogali.familiarsplugin.familiars.impl.Familiar;
import me.ogali.familiarsplugin.menus.items.lists.TamingProcessListItem;
import me.ogali.familiarsplugin.utils.Chat;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class TamingProcessListMenu {

    public void show(Player player, Familiar familiar) {
        Gui gui = new Gui(FamiliarsPlugin.getInstance(), 6, Chat.colorizeHex("&8Server Taming Processes"));
        PaginatedPane paginatedPane = new PaginatedPane(0, 0, 9, 6);
        gui.setOnGlobalClick(click -> click.setCancelled(true));

        List<GuiItem> abstractTamingProcessItemList = new ArrayList<>();
        FamiliarsPlugin.getInstance().getTamingProcessRegistry()
                .getTamingProcessSet()
                .forEach(abstractTamingProcess -> abstractTamingProcessItemList
                        .add(new TamingProcessListItem(familiar, abstractTamingProcess)));

        paginatedPane.populateWithGuiItems(abstractTamingProcessItemList);

        gui.addPane(paginatedPane);
        gui.show(player);
    }

}

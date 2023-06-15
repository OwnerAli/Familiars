package me.ogali.familiarsplugin.menus.items;

import me.despical.inventoryframework.GuiItem;
import me.ogali.familiarsplugin.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.function.Consumer;

public class FinishButton extends GuiItem {

    public FinishButton(Consumer<InventoryClickEvent> inventoryClickEventConsumer) {
        super(new ItemBuilder(Material.ARROW)
                .setName("&4&lDone")
                .addLoreLines("", "&fLeft-click to save changes")
                .build(), inventoryClickEventConsumer);
    }

}

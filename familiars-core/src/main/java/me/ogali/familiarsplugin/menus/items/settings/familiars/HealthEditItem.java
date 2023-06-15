package me.ogali.familiarsplugin.menus.items.settings.familiars;

import me.despical.inventoryframework.GuiItem;
import me.ogali.familiarsplugin.familiars.domain.AbstractFamiliar;
import me.ogali.familiarsplugin.prompts.impl.familiars.HealthPrompt;
import me.ogali.familiarsplugin.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class HealthEditItem extends GuiItem {

    public HealthEditItem(AbstractFamiliar familiar) {
        super(new ItemBuilder(Material.STONE_BUTTON)
                        .setName("&4Familiar Health: &f" + familiar.getHealth())
                        .addLoreLines("", "&fLeft-click to change")
                        .build(),
                click -> {
                    click.getWhoClicked().closeInventory();
                    new HealthPrompt(familiar, (Player) click.getWhoClicked()).prompt();
                });
    }

}

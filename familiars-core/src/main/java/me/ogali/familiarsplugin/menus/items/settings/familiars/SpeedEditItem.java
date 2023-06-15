package me.ogali.familiarsplugin.menus.items.settings.familiars;

import me.despical.inventoryframework.GuiItem;
import me.ogali.familiarsplugin.familiars.domain.AbstractFamiliar;
import me.ogali.familiarsplugin.prompts.impl.familiars.SpeedPrompt;
import me.ogali.familiarsplugin.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class SpeedEditItem extends GuiItem {

    public SpeedEditItem(AbstractFamiliar familiar) {
        super(new ItemBuilder(Material.STONE_BUTTON)
                        .setName("&4Familiar Speed: &f" + familiar.getSpeed())
                        .addLoreLines("", "&fLeft-click to change")
                        .build(),
                click -> {
                    click.getWhoClicked().closeInventory();
                    new SpeedPrompt(familiar, (Player) click.getWhoClicked()).prompt();
                });
    }

}

package me.ogali.familiarsplugin.menus.items.settings.familiars;

import me.despical.inventoryframework.GuiItem;
import me.ogali.familiarsplugin.familiars.impl.Familiar;
import me.ogali.familiarsplugin.prompts.impl.familiars.SpawnChancePrompt;
import me.ogali.familiarsplugin.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class SpawnChanceEditItem extends GuiItem {

    public SpawnChanceEditItem(Familiar familiar) {
        super(new ItemBuilder(Material.STONE_BUTTON)
                        .setName("&4Familiar Spawn Chance: &f" + familiar.getSpawnChance())
                        .addLoreLines("", "&fLeft-click to change")
                        .build(),
                click -> {
                    click.getWhoClicked().closeInventory();
                    new SpawnChancePrompt(familiar, (Player) click.getWhoClicked()).prompt();
                });
    }

}

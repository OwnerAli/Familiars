package me.ogali.familiarsplugin.menus.items.settings.familiars;

import me.despical.inventoryframework.GuiItem;
import me.ogali.familiarsplugin.familiars.impl.Familiar;
import me.ogali.familiarsplugin.familiars.impl.LivingFamiliar;
import me.ogali.familiarsplugin.menus.FamiliarEffectsMenu;
import me.ogali.familiarsplugin.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class EffectEditItem extends GuiItem {

    public EffectEditItem(LivingFamiliar familiar) {
        super(new ItemBuilder(Material.STONE_BUTTON)
                        .setName("&4Familiar Effects")
                        .addLoreLines("&7Particles, trails, etc.", "", "&aLeft-click to change")
                        .build(),
                click -> new FamiliarEffectsMenu().show((Player) click.getWhoClicked(), familiar));
    }

    public EffectEditItem(Familiar familiar) {
        super(new ItemBuilder(Material.STONE_BUTTON)
                        .setName("&4Familiar Effects")
                        .addLoreLines("&7Particles, trails, etc.", "", "&aLeft-click to change")
                        .build(),
                click -> new FamiliarEffectsMenu().show(click.getWhoClicked(), familiar));
    }

}

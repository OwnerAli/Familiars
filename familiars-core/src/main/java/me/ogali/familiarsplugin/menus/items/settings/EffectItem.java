package me.ogali.familiarsplugin.menus.items.settings;

import me.despical.inventoryframework.GuiItem;
import me.ogali.familiarsplugin.familiars.impl.TamedFamiliar;
import me.ogali.familiarsplugin.menus.FamiliarEffectsMenu;
import me.ogali.familiarsplugin.utils.ItemBuilder;
import org.bukkit.Material;

public class EffectItem extends GuiItem {

    public EffectItem(TamedFamiliar familiar) {
        super(new ItemBuilder(Material.STONE_BUTTON)
                        .setName("&4Familiar Effects")
                        .addLoreLines("&7Particles, trails, etc.", "", "&aLeft-click to change")
                        .build(),
                click -> new FamiliarEffectsMenu().show(familiar.getOwner(), familiar));
    }

}

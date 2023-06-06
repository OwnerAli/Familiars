package me.ogali.familiarsplugin.familiars.impl;

import lombok.Getter;
import me.ogali.familiarsplugin.familiars.Rarity;
import me.ogali.familiarsplugin.familiars.domain.Familiar;
import me.ogali.familiarsplugin.nms.CustomSkullProvider;
import me.ogali.familiarsplugin.utils.Chat;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

@Getter
public class TamedFamiliar extends Familiar {

    private final Player owner;
    private final double speed;

    public TamedFamiliar(Entity entity, String displayName, Rarity rarity, String id, Player owner, double speed) {
        super(entity, Chat.colorize(owner.getName() + "'s " + displayName), rarity, id);
        this.owner = owner;
        this.speed = speed;
        updateDisplayName();
    }

    public void replaceUntamedEntityWithTamedEntity(Entity entity) {
        setEntity(entity);
        updateDisplayName();
    }

    private void updateDisplayName() {
        getEntity().setCustomName(Chat.colorizeHex("#bc98eb" + getDisplayName()));
    }

    @Override
    public void interact(Player player) {
        Inventory inventory = Bukkit.createInventory(player, InventoryType.DROPPER,
                Chat.colorizeHex("&6&lManage " + getDisplayName()));
        ItemStack infoItem = CustomSkullProvider.getCustomSkull(getEntity().getType());
        ItemMeta itemMeta = infoItem.getItemMeta();
        itemMeta.setDisplayName(Chat.colorize("&d&lPET INFO"));
        itemMeta.setLore(List.of(Chat.colorize("&fType: " + getEntity().getType()), Chat.colorize("&fHealth: " +
                ((LivingEntity) getEntity()).getHealth() + "♡")));
        infoItem.setItemMeta(itemMeta);

        inventory.setItem(1, infoItem);
        player.openInventory(inventory);
    }

}


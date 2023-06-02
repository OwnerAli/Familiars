package me.ogali.familiarsplugin.nms;

import net.minecraft.network.chat.ChatType;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.protocol.game.ClientboundChatPacket;
import org.bukkit.craftbukkit.v1_18_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class ActionBarProvider_v1_18_R2 extends ActionBarProvider {

    @Override
    public void sendActionBarPacket(Player player, String message) {
        final CraftPlayer craftPlayer = (CraftPlayer) player;

        ClientboundChatPacket messagePacket = new ClientboundChatPacket(new TextComponent(message),
                ChatType.GAME_INFO, craftPlayer.getUniqueId());

        craftPlayer.getHandle().connection.send(messagePacket);
    }

}

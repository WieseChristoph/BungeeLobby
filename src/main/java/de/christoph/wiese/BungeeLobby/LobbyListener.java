package de.christoph.wiese.BungeeLobby;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.event.ServerConnectedEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class LobbyListener implements Listener {

    @EventHandler
    public void onServerConnected(ServerConnectedEvent event) {
        if(!event.getServer().getInfo().getName().equals("lobby")) {
            event.getPlayer().sendMessage(
                ChatMessageType.ACTION_BAR,
                new ComponentBuilder("/lobby to return to the lobby").color(ChatColor.GOLD).create()
            );
        }
    }
}

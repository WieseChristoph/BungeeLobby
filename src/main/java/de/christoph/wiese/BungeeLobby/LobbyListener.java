package de.christoph.wiese.BungeeLobby;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.event.ServerConnectedEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class LobbyListener implements Listener {

    final BungeeLobby main;

    public LobbyListener (BungeeLobby config) {
        this.main = config;
    }

    @EventHandler
    public void onServerConnected(ServerConnectedEvent event) {
        // check if player is joining lobby or other server. If its another server the message is shown.
        if(!event.getServer().getInfo().getName().equals(main.config.getString("lobbyServerName"))) {
            event.getPlayer().sendMessage(
                ChatMessageType.ACTION_BAR,
                new ComponentBuilder("/" + main.config.getString("lobbyCmdName") + " to return to the lobby!")
                        .color(ChatColor.GOLD).create()
            );
        }
    }
}

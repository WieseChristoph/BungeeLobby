package de.christoph.wiese.BungeeLobby;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class LobbyCmd extends Command {
    final BungeeLobby main;

    public LobbyCmd(BungeeLobby main, String name) {
        super(name, "bungeelobby.command", "lobby");
        this.main = main;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        ProxiedPlayer p = (ProxiedPlayer) sender;
        if ((sender instanceof ProxiedPlayer)) {
            // connect player do lobby server
            p.sendMessage(new ComponentBuilder("Connecting you to the lobby!").color(ChatColor.GREEN).create());
            p.connect(ProxyServer.getInstance().getServerInfo(main.config.getString("lobbyServerName")));
        }
    }
}

package de.christoph.wiese.BungeeLobby;

import com.google.common.io.ByteStreams;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

import java.io.*;

public class BungeeLobby extends Plugin {
    Configuration config;

    @Override
    public void onEnable() {
        try {
            initConfig();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // register commands and listeners
        ProxyServer.getInstance().getPluginManager().registerCommand(this, new LobbyCmd(this, config.getString("lobbyCmdName")));
        ProxyServer.getInstance().getPluginManager().registerListener(this, new LobbyListener(this));
    }

    @Override
    public void onDisable() {
    }

    private void initConfig() throws IOException {
        // create folder and copy default config if not exists
        if (!getDataFolder().exists()) {
            getDataFolder().mkdir();
        }
        File configFile = new File(getDataFolder(), "config.yml");
        if (!configFile.exists()) {
            try {
                configFile.createNewFile();
                try (InputStream is = getResourceAsStream("config.yml");
                     OutputStream os = new FileOutputStream(configFile)) {
                    ByteStreams.copy(is, os);
                }
            } catch (IOException e) {
                throw new RuntimeException("Unable to create configuration file", e);
            }
        }
        // get config and set default values
        config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(new File(getDataFolder(), "config.yml"));
    }
}

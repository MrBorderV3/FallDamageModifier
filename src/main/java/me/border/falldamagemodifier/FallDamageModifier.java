package me.border.falldamagemodifier;

import me.border.falldamagemodifier.listeners.DamageHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class FallDamageModifier extends JavaPlugin {

    public static FallDamageModifier instance;

    public static FallDamageModifier getInstance(){
        return instance;
    }

    @Override
    public void onEnable() {
        saveDefaultConfig();
        getConfig().options().copyDefaults(true);
        instance = this;
        registerHandler(new DamageHandler());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void registerHandler(Listener listener){
        getServer().getPluginManager().registerEvents(listener, this);
    }
}

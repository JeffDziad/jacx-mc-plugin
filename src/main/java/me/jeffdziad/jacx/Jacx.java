package me.jeffdziad.jacx;

import me.jeffdziad.jacx.commands.PositionCmd;
import me.jeffdziad.jacx.commands.positionUtils.PositionTracker;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class Jacx extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "[Jacx --- Enabled]");
        registerEventHandlers();
        registerCommandHandlers();
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "[Jacx --- Disabled]");
    }

    private void registerEventHandlers() {
        System.out.println("[Jacx] Registered Event Handlers.");
        getServer().getPluginManager().registerEvents(new PositionTracker(), this);
        getServer().getPluginManager().registerEvents(new Handler(), this);
    }

    private void registerCommandHandlers() {
        System.out.println("[Jacx] Registered Command Handlers.");
        getCommand("position").setExecutor(new PositionCmd());
    }


}

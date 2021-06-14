package me.jeffdziad.jacx;

import me.jeffdziad.jacx.commands.positionUtils.PositionTracker;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Handler implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "[Jacx Handler] " + event.getPlayer().getName() + " Joined");
        PositionTracker.addNewPlayer(event);
    }

}

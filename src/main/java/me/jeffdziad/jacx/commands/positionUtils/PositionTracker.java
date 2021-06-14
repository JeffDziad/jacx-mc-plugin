package me.jeffdziad.jacx.commands.positionUtils;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.ArrayList;
import java.util.List;

public class PositionTracker implements Listener {

    private static List<PlayerPosition> playerPositions = new ArrayList<>();

    private static List<String> usernames = new ArrayList<>();

    public void updatePlayerPosition(PlayerMoveEvent event) {
        for(PlayerPosition i : playerPositions) {
            if(i.getPlayer().getName().equals(event.getPlayer().getName())) {
                i.setFrom(event.getFrom());
                i.setTo(event.getTo());
            }
        }
    }

    public String getPlayerPosition(String playerName) {
        String output = "Failed.";
        for(int i = 0; i <= usernames.size(); i++) {
            if(usernames.get(i).equals(playerName)) {
                PlayerPosition pp = playerPositions.get(i);
                Player p = pp.getPlayer();
                double FrX = pp.getFrom().getX();
                double FrY = pp.getFrom().getY();
                double FrZ = pp.getFrom().getZ();
                double ToX = pp.getTo().getX();
                double ToY = pp.getTo().getY();;
                double ToZ = pp.getTo().getZ();;
                output = String.format("[%s]\n" + "TO:" + ChatColor.RED + " X: %.2f, " + ChatColor.GREEN + "Y: %.2f, " + ChatColor.BLUE + "Z: %.2f" + ChatColor.WHITE + " \nFROM: "+ ChatColor.RED + "X: %.2f, " + ChatColor.GREEN + "Y: %.2f, " + ChatColor.BLUE + "Z: %.2f", p.getName(), FrX, FrY, FrZ, ToX, ToY, ToZ);
                return output;
            }
        }
        return output;
    }

    public static void addNewPlayer(PlayerJoinEvent event) {
        playerPositions.add(new PlayerPosition(event.getPlayer(), new Location(null, 0, 0, 0), new Location(null, 0, 0, 0)));
        usernames.add(event.getPlayer().getName());
    }


    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        updatePlayerPosition(event);
    }

}

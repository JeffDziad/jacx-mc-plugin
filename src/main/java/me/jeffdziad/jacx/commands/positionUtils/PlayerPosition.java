package me.jeffdziad.jacx.commands.positionUtils;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class PlayerPosition {

    private Player player;
    private Location from;
    private Location to;

    public PlayerPosition(Player player, Location from, Location to) {
        this.player = player;
        this.from = from;
        this.to = to;
    }

    public Player getPlayer() {
        return player;
    }

    public Location getFrom() {
        return from;
    }

    public Location getTo() {
        return to;
    }

    public void setFrom(Location from) {
        this.from = from;
    }

    public void setTo(Location to) {
        this.to = to;
    }
}

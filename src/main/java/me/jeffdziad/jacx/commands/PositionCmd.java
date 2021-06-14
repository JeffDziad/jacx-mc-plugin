package me.jeffdziad.jacx.commands;

import me.jeffdziad.jacx.commands.positionUtils.PositionTracker;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PositionCmd implements CommandExecutor {

    private PositionTracker tracker;

    public PositionCmd() { tracker = new PositionTracker(); }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player) sender;
            p.sendMessage(tracker.getPlayerPosition(args[0]));
        }
        return false;
    }
}

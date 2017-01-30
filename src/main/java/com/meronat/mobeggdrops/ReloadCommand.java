package com.meronat.mobeggdrops;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ReloadCommand implements CommandExecutor {

    private MobEggDrops plugin;

    public ReloadCommand(MobEggDrops plugin) {

        this.plugin = plugin;

    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        this.plugin.reloadConfig();
        this.plugin.saveConfig();
        sender.sendMessage(ChatColor.DARK_GREEN + "MobEggDrops " + ChatColor.GRAY + "has been successfully reloaded.");

        return true;

    }

}

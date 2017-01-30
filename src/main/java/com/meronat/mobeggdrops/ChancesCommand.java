package com.meronat.mobeggdrops;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;

public class ChancesCommand implements CommandExecutor {

    private MobEggDrops plugin;

    public ChancesCommand(MobEggDrops plugin) {

        this.plugin = plugin;

    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Bukkit.getScheduler().runTaskAsynchronously(plugin, () -> {

            sender.sendMessage(ChatColor.DARK_GREEN + "Chances of mobs dropping their egg equivalent:");

            for (EntityType type : EntityType.values()) {

                if (this.plugin.properEntity(type.toString())) {

                    sender.sendMessage(ChatColor.GRAY + type.toString() + ": " + ChatColor.GREEN + this.plugin.getChance(type.toString()) + "%");

                }

            }

        });

        return true;

    }

}

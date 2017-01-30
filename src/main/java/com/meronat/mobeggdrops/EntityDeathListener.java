package com.meronat.mobeggdrops;

import java.util.concurrent.ThreadLocalRandom;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SpawnEggMeta;

public final class EntityDeathListener implements Listener {

    private MobEggDrops plugin;

    EntityDeathListener(MobEggDrops plugin) {

        this.plugin = plugin;

    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {

        EntityType type = event.getEntityType();

        if (!this.plugin.properEntity(type.toString())) {
            return;
        }

        int chance = this.plugin.getChance(type.toString());

        if (chance == 0) {
            return;
        }

        if (chance < ThreadLocalRandom.current().nextInt(0, 101)) {
            return;
        }

        ItemStack egg = new ItemStack(Material.MONSTER_EGG);

        ItemMeta meta = egg.getItemMeta();

        if (!(meta instanceof SpawnEggMeta)) {
            return;
        }

        ((SpawnEggMeta) meta).setSpawnedType(type);

        egg.setItemMeta(meta);

        egg.setAmount(1);

        event.getDrops().add(egg);

    }

}

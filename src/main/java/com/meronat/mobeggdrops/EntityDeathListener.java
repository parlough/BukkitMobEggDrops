/*
 * This file is part of MobEggDrops, licensed under the MIT License.
 *
 * Copyright (c) 2017 Meronat <http://meronat.com>
 * Copyright (c) Contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

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

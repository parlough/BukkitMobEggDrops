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

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class MobEggDrops extends JavaPlugin {

    @Override
    public void onEnable() {

        this.loadConfig();

        this.getServer().getPluginManager().registerEvents(new EntityDeathListener(this), this);

        this.getCommand("med").setExecutor(new ReloadCommand(this));
        this.getCommand("medchances").setExecutor(new ChancesCommand(this));

    }

    private void loadConfig() {

        FileConfiguration config = this.getConfig();

        config.addDefault("BAT", 5);
        config.addDefault("BLAZE", 5);
        config.addDefault("CAVE_SPIDER", 5);
        config.addDefault("CHICKEN", 5);
        config.addDefault("COW", 5);
        config.addDefault("CREEPER", 5);
        config.addDefault("DONKEY", 5);
        config.addDefault("ELDER_GUARDIAN", 5);
        config.addDefault("ENDERMAN", 5);
        config.addDefault("ENDERMITE", 5);
        config.addDefault("EVOKER", 5);
        config.addDefault("GHAST", 5);
        config.addDefault("GUARDIAN", 5);
        config.addDefault("HORSE", 5);
        config.addDefault("HUSK", 5);
        config.addDefault("LLAMA", 5);
        config.addDefault("MAGMA_CUBE", 5);
        config.addDefault("MUSHROOM_COW", 5);
        config.addDefault("MULE", 5);
        config.addDefault("OCELOT", 5);
        config.addDefault("PIG", 5);
        config.addDefault("POLAR_BEAR", 5);
        config.addDefault("RABBIT", 5);
        config.addDefault("SHEEP", 5);
        config.addDefault("SHULKER", 5);
        config.addDefault("SILVERFISH", 5);
        config.addDefault("SKELETON", 5);
        config.addDefault("SKELETON_HORSE", 5);
        config.addDefault("SLIME", 5);
        config.addDefault("SPIDER", 5);
        config.addDefault("SQUID", 5);
        config.addDefault("STRAY", 5);
        config.addDefault("VEX", 5);
        config.addDefault("VILLAGER", 5);
        config.addDefault("VINDICATOR", 5);
        config.addDefault("WITCH", 5);
        config.addDefault("WITHER_SKELETON", 5);
        config.addDefault("WOLF", 5);
        config.addDefault("ZOMBIE", 5);
        config.addDefault("ZOMBIE_HORSE", 5);
        config.addDefault("PIG_ZOMBIE", 5);
        config.addDefault("ZOMBIE_VILLAGER", 5);

        config.options().copyDefaults(true);
        this.saveConfig();

    }

    public boolean properEntity(String entity) {

        return this.getConfig().contains(entity);

    }

    public int getChance(String entity) {

        return this.getConfig().getInt(entity);

    }

}

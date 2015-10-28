package io.not2excel.cooldown;
/*
 * Copyright (C) 2013-Current Carter Gale (Ktar5) <buildfresh@gmail.com>
 * 
 * This file is part of GuildsCore.
 * 
 * GuildsCore can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */

import lombok.Getter;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.util.UUID;

public class CooldownFinishEvent extends Event {

    @Getter
    private UUID player;
    @Getter
    private String ability;

    public CooldownFinishEvent(UUID player, String ability) {
        this.player = player;
        this.ability = ability;
    }

    @Override
    public HandlerList getHandlers() {
        return null;
    }
}

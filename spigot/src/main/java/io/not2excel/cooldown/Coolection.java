package io.not2excel.cooldown;
/*
 * Copyright (C) 2013-Current Carter Gale (Ktar5) <buildfresh@gmail.com>
 * 
 * This file is part of GuildsCore.
 * 
 * GuildsCore can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */

import org.bukkit.Bukkit;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class Coolection {

    private HashMap<String, Cooldown> cooldowns;
    private UUID uuid;

    protected Coolection(UUID uuid, String cooldown, int seconds){
        cooldowns = new HashMap<>();
        this.uuid = uuid;
        cooldowns.put(cooldown.toLowerCase(), new Cooldown(seconds));
    }

    protected void add(String cooldown, int seconds){
        if(!isCooling(cooldown)){
            cooldowns.put(cooldown, new Cooldown(seconds));
        }
    }

    protected boolean isEmpty(){
        return cooldowns.isEmpty();
    }

    protected boolean isCooling(String cooldown){
        return cooldowns.containsKey(cooldown.toLowerCase());
    }

    protected double timeRemaining(String cooldown){
        return handleCooldown(cooldown.toLowerCase());
    }

    protected void removeCooldown(String cooldown){
        if(cooldowns.containsKey(cooldown.toLowerCase())){
            Bukkit.getServer().getPluginManager().callEvent(new CooldownFinishEvent(uuid, cooldown));
            cooldowns.remove(cooldown.toLowerCase());
        }
    }

    protected void removeCooldowns(List<String> coolList){
        for(String string : coolList){
            Bukkit.getServer().getPluginManager().callEvent(new CooldownFinishEvent(uuid, string));
            cooldowns.remove(string);
        }
    }

    protected int handleCooldown(String cooldown){
        Cooldown cool = cooldowns.get(cooldown.toLowerCase());
        if(cool != null){
            if(cool.isFinished()){
                removeCooldown(cooldown.toLowerCase());
            }else{
                return cool.timeLeft();
            }
        }
        return 0;
    }

    public boolean handleCooldowns() {
        if(isEmpty()){
            return true;
        }
        Iterator<Cooldown> iterator = cooldowns.values().iterator();
        while(iterator.hasNext()){
            Cooldown entry = iterator.next();
            if(entry.isFinished()){
                iterator.remove();
            }
        }
        return isEmpty();
    }
}

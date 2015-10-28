package io.not2excel.cooldown;
/*
 * Copyright (C) 2013-Current Carter Gale (Ktar5) <buildfresh@gmail.com>
 * 
 * This file is part of GuildsCore.
 * 
 * GuildsCore can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */

public class Cooldown {

    private long startStamp;
    private long endStamp;

    protected Cooldown(int quarterSeconds){
        startStamp = System.currentTimeMillis() / 250;
        endStamp = startStamp + quarterSeconds;
    }

    public boolean isFinished(){
        return (System.currentTimeMillis() / 250) >= endStamp;
    }

    public int timeLeft(){
        return (short) ((System.currentTimeMillis() / 250) - startStamp);
    }

}

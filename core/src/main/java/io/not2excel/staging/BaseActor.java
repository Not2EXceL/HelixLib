package io.not2excel.staging;

import com.minecave.guilds.core.GuildCore;

/**
 * Created by ktar5 on 8/28/2015.
 */
public abstract class BaseActor extends Actor {

    /**
     * We're actors!
     * (Called when we want to do something, after arriving)
     */
    public abstract void act();

    public void remove() {
        GuildCore.getInstance().getDrawingStage().remove(ID);
    }

}

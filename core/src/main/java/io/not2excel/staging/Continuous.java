package io.not2excel.staging;

/**
 * Created by ktar5 on 8/28/2015.
 */
public abstract class Continuous extends BaseActor {

    private final int effectEveryTicks;
    private int ticksAlive = 0;
    private final int durationTicks;

    public Continuous(int duration, int effectEveryTicks) {
        super();
        this.effectEveryTicks = effectEveryTicks;
        this.durationTicks = duration;
        try{
            if(durationTicks % effectEveryTicks != 0){
                throw new DurationException(duration, effectEveryTicks);
            }
        }catch (DurationException e){
            e.printStackTrace();
        }
    }

    @Override
    public final void tick(){
        if(ticksAlive % effectEveryTicks == 0){
            act();
        }
        ticksAlive += 1;
        if (ticksAlive >= durationTicks) {
            remove();
        }
    }

    private class DurationException extends Exception {
        public DurationException(int duration, int effectEveryTicks) {}
    }
}

package io.not2excel.staging;

/**
 * Created by ktar5 on 8/28/2015.
 */
public abstract class Instant extends BaseActor {

    /**
     * Why would we need to add this to the drawing stage, if it isn't continuous?
     */
    public Instant() {
        super();
        act();
    }

    @Override
    public final void tick(){}

}

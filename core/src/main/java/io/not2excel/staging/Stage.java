package io.not2excel.staging;

import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by ktar5 on 8/28/2015.
 */
public class Stage extends BukkitRunnable {


    private volatile List<Actor> objects = new ArrayList<>();

    /*
     * (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        for (Actor obj : objects) {
            obj.tick();
        }
    }

    /**
     * Adds a {@link BaseActor} to the stage to be rendered.
     *
     * @param object The object.
     */
    public synchronized void add(Actor object) {
        // If we start getting ConcurrentModificationExceptions from this, let me know.
        if (!contains(object)) objects.add(object);
    }

    /**
     * Removes the specified object from the stage via its {@link UUID}.
     *
     * @param objectID The ID to remove.
     */
    public synchronized void remove(UUID objectID) {
        for (int i = 0; i < objects.size(); i++) {
            if (objects.get(i).ID.equals(objectID)) {
                objects.remove(i);
                return;
            }
        }
    }

    /**
     * Determines if the specified {@link BaseActor} is within the current stage.
     *
     * @param object The object.
     * @return True if the object is on the stage, false otherwise.
     */
    public synchronized boolean contains(Actor object) {
        for (Actor obj : objects) if (obj.equals(object)) return true;
        return false;
    }
}

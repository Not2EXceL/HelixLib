package io.not2excel.staging;

import java.util.UUID;

/*
 * Copyright (C) 2013-Current Carter Gale (Ktar5) <buildfresh@gmail.com>
 * 
 * This file is part of GuildsCore.
 * 
 * GuildsCore can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */
public abstract class Actor {

    public final UUID ID;

    public Actor() {
        ID = UUID.randomUUID();
    }

    public abstract void tick();
}

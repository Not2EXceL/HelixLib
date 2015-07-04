/*
 * Copyright (C) 2011-Current Richmond Steele (Not2EXceL) (nasm) <not2excel@gmail.com>
 * 
 * This file is part of helixlib.
 * 
 * helixlib can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */
package io.not2excel.menu;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

import java.util.function.BiConsumer;

@Data
@AllArgsConstructor(staticName = "create")
public final class MenuIcon {

    public static final BiConsumer<Player, ClickType> EMPTY_LISTENER = (player, clickType) -> {
    };

    private final ItemStack                     itemStack;
    private       BiConsumer<Player, ClickType> iconListener;

    public static MenuIcon create(ItemStack itemStack) {
        return MenuIcon.create(itemStack, EMPTY_LISTENER);
    }
}

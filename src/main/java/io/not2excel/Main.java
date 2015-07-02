/*
 * Copyright (C) 2011-Current Richmond Steele (Not2EXceL) (nasm) <not2excel@gmail.com>
 * 
 * This file is part of module-api.
 * 
 * module-api can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */
package io.not2excel;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] main) {
//        ModuleLoader<?> loader = () -> null;
//        loader.getInternalModules().forEach((s, l) -> {
//            System.out.println("<====================>");
//            System.out.println(s);
//            System.out.println("----------------------");
//            System.out.println(l.toString());
//            System.out.println("<====================>");
//        });
        System.out.println((byte)120);
        System.out.println((byte)(120 + (Byte.MAX_VALUE + 1) * 22));
    }

    public static List<Location> erikPls(Player player, int range) {
        List<Block> blocks = player.getLineOfSight((Set<Material>) null, range);
//        return blocks.stream().map(Block::getLocation).collect(Collectors.toCollection(LinkedList::new));
//        return blocks.stream().map(Block::getLocation).collect(Collectors.toList());
//        return blocks.stream().map(Block::getLocation).collect(Collectors.toCollection(() ->
//                                                             Collections.unmodifiableList(new ArrayList<>(blocks.size()))));
        return blocks.stream().map(Block::getLocation).collect(Collectors.toCollection(() -> new ArrayList<>(blocks.size())));
    }
}

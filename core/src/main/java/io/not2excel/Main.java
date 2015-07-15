/*
 * Copyright (C) 2011-Current Richmond Steele (Not2EXceL) (nasm) <not2excel@gmail.com>
 *
 * This file is part of module-api.
 *
 * module-api can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */
package io.not2excel;

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
//        String s = "1.23 Hours asdf";
//        System.out.println(s.substring(s.indexOf(" Hours") + " Hours".length()).trim());

        long pos = (long) ((-5 & 0x3FFFFFF) << 6 |
                           (15 & 0xFFF) << 26 |
                           10 & 0x3FFFFFF);
        System.out.println(pos);
        long x = pos >> 6;
        long y = (pos >> 26) & 0xFFF;
        long z = pos << 6 >> 38;
        if (x >= (2 ^ 25)) {
            x -= 2 ^ 26;
        }
        if (y >= (2 ^ 11)) {
            y -= 2 ^ 12;
        }
        if (z >= (2 ^ 25)) {
            z -= 2 ^ 26;
        }
        System.out.println(x);
        System.out.println(y);
        System.out.println(z);

    }
}

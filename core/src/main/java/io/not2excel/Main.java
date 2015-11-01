/*
 * Copyright (C) 2011-Current Richmond Steele (Not2EXceL) (nasm) <not2excel@gmail.com>
 *
 * This file is part of module-api.
 *
 * module-api can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */
package io.not2excel;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

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

//        long pos = (long) ((-5 & 0x3FFFFFF) << 6 |
//                           (15 & 0xFFF) << 26 |
//                           10 & 0x3FFFFFF);
//        System.out.println(pos);
//        long x = pos >> 6;
//        long y = (pos >> 26) & 0xFFF;
//        long z = pos << 6 >> 38;
//        if (x >= (2 ^ 25)) {
//            x -= 2 ^ 26;
//        }
//        if (y >= (2 ^ 11)) {
//            y -= 2 ^ 12;
//        }
//        if (z >= (2 ^ 25)) {
//            z -= 2 ^ 26;
//        }
//        System.out.println(x);
//        System.out.println(y);
//        System.out.println(z);

//        TreeMap<BigInteger, List<Integer>> products = new TreeMap<>();
//        Integer[] a = {7, 3, 1, 6, 7, 1, 7, 6, 5, 3, 1, 3, 3};
//        Integer[] b = {3, 1, 6, 7, 1, 7, 6, 5, 3, 1, 3, 3, 3};
//        int aSum = 0;
//        for(int i : a) {
//            aSum += a[i];
//        }
//        int bSum = 0;
//        for(int i : b) {
//            bSum += b[i];
//        }
//        products.put(BigInteger.valueOf(aSum), Arrays.asList(a));
//        products.put(BigInteger.valueOf(bSum), Arrays.asList(b));
//
//        products.forEach((bigint, array) -> {
//
//            System.out.print(bigint + " : ");
//            for (int i : array) {
//                System.out.print(i + "; ");
//            }
//            System.out.println();
//        });

        String string = new BigInteger("731671765313306249192251196744265"
                                       + "74742355349194934969835203127745"
                                       + "0632623957831801698480186947885184"
                                       + "385861560789112949495459501737958331"
                                       + "95285320880551112540698747158523863050"
                                       + "7156932909632952274430435576689664895044"
                                       + "524452316173185640309871112172238311362229"
                                       + "89342338030813533627661428280644448664523874"
                                       + "93035890729629049156044077239071381051585930796"
                                       + "0866701724271218839987979087922749219016997208880"
                                       + "93776657273330010533678812202354218097512545405947"
                                       + "522435258490771167055601360483958644670632441572"
                                       + "2155397536978179778461740649551492908625693219"
                                       + "784686224828397224137565705605749026140797296"
                                       + "8652414535100474821663704844031998900088952"
                                       + "43450658541227588666881164271714799244429"
                                       + "2823086346567481391912316282458617866458"
                                       + "3591245665294765456828489128831426076900"
                                       + "4224219022671055626321111109370544217506"
                                       + "94165896040807198403850962455444362981230"
                                       + "9878799272442849091888458015616609791913387"
                                       + "549920052406368991256071760605886116467109405"
                                       + "077541002256983155200055935729725716362695618826"
                                       + "70428252483600823257530420752963450").toString();
        List<Long> digits = new ArrayList<>();
        TreeMap<Long, List<Long>> products = new TreeMap<>();

        for (int i = 0; i < 12; i++) {
            digits.add((long) Character.getNumericValue(string.charAt(i)));
            Long product = 1L;
            for (Long n : digits) {
                product *= n;
            }
            System.out.println(product + " : " + digits);
            products.put(product, digits);
            System.out.println(products.get(product));
        }
        System.out.println(" ++12 =============================================================");

        for (int i = 12; i < 1000; i++) {
            List<Long> digits1 = new ArrayList<>();
            digits1.addAll(digits);
            if(digits1.isEmpty()) continue;
            digits1.remove(0);
            digits1.add((long) Character.getNumericValue(string.charAt(i)));
            Long product = 1L;
            for (Long n : digits1) {
                product *= n;
            }
            System.out.println(product + " : " + digits1);
            products.put(product, digits1);
            System.out.println(products.get(product));
        }
        System.out.println(products);

        Long low = products.firstKey();
        System.out.println("Lowest key-value: " + low + " - " + products.get(low));
        Long high = products.lastKey();
        System.out.println("Highest key-value: " + high + " - " + products.get(high));
    }
}

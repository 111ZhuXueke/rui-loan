package com.rui.web.common.utils;

import java.util.*;

/**
 * @author : zhuxueke
 * @since : 2018-02-07 10:45
 **/
public class Lambdas {
    public static void main(String[] args){
        List<Integer> list = Arrays.asList(1,4,3,2,1,7,6,9,8,8,1);
        List<int[]> integersList = Arrays.asList(new int[]{0,6},new int[]{5,10});
        Map<Integer,Map<Integer,Integer>> ilist = new HashMap<>();
        boolean[] booleans = new boolean[]{true,true};
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < integersList.size(); j++) {
                if(list.get(i) > integersList.get(j)[0] && list.get(i) < integersList.get(j)[1] ? true : false){
                    if(ilist.get(integersList.get(j)[0]) == null){
                        ilist.put(integersList.get(j)[0],new HashMap<Integer,Integer>());
                        ilist.get(integersList.get(j)[0]).put(integersList.get(j)[1], 0);
                    }
                }
                if(list.get(i) > integersList.get(j)[0] && list.get(i) <= integersList.get(j)[1] ? true : false){
                    if(ilist.get(integersList.get(j)[0]) == null){
                        ilist.put(integersList.get(j)[0],new HashMap<Integer,Integer>());
                        ilist.get(integersList.get(j)[0]).put(integersList.get(j)[1], 0);
                    }
                }
            }
            if(list.get(i) > integersList.get(0)[0] && list.get(i) < integersList.get(0)[1] ? true : false){
                ilist.get(0);
                ilist.get(integersList.get(0)[0]).put(integersList.get(0)[1],ilist.get(integersList.get(0)[0]).get(integersList.get(0)[1]) + 1);
            }
            if(list.get(i) > integersList.get(1)[0] && list.get(i) <= integersList.get(1)[1] ? true : false){
                ilist.get(integersList.get(1)[0]).put(integersList.get(1)[1],ilist.get(integersList.get(1)[0]).get(integersList.get(1)[1]) + 1);
            }
        }
        for (int[] item : integersList){
            System.out.println(ilist.get(item[0]).get(item[1]));
        }

//        long smail = list.stream().filter(x -> x <= 5).count();
//        // 小于 5
//        System.out.println(smail);
//
//        long big = list.stream().filter(x -> x > 5 && x <= 10).count();
//        // 大于 5
//        System.out.println(big);
    }
}

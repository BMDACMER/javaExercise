package javaCollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

/**
 * 扑克第二版
 */
public class PokerV2 {
    public static void main(String[] args) {
        /*
         * 1组装54张扑克牌
         */
        // 1.1 创建Map集合存储
        HashMap<Integer, String> pokerMap = new HashMap<>();
        // 1.2 创建 花色集合 与 数字集合
        ArrayList<String> colors = new ArrayList<>();
        ArrayList<String> numbers = new ArrayList<>();
        // 1.3 存储 花色 与数字
        Collections.addAll(colors,"红桃","梅花","黑桃","方块");
        Collections.addAll(numbers,"2","3","4","5","6","7","8","9","10","J","Q","K","A");

        // 设置 存储编号变量
        int count = 1;
        pokerMap.put(count++,"大王");
        pokerMap.put(count++,"小王");
        // 1.4 创建牌 存储到map集合中
        for (String number : numbers) {
            for (String color : colors) {
                String card = color + number;
                pokerMap.put(count++, card);
            }
        }


        /*
         * 2 将54张牌顺序打乱
         */
        // 取出编号 集合
        Set<Integer> numberSet = pokerMap.keySet();
        // 因为要将编号打乱顺序 所以 应该先进行转换到 list集合中
        ArrayList<Integer> numberList = new ArrayList<>();
        numberList.addAll(numberSet);
        // 打乱顺序
        Collections.shuffle(numberList);
        // 3 完成三个玩家交替摸牌，每人17张牌，最后三张留作底牌
        // 3.1 发牌的编号
        // 创建三个玩家编号集合 和一个 底牌编号集合
        ArrayList<Integer> noP1 = new ArrayList<>();
        ArrayList<Integer> noP2 = new ArrayList<>();
        ArrayList<Integer> noP3 = new ArrayList<>();
        ArrayList<Integer> holeCard = new ArrayList<>();
        // 3.2发牌的编号
        for (int i = 0; i < numberList.size(); i++) {
            if (i >= 51) {
                holeCard.add(numberList.get(i));
            } else {
                if (i % 3 == 0) {
                    noP1.add(numberList.get(i));
                } else if (i % 3 == 1) {
                    noP2.add(numberList.get(i));
                } else if (i % 3 == 2) {
                    noP3.add(numberList.get(i));
                }
            }
        }

        // 4 查看三人各自手中的牌（按照牌的大小排序）、底牌
        // 4.1 对手中编号进行排序
        Collections.sort(noP1);
        Collections.sort(noP2);
        Collections.sort(noP3);
        Collections.sort(holeCard);
        // 4.2 进行牌面的转换
        // 创建三个玩家牌面集合 以及底牌牌面集合
        ArrayList<String> player1 = new ArrayList<>();
        ArrayList<String> player2 = new ArrayList<>();
        ArrayList<String> player3 = new ArrayList<>();
        ArrayList<String> dipai = new ArrayList<>();
        // 4.3转换
        for (Integer i : noP1) {
            String card = pokerMap.get(i);
            player1.add(card);
        }

        for (Integer i : noP2) {
            String card = pokerMap.get(i);
            player2.add(card);
        }

        for (Integer i : noP3) {
            String card = pokerMap.get(i);
            player3.add(card);
        }

        for (Integer i : holeCard) {
            String card = pokerMap.get(i);
            dipai.add(card);
        }
        //4.5 查看
        System.out.println("令狐冲："+player1);
        System.out.println("石破天："+player2);
        System.out.println("鸠摩智："+player3);
        System.out.println("底牌："+dipai);
    }
}

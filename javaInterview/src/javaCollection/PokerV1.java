package javaCollection;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * 扑克游戏 第一版
 */
public class PokerV1 {
    public static void main(String[] args) {
        // 1 准备牌操作
        ArrayList<String> pokerBox = new ArrayList<>();
        ArrayList<String> colors = new ArrayList<>();
        ArrayList<String> numbers = new ArrayList<>();

        colors.add("红桃");
        colors.add("方块");
        colors.add("黑桃");
        colors.add("梅花");

        for (int i = 2; i <= 10; i++) {
            numbers.add(i + "");
        }
        numbers.add("J");
        numbers.add("Q");
        numbers.add("K");
        numbers.add("A");

        for (String color : colors) {
            for (String number : numbers) {
                String card = color + number;
                pokerBox.add(card);
            }
        }

        pokerBox.add("小王");
        pokerBox.add("大王");

        // 2 洗牌
        Collections.shuffle(pokerBox);

        // 3 发牌
        ArrayList<String> player1 = new ArrayList<>();
        ArrayList<String> player2 = new ArrayList<>();
        ArrayList<String> player3 = new ArrayList<>();
        ArrayList<String> holeCard = new ArrayList<>();  // 底牌

        for (int i = 0; i < pokerBox.size(); i++) {
            String card = pokerBox.get(i);
            if (i >= 51) {
                holeCard.add(card);
            } else {
                if (i%3==0) {
                    player1.add(card);
                } else if (i%3 == 1) {
                    player2.add(card);
                } else {
                    player3.add(card);
                }
            }
        }

        // 测试
        System.out.println("令狐冲："+player1);
        System.out.println("田伯光："+player2);
        System.out.println("绿竹翁："+player3);
        System.out.println("底牌："+holeCard);
    }
}

package javaCollection;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * �˿���Ϸ ��һ��
 */
public class PokerV1 {
    public static void main(String[] args) {
        // 1 ׼���Ʋ���
        ArrayList<String> pokerBox = new ArrayList<>();
        ArrayList<String> colors = new ArrayList<>();
        ArrayList<String> numbers = new ArrayList<>();

        colors.add("����");
        colors.add("����");
        colors.add("����");
        colors.add("÷��");

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

        pokerBox.add("С��");
        pokerBox.add("����");

        // 2 ϴ��
        Collections.shuffle(pokerBox);

        // 3 ����
        ArrayList<String> player1 = new ArrayList<>();
        ArrayList<String> player2 = new ArrayList<>();
        ArrayList<String> player3 = new ArrayList<>();
        ArrayList<String> holeCard = new ArrayList<>();  // ����

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

        // ����
        System.out.println("����壺"+player1);
        System.out.println("�ﲮ�⣺"+player2);
        System.out.println("�����̣�"+player3);
        System.out.println("���ƣ�"+holeCard);
    }
}

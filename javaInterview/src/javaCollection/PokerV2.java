package javaCollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

/**
 * �˿˵ڶ���
 */
public class PokerV2 {
    public static void main(String[] args) {
        /*
         * 1��װ54���˿���
         */
        // 1.1 ����Map���ϴ洢
        HashMap<Integer, String> pokerMap = new HashMap<>();
        // 1.2 ���� ��ɫ���� �� ���ּ���
        ArrayList<String> colors = new ArrayList<>();
        ArrayList<String> numbers = new ArrayList<>();
        // 1.3 �洢 ��ɫ ������
        Collections.addAll(colors,"����","÷��","����","����");
        Collections.addAll(numbers,"2","3","4","5","6","7","8","9","10","J","Q","K","A");

        // ���� �洢��ű���
        int count = 1;
        pokerMap.put(count++,"����");
        pokerMap.put(count++,"С��");
        // 1.4 ������ �洢��map������
        for (String number : numbers) {
            for (String color : colors) {
                String card = color + number;
                pokerMap.put(count++, card);
            }
        }


        /*
         * 2 ��54����˳�����
         */
        // ȡ����� ����
        Set<Integer> numberSet = pokerMap.keySet();
        // ��ΪҪ����Ŵ���˳�� ���� Ӧ���Ƚ���ת���� list������
        ArrayList<Integer> numberList = new ArrayList<>();
        numberList.addAll(numberSet);
        // ����˳��
        Collections.shuffle(numberList);
        // 3 ���������ҽ������ƣ�ÿ��17���ƣ����������������
        // 3.1 ���Ƶı��
        // ����������ұ�ż��� ��һ�� ���Ʊ�ż���
        ArrayList<Integer> noP1 = new ArrayList<>();
        ArrayList<Integer> noP2 = new ArrayList<>();
        ArrayList<Integer> noP3 = new ArrayList<>();
        ArrayList<Integer> holeCard = new ArrayList<>();
        // 3.2���Ƶı��
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

        // 4 �鿴���˸������е��ƣ������ƵĴ�С���򣩡�����
        // 4.1 �����б�Ž�������
        Collections.sort(noP1);
        Collections.sort(noP2);
        Collections.sort(noP3);
        Collections.sort(holeCard);
        // 4.2 ���������ת��
        // ��������������漯�� �Լ��������漯��
        ArrayList<String> player1 = new ArrayList<>();
        ArrayList<String> player2 = new ArrayList<>();
        ArrayList<String> player3 = new ArrayList<>();
        ArrayList<String> dipai = new ArrayList<>();
        // 4.3ת��
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
        //4.5 �鿴
        System.out.println("����壺"+player1);
        System.out.println("ʯ���죺"+player2);
        System.out.println("�Ħ�ǣ�"+player3);
        System.out.println("���ƣ�"+dipai);
    }
}

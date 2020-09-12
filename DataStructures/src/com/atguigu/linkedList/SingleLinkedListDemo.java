package com.atguigu.linkedList;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/9/6 22:11
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        //���в���
        //�ȴ����ڵ�
        HeroNode hero1 = new HeroNode(1, "�ν�", "��ʱ��");
        HeroNode hero2 = new HeroNode(2, "¬����", "������");
        HeroNode hero3 = new HeroNode(3, "����", "�Ƕ���");
        HeroNode hero4 = new HeroNode(4, "�ֳ�", "����ͷ");

        //����Ҫ������
        SingleLinkedList singleLinkedList = new SingleLinkedList();


        //����
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero4);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);

        // ����һ�µ�����ķ�ת����
        System.out.println("ԭ����������~~");
        singleLinkedList.list();
    }
}

class SingleLinkedList {
    private HeroNode head = new HeroNode(0,"","");

    public HeroNode getHead() {
        return head;
    }

    public void add(HeroNode heroNode) {
        HeroNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = heroNode;
    }

    public void addByOrder(HeroNode heroNode) {
        HeroNode temp = head;
        boolean flag = false;
        while (temp.next != null) {
            if (temp.next.no > heroNode.no) {
                break;
            } else if (temp.next.no == heroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.printf("׼�������Ӣ�۵ı�� %d �Ѿ�������, ���ܼ���\n", heroNode.no);
        } else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    public void update(HeroNode newHeroNode) {
        //�ж��Ƿ��
        if(head.next == null) {
            System.out.println("����Ϊ��~");
            return;
        }
        //�ҵ���Ҫ�޸ĵĽڵ�, ����no���
        //����һ����������
        HeroNode temp = head.next;
        boolean flag = false; //��ʾ�Ƿ��ҵ��ýڵ�
        while (temp != null) {
            if (temp.no == newHeroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        } else {
            System.out.printf("û���ҵ� ��� %d �Ľڵ㣬�����޸�\n", newHeroNode.no);
        }
    }

    public void del(int no) {
        HeroNode temp = head;
        boolean flag = false; // ��־�Ƿ��ҵ���ɾ���ڵ��
        while(true) {
            if(temp.next == null) { //�Ѿ�����������
                break;
            }
            if(temp.next.no == no) {
                //�ҵ��Ĵ�ɾ���ڵ��ǰһ���ڵ�temp
                flag = true;
                break;
            }
            temp = temp.next; //temp���ƣ�����
        }
        //�ж�flag
        if(flag) { //�ҵ�
            //����ɾ��
            temp.next = temp.next.next;
        }else {
            System.out.printf("Ҫɾ���� %d �ڵ㲻����\n", no);
        }
    }

    //��ʾ����[����]
    public void list() {
        //�ж������Ƿ�Ϊ��
        if(head.next == null) {
            System.out.println("����Ϊ��");
            return;
        }
        //��Ϊͷ�ڵ㣬���ܶ������������Ҫһ����������������
        HeroNode temp = head.next;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

}

class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
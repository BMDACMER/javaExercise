package java_multithreading_skills_01.com.controller;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/11/2 21:24
 */
public class Run {
    public static void main(String[] args) {
        ALogin a = new ALogin();
        BLogin b = new BLogin();
        a.start();
        b.start();
    }
}

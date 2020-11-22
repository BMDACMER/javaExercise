package java_multithreading_skills_01.com.controller;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/11/2 21:23
 */
public class ALogin extends Thread{
    @Override
    public void run() {
        LoginServlet.doPost("a","aa");
    }
}

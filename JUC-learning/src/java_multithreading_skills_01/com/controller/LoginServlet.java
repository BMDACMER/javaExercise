package java_multithreading_skills_01.com.controller;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/11/2 21:19
 */
public class LoginServlet {
    private static String usernameRef;
    private static String passwordRef;

    public static synchronized void doPost(String username, String password) {
        usernameRef = username;
        if (username.equals("a")) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        passwordRef = password;

        System.out.println("username=" + usernameRef + " password=" + passwordRef);
    }
}

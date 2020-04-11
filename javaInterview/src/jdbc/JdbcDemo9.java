package jdbc;

import util.JDBCUtils;

import javax.management.StandardEmitterMBean;
import java.sql.*;
import java.util.Scanner;

/**
 * ��ϰ��
 * ����
 *      1��ͨ������¼���û���������
 *      2�� �ж��û��Ƿ��¼�ɹ�
 */
public class JdbcDemo9 {
    public static void main(String[] args) {
        //1 ����¼�롣�����û���������
        Scanner sc = new Scanner(System.in);
        System.out.println("�������û�����");
        String username = sc.nextLine();
        System.out.println("���������룺");
        String password = sc.nextLine();
        // 2 ���÷���
        boolean flag = new JdbcDemo9().login2(username,password);
        // 3 �жϽ���� �����ͬ���
        if (flag) {
            //��½�ɹ�
            System.out.println("��½�ɹ���");
        } else {
            System.out.println("�û������������");
        }
    }

    /**
     * ��½����
     */
    public boolean login(String username, String password) {
        if (username == null || password == null) {
            return false;
        }
        // �������ݿ��ж��Ƿ��½�ɹ�
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        // ��ȡ����
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select * from user where username = '"+username+"' and password = '"+password+"' ";
            System.out.println(sql);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs,stmt,conn);
        }

        return false;
    }

    /**
     * ��¼����,ʹ��PreparedStatementʵ��
     */
    public boolean login2(String username ,String password){
        if(username == null || password == null){
            return false;
        }
        //�������ݿ��ж��Ƿ��¼�ɹ�
        Connection conn = null;
        PreparedStatement pstmt =  null;
        ResultSet rs = null;
        //1.��ȡ����
        try {
            conn =  JDBCUtils.getConnection();
            //2.����sql
            String sql = "select * from user where username = ? and password = ?";
            //3.��ȡִ��sql�Ķ���
            pstmt = conn.prepareStatement(sql);
            //��?��ֵ
            pstmt.setString(1,username);
            pstmt.setString(2,password);
            //4.ִ�в�ѯ,����Ҫ����sql
            rs = pstmt.executeQuery();
            //5.�ж�
            return rs.next();//�������һ�У��򷵻�true

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,pstmt,conn);
        }


        return false;
    }
}

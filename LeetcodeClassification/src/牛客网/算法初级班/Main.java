package ţ����.�㷨������;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/9/18 21:12
 */

import java.util.Scanner;

/**
 * ����ũ�����г����ĸţÿ��ֻ����1ͷСĸţ������������������һ��ũ����1ֻ�����ĸţ��
 * �ӵڶ��꿪ʼ��ĸţ��ʼ��Сĸţ��ÿֻСĸţ����֮������ֿ�����Сĸţ����������N��
 * ���N����ţ����������
 * ���е�ţ�������������Ե�n-1���ţ�������ʧ�ػ��n�ꡣͬʱ�����г����ţ������1ͷ�µ�ţ��
 * ��ô�����ţ���������ǵ�n-3�������ţ������n��Ŀ϶����ǳ����ţ����������ţ�϶���û�г��졣
 * ����C(N)=C(N-1)+C(N-3).
 * ��ʼ�� C��1��==1  C(2)==2  C(3)==3
 * ��쳲������ر����ơ�
 */
public class Main {
    /*//�����ݹ�
    public int c1(int n){
        if(n<0) return 0;
        if(n==1||n==2||n==3) return n;
        return c1(n-1)+c1(n-3);
    }
    //olog(n)
    //C(N)=C(N-1)+C(N-3).��һ������������У�һ�������þ���˷�����ʽ��ʾ����״̬����Ϊ3*3����
    public int c3(int n){
        if(n<0) return 0;
        if(n==1||n==2||n==3) return n;
        int [][] base={{1,1,0},{0,0,1},{1,0,0}};
        int [][]result=matrixPower(base,n-2);
        return 3*result[0][0]+2*result[1][0]+result[2][1];
    }
    //�������
    public int[][] muliMatrix(int [][]m1,int [][]m2){
        int [][]result=new int[m1.length][m2[0].length];
        for(int i=0;i<m1.length;i++){
            for(int j=0;j<m2[0].length;j++){
                for(int k=0;k<m2.length;k++){
                    result[i][j]+=m1[i][k]*m2[k][j];
                }
            }
        }
        return result;
    }
    //�����n����
    public int[][] matrixPower(int [][]m,int p){
        int [][]result=new int[m.length][m[0].length];
        for(int i=0;i<result.length;i++){
            result[i][i]=1;
        }
        int [][]temp=m;
        for(;p!=0;p>>=1){
            if((p&1)!=0){
                result=muliMatrix(result,temp);
            }
            temp=muliMatrix(temp,temp);
        }
        return result;
    }*/

    public  int cowNums(int n){
        int []dp=new int [n+1];
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        if(n==2)
            return 2;
        if(n==3)
            return 3;
        dp[0]=0;
        dp[1]=1;
        dp[2]=2;
        dp[3]=3;
        for(int i=4;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-3];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Main m = new Main();
        Scanner sc = new Scanner(System.in);
        int n;
        while (sc.hasNextInt()) {
            n = sc.nextInt();
            System.out.println(m.cowNums(n));
        }
    }
}

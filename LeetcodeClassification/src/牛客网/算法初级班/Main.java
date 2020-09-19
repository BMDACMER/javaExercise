package 牛客网.算法初级班;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/9/18 21:12
 */

import java.util.Scanner;

/**
 * 假设农场中有成熟的母牛每年只会生1头小母牛，并且永不会死。第一年农场有1只成熟的母牛，
 * 从第二年开始，母牛开始生小母牛，每只小母牛三年之后成熟又可以生小母牛，给定正数N，
 * 求出N年后的牛的数量。。
 * 所有的牛都不会死，所以第n-1年的牛会毫无损失地活到第n年。同时。所有成熟的牛都会生1头新的牛，
 * 那么成熟的牛的数量就是第n-3年的所有牛，到第n年的肯定都是成熟的牛。其间出生的牛肯定都没有成熟。
 * 所以C(N)=C(N-1)+C(N-3).
 * 初始项 C（1）==1  C(2)==2  C(3)==3
 * 与斐波那契特别类似。
 */
public class Main {
    /*//暴力递归
    public int c1(int n){
        if(n<0) return 0;
        if(n==1||n==2||n==3) return n;
        return c1(n-1)+c1(n-3);
    }
    //olog(n)
    //C(N)=C(N-1)+C(N-3).是一个三姐递推数列，一定可以用矩阵乘法的形式表示。且状态矩阵为3*3矩阵
    public int c3(int n){
        if(n<0) return 0;
        if(n==1||n==2||n==3) return n;
        int [][] base={{1,1,0},{0,0,1},{1,0,0}};
        int [][]result=matrixPower(base,n-2);
        return 3*result[0][0]+2*result[1][0]+result[2][1];
    }
    //矩阵相乘
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
    //矩阵的n次幂
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

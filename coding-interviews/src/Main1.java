import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        int n, m, a, b;
        Scanner scan = new Scanner(System.in);

        while (true) {
            ArrayList<Integer> list = new ArrayList<>();
            n = scan.nextInt();
            m = scan.nextInt();
            a = scan.nextInt();
            b = scan.nextInt();

//            if (n < 1 || m < 1 || a <1 || b < 1 || n > 100 || m > 100 || a > 100 || b > 100 ){
//                return;
//            }
            int lost;
            if (n >= m) {
                lost = n - m;
            } else {
                lost = n - (m % n);
            }

            int cost;
            for (int i = 0; i <= lost; i++) {
                cost = 0;
                for (int j = 0; j <= lost; j++) {
                    if (i + j == lost) {
                        cost += a * i + b * j;
                        list.add(cost);
                    }
                }
            }

            Collections.sort(list);
            System.out.println(list.get(0));
        }

    }
}


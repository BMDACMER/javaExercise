import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 优先比较数组小的，在比较编号大的
 */
public class Solution1 {
    /*
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
       int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = 100000;
            }
        }

        for (int i = 0; i < edges.length; i++) {
            int start = edges[i][0];
            int end = edges[i][1];
            int weight = edges[i][2];
            dist[start][end] = weight;
            dist[end][start] = weight;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    dist[j][k] = Math.min(dist[j][k], dist[j][i] + dist[i][k]);
                }
            }
        }

        int res = -1;
        int minCount = 100000;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && dist[i][j] <= distanceThreshold) {
                    count++;
                }
            }

            if (count <= minCount) {
                minCount = count;
                res = i;
            }
        }
        return res;
    }

     */

    /**
     * public List<String> removeSubfolders(String[] folder) {
     * Arrays.sort(folder);
     * List<String> ans = new ArrayList<>();
     * int a = 0;
     * ans.add(folder[0]);
     * for (int i = 1; i < folder.length; i++) {
     * if (!folder[i].startsWith(folder[a] + "/")) {
     * a = i;
     * ans.add(folder[a]);
     * }
     * }
     * return ans;
     * <p>
     * }
     */

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] setArr = new int[n];
        for (int i = 0; i < bookings.length; i++) {
            int start = bookings[i][0] - 1;
            int end = bookings[i][1] - 1;
            int num = bookings[i][2];
            for (int j = start; j <= end; j++) {
                setArr[j] += num;
            }
        }
        return setArr;
    }
}

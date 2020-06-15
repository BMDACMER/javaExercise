package leetcode.mockInterview;
// https://leetcode-cn.com/problems/insert-interval/solution/
// 太难了
public class Interval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int start = 0;
        int end=intervals.length - 1;
        // 合并数组的left值
        Integer left = Integer.MIN_VALUE;
        // 合并数组的right值
        Integer right = Integer.MIN_VALUE;
        // 寻找left
        while (start<intervals.length) {
            if (newInterval[0]<=intervals[start][1]) {
                left = Math.min(intervals[start][0], newInterval[0]);
                break;
            } else
                start++;
        }
        // 没有找到left值说明目标数组应该放到最右边，提前结束
        if (left==Integer.MIN_VALUE){
            int[][] ints = new int[intervals.length + 1][2];
            System.arraycopy(intervals,0,ints,0,intervals.length);
            ints[intervals.length]=newInterval;
            return ints;
        }
        //寻找right
        while (end>=start){
            if (newInterval[1]>=intervals[end][0]) {
                right = Math.max(intervals[end][1], newInterval[1]);
                break;
            }else
                end--;
        }
        //没找到right值但是有left值,说明说明目标数组应该在索引start之后且不需要合并，提前结束。
        if (right==Integer.MIN_VALUE){
            int[][] ints = new int[intervals.length+1][2];
            System.arraycopy(intervals,0,ints,0,start);
            System.arraycopy(intervals,start,ints,start+1,intervals.length-start);
            ints[start]=newInterval;
            return ints;
        }
        //有left有right,则复制合并区间的左边和右边，中间是{left,right}。
        int[][] ints = new int[intervals.length-(end-start)][2];
        if (start>0)    //合并的是第一个，不需要往前复制了。
            System.arraycopy(intervals,0,ints,0,start);
        if (end+1<=intervals.length-1)  //合并的是最后一个，不需要往后复制了。
            System.arraycopy(intervals,end+1,ints,start+1,ints.length-start-1);
        ints[start]=new int[]{left,right};
        return ints;
    }
}

package leetcode.mockInterview;
// https://leetcode-cn.com/problems/insert-interval/solution/
// ̫����
public class Interval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int start = 0;
        int end=intervals.length - 1;
        // �ϲ������leftֵ
        Integer left = Integer.MIN_VALUE;
        // �ϲ������rightֵ
        Integer right = Integer.MIN_VALUE;
        // Ѱ��left
        while (start<intervals.length) {
            if (newInterval[0]<=intervals[start][1]) {
                left = Math.min(intervals[start][0], newInterval[0]);
                break;
            } else
                start++;
        }
        // û���ҵ�leftֵ˵��Ŀ������Ӧ�÷ŵ����ұߣ���ǰ����
        if (left==Integer.MIN_VALUE){
            int[][] ints = new int[intervals.length + 1][2];
            System.arraycopy(intervals,0,ints,0,intervals.length);
            ints[intervals.length]=newInterval;
            return ints;
        }
        //Ѱ��right
        while (end>=start){
            if (newInterval[1]>=intervals[end][0]) {
                right = Math.max(intervals[end][1], newInterval[1]);
                break;
            }else
                end--;
        }
        //û�ҵ�rightֵ������leftֵ,˵��˵��Ŀ������Ӧ��������start֮���Ҳ���Ҫ�ϲ�����ǰ������
        if (right==Integer.MIN_VALUE){
            int[][] ints = new int[intervals.length+1][2];
            System.arraycopy(intervals,0,ints,0,start);
            System.arraycopy(intervals,start,ints,start+1,intervals.length-start);
            ints[start]=newInterval;
            return ints;
        }
        //��left��right,���ƺϲ��������ߺ��ұߣ��м���{left,right}��
        int[][] ints = new int[intervals.length-(end-start)][2];
        if (start>0)    //�ϲ����ǵ�һ��������Ҫ��ǰ�����ˡ�
            System.arraycopy(intervals,0,ints,0,start);
        if (end+1<=intervals.length-1)  //�ϲ��������һ��������Ҫ�������ˡ�
            System.arraycopy(intervals,end+1,ints,start+1,ints.length-start-1);
        ints[start]=new int[]{left,right};
        return ints;
    }
}

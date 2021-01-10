package xiaohaoAlgorithm.oneQuestionPerDay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2021/1/10 8:52
 *
 * 228. 汇总区间
 */
public class SummaryRange {

    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums.length == 0) return res;

        int startIndex = 0;
        int endIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i-1] == 1) {
                endIndex = i;
            }else {
                res.add(help(nums,startIndex,endIndex));
                startIndex = endIndex = i;
            }
        }
        // 将最后一次的字符串 添加到结果中
        res.add(help(nums,startIndex,endIndex));

        return res;
    }

    public String help(int[] nums, int startIndex, int endIndex) {
        StringBuilder sb = new StringBuilder();
        if (startIndex < endIndex) {
            sb.append(nums[startIndex]).append("->").append(nums[endIndex]);
        } else {
            sb.append(nums[startIndex]);
        }
        return sb.toString();
    }

    public static void  main(String[] args) {
        int[] arr = {0,1,2,4,5,7};
        SummaryRange s = new SummaryRange();

        for (String str : s.summaryRanges(arr)) {
            System.out.print(str + " ");
        }
    }

    // 方法二：
    public List<String> summaryRanges2(int[] nums) {
        List<String> ans = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < nums.length; ++i){
            if(!(i + 1 < nums.length && nums[i] == nums[i + 1] - 1)){
                if(sb.length() > 0) sb.append("->");
                sb.append(nums[i]);
                ans.add(sb.toString());
                sb = new StringBuilder();
            } else{
                if(sb.length() == 0) sb.append(nums[i]);
            }
        }
        return ans;
    }
}

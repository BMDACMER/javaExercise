import java.util.HashSet;

/**
 * ��һ������Ϊn����������������ֶ���0��n-1�ķ�Χ�ڡ� ������ĳЩ�������ظ��ģ�����֪���м����������ظ��ġ�
 * Ҳ��֪��ÿ�������ظ����Ρ����ҳ�����������һ���ظ������֡�
 * ���磬������볤��Ϊ7������{2,3,1,0,2,5,3}����ô��Ӧ������ǵ�һ���ظ�������2��
 */
public class Test51 {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    ����Ҫ�ر�ע��~���������ظ���һ������ֵduplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public static boolean duplicate(int numbers[],int length,int [] duplication) {
        duplication[0] = -1;
        if (length < 1 || numbers == null) {
            return false;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < length; i++) {
            if (!set.contains(numbers[i])) {
                set.add(numbers[i]);
            } else {
                duplication[0] = numbers[i];
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = {0};
        int numbers[] = {2,1,3,1,4};
        System.out.println(duplicate(numbers,7,a));
    }
}

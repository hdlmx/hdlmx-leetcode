package cn.hdlmx.leetcode;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * <p>
 * 你可以按任意顺序返回答案。
 * 例如：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SumNumber {
    public int[] twoSum(int[] nums, int target) {
        int[] index = new int[2];
        //解决本题主要使用hash表查找特性，用HashMap来存储遍历过的元素，key为nums元素值，V为nums的下标
        HashMap<Integer, Integer> container = new HashMap<>(nums.length - 1);
        //遍历元素
        for (int i = 0; i < nums.length; i++) {
            //每次遍历的元素都存入index中的第一个位置，最后一个通过元素通过的下标通过计算获得
            index[0] = i;
            //通过target-当前元素，来获取当前元素与目标元素的和为target因为多少
            int rest = target - nums[i];
            //判断目标元素是否是之前遍历过的元素，如果是则获取该元素的下表，否则将此次遍历的元素值与下标存入hashmap中
            if (container.containsKey(rest)) {
                index[1] = container.get(rest);
            } else {
                container.put(nums[i], i);
            }
        }
        return index;
    }

    @Test
    public void test() {
        SumNumber sumNumber = new SumNumber();
        int[] nums = new int[]{1, 2, 3, 4, 5};
        int[] index = sumNumber.twoSum(nums, 9);
        for (int i = 0; i < index.length; i++) {
            System.out.println(index[i]);
        }

    }
}

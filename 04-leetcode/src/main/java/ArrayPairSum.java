import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author YeYaqiao
 * 561. 数组拆分 I
 */
public class ArrayPairSum {

    public int arrayPairSum(int[] nums) {

        int result = 0;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i += 2) {
            result = result + nums[i];
        }

        return result;
    }
}

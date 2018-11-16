//冒泡算法
package suanfa;

import org.junit.Test;

import java.util.Arrays;

public class demo_maopao {
    /**
     * 利用冒泡算法将数字排列顺序
     * 将大的数字放在右边,小的放在左边
     * 冒泡排序
     * 比较方式：相邻的两个元素进行比较.满足条件就会进行位置交换
     * 原理：内循环结束一次，最值出现在尾角标位置
     */

    @Test
    public void TestMaoPao() {

        int[] arr = new int[]{12, 34, 56, 7, 8, 86, 45};

        System.out.println("排序前：" + Arrays.toString(arr));

        for (int i = 0; i < arr.length - 1; i++) { //进行一趟的排序
            for (int j = 0; j < arr.length - 1 - i; j++) {   //前后两个数之间进行比较
//                判断两个数的大小
                if (arr[j] > arr[j + 1]) {
                    int tem = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tem;
                }
            }
            System.out.println("排序后：" + Arrays.toString(arr));
        }
        System.out.println("\n***************************");
        System.out.println("排序后：" + Arrays.toString(arr));
    }


    /**
     * 数组的反向遍历
     */

    @Test
    public void ArrayFanXiang() {

        int[] array = new int[]{12, 3, 4, 54, 5, 64, 648, 979, 821, 4, 549, 4, 98};

        for (int i = array.length - 1; i >= 0; i--) {

            System.out.println(array[i]);
        }

    }




    /**
     * 获取数组中的最大值
     * 思路：
     * 1.需要进行比较,并定义变量中每次比较之后的最大值
     * 2.对数组中的元素进行遍历取出,和变量中的记录的元素进行比较
     */

    @Test
    public void Array() {


    }

}

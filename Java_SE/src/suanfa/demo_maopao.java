//冒泡算法
package suanfa;

public class demo_maopao {
    /**
     * 利用冒泡算法将数字排列顺序
     * 将大的数字放在右边,小的放在左边
     * 冒泡排序
     * 比较方式：相邻的两个元素进行比较.满足条件就会进行位置交换
     * 原理：内循环结束一次，最值出现在尾角标位置
     */

    public static void main(String[] args) {

        int[] a = {121, 3, 23, 54, 3};
        for (int l : a) {
            System.out.println(l);
        }
        System.out.println("排序前的数组：" +);
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 1; j < i; j++) {
                if (a[j] > a[j + 1]) {
                    int tem = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tem;
                }

            }
        }

    }


}

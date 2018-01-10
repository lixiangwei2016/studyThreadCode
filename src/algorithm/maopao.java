package algorithm;

/**
 * Created by lixiangwei2 on 2017/12/29.
 * 冒泡排序
 * N个数字要排序完成，总共进行N-1趟排序，每i趟的排序次数为(N-i)次
 * 时间复杂度O(n)
 */
public class maopao {

    private static int arr[] = {5, 7, 3, 45, 23, 63, 243, 12, 32, 1, 3, 5, 3453};

    public static void main(String[] args) {
        for (int i = 0; i < arr.length - 1; i++) {//外层循环控制排序趟数
            for (int j = 0; j < arr.length - 1 - i; j++) {//内层循环控制每一趟排序多少次
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        for (int i : arr) {
            System.out.println(i);
        }
    }
}

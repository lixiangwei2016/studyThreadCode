package algorithm;

/**
 * Created by lixiangwei2 on 2017/12/29.
 */
public class quick {
    private static int arr[] = {5, 7, 3, 45, 23, 63, 243, 12, 32, 1, 3, 5, 3453};

    public static void main(String[] args) {
        sort(arr,0,arr.length-1);
        for (int i : arr) {
            System.out.println(i);
        }
    }
    public static void sort(int[] data,int start,int end){
        if (start < end) {
            int base = data[start]; // 选定的基准值（第一个数值作为基准值）
            int temp; // 记录临时中间值
            int i = start, j = end;
            do {
                while ((data[i] < base) && (i < end))
                    i++;
                while ((data[j] > base) && (j > start))
                    j--;
                if (i <= j) {
                    temp = data[i];
                    data[i] = data[j];
                    data[j] = temp;
                    i++;
                    j--;
                }
            } while (i <= j);
            if (start < j)
                sort(data, start, j);
            if (end > i)
                sort(data, i, end);
        }

    }
}

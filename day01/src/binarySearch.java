import java.util.Arrays;

/**
 * @program: code
 * @description:二分查找
 * @author: ZCH
 * @create: 2023-02-27 11:54
 **/
public class binarySearch {
            public static boolean find(int[] arr,int num){
                if (arr == null || arr.length == 0){
                    return false;
                }
                int L=0;
                int R= arr.length-1;
                while (L<=R){
                    int mid=(L+R)/2;
                    if (arr[mid]==num){
                        return true;
                    } else if (arr[mid]<num) {
                        L=mid+1;
                    }else {
                        R=mid-1;
                    }
                }
                return false;
            }

            //返回一个数组arr，arr长度[0,maxLen-1],arr中的每个值[0,maxValue-1]
            public static int[] lenRandomValueRandom(int maxLen,int maxValue){
                int len=(int) (Math.random()*maxLen);
                int[] ans=new int[len];
                for (int i = 0; i <len ; i++) {
                    ans[i]=(int) (Math.random()*maxValue);
                }
                return ans;
            }

            public static boolean test(int[] sortedArr, int num) {
                for (int cur : sortedArr) {
                    if (cur == num) {
                        return true;
                    }
                }
                return false;
            }


    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 10;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr = lenRandomValueRandom(maxSize, maxValue);
            Arrays.sort(arr);
            int value = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
            if (test(arr, value) != find(arr, value)) {
                System.out.println("出错了！");
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }



}

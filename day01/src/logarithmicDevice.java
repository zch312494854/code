/**
 * @program: code
 * @description: 对数器
 * @author: ZCH
 * @create: 2023-02-28 08:20
 **/
public class logarithmicDevice {
    //插入排序
    public static void insertionSort(int[] arr) {
        if (arr.length >= 2) {
            for (int i = 1; i < arr.length; i++) {
                //挖出一个要用来插入的值,同时位置上留下一个可以存新的值的坑
                int x = arr[i];
                int j = i - 1;
                //在前面有一个或连续多个值比x大的时候,一直循环往前面找,将x插入到这串值前面
                while (j >= 0 && arr[j] > x) {
                    //当arr[j]比x大的时候,将j向后移一位,正好填到坑中
                    arr[j + 1] = arr[j];
                    j--;
                }
                //将x插入到最前面
                arr[j + 1] = x;
            }
        }
    }

    //选择排序
    public static void selectionSort(int[] arr){
        for(int i = 0; i < arr.length - 1 ; i++){
            int min = i; // 遍历的区间最小的值
            for (int j = i + 1; j < arr.length ;j++){
                if(arr[j] < arr[min]){
                    // 找到当前遍历区间最小的值的索引
                    min = j;
                }
            }
            if(min != i){
                // 发生了调换
                int temp =  arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
            }
        }
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
    public static int[] copyArry(int[] arr){
        int[] ans=new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ans[i]=arr[i];
        }
        return ans;
    }
    //arr1和arr2一定等长
    public static boolean equalValues(int[] arr1,int[] arr2){
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i]!=arr2[i]){
                return false;
            }
        }
        return true;
    }
    public static boolean isSorted(int[] arr){
        if(arr.length<2){
            return true;
        }
        int max=arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max>arr[i]){
                return false;
            }
            max=Math.max(max,arr[i]);

        }
        return true;
    }

    public static void main(String[] args) {
        int maxLen=50;
        int maxValue=1000;
        int testTime=10000;
        for (int i = 0; i < testTime; i++) {
            int[] arr1=lenRandomValueRandom(maxLen,maxValue);
            int[] temp=copyArry(arr1);
            selectionSort(arr1);
            insertionSort(arr1);
            if (!isSorted(arr1)){
                for (int j = 0; j < temp.length; j++) {
                    System.out.println(temp[j]+" ");
                }
                System.out.println();
                System.out.println("排序错误 ");
            }

        }
    }
}

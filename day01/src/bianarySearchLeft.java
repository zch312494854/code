import java.util.Arrays;

/**
 * @program: code
 * @description: 最左值位置查询
 * @author: ZCH
 * @create: 2023-03-01 09:11
 **/
public class bianarySearchLeft {
    //arr有序的，>=num最左
    public static  int mostLeftNoLessNumIndex(int[] arr,int num){
        if(arr==null||arr.length==0){
            return -1;
        }
        int L=0;
        int R= arr.length-1;
        int ans=-1;
        while (L<=R){
            //ans更新
            int mid=(L+R)/2;
            if(arr[mid]>=num){
                ans=mid;
                R=mid-1;
            }else {
                L=mid+1;
            }
        }
        return ans;
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

    public static int test(int[] arr,int value){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>=value){
                return  i;
            }
        }
        return -1;
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
            if (test(arr, value) != test(arr, value)) {
                System.out.println("出错了！");
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }
}

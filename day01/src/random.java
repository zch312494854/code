/**
 * @program: code
 * @description: Math.random()
 * @author: ZCH
 * @create: 2023-02-27 09:47
 **/
public class random {
    public static void main(String[] args) {
        System.out.println("测试开始");
        //Math.random->做到的是doble->[0,1)
        //
        int testTimes=10000000;
        int count=0;
        for (int i = 0; i < testTimes; i++) {
            if (Math.random()<0.3){
                count++;
            }
        }
        System.out.println((double) count/(double)testTimes);//是等概率的
        System.out.println("===============================================");
        //[0,1)->[0,8)
         count=0;
        double ans=Math.random()*8;
        for (int i = 0; i < testTimes; i++) {
            //一共有八段   概率为4/8
            if (Math.random()*8<4){
                count++;
            }
        }
        System.out.println((double) count/(double)testTimes);
        System.out.println("===============================================");
        //int k=?   范围[0,k)
        //若int ans=(int)(Math.random()*k)     [0,k-1]
        int k=9;
        int[] counts=new int[9];
        for (int i = 0; i < testTimes; i++) {
            int anss=(int)(Math.random()*k);
            counts[anss]++;
        }
        for (int i = 0; i < k; i++) {
            System.out.println(i+"这个数出现了"+counts[i]+"次");

        }
        System.out.println("===============================================");
        //[0,x)范围上的数出现概率由原来的x调整成x平方
        count=0;
        double x=0.9;
        for (int i = 0; i < testTimes; i++) {
            if(xToXPower2()<x){
                count++;
            }

        }
        System.out.println((double) count/(double)testTimes);
        System.out.println(Math.pow(x,2));


        System.out.println("===============================================");

        counts=new int[8];
        for (int i = 0; i < testTimes; i++) {
            int nums=f3();
            counts[nums]++;

        }
        for (int i = 0; i < 8; i++) {
            System.out.println(i+"这个数出现了"+counts[i]+"次");
        }

    }
    //返回[0,1)的一个数
    //任意的x，x属于[0,1),[0,x)范围上的数出现概率由原来的x调整成x平方
    public static double xToXPower2(){
        return Math.max(Math.random(),Math.random());
//        return Math.max(Math.random(),Math.max(Math.random(),Math.random());
    }

    //条件只能1-5随机
    public static int f1(){
        return (int)(Math.random()*5)+1;
    }
    //随机机制，只能用f1
    //等概率返回0和1
    public static int f2(){
        int ans=0;
        do {
             ans=f1();
         }while (ans==3);
        return ans< 3 ? 0 : 1;
    }
    //得到000~111做到的概率,实现1-7等概率
    public static int f3(){
        return  (f2() << 2)+(f2() << 1)+(f2() << 0);
    }
    //0-6等概率返回一个
    public static int f4(){
        int ans=0;
        do {
            ans=f3();
        }while (ans==7);
        return ans;
    }
    //等概率1-7
    public static int g(){
        return f4()+1;
    }
    //首先现将给定条件化成0和1，若偶数可以直接换算，若为奇数则需要将中间的数字重新计算返回。
    //利用01二进制位计算组成得到想要的答案
    //若不在范围内，则重新计算。


}

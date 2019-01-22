/**
 *
 * @author percy 希尔排序
 * 选择一个增量序列 t1，t2，……，tk，其中 ti > tj, tk = 1；
 * 按增量序列个数 k，对序列进行 k 趟排序；
 * 每趟排序，根据对应的增量 ti，将待排序列分割成若干长度为 m 的子序列，分别对各子表进行直接插入排序。仅增量因子为 1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
 *
 */
public class ShellSort {
    static int count = 10;
    static long[] longs = new long[count];
    private void ShellSort_(){
        int step = count/2;
        do {
            for (int i=0;i<step;i++){
                for(int j=i;j+step<count;j+=step){
                    long min=longs[j];
                    int position = j;
                    int w=j;
                    while((w)<count-1){
                        if (w+step>count-1){
                            break;
                        }
                        w+=step;
                    }
                    for(int x=j;x<count;x+=step){
                        if (longs[x]<min){
                            min = longs[x];
                            position = x;
                            Swap(longs,position,j);
                        }
                    }


                }
            }

            step = step/2;
        }while(step>=1);//这个地方的条件一定要注意step=1时还要计算一次
    }
    private void Swap(long[] list, int i, int j) {
        long c = list[i];
        list[i] = list[j];
        list[j] = c;
    }

    public static void main(String[] args) {

        for (int i = 0; i < count; i++) {
            longs[i] = Math.round(Math.random() * 1000);
            System.out.print(longs[i] + " ");
        }
        System.out.println("\n");
        System.out.println("------选择排序之后的序列------");
        new ShellSort().ShellSort_();
        for (int i = 0; i < count; i++) {

            System.out.print(longs[i] + " ");
        }
    }
}

package main.book;

public class Sort {


    public static void main(String[] args){
        int[] ar = new int[]{3,5,1,2,4,8,0,0,1441};
        heapSort(ar,3);
        //quickSort(ar);
        showAr(ar);
    }

    public static void bullenSort(int ar[]){
        int len = ar.length;
        for(int x=len-1;x>=0;x--){

            for(int y=0;y<x;y++){

                if(ar[y]>ar[y+1]){
                    int temp = ar[y];
                    ar[y] = ar[y+1];
                    ar[y+1] = temp;
                }

            }
        }
    }

    /**
     *
     * @param ar 排序的数组
     */
    public static void quickSort(int ar[]){
        //quickSort(ar,0,ar.length-1);
        quickSort2(ar,0,ar.length-1);
    }

    /**
     * @param ar    排序的数组
     * @param begin     排序起始位置
     * @param end      排序结束位置
     */

    public static void quickSort(int[] ar,int begin,int end){
        //如果结束位置小于其实位置 递归退出
        if(end<begin){
            return;
        }

        int left = begin;
        int right = end;
        //选择 开始第一个元素位基准元素
        int temp = ar[begin];

        while (right>left){

            while (ar[right]>temp && right >left){
                right--;
            }
            ar[left] = ar[right];

            while(ar[left]<temp && right>left){
                left++;
            }
            ar[right] = ar[left];
        }
        //基准元素归位
        ar[right] = temp;
        //递归排序左右部分
        quickSort(ar,begin,left-1);
        quickSort(ar,left+1,end);
    }

    public static void quickSort2(int[] ar,int begin,int end ){
        if(begin > end){
            return;
        }

        int left = begin-1;
        int right = end+1;

        int temp = ar[begin];

        for(int x=0;x<right;x++){
            if(ar[x]>temp){
                swap(ar,--right,x--);
            }else if (ar[x]<temp){
                swap(ar,++left,x);
            }
        }

        quickSort2(ar,begin,left);
        quickSort2(ar,right,end);
    }

    public static void heapSort(int[] arr){
        heapSort(arr,arr.length);
    }

    public static void heapSort(int[] arr,int num){

        //1.构建大顶堆
        for(int i=arr.length/2-1;i>=0;i--){
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(arr,i,arr.length);
            showAr(arr);
        }

        System.out.println();
        //2.调整堆结构+交换堆顶元素与末尾元素
        for(int j=arr.length-1;j>0;j--){
            if(arr.length - j > num){
                return;
            }
            //将堆顶元素与末尾元素进行交换
            swap(arr,0,j);
            //重新对堆进行调整
            adjustHeap(arr,0,j);
            showAr(arr);
        }
    }

    /**
     * 调整大顶堆（仅是调整过程，建立在大顶堆已构建的基础上）
     * @param arr
     * @param i
     * @param length
     */
    private static void adjustHeap(int[] arr, int i, int length){
        //先取出当前元素i
        int temp = arr[i];
        //从i结点的左子结点开始，也就是2i+1处开始
        for(int k=i*2+1;k<length;k=k*2+1){
            //如果左子结点小于右子结点，k指向右子结点
            if(k+1<length && arr[k]<arr[k+1]){
                k++;
            }
            //如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
            if(arr[k] >temp){
                arr[i] = arr[k];
                i = k;
            }else{
                break;
            }

        }
        //将temp值放到最终的位置
        arr[i] = temp;
    }
    /**
     * 交换元素
     * @param arr
     * @param a
     * @param b
     */
    public static void swap(int []arr,int a ,int b){
        int temp=arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void showAr(int[] ar){
        for(int x=0;x<ar.length;x++){
            System.out.print(ar[x]+" ");
        }
        System.out.println();
    }

}

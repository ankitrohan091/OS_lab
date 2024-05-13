public class MinMax{
    public static void main(String[] args){
        int arr[]={7,12,862,88,18,3,88,2,47,2};
        traverse(arr);
        minMax(arr);
        LinearSearch(arr,88);
    }

    //WAP to Traverse 1D Array
    public static void traverse(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    //WAP to find MIN and MAX Element from 1D Array
    public static void minMax(int arr[]){
        int min=arr[0];
        int max=arr[0];
        for(int i=1;i<arr.length;i++){
            if(min>arr[i])
                min=arr[i];
            if(max<arr[i])
                max=arr[i];
        }
        System.out.println("Minimum Element is : "+min);
        System.out.println("Maximum Element is : "+max);
    }

    //WAP to Implement Linear Search
    public static void LinearSearch(int arr[],int key){
        int index=-1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==key) {
                index=i;
                break;
            }
        }
        if(index==-1)
            System.out.println(key+" is not exit in Array!");
        else
            System.out.println(key+" is exist at "+index+" in the Array!");
    }
}
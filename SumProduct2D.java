import java.util.Scanner;
public class SumProduct2D {
    public static void main(String[] args){
        print2D();
        int arr1[][]={{1,2,3},
                    {4,5,6},
                    {7,8,9}};
        int arr2[][]={{12,13,14},
                        {15,16,17},
                        {18,19,20}};
        calc2D(arr1, arr2);
    }

    //Print the element of 2-D Array. Value should entered at runtime. [aij]m*n where m=3 & n=3
    static final int m=3,n=3;
    public static void print2D(){
        Scanner sc=new Scanner(System.in);
        int arr[][]=new int[m][n];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                System.out.print("Enter element for index at "+i+" "+j+" : ");
                arr[i][j]=sc.nextInt();
            }
            System.out.println();
        }
        System.out.println("The array is : ");
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        sc.close();
        System.out.println();
    }

    //Calculate Sum & product of 2, 2-D Array
    public static void calc2D(int arr1[][],int arr2[][]){
        int sum[][]=new int[arr1.length][arr1[0].length];
        int product[][]=new int[arr1.length][arr1[0].length];
        for(int i=0;i<arr1.length;i++){
            for(int j=0;j<arr1[0].length;j++){
                sum[i][j]=arr1[i][j]+arr2[i][j];
            }
        }
        System.out.println("The Sum Array is : ");
        for(int i=0;i<arr1.length;i++){
            for(int j=0;j<arr1[0].length;j++){
                System.out.print(sum[i][j]+" ");
                product[i][j]=0;
                for(int k=0;k<arr1.length;k++){
                    product[i][j]+=arr1[i][j]*arr2[j][i];
                }
            }
            System.out.println();
        }
        System.out.println("The Product Array is : ");
        for(int i=0;i<arr1.length;i++){
            for(int j=0;j<arr1[0].length;j++){
                System.out.print(product[i][j]+" ");
            }
            System.out.println();
        }
    }
}

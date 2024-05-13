public class FCFS{
    static String process[]={"p1","p2","p3","p4","p5","p6"};
    int AT[]={0,1,2,3,4,5};
    int BT[]={3,2,1,4,5,2};
    static int numberOfProcess=process.length;
    int CT[]=new int[numberOfProcess];
    int TAT[]=new int[numberOfProcess];
    int WT[]=new int[numberOfProcess];
    public static void main(String[] args) {
        FCFS obj=new FCFS();
        obj.completionTime();;
        obj.turnArounTime();;
        obj.waitingTime();;
        obj.printArray();
        obj.printChart();
    }

    public void completionTime(){
        CT[0]=BT[0]-AT[0];
        for(int i=1;i<numberOfProcess;i++){
            CT[i]=CT[i-1]+BT[i];
        }
    }

    public void turnArounTime(){
        for(int i=0;i<numberOfProcess;i++){
            TAT[i]=CT[i]-AT[i];
        }
    }

    public void waitingTime(){
        for(int i=0;i<numberOfProcess;i++){
            WT[i]=TAT[i]-BT[i];
        }
    }

    public double average(int arr[]){
        double sum=0;
        for(int i=0;i<numberOfProcess;i++){
            sum+=arr[i];
        }
        sum/=numberOfProcess;
        String num=String.format("%.3f", sum);
        sum=Double.parseDouble(num);
        return sum;
    }

    public void printArray(){
        System.out.printf("%-5s %-5s %-5s %-5s %-5s %-5s","PID","A.T.","B.T.","C.T.","T.A.T.","W.T.");
        System.out.println();
        for(int i=0;i<numberOfProcess;i++){
            System.out.printf("%-5s %-5d %-5d %-5d %-5d %-5d"
            ,process[i],AT[i],BT[i],CT[i],TAT[i],WT[i]);
            System.out.println();
        }
        System.out.println();
        System.out.println("Average Completion Time is : "+average(CT));
        System.out.println("Average Turn-Around Time is "+average(TAT));
        System.out.println("Average Waiting Time is  : "+average(WT));
    }

    public void printChart(){
        System.out.print("|");
        int totalNumOfCT=(int) average(CT)*numberOfProcess;
        boolean toatlCT[]=new boolean[totalNumOfCT];
        for(int j=0;j<numberOfProcess;j++){
            toatlCT[CT[j]]=true;
        }

        for(int i=0;i<totalNumOfCT;i++){
            System.out.print("--");
        }
        System.out.println("|");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.print("|");
        for(int i=0;i<totalNumOfCT;i++){
            System.out.print("--");
        }
        System.out.println("|");
    }
}
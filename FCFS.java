import java.util.Scanner;
public class FCFS {
    public static void main(String[] args) {
        String[] attribute = {"PID", "A.T", "B.T", "C.T", "T.A.T", "W.T"};
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Number of processes: ");
        int size = scanner.nextInt();
        String[] process = new String[size];
        for(int i = 0; i < size; i++) {
            process[i] = "P" + (i + 1);
        }

        int[] arrival = new int[size];
        System.out.print("Enter arrival times: ");
        for(int i = 0; i < size; i++) {
            arrival[i] = scanner.nextInt();
        }

        int[] burst = new int[size];
        System.out.print("Enter burst times: ");
        for(int i = 0; i < size; i++) {
            burst[i] = scanner.nextInt();
        }

        int[] completion = new int[size];
        int s = arrival[0];
        for(int i = 0; i < size; i++) {
            completion[i] = s + burst[i];
            s = completion[i];
        }

        int[] turnaround = new int[size];
        for(int i = 0; i < size; i++) {
            turnaround[i] = completion[i] - arrival[i];
        }

        int[] waiting = new int[size];
        for(int i = 0; i < size; i++) {
            waiting[i] = turnaround[i] - burst[i];
        }

        System.out.println("    ------ Here's the complete table ------");
        for(int i = 0; i < 6; i++) {
            System.out.printf("%7s", attribute[i]);
        }
        System.out.println();
        for(int i = 0; i < size; i++) {
            System.out.printf("%7s", process[i]);
            System.out.printf("%7d", arrival[i]);
            System.out.printf("%7d", burst[i]);
            System.out.printf("%7d", completion[i]);
            System.out.printf("%7d", turnaround[i]);
            System.out.printf("%7d%n", waiting[i]);
        }

        s = 0;
        for(int i = 0; i < size; i++) {
            s += completion[i];
        }
        System.out.println();
        System.out.println("Average completion time = " + (s / size));

        s = 0;
        for(int i = 0; i < size; i++) {
            s += turnaround[i];
        }
        System.out.println("Average turnaround time = " + (s / size));

        s = 0;
        for(int i = 0; i < size; i++) {
            s += waiting[i];
        }
        System.out.println("Average waiting time = " + (s / size));
        scanner.close();
    }
}

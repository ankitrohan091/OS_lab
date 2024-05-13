import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
public class SJF {
    public static void main(String[] args) {
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
        
        // Create an array of Process objects
        Process[] processes = new Process[size];
        for (int i = 0; i < size; i++) {
            processes[i] = new Process(i + 1, arrival[i], burst[i]);
        }
        
        // Sort processes based on arrival time
        Arrays.sort(processes, Comparator.comparingInt(p -> p.arrivalTime));
        
        // Call SJF scheduling function
        sjfScheduling(processes);
        
        scanner.close();
    }   
    public static void sjfScheduling(Process[] processes) {
        int n = processes.length;
        int[] completion = new int[n];
        int[] turnaround = new int[n];
        int[] waiting = new int[n];
        
        int currentTime = 0;
        boolean[] visited = new boolean[n];
        int completed = 0;
        while (completed < n) {
            int shortestBurst = Integer.MAX_VALUE;
            int shortestIndex = -1;
            for (int i = 0; i < n; i++) {
                if (!visited[i] && processes[i].arrivalTime <= currentTime && processes[i].burstTime < shortestBurst) {
                    shortestBurst = processes[i].burstTime;
                    shortestIndex = i;
                }
            }
            if (shortestIndex == -1) {
                currentTime++;
                continue;
            }
            visited[shortestIndex] = true;
            completion[shortestIndex] = currentTime + processes[shortestIndex].burstTime;
            currentTime = completion[shortestIndex];
            turnaround[shortestIndex] = completion[shortestIndex] - processes[shortestIndex].arrivalTime;
            waiting[shortestIndex] = turnaround[shortestIndex] - processes[shortestIndex].burstTime;
            completed++;
        }

        // Print the table
        String[] attribute = {"PID", "A.T", "B.T", "C.T", "T.A.T", "W.T"};
        System.out.println("    ------ Here's the complete table ------");
        for(int i = 0; i < 6; i++) {
            System.out.printf("%7s", attribute[i]);
        }
        System.out.println();
        for(int i = 0; i < n; i++) {
            System.out.printf("%7s", processes[i].id);
            System.out.printf("%7d", processes[i].arrivalTime);
            System.out.printf("%7d", processes[i].burstTime);
            System.out.printf("%7d", completion[i]);
            System.out.printf("%7d", turnaround[i]);
            System.out.printf("%7d%n", waiting[i]);
        }

        // Calculate and print average times
        int sumCompletion = Arrays.stream(completion).sum();
        int sumTurnaround = Arrays.stream(turnaround).sum();
        int sumWaiting = Arrays.stream(waiting).sum();
        
        System.out.println();
        System.out.println("Average completion time = " + (sumCompletion / processes.length));
        System.out.println("Average turnaround time = " + (sumTurnaround / processes.length));
        System.out.println("Average waiting time = " + (sumWaiting / processes.length));
    }
}
class Process {
    int id;
    int arrivalTime;
    int burstTime;
    
    Process(int id, int arrivalTime, int burstTime) {
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
    }
}
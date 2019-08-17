import java.util.Random;

public class PriorityQueueScheduler implements ProcessScheduler {

    PriorityQueue q;
    Process processToRun;

    public PriorityQueueScheduler() {
        q = new PriorityQueue();
    }

    @Override
    public Process getProcessToRun() {
        if (q.length() == 0 && (processToRun == null || processToRun.getCycles() <= 0)) {
            //if so, then make an idle process that runs for a cycle
            processToRun = new Process("Idle", 1);
        } else if (processToRun == null || processToRun.getCycles() <= 0) {
            //nothing was running or it is done, a new process is needed
            processToRun = q.dequeue();
        } else {
            //continue to run the process that was running
        }
        System.out.println("ProcessToRun: " + processToRun);
        return processToRun;
    }

    @Override
    public void scheduleProcess(Process p) {
        System.out.println("Scheduling PID " + p.getId());
        Random randGen = new Random();
        int priority = randGen.nextInt(100);
        q.enqueue((new PriorityNode(p, priority, null)));

    }

}

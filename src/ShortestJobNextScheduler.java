
public class ShortestJobNextScheduler implements ProcessScheduler {

    QueueInterface<Process> q;
    Process processToRun;

    public ShortestJobNextScheduler() {
        q = new ShortestJobNextQueue();

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
        q.enqueue(p);
    }

}

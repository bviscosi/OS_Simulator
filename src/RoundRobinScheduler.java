
public class RoundRobinScheduler implements ProcessScheduler {

    protected QueueInterface<Process> q;
    protected Process processToRun;
    protected int timeQuantum = 3;

    public RoundRobinScheduler() {
        q = new LinkedQueue<Process>();
    }

    @Override
    public Process getProcessToRun() {
        if (q.length() == 0 && (processToRun == null || processToRun.getCycles() <= 0)) {
            processToRun = new Process("Idle", 1);
        } else if (processToRun == null || processToRun.getCycles() <= 0) {
            processToRun = q.dequeue();
            timeQuantum = 2;
        } else if (timeQuantum == 0) {
            q.enqueue(processToRun);
            processToRun = q.dequeue();
            timeQuantum = 2;
        } else {
            timeQuantum--;
        }
        System.out.println("ProcessToRun: " + processToRun);
        return processToRun;

    }
//        if (q.length() == 0 && (processToRun == null || processToRun.getCycles() <= 0)) {
//            //if so, then make an idle process that runs for a cycle
//            processToRun = new RRProcess("Idle", 1);
//        } else if (processToRun == null || processToRun.getCycles() <= 0) {
//
//            processToRun = q.dequeue();
//            if (processToRun.getCycles() == 0 && processToRun.getCyclesRemaining() > 0) {
//                q.enqueue(processToRun);
//            }
//
//        }
//
//        System.out.println("ProcessToRun: " + processToRun);
//        return processToRun;
//    }

    @Override
    public void scheduleProcess(Process p) {
        q.enqueue(p);
    }

}

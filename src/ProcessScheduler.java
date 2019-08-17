
public interface ProcessScheduler {

    public Process getProcessToRun();

    public void scheduleProcess(Process p);
}

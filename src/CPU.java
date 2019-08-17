
public class CPU {

    private final int CYCLE_DELAY = 500;

    public void run(Process p) {
        p.tick();
        System.out.println("Running PID: " + p.getId());
        delay();

    }

    private void delay() {
        try {
            Thread.sleep(CYCLE_DELAY);
        } catch (InterruptedException ex) {
            System.out.println("DELAY FAIL");
        }
    }
}

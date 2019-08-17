public class SimulationTester {

    public static void main(String[] args) {
        //modify to run your scheduler
        System.out.println("\n" + "FIRST COME FIRST SERVE:" + "\n");
        ProcessScheduler scheduler = new FirstComeFistServeScheduler();
        OSSimulation os = new OSSimulation(scheduler);
        //change the number of cycles
        os.simulate(50);
        System.out.println("\n" + "ROUND ROBIN:" + "\n");
        scheduler = new RoundRobinScheduler();
        os.simulate(50);
        System.out.println("\n" + "SHORTEST JOB NEXT:" + "\n");
        scheduler = new ShortestJobNextScheduler();
        os.simulate(50);
        System.out.println("\n" + "PRIORITY:" + "\n");
        scheduler = new PriorityQueueScheduler();
        os.simulate(50);

    }
}

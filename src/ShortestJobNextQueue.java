
public class ShortestJobNextQueue extends LinkedQueue<Process> {

    @Override
    public boolean enqueue(Process p) {

        if (this.length() > 1) {
            Process temp = frontValue();
            LinkedQueue<Process> tempQ = new LinkedQueue<>();
            int tempCycles = temp.getCycles();

            while (p.getCycles() >= tempCycles) { // using int tC so that when terminating while loop the process isn't altered

                if (length() > 1) { // copies over all shorter jobs to tempQ
                    tempQ.enqueue(dequeue());
                    temp = frontValue();
                    tempCycles = temp.getCycles();
                } else {
                    tempQ.enqueue(dequeue()); // adds last process to tempQ without resetting it to frontVal to avoid NullPointerException
                }
                tempCycles = p.getCycles() + 1; // terminates while loop by ensuring tempCyles is more than p.getCycles
            }
            tempQ.enqueue(p); // adds process after all shorter jobs have been enqueued

            for (int i = 0; i < length(); i++) { //copies over remaining processes to tempQ after new process is enqueued
                tempQ.enqueue(dequeue());

            }

            for (int i = 0; i < tempQ.length(); i++) {
                enqueue(tempQ.dequeue());   //copies over tempQ back to this q
            }
        } else {
            super.enqueue(p); //calls super for to initialize q when called for the first time
        }

        return true;
    }

}

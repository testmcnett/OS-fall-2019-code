// Note the difference below in the run() method
package interrupts;

public class ThreadInterruptExample2 implements Runnable {

	public static void main(String[] args) {
        Thread t1 = new Thread(new ThreadInterruptExample2());
        t1.start();
 
        try {
            Thread.sleep(50000);
            t1.interrupt();
 
        } catch (InterruptedException ex) {
            // do nothing
        }
 
    }
	
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("This is message #" + i);
 
            if (Thread.interrupted()) {
                System.out.println("I'm about to stop");
                return;
            }
        }
    } 
}

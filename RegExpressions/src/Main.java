import javax.xml.stream.Location;
import java.io.*;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args){

        System.out.println("Hello from the main Thread.");
        Thread anotherThread = new AnotherThread();
        anotherThread.setName("== Another Thread ==");  // Sets name of that class's thread
        anotherThread.start();  // Not allows to start more than once. Use start(), not run() always.

        new Thread() {
            public void run(){
                System.out.println("Hello from the anonymous class thread.");
            }
        }.start();

        Thread myRunnableThread = new Thread(new MyRunnable() {
            @Override
            public void run() {
                System.out.println("Hello from another annosmds");
                try{
                    anotherThread.join();   // Runs this thread next, making the myRunnableThread wait, and then continue. The numbers tells it how long to wait.
                    System.out.println("AnotherThread terminated, so I'm running again.");
                } catch (InterruptedException e) {
                    System.out.println("I couldn't wait after all. I was interrupted.");
                }
            }
        });
        myRunnableThread.start();

        //anotherThread.interrupt();  // Interrupts another thread putting it to sleep.

        System.out.println("Hello again from the main Thread.");



        // Will not print in order all the time, it is up to the computer.
        // Runs concurrently with the main method.
        // Use runnables more often because they are more flexible.


    }



}

package Thread;

public class RunThread implements Runnable {

	  public void run() {
	        System.out.println("Hello from a thread!");
	        //Get CSV Files
	        (new Thread(new Main.MassGet())).start();
	    }

	    public static void main(String args[]) {
	        (new Thread(new RunThread())).start();
	        (new Thread(new TestThread())).start();
	    }

	}

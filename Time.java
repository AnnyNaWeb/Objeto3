import java.util.concurrent.Semaphore;

public class Time {   
	Semaphore mutex;
	public Time(int N) {
	this.N = N;
	this.mutex = new Semaphore(1);
	}
	
	int N = 0;
    boolean ganhadorT = false;
    int PulosT = 0;
    int DistanciaT;
  

	public synchronized void Update(int distance) {
		try {
		mutex.acquire();
		PulosT += 1;
		DistanciaT += distance;
		}
		catch(InterruptedException e1) {
            e1.printStackTrace();
		}
		finally {
		mutex.release();
		}
	}
	public void Final() {

		System.out.println("Time " + (N+1) + " : pulou " + PulosT + " vezes e percorreu " + DistanciaT + "cm");
		
	}
	public void GanhadorF() {
		
		if(ganhadorT) {
			System.out.println("Time " + (N+1) + " foi o ganhador!");
		}
	}
}
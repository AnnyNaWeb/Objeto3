	import java.util.Random;
	import java.util.concurrent.Semaphore;
public class Grilo {
	Semaphore mutex;
    public Grilo(String Nome, int team) {
        this.nome = Nome;
        this.timeN = team;
        this.controller = new Semaphore(3);
        
    }
    Semaphore controller;
    Time times[] = null;
	String nome;
    int cms;
    Random rand = new Random();
    int atposicao = 0;
    int pulinhos = 0;
    int timeN = 0;
    boolean top = false;
    boolean acabou = false;
    
    public synchronized void Jump() {
    	try { 
    		controller.acquire(); 
    	
        cms = rand.nextInt(40);
        atposicao += cms;
        pulinhos += 1;
        Main.times[timeN].Update(cms);
        System.out.println("O " + nome + " pulou " + cms + "cm e já percorreu : " + atposicao + "cm");  
    }
  
    
    catch(InterruptedException e1) {
        e1.printStackTrace();
	}
	finally {		
		controller.release();
	}
    } 
    public void Ganhar() {
		top = true;
		Main.times[timeN].ganhadorT = true;
}
}
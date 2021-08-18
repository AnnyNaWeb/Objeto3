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
    boolean acabou = false;

    public synchronized void Jump() {
        cms = rand.nextInt(40);
        atposicao += cms;
        pulinhos += 1;
        System.out.println("O " + nome + " pulou " + cms + "cm e já percorreu : " + atposicao + "cm");  
    }
  
}


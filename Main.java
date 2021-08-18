import java.util.Scanner;

public class Main { 
	static int QtGrilos = 0;
    static int Times = 0;
	static int grilosnotime = 3;
	

	        
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
	    System.out.println("Quantos participantes a corrida vai ter? ");
        QtGrilos = scanner.nextInt();
        System.out.println("Grilos participantes " + QtGrilos);
        System.out.println("Quantos cms a corrida vai ter? ");
        Corrida.Pista = scanner.nextInt();
		
		CtlThread threads[] = null;
        Grilo[] grilos = new Grilo[QtGrilos];
        Time[] times = new Time[Times];
        
        if(QtGrilos % grilosnotime == 0) {
        	Times = (int)(QtGrilos / grilosnotime);
        }
        else {
        	Times = (int) Math.ceil(QtGrilos / grilosnotime); 
        }
        
        for ( int i = 0; i < QtGrilos; i++) {
            grilos[i] = new Grilo("Grilo_" + (i+1), i % Times );
        }
        for(int i = 0; i < Times; i++) {
        	
            times[i] = new Time(i);
            }
        
        Corrida.Inicio(QtGrilos, Times, threads, grilos, times);
    }
		}



import java.util.Scanner;
public class Main { 
	static int QtGrilos = 0;
    static int grupos = 0;
	static int grilosnotime = 3;
	public static Time[] times;
	 
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
	    System.out.println("Quantos participantes a corrida vai ter? ");
        QtGrilos = scanner.nextInt();
        System.out.println("Grilos participantes " + QtGrilos);
        System.out.println("Quantos cms a corrida vai ter? ");
        Corrida.Pista = scanner.nextInt();
		
		CtlThread threads[] = null;
        Grilo[] grilos = new Grilo[QtGrilos];
        
        
        if(QtGrilos % grilosnotime == 0) {
        	grupos = (int)(QtGrilos / grilosnotime);
        }
        else {
        	grupos = (int) Math.ceil(QtGrilos / grilosnotime + 1); 
        }
        times = new Time[grupos]; 
        
        for ( int i = 0; i < QtGrilos; i++) {
            grilos[i] = new Grilo("Grilo_" + (i+1), i % grupos );
        }
        for(int i = 0; i < grupos; i++) {
        	
            times[i] = new Time(i);
            }
        Corrida.Inicio(QtGrilos, grupos, threads, grilos, times);
    }
		}



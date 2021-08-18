import java.util.Scanner;
public class Main { 
	static int Grilos;
    static int grupos;
	public static Time[] times;
	private static Scanner scan;
	 
	public static void main(String[] args) {
		scan = new Scanner(System.in);
	    System.out.println("Quantos grilos irão competir?");
        Grilos = scan.nextInt();
        
        System.out.println("Quantos centímetros a corrida vai ter?");
        Corrida.Pista = scan.nextInt();
		
		CtlThread threads[] = null;
        Grilo[] grilos = new Grilo[Grilos];
        
        
        if(Grilos % 3 == 0) {
        	grupos = (int)(Grilos / 3);
        }
        else {
        	grupos = (int) Math.ceil(Grilos / 3 + 1); 
        }
        times = new Time[grupos]; 
        
        for ( int i = 0; i < Grilos; i++) {
            grilos[i] = new Grilo("Grilo_" + (i+1), i % grupos);
        }
        for(int i = 0; i < grupos; i++) {
        	
            times[i] = new Time(i);
            }
        Corrida.Inicio(Grilos, grupos, threads, grilos, times);
    }
		}
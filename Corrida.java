
public class Corrida {
	static int grilosf = 0;
	public static int Pista = 0;
	static int Colocacao = 1;
	static int timesf = 0;
	static int ColocacaoT = 1;
	static boolean ganharam = false;
	
	
	
	public static void Inicio(int QtGrilos, int Times, CtlThread[] thread, Grilo[] grilo, Time[] times) {
        thread = new CtlThread[QtGrilos];

        for(int i = 0; i < QtGrilos; i++) 
        {
            thread[i] = new CtlThread(grilo[i]);
            thread[i].start();
        }
        for (int i = 0; i < thread.length; i++) 
        {
          try 
          {
            thread[i].join();
          } 
          catch (InterruptedException e ) 
          {
              e.printStackTrace();
          }
        }
        
        while(grilosf < QtGrilos) {
        Corre(QtGrilos,Times, thread, grilo, times);
			
		}
    }

    public static void Corre(int QtGrilos,int Times, CtlThread[] thread, Grilo[] grilo, Time[] times) {
        for(int i = 0; i < QtGrilos; i++)
        for(int n = 0; n < Times; n++)
        {
            if(grilo[i].acabou != true)
            {
                if(grilo[i].atposicao >= Pista) 
                { 
                grilosf ++;
                System.out.println("O " + grilo[i].nome +" Chegou em " + grilo[i].pulinhos + " pulos") ;
                if(grilo[i].atposicao >= Pista)
                {
                	System.out.println("O " + grilo[i].nome + " é o " + Colocacao + " colocado");
                	Colocacao +=1;
                	
                }
                
                if(times[n].ganhadorT != true)
                { 
                	
                }
                	
                grilo[i].acabou = true;
                }
                else 
                {
                    thread[i].run();
                }
            }
        }
            for (int i = 0; i < thread.length; i++) 
            {
              try 
              {
                thread[i].join();
              } 
              catch (InterruptedException e ) 
              {
                  e.printStackTrace();
              }
            }
    }
}
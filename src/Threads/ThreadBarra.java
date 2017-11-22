package Threads;

import interfaz.IngresoDatos;


public class ThreadBarra extends Thread{

	public void run(){

		
		for(int i=0;i<=100;i++){
			
			IngresoDatos.PbhayEquipo.setValue(i);
			
			try {
				
				Thread.sleep(30);
				
				
				
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
				// TODO: handle exception
			}
			
		}
}

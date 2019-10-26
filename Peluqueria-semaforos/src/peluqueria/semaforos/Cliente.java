/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peluqueria.semaforos;

import java.util.concurrent.Semaphore;
/**
 *
 * @author SaFteiNZz
 */
public class Cliente extends Thread{
	int id;
	Semaphore sillasLibres;
	Semaphore sillaCortar;
	
	public Cliente(int id, Semaphore sillasLibres, Semaphore sillaCortar) 
        {
		this.id = id;
		this.sillasLibres = sillasLibres;
		this.sillaCortar = sillaCortar;
	}
	
	@Override
	public void run() {
		// Entra el cliente
		System.out.println("CLIENTE " + id + ": Hola, tienes hueco?");
		
		//Comprueba si hay sillas libres
		comprobarSillasLibres(sillasLibres, sillaCortar);
		
		// Cliente se va
		System.out.println("CLIENTE " + id + ": Hasta luego");
		System.out.println("--------------------------------");
	}
	
	private void comprobarSillasLibres(Semaphore semaforoSillasLibres, Semaphore semaforoSillacortar) {
		try {   
                        //Comprobar si el peluquero se ha dormido
                        if(semaforoSillasLibres.availablePermits() == Peluqueria.N && semaforoSillacortar.availablePermits() > 0) {
                            System.out.println("CLIENTE " + id + ": Eh tu! Despierta!");                        
                        } 
                        //Mirar si hay sillas libres
                        if(semaforoSillasLibres.availablePermits() > 0 ) {
                            // Coger una silla
                            semaforoSillasLibres.acquire();
                            System.out.println("PELUQUERO: Si tengo hueco CLIENTE " + id);
                            //Cortar el pelo
                            comprobarSillacortar(semaforoSillacortar);
                            //Liberar espacio en el semaforo
                            semaforoSillasLibres.release();    
                        //No hay sillas
			} else 
                        {
                            System.out.println("PELUQUERO: No tengo hueco, vuelve luego CLIENTE " + id );
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void comprobarSillacortar(Semaphore semaforoSillacortar) {
		try {
			//Coger el permiso de cortar el pelo
			semaforoSillacortar.acquire();
			
			System.out.println("- CLIENTE " + id + " se está cortando el pelo");
                        //Cortar el pelo (5 segundos)
			Thread.sleep(5000);
			System.out.println("- CLIENTE " + id + " se ha cortado el pelo");
			//Librar espacio en el semaforo de cortar el pelo
			semaforoSillacortar.release();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

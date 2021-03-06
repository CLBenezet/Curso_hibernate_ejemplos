package com.openwebinars.hibernate.herencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Herencia con Single Table
 * www.openwebinars.net
 * @LuisMLopezMag
 */
public class App {
	public static void main(String[] args) {
		
		//Configuramos el EMF a través de la unidad de persistencia
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SingleTable");

		//Generamos un EntityManager
		EntityManager em = emf.createEntityManager();

		//Iniciamos una transacción
		em.getTransaction().begin();
		
		CuentaCredito cuentaCredito = new CuentaCredito();
		cuentaCredito.setTitular("Luismi");
		cuentaCredito.setBalance(500.0);
		cuentaCredito.setTipoInteres(0.20);
		cuentaCredito.setLimiteCredito(600.0);

		
		CuentaDebito cuentaDebito = new CuentaDebito();
		cuentaDebito.setTitular("Luismi");
		cuentaDebito.setBalance(200.0);
		cuentaCredito.setTipoInteres(0.10);
		cuentaDebito.setCargoPorDescubierto(6.5);
		
		em.persist(cuentaCredito);
		em.persist(cuentaDebito);

		//Commiteamos la transacción
		em.getTransaction().commit();
		
		//Cerramos el EntityManager
		em.close();

	}
}

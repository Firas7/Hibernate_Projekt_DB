package de.hsh.dbs2.imdb;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import de.hsh.dbs2.imdb.entities.Movie;

public class Test1 {
	
	public static void main(String [] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dbcon");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		List<Movie> mov = (List<Movie>) em.createQuery("from Movie", Movie.class).getResultList();
		
		for(Movie e : mov) {
			System.out.println("***************************"+e.getTitle()+"****************************************");
			System.out.println("****************************"+e.getGenre()+"***************************************");
		}
		
		em.getTransaction().commit();
	}
}

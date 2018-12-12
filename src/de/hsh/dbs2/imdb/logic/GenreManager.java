package de.hsh.dbs2.imdb.logic;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import de.hsh.dbs2.imdb.entities.Genre;

public class GenreManager {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("dbcon");
	EntityManager em = emf.createEntityManager();
	/**
	 * Ermittelt eine vollstaendige Liste aller in der Datenbank abgelegten Genres
	 * Die Genres werden alphabetisch sortiert zurueckgeliefert.
	 * @return Alle Genre-Namen als String-Liste
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<String> getGenres() throws Exception {
		// TODO
		em.getTransaction().begin();
		Query q = em.createQuery("from Genre",Genre.class);
		List<Genre> genres = (List<Genre>) q.getResultList();
		List<String> genress = new ArrayList<String>();
		for(Genre g :  genres) {
			genress.add(g.toString());
		}
		
		em.getTransaction().commit();
		return genress;
	}

}

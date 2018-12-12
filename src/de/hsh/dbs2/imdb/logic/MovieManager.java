package de.hsh.dbs2.imdb.logic;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import de.hsh.dbs2.imdb.entities.Genre;
import de.hsh.dbs2.imdb.entities.Movie;
import de.hsh.dbs2.imdb.logic.dto.MovieDTO;

public class MovieManager {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("dbcon");
	EntityManager em = emf.createEntityManager();

	/**
	 * Ermittelt alle Filme, deren Filmtitel den Suchstring enthaelt.
	 * Wenn der String leer ist, sollen alle Filme zurueckgegeben werden.
	 * Der Suchstring soll ohne Ruecksicht auf Gross/Kleinschreibung verarbeitet werden.
	 * @param search Suchstring. 
	 * @return Liste aller passenden Filme als MovieDTO
	 * @throws Exception
	 */
	
	@SuppressWarnings("unchecked")
	public List<MovieDTO> getMovieList(String search) throws Exception {
		// TODO
		
		List<MovieDTO> list = new ArrayList<MovieDTO>();
		
		if(search.matches("[0-9]+")){
			
			list.add(getMovie(Long.parseLong(search)));
			
		}
		else{
			
			Query q = em.createQuery("from Movie where upper(title) like upper ('%"+search+"%')",Movie.class);
			//q.setParameter("search", search);
		
			List<Movie> movies = (List<Movie>) q.getResultList();
			for(int i = 0; i<movies.size();i++) {
				
				MovieDTO movDTO = new MovieDTO();
				movDTO.setId(movies.get(i).getId());
				movDTO.setTitle(movies.get(i).getTitle());
				movDTO.setType(movies.get(i).getType());
				movDTO.setYear(movies.get(i).getYear());
				//movDTO.setGenres(movies.get(i).getGenre());
				//movDTO.setCharacters(movies.get(i).getCharacter());
				list.add(movDTO);
			}
		}
		
		return list;
	}

	/*
	 * Speichert die uebergebene Version des Films neu in der Datenbank oder aktualisiert den
	 * existierenden Film.
	 * Dazu werden die Daten des Films selbst (Titel, Jahr, Typ) beruecksichtigt,
	 * aber auch alle Genres, die dem Film zugeordnet sind und die Liste der Charaktere
	 * auf den neuen Stand gebracht.
	 * @param movie Film-Objekt mit Genres und Charakteren.
	 * @throws Exception
	 */
	public void insertUpdateMovie(MovieDTO movieDTO) throws Exception {
		// TODO
		
		Movie movie = new Movie();
		Genre genre = new Genre();
		movie.setId(movieDTO.getId());
		movie.setTitle(movieDTO.getTitle());
		movie.setType(movieDTO.getType());
		movie.setYear(movieDTO.getYear());
		genre.setGenre(movieDTO.getGenres().toString());
		
	}

	/*
	 * Loescht einen Film aus der Datenbank. Es werden auch alle abhaengigen Objekte geloescht,
	 * d.h. alle Charaktere und alle Genre-Zuordnungen.
	 * @param movie
	 * @throws Exception
	 */
	
	public void deleteMovie(long movieId) throws Exception {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		Query q = em.createQuery("");
		
		em.getTransaction().commit();
	}

	
	@SuppressWarnings("unchecked")
	public MovieDTO getMovie(long movieId) throws Exception {
		// TODO Auto-generated method stub
		
		Query q = em.createQuery("from Movie where id = :movieId",Movie.class);
		q.setParameter("movieId", movieId);
		List<Movie> movies = (List<Movie>) q.getResultList();
		MovieDTO mov = new MovieDTO();
		mov.setId(movies.get(0).getId());
		mov.setTitle(movies.get(0).getTitle());
		mov.setType(movies.get(0).getType());
		mov.setYear(movies.get(0).getYear());
		mov.addGenre(movies.get(0).getGenre().toString());
		return mov;
	}
}
package de.hsh.dbs2.imdb.entities;

import javax.persistence.*;

/**
 * Diese Klasse stellt einen Filmcharakter da
 *
 * @author A-Team
 */
@Entity
@Table(name = "moviecharacter")
public class MovieCharacter {

	@Id
	@Column(name = "id")
	@GeneratedValue
	private int id;

	@Column(name = "character")
	private String character;

	@Column(name = "alias")
	private String alias;

	@Column(name = "pos")
	private int pos;

	@ManyToOne
	private Movie movie;

	@ManyToOne
	private Player player;

	/**
	 * Diese Methode gibt die ID zurück.
	 *
	 * @return ID
	 */
	public int getId() {
		return id;
	}

	/**
	 * Diese Methode setzt den ID
	 *
	 * @param id ID
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Diese Methode gibt den Namen des Filmcharakters zurück.
	 *
	 * @return Namen des Filmcharakters
	 */
	public String getCharacter() {
		return character;
	}

	/**
	 * Diese Methode setzt den Namen des Filmcharakters.
	 *
	 * @param character Name
	 */
	public void setCharacter(String character) {
		this.character = character;
	}

	/**
	 * Diese Methode gibt den Alias zurück.
	 *
	 * @return Alias
	 */
	public String getAlias() {
		return alias;
	}

	/**
	 * Diese Methode setzt den Alias.
	 *
	 * @param alias Alias
	 */
	public void setAlias(String alias) {
		this.alias = alias;
	}

	/**
	 * Diese Methode gibt die Position zurück.
	 *
	 * @return Position
	 */
	public int getPos() {
		return pos;
	}

	/**
	 * Diese Methode setzt die Position.
	 *
	 * @param pos Position
	 */
	public void setPos(int pos) {
		this.pos = pos;
	}

	/**
	 * Diese Methode gibt die Person ID zurück.
	 *
	 * @return Person ID
	 */
	public Player getPlayer() {
		return this.player;
	}

	/**
	 * Diese Methode setzt die Person ID.
	 *
	 * @param playerId Person ID
	 */
	public void setPlayer(Player p) {
		this.player = p;
	}

	/**
	 * Diese Methode gibt die Movie ID zurück.
	 *
	 * @return Movie ID
	 */
	public Movie getMovie() {
		return this.movie;
	}

	/**
	 * Diese Methode setzt den Movie ID.
	 *
	 * @param movieId Movie ID
	 */
	public void setMovie(Movie m) {
		this.movie = m;
	}

	/**
	 * Diese Methode gibt den Wert des Moviecharakters als String zurück.
	 *
	 * @return Wert als String
	 */
	@Override
	public String toString() {
		String ret;
		ret = this.getCharacter();/*
									 * if (this.getPerson() != null) { ret += ": " + this.getPerson(); }
									 */
		return ret;
	}

}

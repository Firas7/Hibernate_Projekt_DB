package de.hsh.dbs2.imdb.entities;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

/**
 * Diese Klasse stellt eine Person da
 *
 * @author A-Teams
 */
@Entity
@Table(name = "player")
public class Player {

	@Id
	@Column(name = "id")
	@GeneratedValue
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "sex")
	private char sex;

	@OneToMany(mappedBy = "movie")
	private Set<MovieCharacter> character = new HashSet<MovieCharacter>();

	/**
	 * Diese Methode gibt die Id zurück.
	 *
	 * @return Id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Diese Methode setzt die Id.
	 *
	 * @param id Id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Diese Mehtode gibt den Namen zurück.
	 *
	 * @return Name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Diese Methode setzt den Namen.
	 *
	 * @param name Namen
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Diese Methode gibt das Geschlecht zurück. 'M' oder 'F'
	 *
	 * @return Geschlecht
	 */
	public char getSex() {
		return sex;
	}

	/**
	 * Diese Methode setzt das Geschlecht. 'M' oder 'F'
	 *
	 * @param sex Geschlecht
	 */
	public void setSex(char sex) {
		this.sex = sex;
	}
	
	/**
	 * Diese Methode gibt die Liste der Filmcharaktere zurück.
	 * 
	 * @return Filmcharaktere
	 */
	public Set<MovieCharacter> getCharacter() {
		return this.character;
	}

	/**
	 * Diese Methode gibt den Wert des Person Objekts als String zurück.
	 *
	 * @return String Wert
	 */
	@Override
	public String toString() {
		return this.getName();
	}
}

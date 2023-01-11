package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the lek database table.
 * 
 */
@Entity
@NamedQuery(name="Lek.findAll", query="SELECT l FROM Lek l")
public class Lek implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idLek;

	private String naziv;

	//bi-directional many-to-many association to Recept
	@ManyToMany(mappedBy="leks")
	private List<Recept> recepts;

	public Lek() {
	}

	public int getIdLek() {
		return this.idLek;
	}

	public void setIdLek(int idLek) {
		this.idLek = idLek;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public List<Recept> getRecepts() {
		return this.recepts;
	}

	public void setRecepts(List<Recept> recepts) {
		this.recepts = recepts;
	}

}
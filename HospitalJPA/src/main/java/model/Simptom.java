package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the simptom database table.
 * 
 */
@Entity
@NamedQuery(name="Simptom.findAll", query="SELECT s FROM Simptom s")
public class Simptom implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idSimptom;

	private String naziv;

	//bi-directional many-to-many association to Dijagnoza
	@ManyToMany
	@JoinTable(
		name="simptom_has_dijagnoza"
		, joinColumns={
			@JoinColumn(name="idSimptom")
			}
		, inverseJoinColumns={
			@JoinColumn(name="idDijagnoza")
			}
		)
	private List<Dijagnoza> dijagnozas;

	public Simptom() {
	}

	public int getIdSimptom() {
		return this.idSimptom;
	}

	public void setIdSimptom(int idSimptom) {
		this.idSimptom = idSimptom;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public List<Dijagnoza> getDijagnozas() {
		return this.dijagnozas;
	}

	public void setDijagnozas(List<Dijagnoza> dijagnozas) {
		this.dijagnozas = dijagnozas;
	}

}
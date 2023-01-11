package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the departman database table.
 * 
 */
@Entity
@NamedQuery(name="Departman.findAll", query="SELECT d FROM Departman d")
public class Departman implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idDepartman;

	private String naziv;

	//bi-directional many-to-one association to Doktor
	@OneToMany(mappedBy="departman")
	private List<Doktor> doktors;

	//bi-directional many-to-one association to Tehnicar
	@OneToMany(mappedBy="departman")
	private List<Tehnicar> tehnicars;

	public Departman() {
	}

	public int getIdDepartman() {
		return this.idDepartman;
	}

	public void setIdDepartman(int idDepartman) {
		this.idDepartman = idDepartman;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public List<Doktor> getDoktors() {
		return this.doktors;
	}

	public void setDoktors(List<Doktor> doktors) {
		this.doktors = doktors;
	}

	public Doktor addDoktor(Doktor doktor) {
		getDoktors().add(doktor);
		doktor.setDepartman(this);

		return doktor;
	}

	public Doktor removeDoktor(Doktor doktor) {
		getDoktors().remove(doktor);
		doktor.setDepartman(null);

		return doktor;
	}

	public List<Tehnicar> getTehnicars() {
		return this.tehnicars;
	}

	public void setTehnicars(List<Tehnicar> tehnicars) {
		this.tehnicars = tehnicars;
	}

	public Tehnicar addTehnicar(Tehnicar tehnicar) {
		getTehnicars().add(tehnicar);
		tehnicar.setDepartman(this);

		return tehnicar;
	}

	public Tehnicar removeTehnicar(Tehnicar tehnicar) {
		getTehnicars().remove(tehnicar);
		tehnicar.setDepartman(null);

		return tehnicar;
	}

}
package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the doktor database table.
 * 
 */
@Entity
@NamedQuery(name="Doktor.findAll", query="SELECT d FROM Doktor d")
public class Doktor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idDoktor;

	private String ime;

	private String prezime;

	//bi-directional many-to-one association to Departman
	@ManyToOne
	@JoinColumn(name="idDepartman")
	private Departman departman;

	//bi-directional many-to-one association to Specijalizacija
	@ManyToOne
	@JoinColumn(name="idSpecijalizacija")
	private Specijalizacija specijalizacija;

	//bi-directional many-to-one association to Pregled
	@OneToMany(mappedBy="doktor")
	private List<Pregled> pregleds;

	public Doktor() {
	}

	public int getIdDoktor() {
		return this.idDoktor;
	}

	public void setIdDoktor(int idDoktor) {
		this.idDoktor = idDoktor;
	}

	public String getIme() {
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return this.prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public Departman getDepartman() {
		return this.departman;
	}

	public void setDepartman(Departman departman) {
		this.departman = departman;
	}

	public Specijalizacija getSpecijalizacija() {
		return this.specijalizacija;
	}

	public void setSpecijalizacija(Specijalizacija specijalizacija) {
		this.specijalizacija = specijalizacija;
	}

	public List<Pregled> getPregleds() {
		return this.pregleds;
	}

	public void setPregleds(List<Pregled> pregleds) {
		this.pregleds = pregleds;
	}

	public Pregled addPregled(Pregled pregled) {
		getPregleds().add(pregled);
		pregled.setDoktor(this);

		return pregled;
	}

	public Pregled removePregled(Pregled pregled) {
		getPregleds().remove(pregled);
		pregled.setDoktor(null);

		return pregled;
	}

}
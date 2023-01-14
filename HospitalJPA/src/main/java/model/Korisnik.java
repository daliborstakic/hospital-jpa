package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the korisnik database table.
 * 
 */
@Entity
@NamedQuery(name="Korisnik.findAll", query="SELECT k FROM Korisnik k")
public class Korisnik implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idKorisnik;

	private String ime;

	private String password;

	private String prezime;

	private String username;

	//bi-directional many-to-one association to Doktor
	@OneToMany(mappedBy="korisnik")
	private List<Doktor> doktors;

	//bi-directional many-to-one association to Uloga
	@ManyToOne
	@JoinColumn(name="idUloga")
	private Uloga uloga;

	//bi-directional many-to-one association to Pacijent
	@OneToMany(mappedBy="korisnik")
	private List<Pacijent> pacijents;

	public Korisnik() {
	}

	public int getIdKorisnik() {
		return this.idKorisnik;
	}

	public void setIdKorisnik(int idKorisnik) {
		this.idKorisnik = idKorisnik;
	}

	public String getIme() {
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPrezime() {
		return this.prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Doktor> getDoktors() {
		return this.doktors;
	}

	public void setDoktors(List<Doktor> doktors) {
		this.doktors = doktors;
	}

	public Doktor addDoktor(Doktor doktor) {
		getDoktors().add(doktor);
		doktor.setKorisnik(this);

		return doktor;
	}

	public Doktor removeDoktor(Doktor doktor) {
		getDoktors().remove(doktor);
		doktor.setKorisnik(null);

		return doktor;
	}

	public Uloga getUloga() {
		return this.uloga;
	}

	public void setUloga(Uloga uloga) {
		this.uloga = uloga;
	}

	public List<Pacijent> getPacijents() {
		return this.pacijents;
	}

	public void setPacijents(List<Pacijent> pacijents) {
		this.pacijents = pacijents;
	}

	public Pacijent addPacijent(Pacijent pacijent) {
		getPacijents().add(pacijent);
		pacijent.setKorisnik(this);

		return pacijent;
	}

	public Pacijent removePacijent(Pacijent pacijent) {
		getPacijents().remove(pacijent);
		pacijent.setKorisnik(null);

		return pacijent;
	}

}
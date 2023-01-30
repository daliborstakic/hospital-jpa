package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the pacijent database table.
 * 
 */
@Entity
@NamedQuery(name="Pacijent.findAll", query="SELECT p FROM Pacijent p")
public class Pacijent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPacijent;

	private String ime;

	private String prezime;

	//bi-directional many-to-one association to Obavestenje
	@OneToMany(mappedBy="pacijent")
	private List<Obavestenje> obavestenjes;

	//bi-directional many-to-one association to Omiljeni
	@OneToMany(mappedBy="pacijent")
	private List<Omiljeni> omiljenis;

	//bi-directional many-to-one association to Korisnik
	@ManyToOne
	@JoinColumn(name="idKorisnik")
	private Korisnik korisnik;

	//bi-directional many-to-one association to Pregled
	@OneToMany(mappedBy="pacijent")
	private List<Pregled> pregleds;

	//bi-directional many-to-one association to Zakazivanje
	@OneToMany(mappedBy="pacijent")
	private List<Zakazivanje> zakazivanjes;

	public Pacijent() {
	}

	public int getIdPacijent() {
		return this.idPacijent;
	}

	public void setIdPacijent(int idPacijent) {
		this.idPacijent = idPacijent;
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

	public List<Obavestenje> getObavestenjes() {
		return this.obavestenjes;
	}

	public void setObavestenjes(List<Obavestenje> obavestenjes) {
		this.obavestenjes = obavestenjes;
	}

	public Obavestenje addObavestenje(Obavestenje obavestenje) {
		getObavestenjes().add(obavestenje);
		obavestenje.setPacijent(this);

		return obavestenje;
	}

	public Obavestenje removeObavestenje(Obavestenje obavestenje) {
		getObavestenjes().remove(obavestenje);
		obavestenje.setPacijent(null);

		return obavestenje;
	}

	public List<Omiljeni> getOmiljenis() {
		return this.omiljenis;
	}

	public void setOmiljenis(List<Omiljeni> omiljenis) {
		this.omiljenis = omiljenis;
	}

	public Omiljeni addOmiljeni(Omiljeni omiljeni) {
		getOmiljenis().add(omiljeni);
		omiljeni.setPacijent(this);

		return omiljeni;
	}

	public Omiljeni removeOmiljeni(Omiljeni omiljeni) {
		getOmiljenis().remove(omiljeni);
		omiljeni.setPacijent(null);

		return omiljeni;
	}

	public Korisnik getKorisnik() {
		return this.korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

	public List<Pregled> getPregleds() {
		return this.pregleds;
	}

	public void setPregleds(List<Pregled> pregleds) {
		this.pregleds = pregleds;
	}

	public Pregled addPregled(Pregled pregled) {
		getPregleds().add(pregled);
		pregled.setPacijent(this);

		return pregled;
	}

	public Pregled removePregled(Pregled pregled) {
		getPregleds().remove(pregled);
		pregled.setPacijent(null);

		return pregled;
	}

	public List<Zakazivanje> getZakazivanjes() {
		return this.zakazivanjes;
	}

	public void setZakazivanjes(List<Zakazivanje> zakazivanjes) {
		this.zakazivanjes = zakazivanjes;
	}

	public Zakazivanje addZakazivanje(Zakazivanje zakazivanje) {
		getZakazivanjes().add(zakazivanje);
		zakazivanje.setPacijent(this);

		return zakazivanje;
	}

	public Zakazivanje removeZakazivanje(Zakazivanje zakazivanje) {
		getZakazivanjes().remove(zakazivanje);
		zakazivanje.setPacijent(null);

		return zakazivanje;
	}

}
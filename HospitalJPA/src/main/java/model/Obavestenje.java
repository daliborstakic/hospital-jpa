package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the obavestenje database table.
 * 
 */
@Entity
@NamedQuery(name="Obavestenje.findAll", query="SELECT o FROM Obavestenje o")
public class Obavestenje implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idObavestenje;

	private String kreator;

	private String poruka;

	//bi-directional many-to-one association to Doktor
	@ManyToOne
	@JoinColumn(name="idDoktor")
	private Doktor doktor;

	//bi-directional many-to-one association to Pacijent
	@ManyToOne
	@JoinColumn(name="idPacijent")
	private Pacijent pacijent;

	public Obavestenje() {
	}

	public int getIdObavestenje() {
		return this.idObavestenje;
	}

	public void setIdObavestenje(int idObavestenje) {
		this.idObavestenje = idObavestenje;
	}

	public String getKreator() {
		return this.kreator;
	}

	public void setKreator(String kreator) {
		this.kreator = kreator;
	}

	public String getPoruka() {
		return this.poruka;
	}

	public void setPoruka(String poruka) {
		this.poruka = poruka;
	}

	public Doktor getDoktor() {
		return this.doktor;
	}

	public void setDoktor(Doktor doktor) {
		this.doktor = doktor;
	}

	public Pacijent getPacijent() {
		return this.pacijent;
	}

	public void setPacijent(Pacijent pacijent) {
		this.pacijent = pacijent;
	}

}
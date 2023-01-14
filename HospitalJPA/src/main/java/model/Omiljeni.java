package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the omiljeni database table.
 * 
 */
@Entity
@NamedQuery(name="Omiljeni.findAll", query="SELECT o FROM Omiljeni o")
public class Omiljeni implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idOmiljeni;

	//bi-directional many-to-one association to Doktor
	@ManyToOne
	@JoinColumn(name="idDoktor")
	private Doktor doktor;

	//bi-directional many-to-one association to Pacijent
	@ManyToOne
	@JoinColumn(name="idPacijent")
	private Pacijent pacijent;

	public Omiljeni() {
	}

	public int getIdOmiljeni() {
		return this.idOmiljeni;
	}

	public void setIdOmiljeni(int idOmiljeni) {
		this.idOmiljeni = idOmiljeni;
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
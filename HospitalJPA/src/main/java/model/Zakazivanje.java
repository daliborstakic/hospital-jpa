package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the zakazivanje database table.
 * 
 */
@Entity
@NamedQuery(name="Zakazivanje.findAll", query="SELECT z FROM Zakazivanje z")
public class Zakazivanje implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idZakazivanje;

	@Temporal(TemporalType.DATE)
	private Date datum;

	private Boolean postojiPregled;

	//bi-directional many-to-one association to Doktor
	@ManyToOne
	@JoinColumn(name="idDoktor")
	private Doktor doktor;

	//bi-directional many-to-one association to Pacijent
	@ManyToOne
	@JoinColumn(name="idPacijent")
	private Pacijent pacijent;

	public Zakazivanje() {
	}

	public int getIdZakazivanje() {
		return this.idZakazivanje;
	}

	public void setIdZakazivanje(int idZakazivanje) {
		this.idZakazivanje = idZakazivanje;
	}

	public Date getDatum() {
		return this.datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public Boolean getPostojiPregled() {
		return this.postojiPregled;
	}

	public void setPostojiPregled(Boolean postojiPregled) {
		this.postojiPregled = postojiPregled;
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
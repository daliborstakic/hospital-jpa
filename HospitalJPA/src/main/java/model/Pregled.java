package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the pregled database table.
 * 
 */
@Entity
@NamedQuery(name="Pregled.findAll", query="SELECT p FROM Pregled p")
public class Pregled implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPregled;

	//bi-directional many-to-one association to Dijagnoza
	@ManyToOne
	@JoinColumn(name="idDijagnoza")
	private Dijagnoza dijagnoza;

	//bi-directional many-to-one association to Doktor
	@ManyToOne
	@JoinColumn(name="idDoktor")
	private Doktor doktor;

	//bi-directional many-to-one association to Pacijent
	@ManyToOne
	@JoinColumn(name="idPacijent")
	private Pacijent pacijent;

	//bi-directional many-to-one association to Recept
	@ManyToOne
	@JoinColumn(name="idRecept")
	private Recept recept;

	public Pregled() {
	}

	public int getIdPregled() {
		return this.idPregled;
	}

	public void setIdPregled(int idPregled) {
		this.idPregled = idPregled;
	}

	public Dijagnoza getDijagnoza() {
		return this.dijagnoza;
	}

	public void setDijagnoza(Dijagnoza dijagnoza) {
		this.dijagnoza = dijagnoza;
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

	public Recept getRecept() {
		return this.recept;
	}

	public void setRecept(Recept recept) {
		this.recept = recept;
	}

}
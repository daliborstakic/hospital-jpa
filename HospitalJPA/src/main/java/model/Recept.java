package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the recept database table.
 * 
 */
@Entity
@NamedQuery(name="Recept.findAll", query="SELECT r FROM Recept r")
public class Recept implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idRecept;

	private String opis;

	//bi-directional many-to-one association to Pregled
	@OneToMany(mappedBy="recept")
	private List<Pregled> pregleds;

	//bi-directional many-to-many association to Lek
	@ManyToMany
	@JoinTable(
		name="recept_has_lek"
		, joinColumns={
			@JoinColumn(name="idRecept")
			}
		, inverseJoinColumns={
			@JoinColumn(name="idLek")
			}
		)
	private List<Lek> leks;

	public Recept() {
	}

	public int getIdRecept() {
		return this.idRecept;
	}

	public void setIdRecept(int idRecept) {
		this.idRecept = idRecept;
	}

	public String getOpis() {
		return this.opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public List<Pregled> getPregleds() {
		return this.pregleds;
	}

	public void setPregleds(List<Pregled> pregleds) {
		this.pregleds = pregleds;
	}

	public Pregled addPregled(Pregled pregled) {
		getPregleds().add(pregled);
		pregled.setRecept(this);

		return pregled;
	}

	public Pregled removePregled(Pregled pregled) {
		getPregleds().remove(pregled);
		pregled.setRecept(null);

		return pregled;
	}

	public List<Lek> getLeks() {
		return this.leks;
	}

	public void setLeks(List<Lek> leks) {
		this.leks = leks;
	}

}
package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tehnicar database table.
 * 
 */
@Entity
@NamedQuery(name="Tehnicar.findAll", query="SELECT t FROM Tehnicar t")
public class Tehnicar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTehnicar;

	private String ime;

	private String prezime;

	//bi-directional many-to-one association to Departman
	@ManyToOne
	@JoinColumn(name="idDepartman")
	private Departman departman;

	public Tehnicar() {
	}

	public int getIdTehnicar() {
		return this.idTehnicar;
	}

	public void setIdTehnicar(int idTehnicar) {
		this.idTehnicar = idTehnicar;
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

}
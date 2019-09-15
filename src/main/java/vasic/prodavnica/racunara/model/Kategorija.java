package vasic.prodavnica.racunara.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name="kategorija")
public class Kategorija {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id",nullable=false,unique=true)
	private int id;
	
	@Column(name="naziv",nullable=false)
	private String naziv;
	
	@Column(name="opis",nullable=false)
	private String opis;
	
	@OneToOne
	@JoinColumn(name="podkategorija_id",referencedColumnName="id")
	private Kategorija podkategorija;
	
	public Kategorija() {}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	public Kategorija getPodkategorija() {
		return podkategorija;
	}
	public void setPodkategorija(Kategorija podkategorija) {
		this.podkategorija = podkategorija;
	}
	
	

}

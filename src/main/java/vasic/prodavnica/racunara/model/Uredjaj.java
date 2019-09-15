package vasic.prodavnica.racunara.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;

@Entity(name="uredjaj")
public class Uredjaj extends Artikal{

	@OneToMany
	private List<Komponenta> komponente;
	
	@Min(1)
	@Column(nullable=false)
	private float ukupnaCena;

	public Uredjaj() {super("uredjaj");}

	public List<Komponenta> getKomponente() {
		return komponente;
	}

	public void dodajKomponentu(Komponenta komponenta){
		this.komponente.add(komponenta);
	}

	public void setKomponente(List<Komponenta> komponente) {
		this.komponente = komponente;
	}

	public float getUkupnaCena() {
		return ukupnaCena;
	}

	public void setUkupnaCena(float ukupnaCena) {
		this.ukupnaCena = ukupnaCena;
	}
}

package vasic.prodavnica.racunara.model;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

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

	@ManyToOne
	@JoinColumn(name = "parentId")
	private Kategorija parent;


	@OneToMany(mappedBy = "parent")
	private List<Kategorija> childCategories;
	
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

	public Optional<Kategorija> getParent() {

		return parent == null ? Optional.empty() : Optional.of(parent);
	}

	public void setParent(Kategorija parent) {
		this.parent = parent;
	}

	public List<Kategorija> getChildCategories() {
		return childCategories;
	}

	public void setChildCategories(List<Kategorija> childCategories) {
		this.childCategories = childCategories;
	}
}

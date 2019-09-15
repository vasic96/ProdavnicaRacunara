package vasic.prodavnica.racunara.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

@Entity(name = "komponenta")
public class Komponenta extends Artikal {


    @Column(nullable = false)
    private float cena;

    @Column(nullable = false)
    private int kolicina;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "uredjaj_id", referencedColumnName = "id", nullable = false)
    private Uredjaj uredjaj;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "kategorija_id", referencedColumnName = "id", nullable = false)
    private Kategorija kategorija;

    @Column(nullable = true)
    private String link;

    @OneToMany
    private List<Slika> slike;


    public Komponenta() {
        super("komponenta");
    }


    public float getCena() {
        return cena;
    }


    public void setCena(float cena) {
        this.cena = cena;
    }


    public int getKolicina() {
        return kolicina;
    }


    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }


    public Kategorija getKategorija() {
        return kategorija;
    }


    public void setKategorija(Kategorija kategorija) {
        this.kategorija = kategorija;
    }


    public String getLink() {
        return link;
    }


    public void setLink(String link) {
        this.link = link;
    }

    public Uredjaj getUredjaj() {
        return uredjaj;
    }

    public void setUredjaj(Uredjaj uredjaj) {
        this.uredjaj = uredjaj;
    }
}

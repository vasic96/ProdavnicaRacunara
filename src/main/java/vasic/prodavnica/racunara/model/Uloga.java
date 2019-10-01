package vasic.prodavnica.racunara.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Uloga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "uloga",fetch = FetchType.LAZY,cascade = CascadeType.REFRESH)
    private List<KorisnikUloga> korisniciUloge = new ArrayList<>();

    public Uloga() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<KorisnikUloga> getKorisniciUloge() {
        return korisniciUloge;
    }

    public void setKorisniciUloge(List<KorisnikUloga> korisniciUloge) {
        this.korisniciUloge = korisniciUloge;
    }
}

package vasic.prodavnica.racunara.dto;

import vasic.prodavnica.racunara.model.Kategorija;

public class KategorijaDTO {

    private int id;
    private String naziv;
    private String opis;
    private int podkategorijaId;

    public KategorijaDTO(int id, String naziv, String opis, int podkategorijaId) {
        super();
        this.id = id;
        this.naziv = naziv;
        this.opis = opis;
        this.podkategorijaId = podkategorijaId;
    }

    public KategorijaDTO(Kategorija kategorija) {
        this.id = kategorija.getId();
        this.naziv = kategorija.getNaziv();
        this.opis = kategorija.getOpis();
        this.podkategorijaId = kategorija.getPodkategorija() == null ? 0 : kategorija.getPodkategorija().getId();
    }

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

    public int getPodkategorijaId() {
        return podkategorijaId;
    }

    public void setPodkategorijaId(int podkategorijaId) {
        this.podkategorijaId = podkategorijaId;
    }


}

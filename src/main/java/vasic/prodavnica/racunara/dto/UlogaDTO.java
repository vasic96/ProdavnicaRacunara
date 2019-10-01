package vasic.prodavnica.racunara.dto;

import vasic.prodavnica.racunara.model.Uloga;

public class UlogaDTO {

    private int id;
    private String name;

    public UlogaDTO() {
    }

    public UlogaDTO(Uloga uloga) {
        this.id = uloga.getId();
        this.name = uloga.getName();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

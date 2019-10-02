package vasic.prodavnica.racunara.response;

public class SlikaUploadResponse extends FileResponse {

    private int komponentaId;
    private String komponentaNaziv;


    public SlikaUploadResponse(String name, String uri, String type, long size, int komponentaId, String komponentaNaziv) {
        super(name, uri, type, size);
        this.komponentaId = komponentaId;
        this.komponentaNaziv = komponentaNaziv;
    }

    public int getKomponentaId() {
        return komponentaId;
    }

    public void setKomponentaId(int komponentaId) {
        this.komponentaId = komponentaId;
    }

    public String getKomponentaNaziv() {
        return komponentaNaziv;
    }

    public void setKomponentaNaziv(String komponentaNaziv) {
        this.komponentaNaziv = komponentaNaziv;
    }
}

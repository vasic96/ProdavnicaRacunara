package vasic.prodavnica.racunara.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vasic.prodavnica.racunara.model.Kategorija;
import vasic.prodavnica.racunara.repository.KategorijaRepository;

import java.util.List;

@Service
public class KategorijaService {

    @Autowired
    KategorijaRepository kategorijaRepository;

    public List<Kategorija> getAll() {
        return kategorijaRepository.findAll();
    }

    public Kategorija getOneById(int id) {
        return kategorijaRepository.getOne(id);
    }

    public Kategorija save(Kategorija kategorija) {
        return kategorijaRepository.save(kategorija);
    }


    public void delete(int id) {
        kategorijaRepository.deleteById(id);
    }

    public boolean exist(int id) {
        return kategorijaRepository.existsById(id);
    }


}

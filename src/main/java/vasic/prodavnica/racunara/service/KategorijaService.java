package vasic.prodavnica.racunara.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vasic.prodavnica.racunara.model.Kategorija;
import vasic.prodavnica.racunara.repository.KategorijaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class KategorijaService {

    @Autowired
    KategorijaRepository kategorijaRepository;

    public List<Kategorija> getAll() {
        return kategorijaRepository.findAll();
    }

    public Optional<Kategorija> getOneById(int id) {
        return kategorijaRepository.findById(id);
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

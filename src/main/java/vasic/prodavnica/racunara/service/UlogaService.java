package vasic.prodavnica.racunara.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vasic.prodavnica.racunara.model.Uloga;
import vasic.prodavnica.racunara.repository.UlogaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UlogaService {


    @Autowired
    UlogaRepository ulogaRepository;

    public List<Uloga> getAll() {
        return ulogaRepository.findAll();
    }

    public Optional<Uloga> getById(int id) {
        return ulogaRepository.findById(id);
    }

    public Uloga save(Uloga uloga) {
        return ulogaRepository.save(uloga);
    }

    public void delete(int id) {
        ulogaRepository.deleteById(id);
    }
}

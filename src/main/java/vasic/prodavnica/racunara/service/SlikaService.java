package vasic.prodavnica.racunara.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vasic.prodavnica.racunara.model.Slika;
import vasic.prodavnica.racunara.repository.SlikaRepository;

@Service
public class SlikaService {


    @Autowired
    SlikaRepository slikaRepository;

    public Slika save(Slika slika) {
        return slikaRepository.save(slika);
    }


}

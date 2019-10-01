package vasic.prodavnica.racunara.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vasic.prodavnica.racunara.model.Uloga;

@Repository
public interface UlogaRepository extends JpaRepository<Uloga, Integer> {
}

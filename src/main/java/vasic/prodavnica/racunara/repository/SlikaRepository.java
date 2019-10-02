package vasic.prodavnica.racunara.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vasic.prodavnica.racunara.model.Slika;

@Repository
public interface SlikaRepository extends JpaRepository<Slika, Integer> {
}

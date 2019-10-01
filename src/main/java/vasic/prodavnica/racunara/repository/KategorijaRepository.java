package vasic.prodavnica.racunara.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vasic.prodavnica.racunara.model.Kategorija;

@Repository
public interface KategorijaRepository extends JpaRepository<Kategorija, Integer> {

    boolean existsKategorijaByParentId(int id);
}

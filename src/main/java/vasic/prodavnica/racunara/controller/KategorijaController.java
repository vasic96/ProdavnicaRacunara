package vasic.prodavnica.racunara.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vasic.prodavnica.racunara.dto.KategorijaDTO;
import vasic.prodavnica.racunara.exceptions.EntityNotFoundException;
import vasic.prodavnica.racunara.model.Kategorija;
import vasic.prodavnica.racunara.service.KategorijaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class KategorijaController {

    @Autowired
    KategorijaService kategorijaService;


    @GetMapping("/kategorije/all")
    public ResponseEntity<List<KategorijaDTO>> getAll() {

        List<KategorijaDTO> dtos = kategorijaService.getAll().stream()
                .map(KategorijaDTO::new)
                .collect(Collectors.toList());

        return new ResponseEntity<List<KategorijaDTO>>(dtos, HttpStatus.OK);
    }

    @GetMapping("/kategorije/{id}")
    public ResponseEntity<KategorijaDTO> getById(@PathVariable Integer id) {

        KategorijaDTO kategorijaDTO = kategorijaService.getOneById(id).map(KategorijaDTO::new).orElseThrow(
                () -> new EntityNotFoundException(Kategorija.class.getName(), id)
        );

        return new ResponseEntity<KategorijaDTO>(kategorijaDTO, HttpStatus.OK);
    }

    @PostMapping("/kategorije")
    public ResponseEntity<KategorijaDTO> save(@RequestBody KategorijaDTO kategorijaDTO) {

        Kategorija kategorija = new Kategorija();
        kategorija.setNaziv(kategorijaDTO.getNaziv());
        kategorija.setOpis(kategorijaDTO.getOpis());

        kategorija.setPodkategorija(kategorijaDTO.getPodkategorijaId() < 1
                ? null : kategorijaService.getOneById(kategorijaDTO.getPodkategorijaId()).orElseThrow(
                () -> new EntityNotFoundException(Kategorija.class.getName(), kategorijaDTO.getPodkategorijaId())
        ));

        return new ResponseEntity<KategorijaDTO>(new KategorijaDTO(kategorijaService.save(kategorija)), HttpStatus.OK);
    }

    @DeleteMapping("/kategorije/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {

        kategorijaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }


}

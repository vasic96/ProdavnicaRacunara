package vasic.prodavnica.racunara.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vasic.prodavnica.racunara.dto.KategorijaDTO;
import vasic.prodavnica.racunara.exceptions.CategoryNotFoundException;
import vasic.prodavnica.racunara.exceptions.InvalidRequestBodyException;
import vasic.prodavnica.racunara.model.Kategorija;
import vasic.prodavnica.racunara.service.KategorijaService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class KategorijaController {

    @Autowired
    KategorijaService kategorijaService;


    @GetMapping("/kategorije/all")
    public ResponseEntity<List<KategorijaDTO>> getAll() {

        List<KategorijaDTO> dtos = kategorijaService.getAll().stream().map(KategorijaDTO::new).collect(Collectors.toList());


        return new ResponseEntity<List<KategorijaDTO>>(dtos, HttpStatus.OK);
    }

    @GetMapping("/kategorije/{id}")
    public ResponseEntity<KategorijaDTO> getById(@PathVariable Integer id) {
        return new ResponseEntity<KategorijaDTO>(new KategorijaDTO(kategorijaService.getOneById(id).orElseThrow(() -> new CategoryNotFoundException("Category not found"))), HttpStatus.OK);
    }

    @PostMapping("/kategorije")
    public ResponseEntity<KategorijaDTO> save(@RequestBody Optional<KategorijaDTO> optionalKategorijaDTO) {
        optionalKategorijaDTO.orElseThrow(InvalidRequestBodyException::new);

        Kategorija kategorija = new Kategorija();

        optionalKategorijaDTO.map(kategorijaDTO -> {
            kategorija.setNaziv(kategorijaDTO.getNaziv());
            kategorija.setOpis(kategorijaDTO.getOpis());
            if (kategorijaDTO.getPodkategorijaId() != 0) {
                kategorija.setPodkategorija(kategorijaService.getOneById(kategorijaDTO.getPodkategorijaId()).orElseThrow(() -> new CategoryNotFoundException("Category not found")));
            } else {
                kategorija.setPodkategorija(null);
            }

            return null;
        });
        return new ResponseEntity<KategorijaDTO>(new KategorijaDTO(kategorijaService.save(kategorija)), HttpStatus.OK);
    }

    @DeleteMapping("/kategorije/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {

        kategorijaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }


}

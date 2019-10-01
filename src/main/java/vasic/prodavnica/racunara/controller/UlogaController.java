package vasic.prodavnica.racunara.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vasic.prodavnica.racunara.dto.UlogaDTO;
import vasic.prodavnica.racunara.exceptions.EntityNotFoundException;
import vasic.prodavnica.racunara.model.Uloga;
import vasic.prodavnica.racunara.service.UlogaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UlogaController {


    @Autowired
    UlogaService ulogaService;

    @GetMapping("/uloge")
    public ResponseEntity<List<UlogaDTO>> getAll() {
        List<UlogaDTO> dtos = ulogaService.getAll().stream().map(UlogaDTO::new).collect(Collectors.toList());

        return new ResponseEntity<List<UlogaDTO>>(dtos, HttpStatus.OK);
    }

    @GetMapping("/uloge/{id}")
    public ResponseEntity<UlogaDTO> getById(@PathVariable Integer id) {
        UlogaDTO uloga = ulogaService.getById(id).map(UlogaDTO::new).orElseThrow(
                () -> new EntityNotFoundException(Uloga.class.getName(), id)
        );

        return new ResponseEntity<UlogaDTO>(uloga, HttpStatus.OK);
    }

    @PostMapping("/uloge")
    public ResponseEntity<UlogaDTO> save(@RequestBody UlogaDTO ulogaDTO) {

        Uloga uloga = new Uloga();
        uloga.setName(ulogaDTO.getName());
        return new ResponseEntity<>(new UlogaDTO(ulogaService.save(uloga)), HttpStatus.OK);

    }

    @DeleteMapping("/uloge/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        ulogaService.delete(id);

        return ResponseEntity.ok().build();
    }

}

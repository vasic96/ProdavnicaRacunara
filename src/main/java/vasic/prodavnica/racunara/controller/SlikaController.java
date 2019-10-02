package vasic.prodavnica.racunara.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import vasic.prodavnica.racunara.exceptions.EntityNotFoundException;
import vasic.prodavnica.racunara.model.Slika;
import vasic.prodavnica.racunara.response.SlikaUploadResponse;
import vasic.prodavnica.racunara.service.FIleManagerServiceImpl;
import vasic.prodavnica.racunara.service.KomponentaService;
import vasic.prodavnica.racunara.service.SlikaService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SlikaController {

    @Autowired
    SlikaService slikaService;
    @Autowired
    KomponentaService komponentaService;
    @Autowired
    private FIleManagerServiceImpl fileManagerService;

    @PostMapping("/slika/{id}")
    public ResponseEntity<List<SlikaUploadResponse>> uploadPictures(@RequestPart MultipartFile[] files, @PathVariable Integer id) {

        List<SlikaUploadResponse> responses = Arrays.stream(files)
                .map(file -> {

                    //Save picture object
                    Slika slika = new Slika();
                    slika.setFileName(file.getOriginalFilename());
                    slika.setKomponenta(komponentaService.getOne(id).orElseThrow(() -> new EntityNotFoundException("Komponenta", id)));
                    slikaService.save(slika);

                    String name = fileManagerService.store(file, slika.getKomponenta().getNaziv());
                    String uri = ServletUriComponentsBuilder.fromCurrentContextPath()
                            .path("/download/")
                            .path(name)
                            .toUriString();


                    SlikaUploadResponse slikaUploadResponse1 = new SlikaUploadResponse(name, uri, file.getContentType(), file.getSize(), id, slika.getKomponenta().getNaziv());


                    return slikaUploadResponse1;
                }).collect(Collectors.toList());


        System.out.println(id);

        return new ResponseEntity<List<SlikaUploadResponse>>(responses, HttpStatus.OK);

    }
}

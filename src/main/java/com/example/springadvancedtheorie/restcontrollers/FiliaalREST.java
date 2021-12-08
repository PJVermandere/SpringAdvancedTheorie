package com.example.springadvancedtheorie.restcontrollers;

import com.example.springadvancedtheorie.domain.Filiaal;
import com.example.springadvancedtheorie.exceptions.FilaalNietGevondenException;
import com.example.springadvancedtheorie.services.FiliaalService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.hateoas.server.EntityLinks;
import org.springframework.hateoas.server.ExposesResourceFor;
import org.springframework.hateoas.server.TypedEntityLinks;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.http.HttpResponse;
import java.util.List;

@RestController
@ExposesResourceFor(Filiaal.class)
@RequestMapping("/filialen")
public class FiliaalREST {
    private final FiliaalService service;
    private final TypedEntityLinks.ExtendedTypedEntityLinks<Filiaal> links;

    public FiliaalREST(FiliaalService service, EntityLinks links) {
        this.service = service;
        this.links = links.forType(Filiaal.class, Filiaal::getId);
    }

    @Operation(summary = "Retrieve filiaal whit this id")
    @GetMapping("{id}")
    Filiaal get(@PathVariable long id){
        return service.findById(id).orElseThrow(FilaalNietGevondenException::new);
    }

    @Operation(summary = "Retrieve every filaal in database")
    @GetMapping
    List<Filiaal> getAll(){
        return service.findAll();
    }

    @Operation(summary = "Update filiaal with this id")
    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.CREATED)
    void put(@RequestBody @Valid Filiaal filiaal, @PathVariable long id){
        service.update(filiaal.withId(id));

    }

    @Operation(summary = "Delete filiaal whith this id")
    @DeleteMapping("{id}")
    void delete(@PathVariable long id){
        service.delete(id);
    }

    @Operation(summary = "Add this filiaal to database")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    HttpHeaders post(@RequestBody Filiaal filiaal){
        service.create(filiaal);
        var headers = new HttpHeaders();
        headers.setLocation(links.linkToItemResource(filiaal).toUri());
        return headers;
    }


    @ExceptionHandler(FilaalNietGevondenException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    void nietGevonden() {
    }
}

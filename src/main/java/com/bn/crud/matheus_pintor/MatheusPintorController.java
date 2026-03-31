package com.bn.crud.matheus_pintor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/matheus-pintor")
public class MatheusPintorController {
    @Autowired
    private MatheusPintorService matheusPintorService;

    @GetMapping
    public ResponseEntity<List<MatheusPintorModel>> findAll() {
        return ResponseEntity.ok().body(matheusPintorService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<MatheusPintorModel>> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(matheusPintorService.findById(id));
    }

    @PostMapping
    ResponseEntity<MatheusPintorModel> save(@RequestBody MatheusPintorModel matheusPintorModel) {
        MatheusPintorModel request = matheusPintorService.save(matheusPintorModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(request.getId()).toUri();
        return ResponseEntity.created(uri).body(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        matheusPintorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

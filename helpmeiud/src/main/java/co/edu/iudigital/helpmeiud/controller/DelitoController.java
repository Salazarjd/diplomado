package co.edu.iudigital.helpmeiud.controller;

import co.edu.iudigital.helpmeiud.dto.request.DelitoDTORequest;
import co.edu.iudigital.helpmeiud.dto.response.DelitoDTO;
import co.edu.iudigital.helpmeiud.service.iface.IDelitoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/delitos")
public class DelitoController {

    private final IDelitoService delitoService;

    @GetMapping
    public ResponseEntity<List<DelitoDTO>> index() {
        return ResponseEntity.ok().body(this.delitoService.consularTodos());
    }

    @PostMapping
    public ResponseEntity<DelitoDTO> create(@Valid @RequestBody DelitoDTORequest delitoDTORequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.delitoService.guardarDelito(delitoDTORequest));
    }

}

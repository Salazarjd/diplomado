package co.edu.iudigital.helpmeiud.controller;

import co.edu.iudigital.helpmeiud.dto.request.CasoRequest;
import co.edu.iudigital.helpmeiud.dto.response.CasoDTO;
import co.edu.iudigital.helpmeiud.service.iface.ICasoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/casos")
public class CasoController {

    private final ICasoService casoService;

    @GetMapping
    public ResponseEntity<List<CasoDTO>> index() {
        return ResponseEntity.ok().body(this.casoService.consultarTodos());
    }

    @PostMapping
    public ResponseEntity<CasoDTO> create(@RequestBody CasoRequest casoRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.casoService.crear(casoRequest));
    }
}

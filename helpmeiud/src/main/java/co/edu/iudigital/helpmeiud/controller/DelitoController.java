package co.edu.iudigital.helpmeiud.controller;

import co.edu.iudigital.helpmeiud.dto.response.DelitoDTO;
import co.edu.iudigital.helpmeiud.service.iface.IDelitoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}

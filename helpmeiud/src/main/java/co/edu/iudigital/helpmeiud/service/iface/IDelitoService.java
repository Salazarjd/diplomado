package co.edu.iudigital.helpmeiud.service.iface;

import co.edu.iudigital.helpmeiud.dto.request.DelitoDTORequest;
import co.edu.iudigital.helpmeiud.dto.response.DelitoDTO;

import java.util.List;

public interface IDelitoService {

    List<DelitoDTO> consularTodos();

    DelitoDTO consultarPorId(Long id);

    DelitoDTO guardarDelito(DelitoDTORequest delitoDTORequest);

    void borrarDelitoPorId(Long id);
}

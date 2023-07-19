package co.edu.iudigital.helpmeiud.service.iface;

import co.edu.iudigital.helpmeiud.dto.request.CasoRequest;
import co.edu.iudigital.helpmeiud.dto.response.CasoDTO;

import java.util.List;

public interface ICasoService {

    List<CasoDTO> consultarTodos();

    CasoDTO crear(CasoRequest casoRequest);

    Boolean visible(Boolean visible, Long id);

    CasoDTO consultarPorId(Long id);
}

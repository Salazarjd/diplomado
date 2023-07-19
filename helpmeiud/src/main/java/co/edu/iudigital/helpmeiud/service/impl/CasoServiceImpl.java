package co.edu.iudigital.helpmeiud.service.impl;

import co.edu.iudigital.helpmeiud.dto.request.CasoRequest;
import co.edu.iudigital.helpmeiud.dto.response.CasoDTO;
import co.edu.iudigital.helpmeiud.model.Caso;
import co.edu.iudigital.helpmeiud.model.Delito;
import co.edu.iudigital.helpmeiud.model.Usuario;
import co.edu.iudigital.helpmeiud.repository.ICasoRepository;
import co.edu.iudigital.helpmeiud.repository.IDelitoRepository;
import co.edu.iudigital.helpmeiud.repository.IUsuarioRepository;
import co.edu.iudigital.helpmeiud.service.iface.ICasoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CasoServiceImpl implements ICasoService {

    private final ICasoRepository casoRepository;
    private final IUsuarioRepository usuarioRepository;
    private final IDelitoRepository delitoRepository;

    @Transactional(readOnly = true)
    @Override
    public List<CasoDTO> consultarTodos() {
        List<Caso> casos = this.casoRepository.findAll();

        return casos.stream().map(caso ->
                CasoDTO.builder()
                        .id(caso.getId())
                        .fechaHora(caso.getFechaHora())
                        .latitud(caso.getLatitud())
                        .longitud(caso.getLongitud())
                        .altitud(caso.getAltitud())
                        .descripcion(caso.getDescripcion())
                        .esVisble(caso.getEsVisble())
                        .urlMap(caso.getUrlMap())
                        .rmiUrl(caso.getRmiUrl())
                        .usuarioId(caso.getUsuario().getId())
                        .delitoId(caso.getDelito().getId())
                        .build()).collect(Collectors.toList());
    }

    @Transactional
    @Override
    public CasoDTO crear(CasoRequest casoRequest) {
        Optional<Usuario> usuario = usuarioRepository.findById(casoRequest.getUsuarioId());
        Optional<Delito> delito = delitoRepository.findById(casoRequest.getDelitoId());

        if (!usuario.isPresent() || !delito.isPresent()) {
            return null;
        }
        Caso caso = new Caso();
        caso.setFechaHora(casoRequest.getFechaHora());
        caso.setLatitud(casoRequest.getLatitud());
        caso.setLongitud(casoRequest.getLongitud());
        caso.setAltitud(casoRequest.getAltitud());
        caso.setDescripcion(casoRequest.getDescripcion());
        caso.setEsVisble(casoRequest.getEsVisble());
        caso.setUrlMap(casoRequest.getUrlMap());
        caso.setRmiUrl(casoRequest.getRmiUrl());
        caso.setUsuario(usuario.get());
        caso.setDelito(delito.get());

        Caso casoGuardado = casoRepository.save(caso);
        return CasoDTO.builder()
                .id(casoGuardado.getId())
                .fechaHora(casoGuardado.getFechaHora())
                .latitud(casoGuardado.getLatitud())
                .longitud(casoGuardado.getLongitud())
                .altitud(casoGuardado.getAltitud())
                .descripcion(casoGuardado.getDescripcion())
                .esVisble(casoGuardado.getEsVisble())
                .urlMap(casoGuardado.getUrlMap())
                .rmiUrl(casoGuardado.getRmiUrl())
                .usuarioId(casoGuardado.getUsuario().getId())
                .delitoId(casoGuardado.getDelito().getId())
                .build();
    }

    @Transactional
    @Override
    public Boolean visible(Boolean visible, Long id) {
        return this.casoRepository.setVisible(visible, id);
    }

    @Transactional(readOnly = true)
    @Override
    public CasoDTO consultarPorId(Long id) {
        Optional<Caso> casoOptional = this.casoRepository.findById(id);
        if (!casoOptional.isPresent()) {
            return null;
        }
        Caso caso = casoOptional.get();
        return CasoDTO.builder()
                .id(caso.getId())
                .fechaHora(caso.getFechaHora())
                .latitud(caso.getLatitud())
                .longitud(caso.getLongitud())
                .altitud(caso.getAltitud())
                .descripcion(caso.getDescripcion())
                .esVisble(caso.getEsVisble())
                .urlMap(caso.getUrlMap())
                .rmiUrl(caso.getRmiUrl())
                .usuarioId(caso.getUsuario().getId())
                .delitoId(caso.getDelito().getId())
                .build();
    }
}

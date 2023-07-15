package co.edu.iudigital.helpmeiud.service.impl;

import co.edu.iudigital.helpmeiud.dto.request.DelitoDTORequest;
import co.edu.iudigital.helpmeiud.dto.response.DelitoDTO;
import co.edu.iudigital.helpmeiud.model.Delito;
import co.edu.iudigital.helpmeiud.model.Usuario;
import co.edu.iudigital.helpmeiud.repository.IDelitoRepository;
import co.edu.iudigital.helpmeiud.repository.IUsuarioRepository;
import co.edu.iudigital.helpmeiud.service.iface.IDelitoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DelitoServiceImpl implements IDelitoService {

    private final IDelitoRepository delitoRepository;
    private final IUsuarioRepository usuarioRepository;

    @Override
    @Transactional(readOnly = true)
    public List<DelitoDTO> consularTodos() {
        List<Delito> delitos = this.delitoRepository.findAll();
        return delitos.stream().map(delito ->
                DelitoDTO.builder()
                        .id(delito.getId())
                        .nombre(delito.getNombre())
                        .descripcion(delito.getDescripcion())
                        .build()).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public DelitoDTO consultarPorId(Long id) {
        return null;
    }

    @Override
    @Transactional
    public DelitoDTO guardarDelito(DelitoDTORequest delitoDTORequest) {
        Delito delito = new Delito();
        delito.setNombre(delitoDTORequest.getNombre());
        delito.setDescripcion(delitoDTORequest.getDescripcion());
        Optional<Usuario> usuario = this.usuarioRepository.findById(1L);
        if (!usuario.isPresent()) {
            return null;
        }
        delito.setUsuario(usuario.get());
        Delito delitoResponse = this.delitoRepository.save(delito);
        return DelitoDTO.builder()
                .id(delitoResponse.getId())
                .nombre(delitoResponse.getNombre())
                .descripcion(delitoResponse.getDescripcion())
                .build();
    }

    @Override
    @Transactional
    public void borrarDelitoPorId(Long id) {

    }
}

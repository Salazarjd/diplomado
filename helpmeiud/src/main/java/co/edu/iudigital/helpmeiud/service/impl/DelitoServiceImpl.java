package co.edu.iudigital.helpmeiud.service.impl;

import co.edu.iudigital.helpmeiud.dto.request.DelitoDTORequest;
import co.edu.iudigital.helpmeiud.dto.response.DelitoDTO;
import co.edu.iudigital.helpmeiud.model.Delito;
import co.edu.iudigital.helpmeiud.repository.IDelitoRepository;
import co.edu.iudigital.helpmeiud.service.iface.IDelitoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DelitoServiceImpl implements IDelitoService {

    private final IDelitoRepository delitoRepository;

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
    public DelitoDTO consultarPorId(Long id) {
        return null;
    }

    @Override
    public DelitoDTO guardarDelito(DelitoDTORequest delitoDTORequest) {
        return null;
    }

    @Override
    public void borrarDelitoPorId(Long id) {

    }
}

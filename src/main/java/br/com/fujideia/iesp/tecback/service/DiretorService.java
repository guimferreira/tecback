package br.com.fujideia.iesp.tecback.service;

import br.com.fujideia.iesp.tecback.model.Diretor;
import br.com.fujideia.iesp.tecback.model.dto.DiretorDTO;
import br.com.fujideia.iesp.tecback.repository.DiretorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class DiretorService {
    private final DiretorRepository diretorRepository;

    // C
    public DiretorDTO criarDiretor(DiretorDTO diretorDTO) {
        Diretor diretor = convertToEntity(diretorDTO);
        return convertToDTO(diretorRepository.save(diretor));
    }

    // R
    public List<DiretorDTO> listarDiretores() {
        return diretorRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<DiretorDTO> buscarDiretorPorId(Long id) {
        return diretorRepository.findById(id)
                .map(this::convertToDTO);
    }

    // U
    public Optional<DiretorDTO> atualizarDiretor(Long id, DiretorDTO diretorDTO) {
        return diretorRepository.findById(id).map(diretor -> {
            diretor.setNome(diretorDTO.getNome());
            return convertToDTO(diretorRepository.save(diretor));
        });
    }

    // D
    public boolean deletarDiretor(Long id) {
        if (diretorRepository.existsById(id)) {
            diretorRepository.deleteById(id);
            return true;
        }
        return false;
        }

    // Converte em DTO
    private DiretorDTO convertToDTO(Diretor diretor) {
        return new DiretorDTO(
                diretor.getId(),
                diretor.getNome()
        );
    }

    // Converte em Entity
    private Diretor convertToEntity(DiretorDTO diretorDTO) {
        Diretor diretor = new Diretor();
        diretor.setId(diretorDTO.getId());
        diretor.setNome(diretorDTO.getNome());
        return diretor;
    }
}

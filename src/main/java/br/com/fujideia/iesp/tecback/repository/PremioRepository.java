package br.com.fujideia.iesp.tecback.repository;

import br.com.fujideia.iesp.tecback.model.Premio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PremioRepository
        extends JpaRepository<Premio, Long> {

    Optional<Premio> findByCategoriaAno(String categoria, Integer ano);
}

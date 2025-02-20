package br.com.LucasCrippa.Market.repositories;

import br.com.LucasCrippa.Market.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}

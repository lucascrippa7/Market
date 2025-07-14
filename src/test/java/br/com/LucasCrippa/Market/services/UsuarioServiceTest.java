package br.com.LucasCrippa.Market.services;

import br.com.LucasCrippa.Market.entities.Usuario;
import br.com.LucasCrippa.Market.repositories.UsuarioRepository;
import br.com.LucasCrippa.Market.services.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UsuarioServiceTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioService usuarioService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findAll_DeveRetornarListaDeUsuarios() {
        Usuario user1 = new Usuario(1L, "João", "Silva", "joao@email.com", "12345678901", "Rua A", "senha1");
        Usuario user2 = new Usuario(2L, "Maria", "Souza", "maria@email.com", "10987654321", "Rua B", "senha2");

        when(usuarioRepository.findAll()).thenReturn(Arrays.asList(user1, user2));

        List<Usuario> resultado = usuarioService.findAll();

        assertEquals(2, resultado.size());
        verify(usuarioRepository, times(1)).findAll();
    }

    @Test
    void findById_DeveRetornarUsuarioQuandoExistir() {
        Usuario user = new Usuario(1L, "João", "Silva", "joao@email.com", "12345678901", "Rua A", "senha1");
        when(usuarioRepository.findById(1L)).thenReturn(Optional.of(user));

        Usuario resultado = usuarioService.findById(1L);

        assertEquals("João", resultado.getNome());
        verify(usuarioRepository, times(1)).findById(1L);
    }

    @Test
    void findById_DeveLancarExcecaoQuandoNaoExistir() {
        when(usuarioRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> usuarioService.findById(99L));
    }

    @Test
    void insert_DeveSalvarNovoUsuario() {
        Usuario novo = new Usuario(null, "Carlos", "Lima", "carlos@email.com", "11122233344", "Rua C", "senha3");
        Usuario salvo = new Usuario(3L, "Carlos", "Lima", "carlos@email.com", "11122233344", "Rua C", "senha3");

        when(usuarioRepository.save(novo)).thenReturn(salvo);

        Usuario resultado = usuarioService.insert(novo);

        assertEquals(3L, resultado.getId());
        verify(usuarioRepository).save(novo);
    }

    @Test
    void delete_DeveChamarRepositoryDelete() {
        Usuario user = new Usuario(1L, "João", "Silva", "joao@email.com", "12345678901", "Rua A", "senha1");
        when(usuarioRepository.findById(1L)).thenReturn(Optional.of(user));

        usuarioService.delete(1L);

        verify(usuarioRepository).deleteById(1L);
    }

    @Test
    void update_DeveAtualizarUsuario() {
        Usuario existente = new Usuario(1L, "João", "Silva", "joao@email.com", "12345678901", "Rua A", "senha1");
        Usuario atualizacao = new Usuario(null, "João", "Almeida", "joao@email.com", "12345678901", "Rua Nova", "novaSenha");

        when(usuarioRepository.findById(1L)).thenReturn(Optional.of(existente));
        when(usuarioRepository.save(any(Usuario.class))).thenReturn(existente);

        Usuario resultado = usuarioService.update(1L, atualizacao);

        assertEquals("Almeida", resultado.getSobreNome());
        assertEquals("Rua Nova", resultado.getEndereco());
        assertEquals("novaSenha", resultado.getPassword());
        verify(usuarioRepository).save(existente);
    }
}

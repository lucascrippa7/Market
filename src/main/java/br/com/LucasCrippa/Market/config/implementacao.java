package br.com.LucasCrippa.Market.config;


import br.com.LucasCrippa.Market.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import br.com.LucasCrippa.Market.repositories.UsuarioRepository;

import java.util.Arrays;

@Configuration
@Profile("test")
public class implementacao implements CommandLineRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void run(String...args) throws Exception{
         Usuario usu1 = new Usuario(null, "Lucas","Crippa", "lucas_crippa@hotmail.com", "415145145", "Rua uma", "1234" );
         usuarioRepository.saveAll(Arrays.asList(usu1));

    }
}

package com.hexa.moran.infrastructure.config;

import com.hexa.moran.application.service.AutorService;
import com.hexa.moran.application.service.CategoriaService;
import com.hexa.moran.application.service.EditorService;
import com.hexa.moran.application.service.LibroService;
import com.hexa.moran.application.usecase.AutorServiceImpl;
import com.hexa.moran.application.usecase.CategoriaServiceImpl;
import com.hexa.moran.application.usecase.EditorServiceImpl;
import com.hexa.moran.application.usecase.LibroServiceImpl;
import com.hexa.moran.domain.ports.out.AutorOut;
import com.hexa.moran.domain.ports.out.CategoriaOut;
import com.hexa.moran.domain.ports.out.EditorOut;
import com.hexa.moran.domain.ports.out.LibroOut;
import com.hexa.moran.infrastructure.repository.AutorRepositoryAdapter;
import com.hexa.moran.infrastructure.repository.CategoriaRepositoryAdapter;
import com.hexa.moran.infrastructure.repository.EditorRepositoryAdapter;
import com.hexa.moran.infrastructure.repository.LibroRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public AutorService autorService(AutorOut autorOut){
        return new AutorService(new AutorServiceImpl(autorOut));
    }

    @Bean
    public AutorOut autorOut(AutorRepositoryAdapter autorRepositoryAdapter){
        return autorRepositoryAdapter;
    }

    @Bean
    public CategoriaService categoriaService(CategoriaOut categoriaOut){
        return new CategoriaService(new CategoriaServiceImpl(categoriaOut));
    }

    @Bean
    public CategoriaOut categoriaOut(CategoriaRepositoryAdapter categoriaRepositoryAdapter){
        return categoriaRepositoryAdapter;
    }

    @Bean
    public EditorService editorService(EditorOut editorOut){
        return new EditorService(new EditorServiceImpl(editorOut));
    }

    @Bean
    public EditorOut editorOut(EditorRepositoryAdapter editorRepositoryAdapter){
        return editorRepositoryAdapter;
    }

    @Bean
    public LibroService libroService(LibroOut libroOut){
        return new LibroService(new LibroServiceImpl(libroOut));
    }

    @Bean
    public LibroOut libroOut(LibroRepositoryAdapter libroRepositoryAdapter){
        return libroRepositoryAdapter;
    }
}

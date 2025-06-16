package biblioteca.salas.duoc.biblioteca.salas.duoc;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import biblioteca.salas.duoc.biblioteca.salas.duoc.model.Estudiante;
import biblioteca.salas.duoc.biblioteca.salas.duoc.model.Carrera;
import biblioteca.salas.duoc.biblioteca.salas.duoc.repository.EstudianteRepository;
import biblioteca.salas.duoc.biblioteca.salas.duoc.service.EstudianteService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;
import java.util.Optional;


@ExtendWith(MockitoExtension.class)
public class EstudianteServiceTest {

    @InjectMocks
    private EstudianteService estudianteService;

    @Mock
    private EstudianteRepository estudianteRepository;

    @Test
    public void testFindAll(){
        
        when(estudianteRepository.findAll()).thenReturn(List.of(new Estudiante(1,"1-9","nicolas","correo@correo.com",'D',22222,new Carrera())));

    }

}

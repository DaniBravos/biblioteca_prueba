package biblioteca.salas.duoc.biblioteca.salas.duoc;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import biblioteca.salas.duoc.biblioteca.salas.duoc.model.Carrera;
import biblioteca.salas.duoc.biblioteca.salas.duoc.repository.CarreraRepository;
import biblioteca.salas.duoc.biblioteca.salas.duoc.service.CarreraService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

//@SpringBootTest
@ExtendWith(MockitoExtension.class) 
public class CarreraServiceTest {

    // Inyecta el servicio de Carrera para ser probado.
    @InjectMocks
    private CarreraService carreraService;

    // Crea un mock del repositorio de Carrera para simular su comportamiento.
    @Mock
    private CarreraRepository carreraRepository;

    @Test
    public void testFindAll() {
        // Define el comportamiento del mock: cuando se llame a findAll(), devuelve una lista con una Carrera.
        when(carreraRepository.findAll()).thenReturn(List.of(new Carrera("1", "Ingeniería")));

        // Llama al método findAll() del servicio.
        List<Carrera> carreras = carreraService.findAll();

        // Verifica que la lista devuelta no sea nula y contenga
        // exactamente una Carrera.
        assertNotNull(carreras);//Comprueba que no este nulo
        assertEquals(1, carreras.size());//Este es el que comprueba que me retorne lo mismo
        //Que le envie en mi mock
    }

    @Test
    public void testFindByCodigo() {
        String codigo = "1";
        Carrera carrera = new Carrera(codigo, "Ingeniería");

        // Define el comportamiento del mock: cuando se llame a findById() con "1", devuelve una Carrera opcional.
        when(carreraRepository.findById(codigo)).thenReturn(Optional.of(carrera));

        // Llama al método findByCodigo() del servicio.
        Carrera found = carreraService.findByCodigo(codigo);

        // Verifica que la Carrera devuelta no sea nula y que su código coincida con el código esperado.
        assertNotNull(found);
        assertEquals(codigo, found.getCodigo());//Este es el que comprueba que me retorne lo mismo
        //Que le envie en mi mock
    }

    @Test
    public void testSave() {
        Carrera carrera = new Carrera("1", "Ingeniería");

        // Define el comportamiento del mock: cuando se llame a save(), devuelve la Carrera proporcionada.
        when(carreraRepository.save(carrera)).thenReturn(carrera);

        // Llama al método save() del servicio.
        Carrera saved = carreraService.save(carrera);

        // Verifica que la Carrera guardada no sea nula y que su nombre coincida con el nombre esperado.
        assertNotNull(saved);
        assertEquals("Ingeniería", saved.getNombre());
    }

    @Test
    public void testDeleteByCodigo() {
        String codigo = "1";

        // Define el comportamiento del mock: cuando se llame a deleteById(), no hace nada.
        doNothing().when(carreraRepository).deleteById(codigo);

        // Llama al método deleteByCodigo() del servicio.
        carreraService.deleteByCodigo(codigo);

        // Verifica que el método deleteById() del repositorio se haya llamado exactamente una vez con el código proporcionado.
        verify(carreraRepository, times(1)).deleteById(codigo);
    }
}

package biblioteca.salas.duoc.biblioteca.salas.duoc;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import biblioteca.salas.duoc.biblioteca.salas.duoc.model.Sala;
import biblioteca.salas.duoc.biblioteca.salas.duoc.model.TipoSala;
import biblioteca.salas.duoc.biblioteca.salas.duoc.repository.SalaRepository;
import biblioteca.salas.duoc.biblioteca.salas.duoc.service.SalaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class SalaServiceTest {

    @InjectMocks
    private SalaService salaService;

    @Mock
    private SalaRepository salaRepository;

    @Test
    public void testFindAll() {
        when(salaRepository.findAll()).thenReturn(List.of(new Sala(1, "Sala A", 30, 1, new TipoSala())));

        List<Sala> salas = salaService.findAll();
        assertNotNull(salas);
        assertEquals(1, salas.size());
    }

    @Test
    public void testFindById() {
        Integer id = 1;
        Sala sala = new Sala(id, "Sala A", 30, 1, new TipoSala());
        when(salaRepository.findById(id)).thenReturn(Optional.of(sala));

        Sala found = salaService.findById(id);
        assertNotNull(found);
        assertEquals(id, found.getCodigo());
    }

    @Test
    public void testSave() {
        Sala sala = new Sala(1, "Sala A", 30, 1, new TipoSala());
        when(salaRepository.save(sala)).thenReturn(sala);

        Sala saved = salaService.save(sala);
        assertNotNull(saved);
        assertEquals("Sala A", saved.getNombre());
    }

    @Test
    public void testDeleteById() {
        Integer id = 1;
        doNothing().when(salaRepository).deleteById(id);

        salaService.deleteById(id);
        verify(salaRepository, times(1)).deleteById(id);
    }
}

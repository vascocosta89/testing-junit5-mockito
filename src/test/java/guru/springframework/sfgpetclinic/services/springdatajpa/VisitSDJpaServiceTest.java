package guru.springframework.sfgpetclinic.services.springdatajpa;

import static org.assertj.core.api.Assertions.assertThat;
import guru.springframework.sfgpetclinic.model.Visit;
import guru.springframework.sfgpetclinic.repositories.VisitRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class VisitSDJpaServiceTest {

    @Mock
    VisitRepository repository;

    @InjectMocks
    VisitSDJpaService serviceUnderTest;

    @DisplayName("Test find all")
    @Test
    void findAll() {
        Set<Visit> visits = new HashSet<>();
        visits.add(new Visit());
        visits.add(new Visit());
        when(repository.findAll()).thenReturn(visits);
        Set<Visit> retrievedSet = serviceUnderTest.findAll();
        assertThat(retrievedSet).isNotNull();
        assertThat(retrievedSet).hasSize(2);
        assertEquals(2,retrievedSet.size(),"size does not match expected value");
        verify(repository,times(1)).findAll();
    }

    @Test
    void findById() {
        Visit visit = new Visit();
        when(repository.findById(1L)).thenReturn(Optional.of(visit));
        Visit retrievedVisit = serviceUnderTest.findById(1L);
        assertThat(retrievedVisit).isNotNull();
        verify(repository,times(1)).findById(any(Long.class));
    }

    @Test
    void save() {
        Visit visit = new Visit();
        when(repository.save(any(Visit.class))).thenReturn(visit);
        Visit savedVisit = serviceUnderTest.save(new Visit());
        verify(repository,times(1)).save(any(Visit.class));
        assertThat(savedVisit).isNotNull();
    }

    @Test
    void delete() {
        Visit visit = new Visit();
        serviceUnderTest.delete(visit);
        verify(repository,times(1)).delete(any(Visit.class));
    }

    @Test
    void deleteById() {
        serviceUnderTest.deleteById(1L);
        verify(repository,times(1)).deleteById(any(Long.class));
    }
}
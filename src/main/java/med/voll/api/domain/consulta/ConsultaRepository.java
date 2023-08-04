package med.voll.api.domain.consulta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

    boolean existsByPacienteIdAndData(Long pacienteId, LocalDate data);

    @Query("SELECT c FROM Consulta c " +
            "WHERE c.medico.id = :medicoId " +
            "AND c.data = :data ")
    Consulta findConsultasAgendadasMesmoDiaHora(Long medicoId, LocalDateTime data);
}


package med.voll.api.domain.consulta.validacao;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class ValidarHorarioFuncionamento implements Validacao {

    @Override
    public void validar(DadosAgendamentoConsulta dados) {

        LocalDateTime data = dados.data();

        if (data.getHour() >= 18) {
            throw new ValidacaoException("A consulta só poderá ser agendada, no máximo, até às 18:00 horas");
        }
        if (data.getHour() < 7) {
            throw new ValidacaoException("A consulta só poderá ser agendada a partir das 7:00 horas");
        }
        if (data.getDayOfWeek() == DayOfWeek.SUNDAY) {
            throw new ValidacaoException("Só podem haver consultas de segunda a sábado");
        }
    }
}

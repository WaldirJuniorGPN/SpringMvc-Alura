package med.voll.api.domain.consulta.validacao;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ValidadorAntecedenciaMinima implements Validacao {

    @Override
    public void validar(DadosAgendamentoConsulta dados) {
        LocalDateTime agora = LocalDateTime.now();
        LocalDateTime horarioMinimo = agora.plusMinutes(30);

        if (dados.data().isBefore(horarioMinimo)) {
            throw new ValidacaoException("A consutla deve ser agendada com 30 minutos de antecedência");
        }
    }
}

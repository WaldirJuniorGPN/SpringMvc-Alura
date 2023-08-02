package med.voll.api.domain.consulta.validacao;

import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.stereotype.Component;

@Component
public interface validacao {

    void validar(DadosAgendamentoConsulta dados);
}

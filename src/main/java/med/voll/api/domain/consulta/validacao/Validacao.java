package med.voll.api.domain.consulta.validacao;

import med.voll.api.domain.consulta.DadosAgendamentoConsulta;

public interface Validacao {

    void validar(DadosAgendamentoConsulta dados);
}

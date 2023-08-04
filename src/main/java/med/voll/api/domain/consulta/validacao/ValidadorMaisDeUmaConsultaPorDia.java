package med.voll.api.domain.consulta.validacao;

import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.beans.factory.annotation.Autowired;

public class ValidadorMaisDeUmaConsultaPorDia implements Validacao {

    @Autowired
    ConsultaRepository consultaRepository;

    @Override
    public void validar(DadosAgendamentoConsulta dados) {

    }
}

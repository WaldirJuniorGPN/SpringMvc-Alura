package med.voll.api.domain.consulta.validacao;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.beans.factory.annotation.Autowired;

public class ValidadorMiasDeUmaConsultaPaciente implements Validacao {

    @Autowired
    ConsultaRepository consultaRepository;

    @Override
    public void validar(DadosAgendamentoConsulta dados) {
        if (consultaRepository.existsByPacienteIdAndData(dados.idPaciente(), dados.data().toLocalDate())) {
            throw new ValidacaoException("Não é permitido mais de uma consulta por dia de um mesmo paciente");
        }
    }
}

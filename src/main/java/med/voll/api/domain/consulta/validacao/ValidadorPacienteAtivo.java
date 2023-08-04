package med.voll.api.domain.consulta.validacao;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ValidadorPacienteAtivo implements Validacao {

    @Autowired
    PacienteRepository pacienteRepository;

    @Override
    public void validar(DadosAgendamentoConsulta dados) {
        var paciente = pacienteRepository.getReferenceById(dados.idPaciente());

        if (!paciente.getAtivo()) {
            throw new ValidacaoException("O ID do paciente não existe");
        }
    }
}

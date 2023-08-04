package med.voll.api.domain.consulta.validacao;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.domain.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ValidadorMedicoAtivo implements Validacao {

    @Autowired
    MedicoRepository medicoRepository;

    @Override
    public void validar(DadosAgendamentoConsulta dados) {
        var medico = medicoRepository.getReferenceById(dados.idMedico());

        if (!medico.getAtivo()) {
            throw new ValidacaoException("O ID do médico informado não existe");
        }
    }
}

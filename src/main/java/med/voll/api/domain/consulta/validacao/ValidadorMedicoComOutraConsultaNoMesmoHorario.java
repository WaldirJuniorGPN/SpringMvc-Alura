package med.voll.api.domain.consulta.validacao;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.domain.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoComOutraConsultaNoMesmoHorario implements Validacao {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Override
    public void validar(DadosAgendamentoConsulta dados) {

        var medicoPossuiOutraConsulta = consultaRepository.existsByMedicoIdAndData(dados.idMedico(), dados.data());

        if (medicoPossuiOutraConsulta) {
            throw new ValidacaoException("Médico já possui outra consulta agendada nesse mesmo horário");
        }

    }
}

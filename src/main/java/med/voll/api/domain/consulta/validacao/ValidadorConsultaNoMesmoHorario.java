package med.voll.api.domain.consulta.validacao;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorConsultaNoMesmoHorario implements Validacao {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Override
    public void validar(DadosAgendamentoConsulta dados) {
        var dataConsulta = dados.data();
        var horaUltimaConsulta = consultaRepository.findConsultasAgendadasMesmoDiaHora(dados.idMedico(), dados.data());
        var horaLimite = horaUltimaConsulta.getData().plusHours(1);

        if (dataConsulta.isBefore(horaLimite) || dataConsulta.isEqual(horaLimite)) {
            throw new ValidacaoException("Só é permitido agendar uma nova consulta cujo horário seja após uma hora, no mínimo, da última consulta");
        }

    }
}

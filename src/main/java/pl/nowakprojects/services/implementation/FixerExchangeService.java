package pl.nowakprojects.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.nowakprojects.restclients.FixerExchangeClient;
import pl.nowakprojects.restclients.dto.ExchangeDTO;
import pl.nowakprojects.services.interfaces.IExchangeService;

import java.util.List;

/**
 * Created by Mateusz on 08.04.2017.
 */
@Service("fixerService")
public class FixerExchangeService implements IExchangeService{

    @Autowired
    @Qualifier("fixerClient")
    FixerExchangeClient fixerExchangeClient;

    @Override
    public ResponseEntity<ExchangeDTO> getLatestExchange() {
        return fixerExchangeClient.getLatestRates();
    }

    @Override
    public ResponseEntity<ExchangeDTO> getWhatATerribleFailure() {
        return new ResponseEntity<>(ExchangeDTO.empty(), HttpStatus.I_AM_A_TEAPOT);
    }

    @Override
    public ExchangeDTO getLatestExchangeFor(String baseSymbol, List<String> toExchangeSymbols) {
        return fixerExchangeClient.getLatestRatesWithBase(baseSymbol,toExchangeSymbols);
    }
}

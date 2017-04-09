package pl.nowakprojects.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pl.nowakprojects.services.restclients.FixerExchangeClient;
import pl.nowakprojects.services.restclients.dto.ExchangeDTO;
import pl.nowakprojects.services.IExchangeService;

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
    public ExchangeDTO getLatestExchange() {
        return fixerExchangeClient.getLatestRates();
    }

    @Override
    public ExchangeDTO getWhatATerribleFailure() {
        return ExchangeDTO.empty();
    }

    @Override
    public ExchangeDTO getLatestExchangeFor(String baseSymbol, List<String> toExchangeSymbols) {
        return fixerExchangeClient.getLatestRatesWithBase(baseSymbol,toExchangeSymbols);
    }
}

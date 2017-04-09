package pl.nowakprojects.services;

import pl.nowakprojects.services.restclients.dto.ExchangeDTO;

import java.util.List;

/**
 * Created by Mateusz on 08.04.2017.
 */
public interface IExchangeService {
    ExchangeDTO getLatestExchange();
    ExchangeDTO getWhatATerribleFailure();
    ExchangeDTO getLatestExchangeFor(String baseSymbol, List<String> toExchangeSymbols);
}

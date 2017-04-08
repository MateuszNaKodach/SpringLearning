package pl.nowakprojects.services.interfaces;

import org.springframework.http.ResponseEntity;
import pl.nowakprojects.restclients.dto.ExchangeDTO;

import java.util.List;

/**
 * Created by Mateusz on 08.04.2017.
 */
public interface IExchangeService {
    ResponseEntity<ExchangeDTO> getLatestExchange();
    ResponseEntity<ExchangeDTO> getWhatATerribleFailure();
    ExchangeDTO getLatestExchangeFor(String baseSymbol, List<String> toExchangeSymbols);
}

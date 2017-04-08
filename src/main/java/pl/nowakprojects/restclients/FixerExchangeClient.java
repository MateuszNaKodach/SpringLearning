package pl.nowakprojects.restclients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.nowakprojects.restclients.dto.ExchangeDTO;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Mateusz on 08.04.2017.
 */
@Service("fixerClient")
public class FixerExchangeClient {

    private static final Class<ExchangeDTO> RESPONSE_MODEL_CLASS = ExchangeDTO.class;
    private static final String BASE_URL = "http://api.fixer.io";

    private static final String LATEST_QUERY_ENDPOINT = "/latest";
    private static final String LATEST_WITH_BASE = "/latest?base=%s";
    private static final String EXCHANGE_SYMBOLS_ENDPOINT = "&symbols=%s";
    private static final String DATE_QUERY_ENDPOINT = "/%s";

    @Autowired
    private RestTemplate restTemplate;


    public ResponseEntity<ExchangeDTO> getLatestRates(){
        return restTemplate.getForEntity(getLatestUrl(), RESPONSE_MODEL_CLASS);
    }

    public ExchangeDTO getLatestRatesWithBase(String baseSymbol, List<String> toExchangeSymbols){
        return restTemplate
                .getForObject(getLatestWithBaseUrlParameters(baseSymbol,toExchangeSymbols),RESPONSE_MODEL_CLASS);
    }

    public String getLatestWithBaseUrlParameters(String base, List<String> toExchange){
        String toExchangeSymbolsWithComas = toExchange.stream()
                .map(s -> s + ",")
                .reduce("", (s1,s2) -> s1+s2);

        return String.format(getLatestWithBaseUrl(), base, toExchangeSymbolsWithComas);
    }

    public String getLatestUrl(){
        return BASE_URL+LATEST_QUERY_ENDPOINT;
    }

    public String getLatestWithBaseUrl(){
        return BASE_URL+LATEST_WITH_BASE+EXCHANGE_SYMBOLS_ENDPOINT;
    }


}

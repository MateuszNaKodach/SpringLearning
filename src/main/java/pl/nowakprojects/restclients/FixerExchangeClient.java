package pl.nowakprojects.restclients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.nowakprojects.restclients.dto.ExchangeDTO;

/**
 * Created by Mateusz on 08.04.2017.
 */
@Service("fixerClient")
public class FixerExchangeClient {

    private static final String BASE_URL = "http://api.fixer.io";

    private static final String LATEST_QUERY_ENDPOINT = "/latest";
    private static final String LATEST_WITH_BASE = "/latest?base=%s";
    private static final String DATE_QUERY_ENDPOINT = "/%s";

    @Autowired
    private RestTemplate restTemplate;


    public String getLatestQueryUrl(){
        return BASE_URL+LATEST_QUERY_ENDPOINT;
    }

    public ResponseEntity<ExchangeDTO> getLatestExchange(){
        return restTemplate.getForEntity(getLatestQueryUrl(),ExchangeDTO.class);
    }

}

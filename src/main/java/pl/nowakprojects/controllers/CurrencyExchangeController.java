package pl.nowakprojects.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.nowakprojects.restclients.dto.ExchangeDTO;
import pl.nowakprojects.services.interfaces.IExchangeService;

/**
 * Created by Mateusz on 08.04.2017.
 */
@RestController
@RequestMapping("/api/v1/exchange")
public class CurrencyExchangeController{

    @Autowired
    @Qualifier("fixerService")
    private IExchangeService exchangeService;

    @RequestMapping(name = "/latest", method = RequestMethod.GET)
    public ResponseEntity<ExchangeDTO> getLatestCurrencyRates(){
        return exchangeService.getLatestExchange();
    }

    

}

package pl.nowakprojects.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.nowakprojects.restclients.dto.ExchangeDTO;
import pl.nowakprojects.services.interfaces.IExchangeService;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * Created by Mateusz on 08.04.2017.
 */
@RestController
@RequestMapping("/exchange")
public class CurrencyExchangeController{

    @Autowired
    @Qualifier("fixerService")
    private IExchangeService exchangeService;

    @RequestMapping(value = "/latest", method = RequestMethod.GET)
    public ResponseEntity<ExchangeDTO> getLatestCurrencyRates(){
        return exchangeService.getLatestExchange();
    }

    @RequestMapping(value = "/future", method = RequestMethod.GET)
    public ResponseEntity<ExchangeDTO> getFutureRates(){
        return exchangeService.getWhatATerribleFailure();
    }

    @RequestMapping(value = "/latestFor",method = RequestMethod.GET)
    public ExchangeDTO getLatestExchangeFor(
            @RequestParam(name="base") String baseSymbol,
            @RequestParam(name="symbols") List<String> toExchangeSymbols){
        return exchangeService.getLatestExchangeFor(baseSymbol,toExchangeSymbols);
    }



}

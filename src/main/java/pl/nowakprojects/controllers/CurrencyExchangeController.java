package pl.nowakprojects.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.nowakprojects.controllers.paramscontainers.ExchangeParams;
import pl.nowakprojects.services.restclients.dto.ExchangeDTO;
import pl.nowakprojects.services.IExchangeService;

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
        return new ResponseEntity<>(exchangeService.getLatestExchange(),HttpStatus.OK);
    }

    @RequestMapping(value = "/future", method = RequestMethod.GET)
    public ResponseEntity<ExchangeDTO> getFutureRates(){
        return new ResponseEntity<>(exchangeService.getWhatATerribleFailure(), HttpStatus.I_AM_A_TEAPOT);
    }

    @RequestMapping(value = "/latestFor",method = RequestMethod.GET)
    public ExchangeDTO getLatestExchangeFor(
            @RequestParam(name="base") String baseSymbol,
            @RequestParam(name="symbols") List<String> toExchangeSymbols){
        return exchangeService.getLatestExchangeFor(baseSymbol,toExchangeSymbols);
    }

    @RequestMapping(value = "/latestFor",method = RequestMethod.POST)
    public ExchangeDTO getLatestExchangeForParams(@Validated @RequestBody ExchangeParams exchangeParams){
        return exchangeService.getLatestExchangeFor(exchangeParams.getBaseSymbol(),exchangeParams.getToExchangeSymbols());
    }



}

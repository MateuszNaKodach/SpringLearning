package pl.nowakprojects.controllers.paramscontainers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by Mateusz on 09.04.2017.
 */
@Data
@AllArgsConstructor
public class ExchangeParams {

    @NotNull
    private final String baseSymbol;

    @NotNull
    private final List<String> toExchangeSymbols;

}

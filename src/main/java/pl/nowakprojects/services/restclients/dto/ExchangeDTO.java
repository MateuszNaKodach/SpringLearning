package pl.nowakprojects.services.restclients.dto;

import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mateusz on 08.04.2017.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExchangeDTO {

    @Expose
    private String base;

    @Expose
    private Date date;

    @Expose
    private Map<String,BigDecimal> rates;

    public static ExchangeDTO empty(){
        return new ExchangeDTO("", new Date(),new HashMap<>());
    }

}

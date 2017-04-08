package pl.nowakprojects.restclients.dto;

import com.google.gson.annotations.Expose;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Map;

/**
 * Created by Mateusz on 08.04.2017.
 */
@Data
public class ExchangeDTO {

    @Expose
    String base;

    @Expose
    Date date;

    @Expose
    Map<String,BigDecimal> rates;

}

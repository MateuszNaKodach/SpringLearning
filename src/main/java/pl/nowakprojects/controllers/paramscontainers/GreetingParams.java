package pl.nowakprojects.controllers.paramscontainers;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Mateusz on 08.04.2017.
 */
@Data
public class GreetingParams {

    private String title;

    @NotNull
    private String name;

    @NotNull
    @Size(min = 2, max = 20)
    private String surname;

    @Max(value = 130)
    @Min(value = 0)
    private Integer age;

}

package pl.nowakprojects.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import pl.nowakprojects.services.interfaces.IInfoService;

/**
 * Created by Mateusz on 08.04.2017.
 */
@Controller
public class InfoController {

    @Qualifier("prodInfo")
    private IInfoService infoService;

    @Autowired
    public InfoController(IInfoService infoService) {
        this.infoService = infoService;
    }
}

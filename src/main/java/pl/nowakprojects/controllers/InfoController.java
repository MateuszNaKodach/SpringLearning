package pl.nowakprojects.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import pl.nowakprojects.services.IInfoService;

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

package pl.nowakprojects.services.impl;

import org.springframework.stereotype.Service;
import pl.nowakprojects.model.Info;
import pl.nowakprojects.services.IInfoService;

/**
 * Created by Mateusz on 08.04.2017.
 */
@Service("prodInfo")
public class InfoServiceProd implements IInfoService {

    @Override
    public Info getInfo() {
        return new Info("Prod Info");
    }
}

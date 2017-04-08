package pl.nowakprojects.services.implementation;

import org.springframework.stereotype.Service;
import pl.nowakprojects.models.Info;
import pl.nowakprojects.services.interfaces.IInfoService;

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

package pl.nowakprojects.services.implementation;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pl.nowakprojects.models.Info;
import pl.nowakprojects.services.interfaces.IInfoService;

/**
 * Created by Mateusz on 08.04.2017.
 */
@Service("devInfo")
@Primary
public class InfoServiceDev implements IInfoService {

    @Override
    public Info getInfo() {
        return new Info("Dev Info");
    }
}

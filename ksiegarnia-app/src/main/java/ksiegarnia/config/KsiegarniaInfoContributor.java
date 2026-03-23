package ksiegarnia.config;

import ksiegarnia.service.KsiazkaService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KsiegarniaInfoContributor implements InfoContributor {

    private final KsiazkaService ksiazkaService;

    @Override
    public void contribute(Info.Builder builder) {

        builder.withDetail("ksiazki", ksiazkaService.getAllKsiazki().size());
    }
}

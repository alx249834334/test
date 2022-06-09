package campaign.repository;

import campaign.model.Campaign;
import campaign.model.Scenario;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface ICampaignRepository {
    Campaign getCompany(UUID id);

    void save(Campaign company);

    void updateWithParameters(Map<String, String> mapToUpdate, UUID id);

    @Transactional
    void save(List<Scenario> scenarioList);
}


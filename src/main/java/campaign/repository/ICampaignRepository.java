package campaign.repository;

import campaign.model.Campaign;

import java.util.Map;
import java.util.UUID;

public interface ICampaignRepository {
    Campaign getCompany(UUID id);

    void save(Campaign company);

    void updateWithParameters(Map<String, String> mapToUpdate, UUID id);
}


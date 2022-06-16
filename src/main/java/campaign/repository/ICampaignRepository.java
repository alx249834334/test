package campaign.repository;

import campaign.model.Campaign;
import campaign.model.Scenario;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * The interface Campaign repository.
 */
public interface ICampaignRepository {
    /**
     * Gets company.
     *
     * @param id the id
     * @return the company
     */
    Campaign getCompany(UUID id);

    /**
     * Save.
     *
     * @param company the company
     */
    void save(Campaign company);

    /**
     * Update with parameters.
     *
     * @param mapToUpdate the map to update
     * @param id          the id
     */
    void updateWithParameters(Map<String, String> mapToUpdate, UUID id);

    /**
     * Save.
     *
     * @param scenarioList the scenario list
     */
    @Transactional
    void save(List<Scenario> scenarioList);
}


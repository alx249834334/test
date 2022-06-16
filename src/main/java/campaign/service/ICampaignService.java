package campaign.service;

import campaign.model.Campaign;
import campaign.validation.CampaignPatchDto;
import campaign.validation.CampaignDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

/**
 * The interface Campaign service.
 */
public interface ICampaignService {
    /**
     * Gets campaign.
     *
     * @param id the id
     * @return the campaign
     */
    Campaign getCampaign(UUID id);

    /**
     * Create campaign uuid.
     *
     * @param newCampaign the new campaign
     * @return the uuid
     */
    UUID createCampaign(CampaignDto newCampaign);

    /**
     * Update campaign.
     *
     * @param id            the id
     * @param patchCampaign the patch campaign
     */
    void updateCampaign(UUID id, CampaignPatchDto patchCampaign);

    /**
     * Upload scenarios and get campaign campaign.
     *
     * @param file the file
     * @return the campaign
     * @throws Exception the exception
     */
    Campaign uploadScenariosAndGetCampaign(MultipartFile file) throws Exception;
}


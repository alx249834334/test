package campaign.service;

import campaign.model.Campaign;
import campaign.validation.CampaignPatchDto;
import campaign.validation.CampaignDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

public interface ICampaignService {
    Campaign getCampaign(UUID id);

    UUID createCampaign(CampaignDto newCampaign);

    void updateCampaign(UUID id, CampaignPatchDto patchCampaign);

    Campaign uploadScenariosAndGetCampaign(MultipartFile file) throws Exception;
}


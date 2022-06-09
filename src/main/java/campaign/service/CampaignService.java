package campaign.service;

import campaign.converter.CampaignMapper;
import campaign.converter.ConverterCsv;
import campaign.model.Campaign;
import campaign.model.Scenario;
import campaign.repository.ICampaignRepository;
import campaign.validation.CampaignPatchDto;
import campaign.validation.CampaignDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CampaignService implements ICampaignService {

    private final ICampaignRepository companyRepository;

    private CampaignMapper mapper
            = Mappers.getMapper(CampaignMapper.class);

    public CampaignService(ICampaignRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public Campaign getCampaign(UUID id) {
        var result = companyRepository.getCompany(id);
        return result;
    }

    @Override
    public UUID createCampaign(CampaignDto newCompany) {
        var campaign = mapper.CampaignDtoToCampaign(newCompany);
        companyRepository.save(campaign);
        return campaign.getId();
    }

    @Override
    public void updateCampaign(UUID id, CampaignPatchDto patchCampaign) {
        ObjectMapper oMapper = new ObjectMapper();
        if (patchCampaign.getStatus() == null) {
            patchCampaign.setStatus("new");
        }
        Map<String, String> map = oMapper.convertValue(patchCampaign, Map.class);
        companyRepository.updateWithParameters(map, id);
    }

    @Override
    public void uploadScenarios(MultipartFile file) throws Exception {

        var ListScenarioToUpload = ConverterCsv.convertFileToTargetObject(file, Scenario.class);
        var groupByIdListToUpdate = ListScenarioToUpload.stream().collect
                (Collectors.groupingBy(Scenario::getId));
    }
}

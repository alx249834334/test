package campaign.service;

import campaign.converter.CampaignMapper;
import campaign.converter.ConverterCsv;
import campaign.converter.ScenarionMapper;
import campaign.model.Campaign;
import campaign.model.Scenario;
import campaign.repository.ICampaignRepository;
import campaign.validation.CampaignPatchDto;
import campaign.validation.CampaignDto;
import campaign.validation.ScenarioDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * The type Campaign service.
 */
@Service
public class CampaignService implements ICampaignService {

    private final ICampaignRepository companyRepository;

    private CampaignMapper campaignMapper
            = Mappers.getMapper(CampaignMapper.class);

    private ScenarionMapper scenarionMapper
            = Mappers.getMapper(ScenarionMapper.class);

    /**
     * Instantiates a new Campaign service.
     *
     * @param companyRepository the company repository
     */
    public CampaignService(ICampaignRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public Campaign getCampaign(UUID id) {
        var result = companyRepository.getCompany(id);
        return result;
    }

    /**
     *
     * @param newCompany
     * @return
     */
    @Override
    public UUID createCampaign(CampaignDto newCompany) {
        var campaign = campaignMapper.CampaignDtoToCampaign(newCompany);
        companyRepository.save(campaign);
        return campaign.getId();
    }

    /**
     *
     * @param id            the id
     * @param patchCampaign the patch campaign
     */
    @Override
    public void updateCampaign(UUID id, CampaignPatchDto patchCampaign) {
        ObjectMapper oMapper = new ObjectMapper();
        if (patchCampaign.getStatus() == null) {
            patchCampaign.setStatus("new");
        }
        Map<String, String> map = oMapper.convertValue(patchCampaign, Map.class);
        companyRepository.updateWithParameters(map, id);
    }

    /**
     *
     * @param file the file
     * @return
     * @throws Exception
     */
    @Override
    public Campaign uploadScenariosAndGetCampaign(MultipartFile file) throws Exception {
        var ListScenarioDtoToUpload = ConverterCsv.convertFileToTargetObject(file, ScenarioDto.class);
        var ListScenarioToUpload = ListScenarioDtoToUpload.stream().
                map( el -> scenarionMapper.ScenarioDtoToScenario(el) ).collect(Collectors.toList());

        companyRepository.save(ListScenarioToUpload);

        var groupByIdListToUpdate = ListScenarioToUpload.stream().collect
                (Collectors.groupingBy(Scenario::getCampaign_id));
        var keyUUID = groupByIdListToUpdate.keySet().stream().findFirst().get();
        var companyByKeyUUID = companyRepository.getCompany(keyUUID);
        companyByKeyUUID.setScenarioList(ListScenarioToUpload);
        return companyByKeyUUID;
    }
}

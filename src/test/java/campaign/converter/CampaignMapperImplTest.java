package campaign.converter;

import campaign.model.Campaign;
import campaign.validation.CampaignDto;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

class CampaignMapperImplTest {

    private CampaignMapper mapper
            = Mappers.getMapper(CampaignMapper.class);

    @Test
    void campaignToDto() {
        var campaign = new Campaign("test_name");
        var campaignToDto = mapper.CampaignToDto(campaign);

        assertEquals(campaign.getStatus(), campaignToDto.getStatus());
        assertEquals(campaign.getName(), campaignToDto.getName());
    }

    @Test
    void campaignDtoToCampaign() {
        var campaignToDto = new CampaignDto("test_name");
        var campaign = mapper.CampaignDtoToCampaign(campaignToDto);

        assertEquals(campaign.getStatus(), campaignToDto.getStatus());
        assertEquals(campaign.getName(), campaignToDto.getName());
        assertNotNull(campaign.getId());
    }
}
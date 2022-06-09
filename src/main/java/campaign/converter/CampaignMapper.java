package campaign.converter;

import campaign.validation.CampaignDto;
import campaign.model.Campaign;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.UUID;

@Mapper
public interface CampaignMapper {
    @Mappings({
            @Mapping(target="name", source="campaign.name"),
            @Mapping(target="status", source="campaign.status")
    })
    CampaignDto CampaignToDto(Campaign campaign);
    @Mappings({
            @Mapping(target = "id", expression = "java(getUUID())"),
            @Mapping(target="name", source="campaignDto.name"),
            @Mapping(target="status", source="campaignDto.status")
    })
    Campaign CampaignDtoToCampaign(CampaignDto campaignDto);

    default UUID getUUID() {
        return UUID.randomUUID();
    }

}
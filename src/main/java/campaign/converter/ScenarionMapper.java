package campaign.converter;

import campaign.model.Campaign;
import campaign.model.Scenario;
import campaign.validation.CampaignDto;
import campaign.validation.ScenarioDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.UUID;

@Mapper
public interface ScenarionMapper {
    @Mappings({
            @Mapping(target = "name", source = "scenario.name"),
            @Mapping(target = "start_date", source = "scenario.start_date"),
            @Mapping(target = "end_date", source = "scenario.end_date"),
            @Mapping(target = "campaign_id", expression = "java(scenario.getId().toString())")

    })
    ScenarioDto ScenarioToDto(Scenario scenario);

    @Mappings({
            @Mapping(target = "id", expression = "java(getUUID())"),
            @Mapping(target = "campaign_id", expression = "java(UUID.fromString(scenarioDto.getCampaign_id()))"),
            @Mapping(target = "name", source = "scenarioDto.name"),
            @Mapping(target = "start_date", source = "scenarioDto.start_date"),
            @Mapping(target = "end_date", source = "scenarioDto.end_date")
    })
    Scenario ScenarioDtoToScenario(ScenarioDto scenarioDto);

    default UUID getUUID() {
        return UUID.randomUUID();
    }

}

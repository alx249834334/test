package campaign.validation;

import javax.validation.constraints.Pattern;

//TODO: продумать логику валидации (любой из атрибутов может отсутствовать)
public class CampaignPatchDto {

    private String name;

    @Pattern(regexp = "new|active|deactivated")
    private String status = "new";

    public CampaignPatchDto(String name, String status) {
        this.name = name;
        this.status = status;
    }

    public CampaignPatchDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}



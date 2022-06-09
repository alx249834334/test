package campaign.validation;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class CampaignDto {
    @NotNull
    private String name;

    @Pattern(regexp = "new|active|deactivated")
    private String status = "new";

    public CampaignDto(String name, String status) {
        this.name = name;
        this.status = status;
    }

    public CampaignDto(String name) {
        this.name = name;
    }

    public CampaignDto() {
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

package campaign.validation;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * /**
 * The type Campaign dto.
 */
public class CampaignDto {
    @NotNull
    private String name;

    @Pattern(regexp = "new|active|deactivated")
    private String status = "new";

    /**
     * Instantiates a new Campaign dto.
     *
     * @param name   the name
     * @param status the status
     */
    public CampaignDto(String name, String status) {
        this.name = name;
        this.status = status;
    }

    /**
     * Instantiates a new Campaign dto.
     *
     * @param name the name
     */
    public CampaignDto(String name) {
        this.name = name;
    }

    /**
     * Instantiates a new Campaign dto.
     */
    public CampaignDto() {
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets status.
     *
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets status.
     *
     * @param status the status
     */
    public void setStatus(String status) {
        this.status = status;
    }
}

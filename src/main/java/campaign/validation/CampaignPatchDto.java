package campaign.validation;

import javax.validation.constraints.Pattern;

/**
 * The type Campaign patch dto.
 */
//TODO: продумать логику валидации (любой из атрибутов может отсутствовать)
public class CampaignPatchDto {

    private String name;

    @Pattern(regexp = "new|active|deactivated")
    private String status = "new";

    /**
     * Instantiates a new Campaign patch dto.
     *
     * @param name   the name
     * @param status the status
     */
    public CampaignPatchDto(String name, String status) {
        this.name = name;
        this.status = status;
    }

    /**
     * Instantiates a new Campaign patch dto.
     */
    public CampaignPatchDto() {
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



package campaign.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


/**
 * The type Campaign.
 */
public class Campaign {

    private UUID id = UUID.randomUUID();

    private String name;

    private String status = "new";

    /**
     * Gets scenario list.
     *
     * @return the scenario list
     */
    public List<Scenario> getScenarioList() {
        return scenarioList;
    }

    /**
     * Sets scenario list.
     *
     * @param scenarioList the scenario list
     */
    public void setScenarioList(List<Scenario> scenarioList) {
        this.scenarioList = scenarioList;
    }

    private List<Scenario> scenarioList = new ArrayList<>();

    /**
     * Instantiates a new Campaign.
     *
     * @param id     the id
     * @param name   the name
     * @param status the status
     */
    public Campaign(UUID id, String name, String status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    /**
     * Instantiates a new Campaign.
     *
     * @param id   the id
     * @param name the name
     */
    public Campaign(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Instantiates a new Campaign.
     *
     * @param name the name
     */
    public Campaign(String name) {
        this.name = name;
    }

    /**
     * Instantiates a new Campaign.
     */
    public Campaign() {
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public UUID getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(UUID id) {
        this.id = id;
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
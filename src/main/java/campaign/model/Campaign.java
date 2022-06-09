package campaign.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

//TODO: to complete
public class Campaign {

    private UUID id = UUID.randomUUID();

    private String name;

    private String status = "new";

    public List<Scenario> getScenarioList() {
        return scenarioList;
    }

    public void setScenarioList(List<Scenario> scenarioList) {
        this.scenarioList = scenarioList;
    }

    private List<Scenario> scenarioList = new ArrayList<>();

    public Campaign(UUID id, String name, String status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public Campaign(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public Campaign(String name) {
        this.name = name;
    }

    public Campaign() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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
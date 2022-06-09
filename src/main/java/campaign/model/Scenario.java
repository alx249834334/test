package campaign.model;

import java.time.LocalDate;
import java.util.UUID;

/*TODO: добавить валидацию для JSON или написать конвертер для ручной валидации (в целом лучше взять что-то готовое, если есть от Jackson)
при текущей реализии при ошибке названия обоих атрибутов может обновиться на null,new,
возможно написать ручную валидацию JSON
*/
public class Scenario {

    //@main.java.validation.UUID
    private UUID id = UUID.randomUUID();

    //@NotEmpty
    private String name;

    private LocalDate start_date;

    private LocalDate end_date;

    private UUID campaign_id;

    public Scenario(UUID id, String name, LocalDate start_date, LocalDate end_date, UUID campaign_id) {
        this.id = id;
        this.name = name;
        this.start_date = start_date;
        this.end_date = end_date;
        this.campaign_id = campaign_id;
    }

    public LocalDate getStart_date() {
        return start_date;
    }

    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }

    public LocalDate getEnd_date() {
        return end_date;
    }

    public void setEnd_date(LocalDate end_date) {
        this.end_date = end_date;
    }

    public UUID getCampaign_id() {
        return campaign_id;
    }

    public void setCampaign_id(UUID campaign_id) {
        this.campaign_id = campaign_id;
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

}


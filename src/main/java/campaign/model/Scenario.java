package campaign.model;

import java.time.LocalDate;
import java.util.UUID;

/**
 * The type Scenario.
 */
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

    /**
     * Instantiates a new Scenario.
     *
     * @param id          the id
     * @param name        the name
     * @param start_date  the start date
     * @param end_date    the end date
     * @param campaign_id the campaign id
     */
    public Scenario(UUID id, String name, LocalDate start_date, LocalDate end_date, UUID campaign_id) {
        this.id = id;
        this.name = name;
        this.start_date = start_date;
        this.end_date = end_date;
        this.campaign_id = campaign_id;
    }

    /**
     * Gets start date.
     *
     * @return the start date
     */
    public LocalDate getStart_date() {
        return start_date;
    }

    /**
     * Sets start date.
     *
     * @param start_date the start date
     */
    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }

    /**
     * Gets end date.
     *
     * @return the end date
     */
    public LocalDate getEnd_date() {
        return end_date;
    }

    /**
     * Sets end date.
     *
     * @param end_date the end date
     */
    public void setEnd_date(LocalDate end_date) {
        this.end_date = end_date;
    }

    /**
     * Gets campaign id.
     *
     * @return the campaign id
     */
    public UUID getCampaign_id() {
        return campaign_id;
    }

    /**
     * Sets campaign id.
     *
     * @param campaign_id the campaign id
     */
    public void setCampaign_id(UUID campaign_id) {
        this.campaign_id = campaign_id;
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

}


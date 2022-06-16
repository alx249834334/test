package campaign.validation;

import campaign.converter.LocalDateConverter;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;
import com.opencsv.bean.CsvDate;

import java.time.LocalDate;

/**
 * The type Scenario dto.
 */
public class ScenarioDto {
    @CsvBindByName(column = "name")
    private String name;
    @CsvCustomBindByName(column = "start_date", converter = LocalDateConverter.class)
    private LocalDate start_date;
    @CsvCustomBindByName(column = "end_date", converter = LocalDateConverter.class)
    private LocalDate end_date;
    @CsvBindByName(column = "campaign_id")
    private String campaign_id;

    /**
     * Instantiates a new Scenario dto.
     *
     * @param name        the name
     * @param start_date  the start date
     * @param end_date    the end date
     * @param campaign_id the campaign id
     */
    public ScenarioDto(String name, LocalDate start_date, LocalDate end_date, String campaign_id) {
        this.name = name;
//        this.start_date = start_date;
//        this.end_date = end_date;
        this.campaign_id = campaign_id;
    }

    /**
     * Instantiates a new Scenario dto.
     */
    public ScenarioDto() {
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
    public String getCampaign_id() {
        return campaign_id;
    }

    /**
     * Sets campaign id.
     *
     * @param campaign_id the campaign id
     */
    public void setCampaign_id(String campaign_id) {
        this.campaign_id = campaign_id;
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

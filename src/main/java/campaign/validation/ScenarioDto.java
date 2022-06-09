package campaign.validation;

import campaign.converter.LocalDateConverter;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;
import com.opencsv.bean.CsvDate;

import java.time.LocalDate;

public class ScenarioDto {
    @CsvBindByName(column = "name")
    private String name;
    @CsvCustomBindByName(column = "start_date", converter = LocalDateConverter.class)
    private LocalDate start_date;
    @CsvCustomBindByName(column = "end_date", converter = LocalDateConverter.class)
    private LocalDate end_date;
    @CsvBindByName(column = "campaign_id")
    private String campaign_id;

    public ScenarioDto(String name, LocalDate start_date, LocalDate end_date, String campaign_id) {
        this.name = name;
//        this.start_date = start_date;
//        this.end_date = end_date;
        this.campaign_id = campaign_id;
    }

    public ScenarioDto() {
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

    public String getCampaign_id() {
        return campaign_id;
    }

    public void setCampaign_id(String campaign_id) {
        this.campaign_id = campaign_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

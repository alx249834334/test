package campaign.repository;

import campaign.model.Campaign;
import campaign.model.Scenario;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Component
public class CampaignRepository implements ICampaignRepository {

    public static final String SQL_START_UPDATE = "UPDATE campaign SET ";
    public static final String SQL_END_UPDATE = " WHERE id = ?";
    public static final String INSERT_INTO_CAMPAIGN_ID_NAME_STATUS_VALUES = "INSERT INTO campaign(id, name, status) VALUES(?,?,?)";
    public static final String INSERT_INTO_SCENARIO =
            "INSERT INTO scenario(id, name, start_date,end_date,campaign_id) VALUES(?,?,?,?,?)";
    private static final String SQL_SELECT_CAMPAIGN = "SELECT id,name,status FROM campaign WHERE id = ?";

    private static final RowMapper<Campaign> SELECT_MAPPER =
            (rs, i) -> new Campaign(UUID.fromString(rs.getString(1)),
                    rs.getString(2),
                    rs.getString(3)
                    );

    private final JdbcTemplate jdbcTemplate;

    public CampaignRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void updateWithParameters(Map<String, String> mapToUpdate, UUID id) {
        List<Object> parameters = new ArrayList<Object>();
        String sql = prepareQuery(mapToUpdate, id, parameters);
        jdbcTemplate.update(sql, parameters.toArray());
    }

    private String prepareQuery(Map<String, String> mapToUpdate, UUID id, List<Object> map) {
        StringBuilder sql_middle = new StringBuilder("");
        StringBuilder finalSql_middle = sql_middle;
        mapToUpdate.forEach((k, v) -> {
            StringBuilder fieldParam = new StringBuilder(":").append(k);
            finalSql_middle.append(k.toUpperCase()).append("=").append("?, ");
            map.add(v);
        });
        var len = finalSql_middle.length();
        sql_middle = new StringBuilder(finalSql_middle.substring(0, len - 2));
        String sql = SQL_START_UPDATE + sql_middle.toString() + SQL_END_UPDATE;
        map.add(id);
        return sql;
    }

    @Override
    @Transactional(readOnly = true)
    public Campaign getCompany(UUID id) {
        var campaign= jdbcTemplate.query(
                SQL_SELECT_CAMPAIGN,
                rs -> rs.next() ? SELECT_MAPPER.mapRow(rs, 1) : null,
                id);
        return campaign;
    }

    @Override
    @Transactional
    public void save(Campaign campaign) {
        jdbcTemplate.update(INSERT_INTO_CAMPAIGN_ID_NAME_STATUS_VALUES,
                campaign.getId(), campaign.getName(), campaign.getStatus());
    }

    @Override
    @Transactional
    public void save(List<Scenario> scenarioList) {
        scenarioList.forEach( el ->
        jdbcTemplate.update(INSERT_INTO_SCENARIO ,
                el.getId(),el.getName(),el.getStart_date(),el.getEnd_date(),el.getCampaign_id()));
    }
}

package campaign.service;

import campaign.controller.CampaignController;
import campaign.repository.CampaignRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class CampaignServiceTest {

    @Autowired
    CampaignRepository campaignRepository;

    @Test
    public void contextLoads() {
        assertThat(campaignRepository).isNotNull();
    }

}
package campaign;

import campaign.controller.CampaignController;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * The type Application test.
 */
@SpringBootTest
class ApplicationTest {

    /**
     * The Controller.
     */
    @Autowired
    CampaignController controller;

    /**
     * Context loads.
     */
    @Test
    public void contextLoads() {
        assertThat(controller).isNotNull();
    }
}
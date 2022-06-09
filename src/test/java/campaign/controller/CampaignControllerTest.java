package campaign.controller;

import campaign.service.ICampaignService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CampaignController.class)
class CampaignControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ICampaignService campaignService;

    @Test
    public void testGet() throws Exception {
        this.mockMvc.perform(get("/api/campaigns/ec3b15b5-d075-4430-b447-c3d2661c64a0")).andDo(print()).andExpect(status().isOk());
                //.andExpect(content().string(containsString("Hello, World")));
    }

    @Test
    public void testPost() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders
                .post("/api/campaigns")
                .accept(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"my_login4444\"}")
                .contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(request).andExpect(status().isOk());

        RequestBuilder requestExtended = MockMvcRequestBuilders
                .post("/api/campaigns")
                .accept(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"my_login4444\",\"status\":\"new\"}")
                .contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestExtended).andExpect(status().isOk());
    }

    @Test
    public void testPatch() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders
                .patch("/api/campaigns/ec3b15b5-d075-4430-b447-c3d2661c64a0")
                .accept(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"my_login4444\"}")
                .contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(request).andExpect(status().isOk());

        RequestBuilder requestFailedValidate = MockMvcRequestBuilders
                .patch("/api/campaigns/ec3b15b5" +
                        "-d075-4430-b447-c3d2661c64a0")
                .accept(MediaType.APPLICATION_JSON)
                .content("{\"status\":\"my_login4444\"}")
                .contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestFailedValidate).andExpect(status().isBadRequest());

        RequestBuilder requestOkValidate = MockMvcRequestBuilders
                .patch("/api/campaigns/ec3b15b5" +
                        "-d075-4430-b447-c3d2661c64a0")
                .accept(MediaType.APPLICATION_JSON)
                .content("{\"status\":\"new\"}")
                .contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestOkValidate).andExpect(status().isOk());

        RequestBuilder requestExtended = MockMvcRequestBuilders
                .patch("/api/campaigns/ec3b15b5-d075-4430-b447-c3d2661c64a0")
                .accept(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"my_login4444\",\"status\":\"new\"}")
                .contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestExtended).andExpect(status().isOk());
    }

    @Test
    public void testUpload() throws Exception {
        MockMultipartFile file
                = new MockMultipartFile(
                "file",
                "hello.txt",
                MediaType.TEXT_PLAIN_VALUE,
                "Hello, World!".getBytes()
        );

        mockMvc.perform(multipart("/api/campaign/upload_scenarios").file(file)).andExpect(status().isOk());
    }
}
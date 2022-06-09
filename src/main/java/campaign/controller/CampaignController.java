package campaign.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import campaign.model.Campaign;
import campaign.service.ICampaignService;
import campaign.validation.CampaignPatchDto;
import campaign.validation.CampaignDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

import java.util.UUID;

//TODO: add CustomGlobalExceptionHandler

@RestController
@RequestMapping("/api")
public class CampaignController {

    private final ICampaignService campaignService;

    private final Logger log = LoggerFactory.getLogger(CampaignController.class);

    public CampaignController(ICampaignService campaignService) {
        this.campaignService = campaignService;
    }

    @ExceptionHandler(JsonProcessingException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<String> handleJsonProcessingException(
            JsonProcessingException exception
    ) {
        log.error("Failed to parse json", exception);
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Failed to parse json");
    }

    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<String> handleException(
            Throwable exception
    ) {
        log.error("INTERNAL_SERVER_ERROR", exception);
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("INTERNAL_SERVER_ERROR");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<String> handleException(
            MethodArgumentNotValidException exception
    ) {
        log.error("BAD_REQUEST", exception);
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("BAD_REQUEST - Validation request failed");
    }

    @GetMapping("/campaigns/{id}")
    public Campaign getCampaign(@PathVariable UUID id) throws JsonProcessingException {
        var result = campaignService.getCampaign(id);
        return result;
    }

    @PostMapping("/campaigns")
    public String newCampaign(@RequestBody @Valid CampaignDto newCampaign) {
        var id = campaignService.createCampaign(newCampaign);
        return "id:" + id;
    }

    @PatchMapping(value = "/campaigns/{id}")
    public void patchCampaign(@PathVariable UUID id,
                              @RequestBody @Valid CampaignPatchDto patchCampaign)  throws JsonProcessingException {
        campaignService.updateCampaign(id, patchCampaign);
    }

    //TODO:данный метод не реализован, здесь только черновик возможной реализации
    @PostMapping("/campaign/upload_scenarios")
    public String handleFileUpload(@RequestParam("file") MultipartFile file) throws Exception {
        campaignService.uploadScenarios(file);
        return "file";
    }
}
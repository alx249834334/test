package campaign.converter;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class ConverterCsv {

    private final static Logger log = LoggerFactory.getLogger(ConverterCsv.class);

    public static <T> List<T> convertFileToTargetObject(MultipartFile file, Class<T> target) throws Exception {
        if (file == null) {
            throw new Exception("No file uploaded!");
        }
        try {
            InputStreamReader streamReader = new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8);
            CsvToBean<T> csvToBean = new CsvToBeanBuilder<T>(streamReader)
                    .withType(target)
                    //.withSeparator(';')
                    //.withIgnoreLeadingWhiteSpace(true)
                    .build();
            return csvToBean.parse();
        } catch (IOException e) {
            log.error("Can't convert file to target class: {}", target.getSimpleName(), e);
            throw new Exception("Can't convert file to target class");
        }
    }
}

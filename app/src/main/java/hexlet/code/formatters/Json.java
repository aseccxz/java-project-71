package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.DifferStatusData;

import java.util.List;

public class Json {
    public static String toJsonFormat(List<DifferStatusData> changesLog) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(changesLog);
    }
}

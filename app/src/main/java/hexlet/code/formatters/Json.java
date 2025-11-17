package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.DifferStatusData;

import java.util.List;

public class Json {
    public static String toJsonFormat(List<DifferStatusData> changesLog) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        StringBuilder sb = new StringBuilder("{\n");
        for (DifferStatusData value : changesLog) {
            String jsonOldValue = objectMapper.writeValueAsString(value.getOldValue());
            String jsonNewValue = objectMapper.writeValueAsString(value.getNewValue());
            String currentLine = switch (value.getStatusName()) {
                case DifferStatusData.ADDED, DifferStatusData.UNCHANGED -> "  \"" + value.getKeyValue()
                        + "\": {\n    \"status\":\""  + value.getStatusName() + "\",\n    \"current\": "
                        + jsonOldValue + "\n  }";
                case DifferStatusData.CHANGED -> "  \"" + value.getKeyValue() + "\": {\n    \"status\": \""
                        + value.getStatusName() + "\",\n    \"previous\": " + jsonOldValue + ",\n    \"current\": "
                        + jsonNewValue + "\n  }";
                case DifferStatusData.DELETED -> "  \"" + value.getKeyValue() + "\": {\n    \"status\": \""
                        + value.getStatusName() + "\",\n    \"previous\": " + jsonOldValue + "\n  }";
                default -> "";
            };
            sb.append(currentLine);
            if (!value.equals(changesLog.getLast())) {
                sb.append(",\n");
            }
        }
        sb.append("\n}");
        return sb.toString();
    }
}

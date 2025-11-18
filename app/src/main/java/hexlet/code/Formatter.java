package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.List;

public class Formatter {
    public static String formatOption(String format, List<DifferStatusData> changesLog)
            throws JsonProcessingException {
        return switch (format) {
            case "plain" -> Plain.toPlainFormat(changesLog);
            case "stylish" -> Stylish.toStylishFormat(changesLog);
            case "json" -> Json.toJsonFormat(changesLog);
            default -> throw new RuntimeException("Unknown format: " + format);
        };
    }
}

package hexlet.code.formatters;

import hexlet.code.DifferStatusData;

import java.util.List;

public class Stylish {
    public static String toStylishFormat(List<DifferStatusData> changesLog) {
        StringBuilder sb = new StringBuilder("{\n");
        for (DifferStatusData value : changesLog) {
            String currentLine = switch (value.getStatusName()) {
                case DifferStatusData.ADDED -> "  + " + value.getKeyValue() + ": " + value.getOldValue();
                case DifferStatusData.CHANGED -> "  - " + value.getKeyValue() + ": " + value.getOldValue()
                        + "\n  + " + value.getKeyValue() + ": " + value.getNewValue();
                case DifferStatusData.DELETED -> "  - " + value.getKeyValue() + ": " + value.getOldValue();
                case DifferStatusData.UNCHANGED -> "    " + value.getKeyValue() + ": " + value.getOldValue();
                default -> "";
            };
            sb.append(currentLine).append("\n");
        }
        sb.append("}");
        return sb.toString();
    }
}

package hexlet.code.formatters;

import hexlet.code.DifferStatusData;

import java.util.List;

public class Plain {
    public static String hideComplexValue(Object object) {
        if (object == null) {
            return "null";
        } else if (object instanceof String) {
            return "'" + object + "'";
        } else if (object instanceof List || object instanceof java.util.Map) {
            return "[complex value]";
        }
        return object.toString();
    }

    public static String toPlainFormat(List<DifferStatusData> changesLog) {
        StringBuilder sb = new StringBuilder();
        for (DifferStatusData value : changesLog) {
            String currentLine = switch (value.getStatusName()) {
                case DifferStatusData.ADDED ->
                        "Property '" + value.getKeyValue() + "' was added with value: "
                                + hideComplexValue(value.getOldValue());
                case DifferStatusData.CHANGED ->
                        "Property '" + value.getKeyValue() + "' was updated. From "
                                + hideComplexValue(value.getOldValue())
                                + " to " + hideComplexValue(value.getNewValue());
                case DifferStatusData.DELETED -> "Property '" + value.getKeyValue() + "' was removed";
                case DifferStatusData.UNCHANGED -> "";
                default -> throw new RuntimeException("Unknown status: " + value.getStatusName());
            };
            if (currentLine.isEmpty()) {
                continue;
            }
            sb.append(currentLine);
            if (!value.equals(changesLog.getLast())) {
                sb.append("\n");
            }
        }
        return sb.toString().trim();
    }
}

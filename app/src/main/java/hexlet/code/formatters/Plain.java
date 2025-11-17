package hexlet.code.formatters;

import hexlet.code.DifferStatusData;

import java.util.List;

public class Plain {
    public static Object hideComplexValue(Object object) {
        if (object instanceof Number || object instanceof String || object instanceof Boolean || object == null) {
            return object;
        }
        return "[complex value]";
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
                case DifferStatusData.DELETED -> "Property '" + value.getKeyValue() + " was removed";
                default -> "";
            };
            if (currentLine.isEmpty()) {
                continue;
            }
            sb.append(currentLine);
            if (!value.equals(changesLog.getLast())) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}

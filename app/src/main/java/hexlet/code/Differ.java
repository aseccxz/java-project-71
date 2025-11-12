package hexlet.code;

import org.apache.commons.collections4.CollectionUtils;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Differ {

    public static String generate(String pathJson1, String pathJson2) throws Exception {
            Map<String, Object> json1 = Parser.getMapFromJSONPath(pathJson1);
            Map<String, Object> json2 = Parser.getMapFromJSONPath(pathJson2);
    //        Map<String, String> json1 = Parser.getMapFromYAMLPath(pathJson1);
    //        Map<String, String> json2 = Parser.getMapFromYAMLPath(pathJson2);
            Set<String> keysJson1 = json1.keySet();
            Set<String> keysJson2 = json2.keySet();
            List<String> allKeys = (List<String>) CollectionUtils.union(keysJson1, keysJson2);
            List<String> commonKeys = (List<String>) CollectionUtils.intersection(keysJson1, keysJson2);
            List<String> uniqueKeysJson1 = (List<String>) CollectionUtils.subtract(keysJson1, keysJson2);
            List<String> uniqueKeysJson2 = (List<String>) CollectionUtils.subtract(keysJson2, keysJson1);
            StringBuilder diff = new StringBuilder();
            allKeys.sort(String::compareTo);

            allKeys.forEach(key -> {
                if (commonKeys.contains(key)) {
                    if (Objects.equals(json1.get(key), json2.get(key))) {
                        diff.append("  ").append(key).append(": ").append(json1.get(key)).append("\n");
                    } else {
                        diff.append("- ").append(key).append(": ").append(json1.get(key)).append("\n");
                        diff.append("+ ").append(key).append(": ").append(json2.get(key)).append("\n");
                    }
                }
                if (uniqueKeysJson1.contains(key)) {
                    diff.append("- ").append(key).append(": ").append(json1.get(key)).append("\n");
                }
                if (uniqueKeysJson2.contains(key)) {
                    diff.append("+ ").append(key).append(": ").append(json2.get(key)).append("\n");
                }
            });
            if (!diff.isEmpty() && diff.charAt(diff.length() - 1) == '\n') {
                diff.deleteCharAt(diff.length() - 1);
            }
            return diff.toString();
    }
}

package hexlet.code;

import org.apache.commons.collections4.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Differ {
    public static String generate(Map<String, String> json1, Map<String, String> json2) {
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
                if (json1.get(key).equals(json2.get(key))) {
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
        return diff.toString();
    }
}

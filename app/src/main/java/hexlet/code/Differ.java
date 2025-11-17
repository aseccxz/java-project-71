package hexlet.code;

import org.apache.commons.collections4.CollectionUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;


public class Differ {

    public static String generate(String pathJson1, String pathJson2, String format) throws Exception {
        Map<String, Object> file1 = Parser.getMapFromJSONPath(pathJson1);
        Map<String, Object> file2 = Parser.getMapFromJSONPath(pathJson2);
        Set<String> keysJson1 = file1.keySet();
        Set<String> keysJson2 = file2.keySet();
        List<String> allKeys = (List<String>) CollectionUtils.union(keysJson1, keysJson2);
        List<String> commonKeys = (List<String>) CollectionUtils.intersection(keysJson1, keysJson2);
        List<String> uniqueKeysJson1 = (List<String>) CollectionUtils.subtract(keysJson1, keysJson2);
        List<String> uniqueKeysJson2 = (List<String>) CollectionUtils.subtract(keysJson2, keysJson1);
        StringBuilder diff = new StringBuilder();
        allKeys.sort(String::compareTo);
        List<DifferStatusData> changesLog = new ArrayList<>();
        allKeys.forEach(key -> {
            if (commonKeys.contains(key)) {
                if (Objects.equals(file1.get(key), file2.get(key))) {
                    changesLog.add(new DifferStatusData(DifferStatusData.UNCHANGED, key, file1.get(key)));
                } else {
                    changesLog.add(new DifferStatusData(DifferStatusData.CHANGED, key, file1.get(key), file2.get(key)));
                }
            }
            if (uniqueKeysJson1.contains(key)) {
                changesLog.add(new DifferStatusData(DifferStatusData.DELETED, key, file1.get(key)));
            }
            if (uniqueKeysJson2.contains(key)) {
                changesLog.add(new DifferStatusData(DifferStatusData.ADDED, key, file2.get(key)));
            }
        });
        return Formatter.formatOption(format, changesLog);
    }
}

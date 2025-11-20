package hexlet.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.Objects;

public class DifferCalculator {
    public static List<DifferStatusData> getListOfDifferences(Map<String, Object> data1, Map<String, Object> data2) {
        Set<String> keysFile1 = data1.keySet();
        Set<String> keysFile2 = data2.keySet();
        Set<String> allKeys = new TreeSet<>(keysFile1);
        allKeys.addAll(keysFile2);
        List<DifferStatusData> changesLog = new ArrayList<>();
        allKeys.forEach(key -> {
            if (data1.containsKey(key) && data2.containsKey(key)) {
                if (Objects.equals(data1.get(key), data2.get(key))) {
                    changesLog.add(new DifferStatusData(DifferStatusData.UNCHANGED, key, data1.get(key)));
                } else {
                    changesLog.add(new DifferStatusData(DifferStatusData.CHANGED, key, data1.get(key), data2.get(key)));
                }
            } else if (data1.containsKey(key)) {
                changesLog.add(new DifferStatusData(DifferStatusData.DELETED, key, data1.get(key)));
            } else if (data2.containsKey(key)) {
                changesLog.add(new DifferStatusData(DifferStatusData.ADDED, key, data2.get(key)));
            }
        });
        return changesLog;
    }
}

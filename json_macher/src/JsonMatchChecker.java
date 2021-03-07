import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;
import java.util.Set;

public class JsonMatchChecker {
    private ObjectMapper objectMapper;

    public JsonMatchChecker() {
        objectMapper = new ObjectMapper();
    }

    public boolean check(String mark, String data) throws JsonProcessingException {
        Map markMap = objectMapper.readValue(mark, Map.class);
        Map dataMap = objectMapper.readValue(data, Map.class);
        return check(markMap, dataMap, "");
    }

    private boolean check(Map<String, Object> mark, Map<String, Object> data, String fieldPath) {
        Set<String> keyData = data.keySet();
        boolean result = mark.keySet().stream().allMatch(key -> {
            boolean haveField = keyData.contains(key);
            if (!haveField) {
                System.out.println("Nie ma pola:" + String.format("%s%s", fieldPath, key));
                return Boolean.FALSE;
            }
            return checkElement(mark.get(key), data.get(key), String.format("%s%s->", fieldPath, key));
        });
        return result;
    }

    private boolean checkElement(Object a, Object b, String fieldPath) {
        Map mapA = getMap(a);
        Map mapB = getMap(b);
        boolean bothMap = (mapA != null && mapB != null);
        if (bothMap) {
            return check(mapA, mapB, fieldPath);
        }
        boolean equals = a.getClass().equals(b.getClass());
        if (!equals) {
            System.out.printf(" Nie te same klasy %s  %s\n", a.getClass().toString(), b.getClass().toString());
        }
        return equals;
    }

    private Map getMap(Object object) {
        try {
            return objectMapper.convertValue(object, Map.class);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}

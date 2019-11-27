package serializations.json;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapSerializer {

    public static String serialize(Map<String, Object> map) {
        JSONObject jsonedMap = new JSONObject();
        // для всех фильтруемых полей
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            jsonedMap.put(entry.getKey(), entry.getValue());
        }
        // возвращаем строковое представление
        return jsonedMap.toString();
    }

    public static Map<String, Object> desirialize(String serializedMap) {
        HashMap<String, Object> map = new HashMap<>();
        JSONObject jsonObject = new JSONObject(serializedMap);

        Iterator keys = jsonObject.keys();
        while (keys.hasNext()) {
            String key = (String) keys.next();
            map.put(key, jsonObject.get(key));
        }

        return map;
    }
}
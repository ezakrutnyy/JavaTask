package spring.skope;

import com.google.common.collect.Maps;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.time.LocalTime;
import java.util.Map;


public class PeriodicalScopeConfigurer implements Scope {

    Map<String, Pair<LocalTime, Object>> map = Maps.newHashMap();

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        if (map.containsKey(name)) {
            Pair<LocalTime, Object> pair = map.get(name);
            if (LocalTime.now().getSecond() - pair.getLeft().getSecond() > 5) {
                map.put(name, Pair.of(LocalTime.now(), objectFactory.getObject()));
            }
        } else {
            map.put(name, Pair.of(LocalTime.now(), objectFactory.getObject()));
        }
        return map.get(name).getRight();
    }

    @Override
    public Object remove(String s) {
        return null;
    }

    @Override
    public void registerDestructionCallback(String s, Runnable runnable) {

    }

    @Override
    public Object resolveContextualObject(String s) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }
}

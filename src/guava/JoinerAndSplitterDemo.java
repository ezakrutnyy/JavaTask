package guava;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.checkerframework.checker.signedness.SignednessUtil;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Евгений on 14.11.2018.
 */
public class JoinerAndSplitterDemo {
    public static void main(String[] args) {
        List<String> inputs = Lists.newArrayList("11", "14", "15", null,"55", "66","");
        String str = Joiner.on(";").skipNulls().join(inputs);
        System.out.println(str);
        List<String> outputs = Splitter.on(";").trimResults().omitEmptyStrings().splitToList(str);
        System.out.println(outputs);

        Map<String,String> mapsInput = Maps.newLinkedHashMap();
        mapsInput.put("Ivanov", "11");
        mapsInput.put("Petrov", "14");
        mapsInput.put("Sidorov", "15");
        mapsInput.put("Leonov", "55");
        mapsInput.put("Smirnov", "66");
        String mapString = Joiner.on("&").withKeyValueSeparator("=").join(mapsInput);
        System.out.println(mapString);

        Map<String,String> mapsOutput = Splitter.on("&").withKeyValueSeparator("=").split(mapString);
        System.out.println(mapsOutput);

    }
}

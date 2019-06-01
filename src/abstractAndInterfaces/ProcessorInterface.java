package abstractAndInterfaces;

import com.sun.corba.se.impl.orbutil.ObjectWriter;

import java.util.Arrays;
import java.util.logging.Filter;

/**
 * Created by Евгений on 03.05.2018.
 */
public class ProcessorInterface {

    final static String str = "Hello World! Today is Monday!";

    static void process(Processor p, Object obj) {
        System.out.println("Наименование класса: "+p.getName());
        System.out.println(p.process(obj));
    }

    public static void main(String[] args) {
        process(new LowerCaseProcess(), str);
        process(new UpperCaseProcess(), str);
        process(new SplitCaseProcess(), str);

        WaveForm form = new WaveForm();
        process(new FilterAdapter(new LowPass(1.0)), form);
        process(new FilterAdapter(new HighPass(2.0)), form);
        process(new FilterAdapter(new BandsPass(3.0,4.0)), form);
    }

}

interface Processor {
    String getName();
    Object process(Object obj);
}

abstract class StringProcessor implements  Processor {
    public String getName() {
        return getClass().getSimpleName();
    }
}

class UpperCaseProcess extends StringProcessor {
    @Override
    public Object process(Object obj) {
        return ((String) obj).toUpperCase();
    }
}

class LowerCaseProcess extends StringProcessor {
    @Override
    public Object process(Object obj) {
        return ((String) obj).toLowerCase();
    }
}

class SplitCaseProcess extends StringProcessor {
    @Override
    public Object process(Object obj) {
        return Arrays.toString(((String) obj).split(" "));
    }
}

class WaveForm {
    private static long counter;
    private long id = counter++;

    @Override
    public String toString() {
        return "WaveForm{" +
                "id=" + id +
                '}';
    }
}

class Filters {
    String getFilterName() {
        return getClass().getSimpleName();
    }

    WaveForm processingsss(WaveForm wf) {
        return wf;
    }
}

class LowPass extends  Filters {
    private  double cutoff;

    public LowPass(double cutoff) {
        this.cutoff = cutoff;
    }

    WaveForm processingsss(WaveForm input) {
        return input;
    }
}

class HighPass extends  Filters {
    private  double cutoff;

    public HighPass(double cutoff) {
        this.cutoff = cutoff;
    }

    WaveForm processingsss(WaveForm input) {
        return input;
    }
}


class BandsPass extends  Filters {
    private  double lowCutoff;
    private  double highCutoff;

    public BandsPass(double lowCutoff, double highCutoff) {
        this.lowCutoff = lowCutoff;
        this.highCutoff = highCutoff;
    }

    WaveForm processingsss(WaveForm input) {
        return input;
    }
}


class FilterAdapter implements Processor {

    private Filters filters;

    public FilterAdapter(Filters filters) {
        this.filters = filters;
    }

    @Override
    public String getName() {
        return filters.getFilterName();
    }

    @Override
    public Object process(Object obj) {
        return filters.processingsss((WaveForm) obj);
    }
}

package guava;

import com.google.common.base.Optional;

/**
 * Created by Евгений on 14.11.2018.
 */
public class OptionalDemo {
    public static void main(String[] args) {
        Optional<String> opt = Optional.absent();
        if (opt.isPresent()) {
            System.out.println(opt.get());
        }
        String f = opt.or("default");
        System.out.println(f);

    }
}
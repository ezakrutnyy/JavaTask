package abstractAndInterfaces.functional;

import streams.Employee;

import java.util.function.Function;

public class FunctionDemo {

    public static Function<Employee, String> funcTreeChars = (emp) -> emp.getCity().substring(0,3);

}

package streams;

public class DescriptionStream {
    /**
     *
     * Java Stream API предлагает два вида методов:
     * 1. Конвейерные — возвращают другой stream, то есть работают как builder,
     * 2. Терминальные — возвращают другой объект, такой как коллекция, примитивы, объекты, Optional и т.д.
     *
     ******************************************************************************************************************
     *  Краткое описание конвейерных методов работы со стримами:
     *
     * filter
     * Отфильтровывает записи, возвращает только записи, соответствующие условию
     * collection.stream().filter(«a1»::equals).count()
     *
     * skip
     * Позволяет пропустить N первых элементов
     * collection.stream().skip(collection.size() — 1).findFirst().orElse(«1»)
     *
     * distinct
     * Возвращает стрим без дубликатов (для метода equals)
     * collection.stream().distinct().collect(Collectors.toList())
     *
     * map
     * Преобразует каждый элемент стрима
     * collection.stream().map((s) -> s + "_1").collect(Collectors.toList())
     *
     * peek
     * Возвращает тот же стрим, но применяет функцию к каждому элементу стрима
     * collection.stream().map(String::toUpperCase).peek((e) -> System.out.print("," + e)).collect(Collectors.toList())
     *
     * limit
     * Позволяет ограничить выборку определенным количеством первых элементов
     * collection.stream().limit(2).collect(Collectors.toList())
     *
     * sorted
     * Позволяет сортировать значения либо в натуральном порядке, либо задавая Comparator
     * collection.stream().sorted().collect(Collectors.toList())
     *
     * mapToInt,
     * mapToDouble,
     * mapToLong
     * Аналог map, но возвращает числовой стрим (то есть стрим из числовых примитивов)
     * collection.stream().mapToInt((s) -> Integer.parseInt(s)).toArray()
     *
     * flatMap,
     * flatMapToInt,
     * flatMapToDouble,
     * flatMapToLong
     * Похоже на map, но может создавать из одного элемента несколько
     * collection.stream().flatMap((p) -> Arrays.asList(p.split(",")).stream()).toArray(String[]::new)
     *
     *
     *******************************************************************************************************************
     *  Краткое описание терминальных методов работы со стримами
     *
     * findFirst
     * Возвращает первый элемент из стрима (возвращает Optional)
     * collection.stream().findFirst().orElse(«1»)
     *
     *
     * findAny
     * Возвращает любой подходящий элемент из стрима (возвращает Optional)
     * collection.stream().findAny().orElse(«1»)
     *
     *
     * collect	Представление результатов в виде коллекций и других структур данных
     * collection.stream().filter((s) -> s.contains(«1»)).collect(Collectors.toList())
     *
     * count
     * Возвращает количество элементов в стриме
     * collection.stream().filter(«a1»::equals).count()
     *
     * anyMatch
     * Возвращает true, если условие выполняется хотя бы для одного элемента
     * collection.stream().anyMatch(«a1»::equals)
     *
     * noneMatch
     * Возвращает true, если условие не выполняется ни для одного элемента
     * collection.stream().noneMatch(«a8»::equals)
     *
     * allMatch
     * Возвращает true, если условие выполняется для всех элементов
     * collection.stream().allMatch((s) -> s.contains(«1»))
     *
     * min
     * Возвращает минимальный элемент, в качестве условия использует компаратор
     * collection.stream().min(String::compareTo).get()
     *
     * max
     * Возвращает максимальный элемент, в качестве условия использует компаратор
     * collection.stream().max(String::compareTo).get()
     *
     * forEach
     * Применяет функцию к каждому объекту стрима, порядок при параллельном выполнении не гарантируется
     * set.stream().forEach((p) -> p.append("_1"));
     *
     * forEachOrdered
     * Применяет функцию к каждому объекту стрима, сохранение порядка элементов гарантирует
     * list.stream().forEachOrdered((p) -> p.append("_new"));
     *
     * toArray
     * Возвращает массив значений стрима
     * collection.stream().map(String::toUpperCase).toArray(String[]::new);
     *
     * reduce
     * Позволяет выполнять агрегатные функции на всей коллекцией и возвращать один результат
     * collection.stream().reduce((s1, s2) -> s1 + s2).orElse(0)
     *
     *******************************************************************************************************************
     *
     * Краткое описание дополнительных методов у числовых стримов
     *
     * sumRecursive
     * Возвращает сумму всех чисел
     * collection.stream().mapToInt((s) -> Integer.parseInt(s)).sumRecursive()
     *
     * average
     * Возвращает среднее арифметическое всех чисел
     * collection.stream().mapToInt((s) -> Integer.parseInt(s)).average()
     *
     * mapToObj
     * Преобразует числовой стрим обратно в объектный
     * intStream.mapToObj((id) -> new Key(id)).toArray()
     *
     *******************************************************************************************************************
     *
     * Несколько других полезных методов стримов
     * isParallel
     * Узнать является ли стрим параллельным
     *
     *
     * parallel
     * Вернуть параллельный стрим, если стрим уже параллельный, то может вернуть самого себя
     *
     * sequential
     * Вернуть последовательный стрим, если стрим уже последовательный, то может вернуть самого себя
     *
     *
     * ******************************************************************************************************************
     *
     * Давайте рассмотрим статические методы из Collectors:
     * Метод	Описание
     *
     * toList, toCollection, toSet	                                представляют стрим в виде списка, коллекции или множества
     * toConcurrentMap, toMap	                                    позволяют преобразовать стрим в map
     * averagingInt, averagingDouble, averagingLong	                возвращают среднее значение
     * summingInt, summingDouble, summingLong	                    возвращает сумму
     * summarizingInt, summarizingDouble, summarizingLong	        возвращают SummaryStatistics с разными агрегатными значениями
     * partitioningBy	                                            разделяет коллекцию на две части по соответствию условию и
     *                                                              возвращает их как Map<Boolean, List>
     * groupingBy	                                                разделяет коллекцию на несколько частей и возвращает Map<N, List<T>>
     * mapping	                                                    дополнительные преобразования значений для сложных Collector'ов
     *
     * * */
}

package carry.分布式专题.第一讲分布式的发展与演进.案例.Demo;

import java.util.*;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {
        List<Record> records = Arrays.asList(new Record("L1", "Li", "S1"), //
                new Record("L1", "Wang", "S2"),//
                new Record("L1", "Wang", "S3"),//
                new Record("L2", "Li", "S4"),//
                new Record("L2", "Li", "S5"),//
                new Record("L2", "Wang", "S6"),//
                new Record("L3", "Wang", "S7"),//
                new Record("L3", "Wang", "S8"));
        Map<String, Long> collect = records.stream().collect(Collectors.groupingBy(Record::getLevel, Collectors.counting()));
        //就不判空了
        //第一题1
        System.out.println("------第一题-------");
        for (String s : collect.keySet()) {
            System.out.println(s + "=" + collect.get(s));
        }

        System.out.println("------第二题-------");
        //2过滤
        List<String> stus = records.stream().filter(item -> "Li".equals(item.getTeacherName())).map(item -> item.getStuName()).collect(Collectors.toList());
        stus.stream().forEach(System.out::println);

        //第三题
        System.out.println("------第三题-------");
        Map<String, Map<String, List<Record>>> recordGroups = records.stream().collect(Collectors.groupingBy(Record::getTeacherName, Collectors.groupingBy(Record::getLevel)));
        for (String s : recordGroups.keySet()) {
            Map<String, List<Record>> stringListMap = recordGroups.get(s);
            List<String> levels = new ArrayList<>();
            for (String s1 : stringListMap.keySet()) {
                levels.add(s1);
            }
            System.out.println(s + "=" + levels);
        }

    }
}

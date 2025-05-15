package enums;

import streams.Transaction;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


enum FileType {
    PDF("asdfasdfasdfsdf"),
    HTML("html"),
    XLSX("xlsx"),
    XLS("xls"),
    DOC("doc"),
    HTML_WITH_API("html", "html_api"),
    HTML_WITH_API_KEY("html", "html_api_key"),
    CSV("csv"),
    JSON("json"),
    SQL("sql");

    private String extension;
    private String folderName;

    private FileType(String extension) {
        this.extension = extension;
        this.folderName = extension;
    }

    private FileType(String extension, String folderName) {
        this.extension = extension;
        this.folderName = folderName;
    }

    public String folderName() {
        return this.folderName;
    }

    public String extension() {
        return this.extension;
    }
}


public class EnumTester{
    public static void main(String[] args) {


//        List<Integer> integers = new LinkedList<>(Arrays.asList(1,2,3,4,5,6,7,7));
//        Map<Integer, Integer> collect = integers.stream().collect(Collectors.groupingBy(Function.identity())).entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, item -> item.getValue().stream().mapToInt(Integer::intValue).sum(), Integer::sum));

//        System.out.println("collect = " + collect);


    }

}

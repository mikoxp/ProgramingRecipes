import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Paths: ");
        List<String> test = FileInDirectory.getFilePath("test//");
        for(String s:test){
            System.out.println(s);
        }
    }
}

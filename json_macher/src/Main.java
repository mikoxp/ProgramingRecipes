import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws JsonProcessingException {

        ObjectMapper objectMapper=new ObjectMapper();

        Map<String,Object> x=new HashMap<>();
        Map<String,Object> xy=new HashMap<>();
        Map<String,Object> z=new HashMap<>();
        Map<String,Object> zy=new HashMap<>();
        xy.put("z","z");
        zy.put("z","zz");
        x.put("a",1);
        x.put("b","b");
        x.put("c",xy);
        x.put("l",new ArrayList<>());
        //---------------------
        z.put("a",12);
        z.put("b","b1");
        z.put("c",zy);
        z.put("l",new LinkedList());
        String sx = objectMapper.writeValueAsString(x);
        String sz = objectMapper.writeValueAsString(z);
        Map mapx =  objectMapper.readValue(sx, Map.class);
        Map mapz =  objectMapper.readValue(sz, Map.class);
        System.out.println(sx);
        System.out.println(sz);
        System.out.println("---------------------");
        System.out.println(mapx);
        System.out.println(mapz);

        JsonMatchChecker checker=new JsonMatchChecker();
        boolean check = checker.check(sx, sz);
        System.out.println("wynik  " +check);
    }
}

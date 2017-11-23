import objects.example.Tester;
import objects.example.TesterA;
import objects.example.TesterB;
import sort.tools.TesterBSorter;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static java.util.Collections.*;

public class Main {

    public static void main(String[] args) {


        List<Tester> list=new LinkedList<>();
        list.add(new Tester("a",1));
        list.add(new Tester("f",11));
        list.add(new Tester("b",5));
        list.add(new Tester("e",3));
        list.add(new Tester(null,3));
        list.add(new Tester("e",0));
        //-------
        List<TesterA> aList=new LinkedList<>();
        List<TesterB> bList=new LinkedList<>();
        for(Tester t:list){
            aList.add(new TesterA(t));
            bList.add(new TesterB(t));
        }
        System.out.println("ORGINAL DATA:");
        System.out.println(list);
        System.out.println("------");
        System.out.println("Inside sort:");
        Collections.sort(aList);
        System.out.println(aList);
        System.out.println("------");
        System.out.println("External sort:");
        Collections.sort(bList,new TesterBSorter(true));
        System.out.println(bList);
        Collections.sort(bList,new TesterBSorter(false));
        System.out.println(bList);
        System.out.println("------");
    }
}

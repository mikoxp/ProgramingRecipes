package org.moles;

import org.moles.checker.impl.MyObjectChecker;

public class Main {
    public static void main(String[] args) {
        Test test=new Test("a",1,1,true,false,null);
        Test test2=new Test("a",1,1,true,false,null);
        test.setF(test2);
        MyObjectChecker checker=new MyObjectChecker();
        runCheck(checker,test);
        test2.setB(1000);
        runCheck(checker,test);
    }

    private static void runCheck(MyObjectChecker checker,Test test){
        boolean check = checker.checkFields(test);
        System.out.println(test.toString()+"->"+check);
    }
}
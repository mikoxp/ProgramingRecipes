package org.moles.checker.impl;

import org.moles.checker.ObjectChecker;
import org.moles.checker.Validator;

public class MyObjectChecker extends ObjectChecker {

    @Override
    protected void initValidators() {
        addValidator(getIntValidator());
    }

    private Validator getIntValidator(){
        return (key, value) -> {
            if (value instanceof Integer i){
                if(i<100){
                    return true;
                }
                System.out.println(String.format("key %s value %d >100",key,i));
                return false;
            }
            return true;
        };
    }

}

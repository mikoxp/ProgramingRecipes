package org.moles.checker;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.*;


public abstract class ObjectChecker {

    private List<Validator> validators;

    private final ObjectMapper mapper;

    public ObjectChecker() {
        mapper=new ObjectMapper();
        validators=new ArrayList<>();
        initValidators();
    }

    public boolean checkFields(Object object) {
        Map map = mapper.convertValue(object, Map.class);
        return map.keySet().stream().allMatch(key -> {
            Object o = map.get(key);
            if (isMap(o)) {
                if (!checkFields(o)) {
                    return false;
                }
            }
            return checkField(""+key,o);
        });
    }

    private boolean checkField(String key,Object value){
        return validators.stream().allMatch(el->el.valid(key,value));
    }

    private boolean isMap(Object o){
        if(o instanceof Map<?,?>){
            return true;
        }
        return false;
    }

    protected abstract void initValidators();

    protected void addValidator(Validator validator){
        validators.add(validator);
    }
}

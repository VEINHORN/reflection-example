package com.veinhorn.reflection;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class JsonConverter {
    public String convert(Object json) throws IllegalAccessException {
        StringBuilder builder = new StringBuilder();
        builder.append("{\n");

        List<String> jsonFields = new ArrayList<>();

        Field[] fields = json.getClass().getFields();
        for (Field field : fields) {
            String jsonField = toJsonField(json, field);
            if (jsonField != null) {
                jsonFields.add(jsonField);
            }
        }

        StringJoiner joiner = new StringJoiner(",\n");
        jsonFields.forEach(joiner::add);

        builder.append(joiner.toString());
        builder.append("\n}");
        return builder.toString();
    }

    private String toJsonField(Object json, Field field) throws IllegalAccessException {

        if (field.getType().equals(Integer.class)) {
            return String.format("\t\"%s\": %d", field.getName(), (Integer) field.get(json));
        } else if (field.getType().equals(String.class)) {
            return String.format("\t\"%s\": \"%s\"", field.getName(), (String) field.get(json));
        } else { // any other type
            Object obj = field.get(json);
            if (obj != null) {
                return "\"" + field.getName() + "\": " + convert(obj);
            }
            return null;
        }
    }

}

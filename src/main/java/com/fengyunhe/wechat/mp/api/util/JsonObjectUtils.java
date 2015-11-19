package com.fengyunhe.wechat.mp.api.util;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ObjectNode;
import org.codehaus.jackson.type.TypeReference;

import java.io.IOException;
import java.util.List;

public class JsonObjectUtils {
    public static ObjectMapper m = new ObjectMapper();

    static {
        // 此配置的作用为当使用此工具将json中的属性还原到bean时，如果有bean中没有的属性，是否报错
        m.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    /**
     * json 转换成 bean
     *
     * @param <T>
     * @param json
     * @param clazz
     * @return
     */
    public static <T> T jsonToBean(String json, Class<T> clazz) {
        if (json == null || clazz == null) {
            return null;
        }
        try {
            return m.readValue(json, clazz);
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> T jsonNodeToBean(JsonNode jsonNode, Class<T> clazz) {
        if (jsonNode == null || clazz == null) {
            return null;
        }

        try {
            return m.readValue(jsonNode, clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * bean 转换成 json
     *
     * @param bean
     * @return
     */
    public static String beanToJson(Object bean) {

        if (bean == null) {
            return null;
        }
        try {
            return m.writeValueAsString(bean);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static JsonNode stringToJsonNode(String jsonString) {
        if (jsonString == null) {
            return null;
        }
        try {
            return m.readTree(jsonString);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T, A extends List<T>> A jsonToList(String jsonString, TypeReference<List<T>> clazz) throws JsonParseException, JsonMappingException, IOException {
        return (A) m.readValue(jsonString, clazz);
    }

    public static JsonNode createNode(String[] keys, Object[] values) {

        if (keys != null && values != null && keys.length == values.length) {

            ObjectNode objectNode = m.createObjectNode();


            for (int i = 0; i < keys.length; i++) {
                String k = keys[i];
                objectNode.putPOJO(k, values[i]);
            }


            return objectNode;
        }


        throw new RuntimeException("key 和 value 的数量要相同");


    }

    public static String createJson(String[] keys, Object[] values) {
        return createNode(keys, values).toString();
    }

}

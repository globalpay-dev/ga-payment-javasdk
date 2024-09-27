
package com.lianpay.globalpay.utils;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.util.List;

public class JacksonUtils {

	private static final ObjectMapper OBJECT_MAPPER = createObjectMapper();
	
	private static ObjectMapper createObjectMapper(){
		ObjectMapper mapper = new ObjectMapper();
		//在反序列化时忽略在 json 中存在但 Java 对象不存在的属性 
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false); 
		//在序列化时日期格式默认为 yyyy-MM-dd'T'HH:mm:ss.SSSZ 
		mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,false);
		//在序列化时忽略值为 null 的属性 
		mapper.setSerializationInclusion(Include.NON_NULL);
		//防止BigDecimal精度丢失
		mapper.enable(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS);
		//忽略值为默认值的属性
		//mapper.setDefaultPropertyInclusion(Include.NON_DEFAULT);
		return mapper;
	}
	
	public static String toJsonString(Object obj){
		if(obj == null){
			return ISOUtil.EMPTY_STRING;
		}
		try {
			return OBJECT_MAPPER.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static <T> T parseObject(String jsonString, Class<T> c){
		if(jsonString == null || "".equals(jsonString.trim())){
			return null;
		}
		try {
			return OBJECT_MAPPER.readValue(jsonString, c);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static <T> T parseObject(String jsonString, TypeReference<T> tr) {
		if(jsonString == null || "".equals(jsonString.trim())){
			return null;
		}
		try {
			return OBJECT_MAPPER.readValue(jsonString, tr);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static <T> List<T> parseArray(String jsonString, Class<T> c) {
		if(jsonString == null || "".equals(jsonString.trim())){
			return null;
		}
		try {
			return OBJECT_MAPPER.readValue(jsonString, new TypeReference<List<T>>() {});
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static <T> T convertValue(Object obj, Class<T> c) {
		return OBJECT_MAPPER.convertValue(obj, c);
	}

	public static <T> T convertValue(Object obj, TypeReference<?> toValueTypeRef) {
		return OBJECT_MAPPER.convertValue(obj, toValueTypeRef);
	}
}
  

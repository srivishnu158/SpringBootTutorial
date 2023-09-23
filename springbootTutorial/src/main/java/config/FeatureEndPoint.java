package config;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Endpoint(id="featur")
public class FeatureEndPoint {
	private Map<String,Feature>map = new ConcurrentHashMap<>();
	
	
	 FeatureEndPoint(){
		map.put("Dept", new Feature(true));
		map.put("User", new Feature(false));
	}
	 @ReadOperation
	 private Map<String,Feature>features(){
		 return map;
	 }
	 @ReadOperation
	private Feature getFeature(@Selector String feature){
		return map.get(feature);
	}
	
	
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	static class Feature{
		boolean isenabled;
	}
}

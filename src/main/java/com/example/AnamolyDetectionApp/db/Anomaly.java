package com.example.AnamolyDetectionApp.db;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.HashMap;
import java.util.Map;

@Document(collection="anomaly")
public class Anomaly {
	
		@Id
		public String id;
		public HashMap<String, Integer> anomalyMap;
		
		public Anomaly() {}
		
		/*public Anomaly(HashMap<String,Integer> anomaly) {
			this.anomaly=anomaly;
			
		}*/
		public Anomaly(String id, Map<String, Integer> anamoly) {
			// TODO Auto-generated constructor stub
			this.id=id;
			this.anomalyMap=(HashMap<String, Integer>) anamoly;
		}

		public String getId() {
			return id;
		}
		public HashMap<String,Integer> getanomaly(){
			return anomalyMap;
		}
		
		public void setAnomaly(HashMap<String,Integer> anomaly) {
			this.anomalyMap=anomaly;
		}

}

package sample.service.impl;

import org.osgi.service.component.annotations.Component;

import sample.service.SampleService;

@Component (
		immediate = true,
		name = "SampleService",
		property = {
				"service.exported.interfaces=sample.service.SampleService", 
				"service.exported.configs=org.apache.cxf.rs", 
				"org.apache.cxf.rs.address=/sample"
		}
		)
public class SampleServiceImpl implements SampleService {
	
	public String getFoo(String id) {
		return id;
	}

	
}

package com.springBootAssighment2.service2.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springBootAssighment2.service2.beans.Person;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MicroService2 {
    
	final static String uri = "http://localhost:8080/persons/get-all-persons";

	public List<Person> getAllPersons()
	{	 
	    RestTemplate restTemplate = new RestTemplate();	 
	    String jsonStrPerson = restTemplate.getForObject(uri, String.class);
	    return transJArrToPersonArr(jsonStrPerson);
	}
	
	public List<Person> getPersonsAK() {
		List<Person> retPersons = new ArrayList<Person>();
		List<Person> allPersons = getAllPersons();
		
		for(Person person : allPersons) {
			if(isFrstChrAK(person) ) {					
				retPersons.add(person);			
			}	    			    
		}				
		return retPersons;
	}
	
	public List<Person> getAllIsrAbAvgWght() {
		List<Person> retPersons = new ArrayList<Person>();
		List<Person> allPersons = getAllPersons();
		double avgWeight = getAvgWeight(allPersons);
		
		for(Person person : allPersons) {
			if(person.getWeight() > avgWeight && isFromIsrael(person)) {					
				retPersons.add(person);			
			}		    
		}
		return retPersons;
	}
	

	private List<Person> transJArrToPersonArr(String allPersons) {
		List<Person> persons = new ArrayList<Person>();
		JSONArray personsJA = new JSONArray(allPersons);
		ObjectMapper objectMapper = new ObjectMapper();
		for(Object personJ : personsJA) {
		    try {
		    	Person person = objectMapper.readValue(personJ.toString(), Person.class);
				persons.add(person);								
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return persons;
	}
	
	private boolean isFromIsrael(Person person) {
		return (person.getAddress().getState().equalsIgnoreCase("israel"))?
				true : false;
	}

	private float getAvgWeight(List<Person> persons) {
		float totalWeigh = 0;
		for(Person person : persons) {
			totalWeigh += person.getWeight();
		}
		return totalWeigh/persons.size();
	}

	private boolean isFrstChrAK(Person person) {
		return ('k' == Character.toLowerCase(person.getName().charAt(0)) || 
				'a' == Character.toLowerCase(person.getName().charAt(0)))? 
				true : false;
	}
}

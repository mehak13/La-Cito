package com.mehak.model;

import java.util.HashMap;
import java.util.Map;


public class Patient {

	public String name;
	public String phone;
	public String timings;
	public String _id;
	
	public Patient() {
	}

	public Patient(String name, String phone,String timings) {
		this.name = name;
		this.phone = phone;
		this.timings= timings;
	}
	
	public String getName() {
		return name;
	}
	
	
	@Override
	public String toString() {
		return "Patient [name=" + name + ", phone=" + phone + ",timings=" + timings + ",_id=" + _id + "]";
	}
	
	public Map<String, Object> toMap() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", name);
		map.put("phone",phone);
		map.put("timings",timings);
		return map;
}
}
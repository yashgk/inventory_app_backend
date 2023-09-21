package com.example.lottomgmt.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/report")
public class ReportController {

	@PostMapping("/getdatereport")
	public ResponseEntity<Map<String, Object>> getDateReport(@RequestBody String date) {
		Map<String, Object> response = new HashMap<>();
		try {
			// logic
			response.put("message", "Registered Successfully!");
			return ResponseEntity.status(HttpStatus.CREATED).body(response);
		} catch (Exception e) {
			System.err.println(e.toString());
			response.put("error", e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
	}

	@PostMapping("/getweeklyreport")
	public ResponseEntity<Map<String, Object>> getWeeklyReport(@RequestBody String date) {
		Map<String, Object> response = new HashMap<>();
		try {
			// logic
			response.put("message", "Registered Successfully!");
			return ResponseEntity.status(HttpStatus.CREATED).body(response);
		} catch (Exception e) {
			System.err.println(e.toString());
			response.put("error", e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
	}

	@PostMapping("/getmonthlyreport")
	public ResponseEntity<Map<String, Object>> getMonthlyReport(@RequestBody String date) {
		Map<String, Object> response = new HashMap<>();
		try {
			// logic
			response.put("message", "Registered Successfully!");
			return ResponseEntity.status(HttpStatus.CREATED).body(response);
		} catch (Exception e) {
			System.err.println(e.toString());
			response.put("error", e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
	}
}

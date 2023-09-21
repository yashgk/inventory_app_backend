package com.example.lottomgmt.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lottomgmt.entity.Entry;
import com.example.lottomgmt.entity.View;
import com.example.lottomgmt.service.EntryService;
import com.fasterxml.jackson.annotation.JsonView;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/entry")
public class EntryController {

	@Autowired
	private EntryService entryService;

	@PostMapping("/add")
	public ResponseEntity<Map<String, Object>> addEntry(@RequestBody Map<String,List<Entry>> entries) {
		Map<String, Object> response = new HashMap<>();
		try {
			entryService.createEntry(entries.get("entries"));
			response.put("message", "Entry Created Successfully!");
			return ResponseEntity.status(HttpStatus.CREATED).body(response);
		} catch (Exception e) {
			System.err.println(e.toString());
			response.put("error", e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
	}

	@GetMapping("/get")
	@JsonView(View.class)
	public ResponseEntity<Map<String, Object>> getEntry(@Param("userid") Long userid, @Param("date") String date) {
		Map<String, Object> response = new HashMap<>();
		try {
			response.put("data", entryService.getEntries(date, userid));
			response.put("message", "Successful!");
			return ResponseEntity.status(HttpStatus.OK).body(response);
		} catch (Exception e) {
			System.err.println(e.toString());
			response.put("error", e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
	}
}

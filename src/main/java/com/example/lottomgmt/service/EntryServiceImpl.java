package com.example.lottomgmt.service;

import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lottomgmt.entity.Entry;
import com.example.lottomgmt.exception.ResourceNotFoundException;
import com.example.lottomgmt.repository.EntryRepository;

@Service
public class EntryServiceImpl implements EntryService {

	@Autowired
	private EntryRepository entryRepository;

	@Autowired
	private HttpSession session;

	@Override
	public void createEntry(List<Entry> entries) {
		for (int i = 0; i < entries.size(); i++) {
			entryRepository.save(entries.get(i));
		}
	}

	@Override
	public List<Entry> getEntries(String date, String toDate , String fromDate) throws Exception {
		List<Entry> entries = new ArrayList<Entry>();

		Integer userId =(Integer) session.getAttribute("user_id");
		if(date.isEmpty() || date.equals("")){
			entries = entryRepository.getEntryDataByDates(fromDate, toDate);
		}else{
			entries = entryRepository.findByDateAndUser_Id(date, userId);
		}

		if (!entries.isEmpty()) {
			return entries;
		} else {
			throw new ResourceNotFoundException("Entries not Found!");
		}
	}


}

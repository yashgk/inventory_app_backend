package com.example.lottomgmt.service;

import java.util.List;

import com.example.lottomgmt.entity.Entry;

public interface EntryService {
	void createEntry(List<Entry> entries);

	List<Entry> getEntries(String date, Long userid) throws Exception;
}

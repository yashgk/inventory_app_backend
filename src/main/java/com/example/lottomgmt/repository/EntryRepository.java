package com.example.lottomgmt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lottomgmt.entity.Entry;
import org.springframework.data.jpa.repository.Query;

public interface EntryRepository extends JpaRepository<Entry, Long>{
	List<Entry> findByDateAndUser_Id(String date,Integer userid);

	@Query("From Entry Where date between ?1 and ?2")
	List<Entry> getEntryDataByDates(String fromDate , String toDate);
}

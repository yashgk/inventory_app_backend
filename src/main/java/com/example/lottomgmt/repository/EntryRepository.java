package com.example.lottomgmt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lottomgmt.entity.Entry;

public interface EntryRepository extends JpaRepository<Entry, Long>{
	List<Entry> findByDateAndUser_Id(String date,Long userid);
}

package org.arc.service;

import java.util.List;

import org.arc.entity.Record;

/**
 * @author Mrruan  E-mail:qkmc@outlook.com
 * @version ����ʱ�䣺2017��10��30�� ����8:19:00
 */
public interface RecordService {
	
	List<Record> getAllRecords();
	
	boolean saveOneRecord(Record record);
	
	boolean updateOneRecord(Record record);
	
	boolean deleteOneRecordById(int recordId);
}

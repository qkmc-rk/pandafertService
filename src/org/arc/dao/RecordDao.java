package org.arc.dao;

import java.util.List;

import org.arc.entity.Record;

/**
 * @author Mrruan  E-mail:qkmc@outlook.com
 * @version ����ʱ�䣺2017��10��28�� ����5:34:03
 */
public interface RecordDao {
	//��ɾ�Ĳ�
	int addOneRecord(Record record);
	
	int deleteOneRecordByRecordId(int recordId);
	
	int updateOneRecord(Record record);
	
	Record queryOneRecordByRecordId(int recordId);
	
	List<Record> queryAll();
}
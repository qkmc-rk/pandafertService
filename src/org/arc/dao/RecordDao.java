package org.arc.dao;

import java.util.List;

import org.arc.entity.Record;

/**
 * @author Mrruan  E-mail:qkmc@outlook.com
 * @version 创建时间：2017年10月28日 下午5:34:03
 */
public interface RecordDao {
	//增删改查
	int addOneRecord(Record record);
	
	int deleteOneRecordByRecordId(int recordId);
	
	int updateOneRecord(Record record);
	
	Record queryOneRecordByRecordId(int recordId);
	
	List<Record> queryAll();
}
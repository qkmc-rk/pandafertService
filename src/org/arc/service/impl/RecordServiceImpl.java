package org.arc.service.impl;

import java.util.List;

import org.arc.dao.RecordDao;
import org.arc.dao.impl.RecordDaoImpl;
import org.arc.entity.Record;
import org.arc.service.RecordService;

/**
 * @author Mrruan  E-mail:qkmc@outlook.com
 * @version 创建时间：2017年10月30日 下午8:20:22
 */
public class RecordServiceImpl implements RecordService{

	RecordDao rd = new RecordDaoImpl();
	@Override
	public List<Record> getAllRecords() {
		List<Record> records = rd.queryAll();
		return records;
	}

	@Override
	public boolean saveOneRecord(Record record) {
		int row = rd.addOneRecord(record);
		if(row < 1)
			return false;
		return true;
	}

	@Override
	public boolean updateOneRecord(Record record) {
		if(rd.updateOneRecord(record) < 1)
			return false;
		return true;
	}

	@Override
	public boolean deleteOneRecordById(int recordId) {
		if(rd.deleteOneRecordByRecordId(recordId) < 1)
			return false;
		return true;
	}

}

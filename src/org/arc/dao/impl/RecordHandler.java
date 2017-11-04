package org.arc.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.ResultSetHandler;
import org.arc.entity.Record;

/**
 * @author Mrruan  E-mail:qkmc@outlook.com
 * @version 创建时间：2017年10月29日 下午12:58:20
 */
public class RecordHandler implements ResultSetHandler<List<Record>> {

	@Override
	public List<Record> handle(ResultSet rs) throws SQLException {
		List<Record> recordList= new ArrayList<>();
		Record record;
		while(rs.next()){
			record = new Record();
			record.setRecordId(rs.getInt(1));
			record.setFinishTime(rs.getDate(2));
			record.setRecordNumber(rs.getInt(3));
			record.setResult(rs.getInt(4));
			record.setFertA(rs.getInt(5));
			record.setFertB(rs.getInt(6));
			record.setFertC(rs.getInt(7));
			recordList.add(record);
			record = null;
		}
		return recordList;
	}

}

package org.arc.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.arc.dao.RecordDao;
import org.arc.entity.Record;
import org.arc.util.JdbcUtilC3p0;

/**
 * @author Mrruan  E-mail:qkmc@outlook.com
 * @version 创建时间：2017年10月29日 下午12:57:14
 */
public class RecordDaoImpl implements RecordDao {

	@Override
	public int addOneRecord(Record record) {
		//创建qr对象
		QueryRunner qr = new QueryRunner(JdbcUtilC3p0.getDataSource());
		//准备sql
		String sql = "insert into t_record(finish_time,record_number,result,fert_a,fert_b,fert_c)"
				+ "values(?,?,?,?,?,?)";
		try {
			int update = qr.update(sql, record.getFinishTime(), record.getRecordNumber(), record.getResult(), record.getFertA()
					, record.getFertB(), record.getFertC());
			return update;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteOneRecordByRecordId(int recordId) {
		QueryRunner qr = new QueryRunner(JdbcUtilC3p0.getDataSource());
		String sql = "delete from t_record where record_id = ?";
		try {
			int update = qr.update(sql, recordId);
			return update;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateOneRecord(Record record) {
		QueryRunner qr = new QueryRunner(JdbcUtilC3p0.getDataSource());
		String sql = "update t_record set record_number=?,result=?,fert_a=?,fert_b=?"
				+ ",fert_c=? where record_id=?";
		try {
			int update = qr.update(sql, record.getRecordNumber(), record.getResult(), record.getFertA()
				, record.getFertB(), record.getFertC(), record.getRecordId());
			return update;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Record queryOneRecordByRecordId(int recordId) {
		QueryRunner qr = new QueryRunner(JdbcUtilC3p0.getDataSource());
		String sql = "select * from t_record where record_id = ?";
		try {
			List<Record> recordlist = qr.query(sql, new RecordHandler(),recordId);
			Record record = recordlist.get(0);
			return record;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Record> queryAll() {
		QueryRunner qr = new QueryRunner(JdbcUtilC3p0.getDataSource());
		String sql = "select * from t_record";
		try {
			List<Record> recordlist = qr.query(sql, new RecordHandler());
			return recordlist;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}

package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojo.Fee;
import util.DBUtil;

public class FeeDao {

	public List<Fee> getAll() {
		String sql = "SELECT * FROM fee";
		List<Fee> fees = new ArrayList<Fee>();
		DBUtil.executeQuery(sql,  rs -> {
			try {
				while (rs.next()) {
					Fee fee = new Fee();
					fee.setFeeId(rs.getInt(1));
					fee.setFeeName(rs.getString(2));
					fee.setBaseTime(rs.getInt(3));
					fee.setBaseFee(rs.getDouble(4));
					fee.setUnitFee(rs.getString(5));
					fee.setCreateTime(rs.getDate(6));
					fee.setStartTime(rs.getDate(7));
					fee.setState(rs.getString(8));
					fees.add(fee);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		});
		return fees;
	}

	// 封装一个方法用于添加资费信息
	public int addFee(Fee fee) {
		String sql = "insert into fee(fee_name,base_time," + "base_fee,unit_fee,create_time,start_time,state,remark)"
				+ " " + "values(?,?,?,?,now(),now(),?,?)";
		return DBUtil.executeUpdate(sql, fee.getFeeName(), fee.getBaseTime(), fee.getBaseFee(), fee.getUnitFee(),
				fee.getState(), fee.getRemark());
	}

	public void deleteFee(int id) {
		String sql = "DELETE FROM fee where fee_id = ?";
		DBUtil.executeUpdate(sql, id);
	}

	public boolean updateFeeById(Fee fee) {
		String sql = "update fee SET fee_name = ?," + " base_time = ?,base_fee = ?,unit_fee = ?"
				+ ",state = ?,remark = ? WHERE fee_id = ?";
		return DBUtil.executeUpdate(sql, fee.getFeeName(), fee.getBaseTime(), fee.getBaseFee(), fee.getUnitFee(),
				fee.getState(), fee.getRemark(), fee.getFeeId()) > 0;

	}
	public static void main(String[] args) {
		FeeDao fee = new FeeDao();
		System.out.println(fee.getAll());
	}
}

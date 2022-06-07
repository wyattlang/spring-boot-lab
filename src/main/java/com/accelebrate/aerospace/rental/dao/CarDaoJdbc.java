package com.accelebrate.aerospace.rental.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component 
@Profile("prod")
public class CarDaoJdbc implements CarService {
	
	@Autowired private DataSource datasource;
	private final String sql = "SELECT CARID , RENTALCAR_LOCATION, CATEGORY, COST , MAKE, MODEL FROM RentalCar ";

	@SuppressWarnings("deprecation")
	@Override
	public Collection<RentalCar> getCarsPerLocationAndPrice(String location, double price) {
	 	return new JdbcTemplate(datasource).query(sql + "where pickUp = ? and dailyRate < ?",
	 			new Object[]{location, price}, 
	 			new CarRowMapper<RentalCar>());
	}

	@Override
	public Collection<RentalCar> getAll() {
	 	return new JdbcTemplate(datasource).query(sql, new CarRowMapper<RentalCar>());
	}

	@SuppressWarnings("deprecation")
	@Override
	public RentalCar getByID(long id) {
	 	return new JdbcTemplate(datasource).queryForObject(sql + "where CARID = ?", new Object[]{id}, new CarRowMapper<RentalCar>());
	}
	
	private static class CarRowMapper<T> implements RowMapper<RentalCar> {

		@Override
		public RentalCar mapRow(ResultSet rs, int row) throws SQLException {
			RentalCar car = new RentalCar();
			car.setId(rs.getInt("CARID"));
			car.setCategory(rs.getString("CATEGORY"));
			car.setLocation(rs.getString("RENTALCAR_LOCATION"));
			car.setDailyRate(rs.getDouble("COST"));
			car.setMake(rs.getString("MAKE"));
			car.setModel(rs.getString("MODEL"));
	 		return car;
		}
		
	}

}

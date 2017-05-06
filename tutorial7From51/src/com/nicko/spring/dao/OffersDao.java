package com.nicko.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.nicko.spring.model.Offer;

@Component
public class OffersDao {
	// private JdbcTemplate jdbc; //-->getter dan setter menyesuaikan
	private NamedParameterJdbcTemplate jdbc;

	public OffersDao() 
	{
		System.out.println("Successfully loaded XML");
	}
	
	public NamedParameterJdbcTemplate getDataSource() {
		return jdbc;
	}

	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}

	public List<Offer> getOffers() {
		MapSqlParameterSource params = new MapSqlParameterSource();

		return jdbc.query("select * from offers", params, new RowMapper<Offer>() {
			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Offer offer = new Offer();

				offer.setId(rs.getInt("id"));
				offer.setName(rs.getString("name"));
				offer.setEmail(rs.getString("email"));
				offer.setText(rs.getString("text"));

				return offer;
			}
		});
	}
//
//	public Offer getSingleOffer(int id) {
//		MapSqlParameterSource params = new MapSqlParameterSource();
//		params.addValue("id", id);
//
//		return jdbc.queryForObject("select * from offers where id=:id", params, new RowMapper<Offer>() {
//			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
//				Offer offer = new Offer();
//
//				offer.setId(rs.getInt("id"));
//				offer.setName(rs.getString("name"));
//				offer.setEmail(rs.getString("email"));
//				offer.setText(rs.getString("text"));
//
//				return offer;
//			}
//		});
//	}
//
//	public boolean delete(int id) {
//		MapSqlParameterSource params = new MapSqlParameterSource("id", id);
//
//		// jdbc.getJdbcOperations();
//		return jdbc.update("delete from offers where id=:id", params) == 1;
//	}
//
//	public boolean insert(Offer offer) {
//		// MapSqlParameterSource params = new MapSqlParameterSource();
//		//
//		// params.addValue("name", offer.getName());
//		// params.addValue("email", offer.getEmail());
//		// params.addValue("text", offer.getText());
//
//		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer);
//
//		// jdbc.getJdbcOperations();
//		return jdbc.update("insert into offers(name, email, text) values(:name, :email, :text)", params) == 1;
//	}
//	
//	@Transactional
//	public int[] insertBatch(List<Offer> offer) {
//		SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(offer.toArray());
//		
//		return jdbc.batchUpdate("insert into offers(name, email, text) values(:name, :email, :text)", params);
//	}
//	
//	public boolean update(Offer offer) 
//	{
//		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer);
//		
//		return jdbc.update("update offers set name=:name, email=:email, text=:text where id=:id", params) == 1;
//	}
//
//	public boolean updateTest(String lama, String baru, String pilihan) 
//	{
////		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer);
//		MapSqlParameterSource params = new MapSqlParameterSource();
//		params.addValue("lama", lama);
//		params.addValue("baru", baru);
//		
//		if(pilihan.equalsIgnoreCase("nama"))
//		{
//			return jdbc.update("update offers set name=:baru where name=:lama ", params) == 1;
//		}
//		else if(pilihan.equalsIgnoreCase("email"))
//		{
//			return jdbc.update("update offers set email=:baru where email=:lama ", params) == 1;
//		}
//		else
//		{
//			return jdbc.update("update offers set text=:baru where text=:lama ", params) == 1;
//		}
//	}
//	
//	public int getIdOffers(String search)
//	{
//		Offer offer = new Offer();
//		return offer.getId();
//	}
}

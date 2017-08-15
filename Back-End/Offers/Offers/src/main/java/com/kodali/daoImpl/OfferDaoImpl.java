package com.kodali.daoImpl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.kodali.beans.Offer;
import com.kodali.dao.OfferDao;

@Component("offerDaoImpl")
public class OfferDaoImpl implements OfferDao {
	private NamedParameterJdbcTemplate jdbc;

	@Override
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public List<Offer> getOffers() {
		String query = "select * from offers";
		RowMapper<Offer> rowMapper = (rs, rowNum) -> {
			Offer offer = new Offer();
			offer.setName(rs.getString("name"));
			offer.setEmail(rs.getString("email"));
			offer.setText(rs.getString("text"));
			return offer;
		};

		return jdbc.query(query, rowMapper);
	}

	@Override
	public Offer getOffer(int id) {
		return null;
	}

	@Override
	public boolean createOffer(Offer offer) {

		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer);

		return jdbc.update("insert into offers (name, text, email) values (:name, :text, :email)", params) == 1;

	}

	@Override
	public int[] createOffers(List<Offer> offerList) {
		return null;
	}

	@Override
	public boolean updateOffer(Offer offer) {
		return false;
	}

	@Override
	public boolean deleteOffer(int id) {
		return false;
	}

}

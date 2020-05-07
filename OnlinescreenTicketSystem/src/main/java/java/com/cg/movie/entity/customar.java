package com.cg.movie.entity;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import com.cg.movie.entity.user;
@Entity
@Table(name="lpu_movie_customar")
public class customar {
	@Id
	@Column(name="user_id")
	private int userId;
	@Column(name="customar_name")
	private String customerName;
	@Column(name="password")
	private String password;
	@Column(name="dateofBirth")
	private LocalDate dateofBirth;
	@Column(name="customer_contact")
	private String customercontact;
	@OneToOne()
	@JoinColumn(name="user_id")
	private user u = new user();
	

}

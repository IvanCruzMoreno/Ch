package com.ivanmoreno.blogapp.model.jpa;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data // generates getters, setters, equals, toString & hashCode we well
@Builder // generates builder for the fields within
@NoArgsConstructor // generates a no argument constructor
@AllArgsConstructor // generates a constructor with all arguments
@ToString(exclude = {"blog", "user"}) // generates toString method, skipping passed field as name

@EqualsAndHashCode(exclude = {"blog", "user"}) // generates equals and hashCode methods, skipping passed fields
@Entity
public class Post implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	
	private String content;
	
	@Column(name = "post_status")
	@Type(type = "com.ivanmoreno.blogapp.constants.PgEnumType", 
	      parameters = {@org.hibernate.annotations.Parameter(name = "enumClassName", 
	                     value = "com.ivanmoreno.blogapp.model.jpa.PostStatus")})
	// @Enumerated(EnumType.ORDINAL) // Use this otherwise to store it as integer
	PostStatus postStatus;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "blog_id")
	private Blog blog;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "author_id")
	private User user;
}

package com.codeversus.backend.model;

import java.util.List;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import com.codeversus.backend.enums.Difficulty;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="problems")
public class Problem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String slug;
	@Enumerated(EnumType.STRING)
	private Difficulty difficulty;
	@JdbcTypeCode(SqlTypes.ARRAY)
	private List<String> topics;
	private String source;
	private String referenceUrl;
	private Boolean enabled;
	
	protected Problem() {
		
	}
	public Problem(Long id, String title, String slug, Difficulty difficulty, List<String> topics, String source,
			String referenceUrl, Boolean enabled) {
		this.id = id;
		this.title = title;
		this.slug = slug;
		this.difficulty = difficulty;
		this.topics = topics;
		this.source = source;
		this.referenceUrl = referenceUrl;
		this.enabled = enabled;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSlug() {
		return slug;
	}
	public void setSlug(String slug) {
		this.slug = slug;
	}
	public Difficulty getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(Difficulty difficulty) {
		this.difficulty = difficulty;
	}
	public List<String> getTopics() {
		return topics;
	}
	public void setTopics(List<String> topics) {
		this.topics = topics;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getReferenceUrl() {
		return referenceUrl;
	}
	public void setReferenceUrl(String referenceUrl) {
		this.referenceUrl = referenceUrl;
	}
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	
	
	

}

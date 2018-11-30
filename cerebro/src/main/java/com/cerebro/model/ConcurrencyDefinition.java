package com.cerebro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CONCURRENCY_DEFINITION")
public class ConcurrencyDefinition {
    private Long id;
    private String description;
    private String details;
    private String imagePaths;

    public ConcurrencyDefinition(String description, String details, Long id, String imagesPath) {
	this.id = id;
	this.description = description;
	this.details = details;
	this.imagePaths = imagesPath;
    }

    public ConcurrencyDefinition() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "concurrencySequence")
    @SequenceGenerator(name = "concurrencySequence", sequenceName = "CONCURRENCY_SEQUENCE", allocationSize = 1)
    @Column(name = "ID")
    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    @Column(name = "DESCRIPTION")
    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    @Column(name = "DETAILS")
    public String getDetails() {
	return details;
    }

    public void setDetails(String details) {
	this.details = details;
    }

    @Column(name = "IMAGE_PATHS")
    public String getImagePaths() {
	return imagePaths;
    }

    public void setImagePaths(String imagePaths) {
	this.imagePaths = imagePaths;
    }

    @Override
    public String toString() {
	return "[description=" + description + ", details=" + details + "]";
    }

}

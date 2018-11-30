package com.cerebro.model;


/**
 * Class used to transfer data to UI and get data from UI
 * @author Avinash Babu Donthu - 19 Feb 2017
 *
 */
public class Definition {
    private Long id;
    private String description;
    private String details;
    private String imagePaths;

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public String getDetails() {
	return details;
    }

    public void setDetails(String details) {
	this.details = details;
    }

    public String getImagePaths() {
	return imagePaths;
    }

    public void setImagePaths(String imagePaths) {
	this.imagePaths = imagePaths;
    }

    @Override
    public String toString() {
	return "Definition [description=" + description + ", details=" + details + "]";
    }

}

package com.cerebro.util;

import java.nio.file.Paths;

public interface Constants {
	public static final String CORE_JAVA = "Core Java";
	public static final String APACHE_KAFKA = "Apache Kafka";
	public static final String GROOVY = "Groovy";
	public static final String ENTITY = "entity";
	public static final String REPOSITORY = "repository";
	public static final String MAVEN = "Maven";
	public static final String JENKINS = "Jenkins";
	public static final String NEW_LINE_CHAR = "\n";
	public static final String BR_TAG = "<br/>";
	public static final String INDEX_DIRECTORY = Paths.get("").toAbsolutePath().toString()
			+ "\\src\\main\\resources\\lucene-indexes";
	public static final String DATA_DIRECTORY = Paths.get("").toAbsolutePath().toString()
			+ "\\src\\main\\resources\\public";

}
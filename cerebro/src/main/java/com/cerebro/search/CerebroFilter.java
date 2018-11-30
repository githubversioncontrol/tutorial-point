package com.cerebro.search;

import java.io.File;
import java.io.FileFilter;

/**
 * Filter to filter the files
 * @author Avinash Babu Donthu
 *
 */
public class CerebroFilter implements FileFilter {

	@Override
	public boolean accept(File filePath) {
		return filePath.getName().endsWith(".html");
	}

}

package com.cerebro.search;

import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.IOException;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

@SuppressWarnings({ "deprecation" })
public class Indexer {

	private IndexWriter indexWriter;

	public Indexer(String indexDirectoryPath) throws IOException {
		// this directory will contain indexes
		Directory indexDirectory = FSDirectory.open(new File(indexDirectoryPath));

		// create IndexWriter
		indexWriter = new IndexWriter(indexDirectory, new StandardAnalyzer(Version.LUCENE_36), true,
				IndexWriter.MaxFieldLength.UNLIMITED);
	}

	public void close() throws CorruptIndexException, IOException {
		indexWriter.close();
	}

	public int createIndex(String dataDirPath, FileFilter fileFilter) throws IOException {
		File[] files = new File(dataDirPath).listFiles();

		for (File file : files) {
			if (!file.isDirectory() && !file.isHidden() && file.exists() && file.canRead()
					&& fileFilter.accept(file)) {
				indexFile(file);
			}
		}

		return indexWriter.numDocs();
	}

	private Document getDocument(File file) throws IOException {
		Document document = new Document();

		// index file contents
		Field contentField = new Field("contents", new FileReader(file));
		// index file name
		Field fileNameField = new Field("filename", file.getName(), Field.Store.YES,
				Field.Index.NOT_ANALYZED);
		// index file path
		Field filePathField = new Field("filepath", file.getCanonicalPath(), Field.Store.YES,
				Field.Index.NOT_ANALYZED);

		document.add(contentField);
		document.add(fileNameField);
		document.add(filePathField);

		return document;
	}

	private void indexFile(File file) throws IOException {
		System.out.println("Indexing: " + file.getCanonicalPath());
		Document document = getDocument(file);
		indexWriter.addDocument(document);
	}
}

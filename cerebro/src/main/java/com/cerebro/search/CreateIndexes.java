package com.cerebro.search;

import java.io.IOException;
import java.time.Clock;
import java.time.Duration;
import java.time.LocalDateTime;

import com.cerebro.util.Constants;

public class CreateIndexes {

	//	@Test
	public void createLuceneIndexes() {
		try {
			Indexer indexer = new Indexer(Constants.INDEX_DIRECTORY);
			LocalDateTime startTime = LocalDateTime.now(Clock.systemDefaultZone());
			int numIndexed = indexer.createIndex(Constants.DATA_DIRECTORY, new CerebroFilter());
			LocalDateTime endTime = LocalDateTime.now(Clock.systemDefaultZone());

			indexer.close();
			System.out.println(numIndexed + " files indexed. Time taken: "
					+ Duration.between(startTime, endTime).getSeconds());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

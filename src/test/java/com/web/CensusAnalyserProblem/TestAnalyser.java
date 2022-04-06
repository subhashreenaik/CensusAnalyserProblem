package com.web.CensusAnalyserProblem;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestAnalyser {
	StateCensusAnalyser analyser;
	CSVStateCode codeAnalyser;
	@Before
	public void initialization() {
		analyser = new StateCensusAnalyser();
		codeAnalyser = new CSVStateCode();
	}

	@Test
	public void testRecordMatch() throws InvalidFile, InvalidDelimiter {
		analyser.loadData("src/main/resources/IndiaStateCensusData.csv");
		assertEquals(true, analyser.checkData());
	}
	@Test
	public void testFileCheckSad() throws InvalidFile, InvalidDelimiter {
		analyser.loadData("src/main/resources/IndiaStateCensus.csv");
	}
	
	
	
	@Test
	public void testDelimiterCheckSad() throws InvalidFile, InvalidDelimiter  {
		analyser.loadData("src/main/resources/IndiaStateCensusDataWithoutDeliminator.csv");
	}
	
	@Test
	public void testHeaderCheckSad() throws InvalidFile, InvalidDelimiter {
		analyser.loadData("src/main/resources/IndiaStateCensusData.csv");
	}
	
	@Test
	public void testCodeRecordMatch() throws Exception {
		codeAnalyser.loadData("src/main/resources/IndiaStateCode.csv");
		assertEquals(true, codeAnalyser.checkData(37));
	}
}
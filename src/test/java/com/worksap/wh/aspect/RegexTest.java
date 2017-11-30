package com.worksap.wh.aspect;

import static org.junit.Assert.assertEquals;

import java.util.regex.Pattern;

import org.junit.Test;

public class RegexTest {
	private static final Pattern TYPE_KEYWORD_PATTERN = Pattern.compile(".*type\\:.*");

	private static final Pattern DATE_KEYWORD_PATTERN = Pattern.compile(".*(date\\:|before\\:|after\\:).*");

	@Test
	public void regexMathTest() {
		assertEquals(TYPE_KEYWORD_PATTERN.matcher("+type:\\\"20130101 to 20131231\\\"").matches(), true);
		assertEquals(TYPE_KEYWORD_PATTERN.matcher("0130101 to+date:\\\"20130101 to 20131231\\\"").matches(), false);
		assertEquals(DATE_KEYWORD_PATTERN.matcher("0130101 to+before:\\\"20130101 to 20131231\\\"").matches(), true);
	}
	
}

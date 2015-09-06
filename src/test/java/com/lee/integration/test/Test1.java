package com.lee.integration.test;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:root-context.xml")
@Transactional
public class Test1 extends TestCase {

	public void before() {

	}

	public void after() {

	}

	@Test
	public void test() {
		System.out.println("aaaaaa");
	}
}

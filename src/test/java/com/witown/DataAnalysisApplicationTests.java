package com.witown;

import com.witown.location.mapper.WiLocationMapper;
import com.witown.location.service.DataAnalysisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DataAnalysisApplicationTests {

	@Autowired
	private DataAnalysisService dataAnalysisService;

	@Autowired
	private WiLocationMapper mapper;

	@Test
	public void contextLoads() {
		dataAnalysisService.go();
//		System.out.println(mapper.get("8a2871c55e27f120015e35e1736b032d"));
	}

	public static void main(String[] args) {
		final List<String> list = new ArrayList<>();
		list.add("1");
		list.add("2");
		System.out.println(list);


	}

}

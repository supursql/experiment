package org.exp;

import org.exp.utils.ResultUtils;
import org.exp.utils.TimeUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.spring.annotation.MapperScan;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
@MapperScan(basePackages="banxia.org.mapper")
public class Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@GetMapping("/ping")
	public ResultUtils testApi() {
		HashMap<String, String> res = new HashMap<>();
		res.put("message", "pong");
		return ResultUtils.ok(res);
	}

	@GetMapping("/time")
	public ResultUtils time() {

		long curr = System.currentTimeMillis();
		Calendar calendar1 = Calendar.getInstance();
		calendar1.set(Calendar.DAY_OF_YEAR, calendar1.get(Calendar.DAY_OF_YEAR) + 1);
		Calendar calendar2 = Calendar.getInstance();
		calendar2.set(Calendar.DAY_OF_YEAR, calendar2.get(Calendar.DAY_OF_YEAR) + 2);
		Calendar calendar3 = Calendar.getInstance();
		calendar3.set(Calendar.DAY_OF_YEAR, calendar3.get(Calendar.DAY_OF_YEAR) + 3);
		Calendar calendar4 = Calendar.getInstance();
		calendar4.set(Calendar.DAY_OF_YEAR, calendar4.get(Calendar.DAY_OF_YEAR) + 4);
		Calendar calendar5 = Calendar.getInstance();
		calendar5.set(Calendar.DAY_OF_YEAR, calendar5.get(Calendar.DAY_OF_YEAR) + 5);
		Calendar calendar6 = Calendar.getInstance();
		calendar6.set(Calendar.DAY_OF_YEAR, calendar6.get(Calendar.DAY_OF_YEAR) + 6);

		Map<String, String> time = new HashMap<>();
		time.put("one", TimeUtils.timestampToStr(curr));
		time.put("two", TimeUtils.timestampToStr(calendar1.getTimeInMillis()));
		time.put("three", TimeUtils.timestampToStr(calendar2.getTimeInMillis()));
		time.put("four", TimeUtils.timestampToStr(calendar3.getTimeInMillis()));
		time.put("five", TimeUtils.timestampToStr(calendar4.getTimeInMillis()));
		time.put("six", TimeUtils.timestampToStr(calendar5.getTimeInMillis()));
		time.put("seven", TimeUtils.timestampToStr(calendar6.getTimeInMillis()));

		return ResultUtils.ok(time);
	}

	
}

package com.example.backend.guestbook;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GuestbookController {

	@Autowired
	GuestBookDAO gbDao;

	@RequestMapping("/guestbook")
	public List<Map<String, Object>> list(@RequestParam(name = "searchkey", defaultValue = "name") String searchkey,
			@RequestParam(name = "search", defaultValue = "") String search) {
		System.out.println("searchkey : " + searchkey);
		System.out.println("search : " + search);
		return gbDao.list(searchkey, search);
	}

	@RequestMapping("/guestbook/insert")
	public void insert(@RequestParam Map<String, Object> map) {
		gbDao.insert(map);
	}

	@RequestMapping("/guestbook/detail/{idx}")
	public Map<String, Object> detail(@PathVariable(name = "idx") int idx) {
		return gbDao.detail(idx);
	}

	@RequestMapping("/guestbook/update")
	public Map<String, Object> update(@RequestParam Map<String, Object> map) {
		Map<String, Object> result_map = new HashMap<>();
		// hash map 으로 받을 경우 자료형이 고정되지 않는 단점이 있음, 스트링 → 정수로 두번 변환
		int idx = Integer.parseInt(String.valueOf(map.get("idx")));
		String passwd = String.valueOf(map.get("passwd"));
		if (gbDao.check_pwd(idx, passwd)) {
			gbDao.update(map);
			result_map.put("result", "success");
		} else {
			result_map.put("result", "fail");
		}
		return result_map;
	}

	@RequestMapping("/guestbook/delete")
	public Map<String, Object> delete(@RequestParam(name = "idx") int idx,
			@RequestParam(name = "passwd") String passwd) {
		Map<String, Object> result_map = new HashMap<>();
		if (gbDao.check_pwd(idx, passwd)) {
			gbDao.delete(idx);
			result_map.put("result", "success");
		} else {
			result_map.put("result", "fail");
		}
		return result_map;
	}
}
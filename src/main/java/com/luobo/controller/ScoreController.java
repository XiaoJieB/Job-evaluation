package com.luobo.controller;

import com.luobo.entity.Score;
import com.luobo.service.BigWorkService;
import com.luobo.service.ScoreService;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * . Description: Date: 2019/3/22 11:45
 *
 * @author: ws
 * @version: 1.0
 */
@RequestMapping("score")
@Controller
public class ScoreController {

	@Autowired
	ScoreService scoreService;
	@Autowired
	BigWorkService bigWorkService;

	@RequestMapping("/save")
	@ResponseBody
	public Map<String,Object> addScore(Score score, HttpServletRequest request) {
		Map<String, Object> result = new HashMap<String, Object>();
		scoreService.save(score);
		result.put("msg", "分数评价成功！");
		result.put("code", "0");
		return result;
	}
}

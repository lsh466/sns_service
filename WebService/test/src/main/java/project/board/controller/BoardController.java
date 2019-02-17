package project.board.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;

import project.board.DTO.BoardDTO;
import project.board.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping(value="/showBoardList.do")
	public String showBoardList(Model model) throws JsonGenerationException, JsonMappingException, IOException {
		List<BoardDTO> boardList = boardService.showBoardList();
		
		JsonArray result = (JsonArray) new Gson().toJsonTree(boardList,
		            new TypeToken<List<BoardDTO>>() {
		            }.getType());
		
		model.addAttribute("list", result);
		
		return "boardlist";
	}
	
	@RequestMapping(value="/writeBoardContent.do", method=RequestMethod.GET)
	public String writeBoardContent(Model model, HttpServletRequest request, @RequestParam HashMap<String, Integer> params ) {
		BoardDTO item = boardService.showBoardItem(params);
		model.addAttribute("content",request.getParameter("content"));
		model.addAttribute("item", item);
		
		return "boardcontent";
	}
}

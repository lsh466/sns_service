package boardlist.web;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import DTO.BoardVO;
import boardlist.service.BoardService;

@Controller
@RequestMapping("/boardList.do")
public class BoardListController {
	@Inject
	BoardService boardService;
	
	public String boardList(Model model) throws Exception{
		List<BoardVO> list = boardService.boardList();
		model.addAttribute("list", list);
		
		return "boardList";
	}
}

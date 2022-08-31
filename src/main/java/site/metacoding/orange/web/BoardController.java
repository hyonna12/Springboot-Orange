package site.metacoding.orange.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.AllArgsConstructor;
import site.metacoding.orange.domain.Board;
import site.metacoding.orange.domain.BoardDao;

@AllArgsConstructor
@Controller
public class BoardController {
	
	private BoardDao boardDao; 
	// ioc컨테이너에 들어있는거 가져오기
	// 만들어놓은 boardDao 를 의존, composition하고 있는데 null이니까 @allargsconstructor로 생성자 넣어준것, 생성자 직접 입력해도됨  
	// 이렇게 쓸수있는데 boardDao 에 @repository있어서 메모리에 띄웠기때문임
	
	@PostMapping("/board")	// cv패턴
	public String postData(Board board) {
		boardDao.save(board);
		return "index";
	}
	
	@GetMapping("/board/{id}")	// mvc패턴
	public String getData(@PathVariable Integer id, Model model) {
		Board board = boardDao.findById(id).get();
		model.addAttribute("board", board);
		return "detail";
	}
}

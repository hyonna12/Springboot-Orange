package site.metacoding.orange.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository	// 메모리에 띄워줌, new 안해도됨 / restcontroller, controller, repository -> 메모리에 띄우는 annotation
public interface BoardDao extends JpaRepository<Board, Integer>{	// entity, primary key 타입, 5가지 메서드 만들지않아도됨

}

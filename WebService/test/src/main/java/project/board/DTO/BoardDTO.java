package project.board.DTO;

import java.sql.Date;

public class BoardDTO {
	private int board_index;
	private String board_title;
	private String board_content;
	private String board_writer;
	private int board_cnt;
	private Date date;
	
	public int getBoard_index() {
		return board_index;
	}
	public void setBoard_index(int board_index) {
		this.board_index = board_index;
	}
	public String getBoard_title() {
		return board_title;
	}
	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	public String getBoard_content() {
		return board_content;
	}
	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}
	public String getBoard_writer() {
		return board_writer;
	}
	public void setBoard_writer(String board_writer) {
		this.board_writer = board_writer;
	}
	public int getBoard_cnt() {
		return board_cnt;
	}
	public void setBoard_cnt(int board_cnt) {
		this.board_cnt = board_cnt;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
}

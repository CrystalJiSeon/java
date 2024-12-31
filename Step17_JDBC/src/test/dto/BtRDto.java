package test.dto;

public class BtRDto {
	private int no;
	private String title;
	private String writer;
	
	public BtRDto() {}

	public BtRDto(int no, String title, String writer) {
		super();
		this.no = no;
		this.title = title;
		this.writer = writer;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}
}

package model;

public class Content {
	private int id;
	private String 	title;
	private String brief;
	private String content;
	private String author_id;
	private String createDate;
	private String updateDate;
	
	
	public Content(int id, String title, String brief, String content, String authorID) {
		this.id = id;
		this.title = title;
		this.brief = brief;
		this.content = content;
		this.author_id = authorID;
	}
	
	
	public Content(int id, String title, String brief, String content, String authorID, String createDate, String updateDate) {
		this.id = id;
		this.title = title;
		this.brief = brief;
		this.content = content;
		this.author_id = authorID;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}
	
	public Content(String title, String brief, String content, String authorID) {
		this.title = title;
		this.brief = brief;
		this.content = content;
		this.author_id = authorID;
	}
	
	public Content() {
	}
	
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBrief() {
		return brief;
	}
	public void setBrief(String brief) {
		this.brief = brief;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAuthorID() {
		return author_id;
	}
	public void setAuthorID(String authorID) {
		this.author_id = authorID;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}


	public String getCreateDate() {
		return createDate;
	}


	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}


	public String getUpdateDate() {
		return updateDate;
	}


	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
}

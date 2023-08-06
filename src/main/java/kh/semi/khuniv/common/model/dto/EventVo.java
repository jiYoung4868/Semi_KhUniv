package kh.semi.khuniv.common.model.dto;

public class EventVo {
//	EVENT_NO      NOT NULL NUMBER         
//	EVENT_SD      NOT NULL DATE           
//	EVENT_ED      NOT NULL DATE           
//	EVENT_TITLE   NOT NULL VARCHAR2(300)  
//	EVENT_CONTENT          VARCHAR2(1000) 

	private String eventNo;
	private String eventSd;
	private String eventEd;
	private String title;
	private String content;
	
	@Override
	public String toString() {
		return "EventVo [eventNo=" + eventNo + ", eventSd=" + eventSd + ", eventEd=" + eventEd + ", title=" + title
				+ ", content=" + content + "]";
	}

	public String getEventNo() {
		return eventNo;
	}

	public void setEventNo(String eventNo) {
		this.eventNo = eventNo;
	}

	public String getEventSd() {
		return eventSd;
	}

	public void setEventSd(String eventSd) {
		this.eventSd = eventSd;
	}

	public String getEventEd() {
		return eventEd;
	}

	public void setEventEd(String eventEd) {
		this.eventEd = eventEd;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
	
}

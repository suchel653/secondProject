package com.ggiriggiri.web.entity;

import java.util.Date;
import java.util.List;

public class Contest {

	private int id;
	private String writerName;
	private String title;
	private String content;
	private Date startDate;
	private Date endDate;
	private int hit;
	private Date regDate;
	private List<ContestFile> contestFiles;
	private List<ContestImage> contestImages;

	public Contest() {

	}

	public Contest(int id,String writerName, String title, String content, Date startDate, Date endDate) {
		super();
		this.id = id;
		this.writerName = writerName;
		this.title = title;
		this.content = content;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public Contest(int id, String writerName, String title, String content, Date startDate, Date endDate, int hit,
			Date regDate, List<ContestFile> contestFiles, List<ContestImage> contestImages) {
		super();
		this.id = id;
		this.writerName = writerName;
		this.title = title;
		this.content = content;
		this.startDate = startDate;
		this.endDate = endDate;
		this.hit = hit;
		this.regDate = regDate;
		this.contestFiles = contestFiles;
		this.contestImages = contestImages;
	}

	@Override
	public String toString() {
		return "Contest [id=" + id + ", writerName=" + writerName + ", title=" + title + ", content=" + content
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", hit=" + hit + ", regDate=" + regDate
				+ ", contestFiles=" + contestFiles + ", contestImages=" + contestImages + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWriterName() {
		return writerName;
	}

	public void setWriterName(String writerName) {
		this.writerName = writerName;
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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public List<ContestFile> getContestFiles() {
		return contestFiles;
	}

	public void setContestFiles(List<ContestFile> contestFiles) {
		this.contestFiles = contestFiles;
	}

	public List<ContestImage> getContestImages() {
		return contestImages;
	}

	public void setContestImages(List<ContestImage> contestImages) {
		this.contestImages = contestImages;
	}

	
}

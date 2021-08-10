package model;

import java.util.Date;

public class Artwork {

	private int artworkId; // pk(�⺻Ű)
	private int exhibitionId; // exhibition�� PK, FK
	private int title; // ��ǰ ����
	private String description; // ��ǰ ����
	private String artistName; // ��ǰ �۰� �̸�
	private Date date; // ��ǰ�� ������ ��¥
	private int viewCount; // ��ǰ�� ��ȸ��
	private int likesCount; // ��ǰ�� ���ƿ� ��
	
	public Artwork() {}

	public Artwork(int artworkId, int exhibitionId, int title, String description, String artistName, Date date,
			int viewCount, int likesCount) {
		super();
		this.artworkId = artworkId;
		this.exhibitionId = exhibitionId;
		this.title = title;
		this.description = description;
		this.artistName = artistName;
		this.date = date;
		this.viewCount = viewCount;
		this.likesCount = likesCount;
	}

	public int getArtworkId() {
		return artworkId;
	}

	public void setArtworkId(int artworkId) {
		this.artworkId = artworkId;
	}

	public int getExhibitionId() {
		return exhibitionId;
	}

	public void setExhibitionId(int exhibitionId) {
		this.exhibitionId = exhibitionId;
	}

	public int getTitle() {
		return title;
	}

	public void setTitle(int title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	public int getLikesCount() {
		return likesCount;
	}

	public void setLikesCount(int likesCount) {
		this.likesCount = likesCount;
	}

}
package vo;

public class CategoryVO extends BaseVO {
	private int categoryId;
	private String blogId;
	private String categoryName;
	private String content;
	private boolean publicCategory;
	
	public CategoryVO() {}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getBlogId() {
		return blogId;
	}

	public void setBlogId(String blogId) {
		this.blogId = blogId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public boolean isPublicCategory() {
		return publicCategory;
	}

	public void setPublicCategory(boolean publicCategory) {
		this.publicCategory = publicCategory;
	}
	
	
}

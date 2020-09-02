package tool;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class PostOnProfile {
	
	private List<Post> posts = new ArrayList<Post>();
	private WebDriver driver;
	public PostOnProfile(WebDriver driver) {
		this.driver = driver;
	}
	
	public void loadPost() {
		driver.get(CommonFacebook.URL_PROFILE);
		List<WebElement> elements =  driver.findElements(By.cssSelector("header abbr"));
		for(WebElement element : elements) {
			WebElement e = element.findElement(By.xpath(".."));
			String str = e.getAttribute("href");
			String url = CommonFacebook.getPostUrl(str);
			String id = CommonFacebook.getPostId(url);
			
			if(id != null) {
				posts.add(new Post(id, url));
			}
		}
	}
	
	public void commentAll(String des) {
		for(Post ePost : posts) {
			driver.get(ePost.getUrl());
			WebElement element = driver.findElement(By.className("mentions-input"));
			element.sendKeys(des);
			try {
				Thread.sleep(400);
				WebElement element2 = driver.findElement(By.cssSelector("button._653w"));
				if(element2!=null) element2.click();
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void likePost(int index) {
		if(index < posts.size() - 1) {
			driver.get(posts.get( index -1).getUrl());
			driver.findElement(By.cssSelector("a._15ko._77li.touchable")).click();
		}
	}
	
	
	public void getAllPost(){
		for(Post ePost : posts) {
			System.out.println("Post");
			System.out.println("Id: " + ePost.getId());
			System.out.println("url: " + ePost.getUrl());
		}
	}
}

class Post{
	
	private String id;
	private String url;
	
	public Post(String id, String url) {
		super();
		this.id = id;
		this.url = url;
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}

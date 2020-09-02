package tool;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Main {
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
        try {
        	Scanner scanner = new Scanner(System.in);
        	
        	System.out.println("Enter username:");
        	String usernameString = scanner.nextLine();
        	System.out.println("Enter password");
        	String passwordString = scanner.nextLine();
        	
            driver.get(CommonFacebook.URL_HOME);
            
            boolean signSuccess = LoginFacebook.login(driver, usernameString, passwordString); // true nếu vào được trang chủ
             
            PostOnProfile postOnProfile = new PostOnProfile(driver);
            postOnProfile.loadPost();
            postOnProfile.getAllPost();
            
            System.out.println("Enter comment. comment all post on profile");
            String comment = scanner.nextLine();
            
            postOnProfile.commentAll(comment.trim());
            
            System.out.println("enter index post . Like post");
            int postIndex = scanner.nextInt();
            postOnProfile.likePost(postIndex);
           
            
            
            scanner.close();
        } finally {
            driver.quit();
        }
	}
}

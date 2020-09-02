package tool;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginFacebook {
	static boolean login(WebDriver driver, String username, String password) {
		
		driver.findElement(By.cssSelector("#m_login_email")).sendKeys(username.trim());
        driver.findElement(By.cssSelector("#m_login_password")).sendKeys(password.trim());
        driver.findElement(By.name("login")).click();
        
        int num = 0;
        while(!driver.getTitle().equals("Facebook")) { if(num++ > 10000) return false;}
        
        driver.get(CommonFacebook.URL_HOME);
        System.out.println("Đăng nhập thành công");
		return true;
	}
}

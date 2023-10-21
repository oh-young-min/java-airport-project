import java.util.Scanner;
import java.time.LocalDate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class selenium {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		LocalDate to_date = LocalDate.now();
		int to_month = to_date.getMonthValue();
		
		System.out.println("출발지를 입력하세요");
		String departure = scanner.nextLine();
		System.out.println("도착지를 입력하세요");
		String destination = scanner.nextLine();
		System.out.println("가는 날을 입력하세요(달 주 요일(일요일 : 1, 월요일 : 2, 화요일 : 3, 수요일 : 4, 목요일 : 5, 금요일 : 6, 토요일 : 7) 순으로 입력)");
		int smonth = scanner.nextInt();
		String sweek = scanner.next();
		String sday = scanner.next();
		System.out.println("오는 날을 입력하세요(달 주 요일(일요일 : 1, 월요일 : 2, 화요일 : 3, 수요일 : 4, 목요일 : 5, 금요일 : 6, 토요일 : 7) 순으로 입력)");
		int emonth = scanner.nextInt();
		String eweek = scanner.next();
		String eday = scanner.next();
		scanner.close();
		
		String ssmonth = String.valueOf(smonth - to_month + 2);
		String semonth = String.valueOf(emonth - to_month + 2);
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://flight.naver.com/");
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/div[4]/div/div/div[2]/div[1]/button[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/div[10]/div[1]/div/input")).sendKeys(departure);
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/div[10]/div[2]/section/div/a")).click();
		
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/div[4]/div/div/div[2]/div[1]/button[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/div[10]/div[1]/div/input")).sendKeys(destination);
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/div[10]/div[2]/section/div/a")).click();
		
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/div[4]/div/div/div[2]/div[2]/button[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/div[10]/div[2]/div[1]/div[2]/div/div["+ssmonth+"]/table/tbody/tr["+sweek+"]/td["+sday+"]/button")).click();
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/div[10]/div[2]/div[1]/div[2]/div/div["+semonth+"]/table/tbody/tr["+eweek+"]/td["+eday+"]/button")).click();
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/div[4]/div/div/div[2]/button")).click();
	}

}
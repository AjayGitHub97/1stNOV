package automationSepPackage;

public class BrokenLinkSearch {

	
		    //private static WebDriver driver = null;

		    @Test
		    public  void borken(){
		        
		        
		        String homePage = "https://www.doyenhub.com";
		        String url = "";
		        HttpURLConnection huc = null;
		        int respCode = 200;
		        
		        driver = new ChromeDriver();
		        
		        driver.manage().window().maximize();
		        
		        driver.get(homePage);
		        
		        List<WebElement> links = driver.findElements(By.tagName("a"));
		        
		        Iterator<WebElement> it = links.iterator();
		        
		        while(it.hasNext()){
		            
		            url = it.next().getAttribute("href");
		            
		            System.out.println(url);
		        
		            if(url == null || url.isEmpty()){
		System.out.println("URL is either not configured for anchor tag or it is empty");
		                continue;
		            }
		            
		            if(!url.startsWith(homePage)){
		                System.out.println("URL belongs to another domain, skipping it.");
		                continue;
		            }
		            
		            try {
		                huc = (HttpURLConnection)(new URL(url).openConnection());
		                
		                huc.setRequestMethod("HEAD");
		                
		                huc.connect();
		                
		                respCode = huc.getResponseCode();
		                
		                if(respCode >= 400){
		                    System.out.println(url+" is a broken link");
		                }
		                else{
		                    System.out.println(url+" is a valid link");
		                }
		                    
		            } catch (MalformedURLException e) {
		                // TODO Auto-generated catch block
		                e.printStackTrace();
		            } catch (IOException e) {
		                // TODO Auto-generated catch block
		                e.printStackTrace();
		            }
		        }


	}

}

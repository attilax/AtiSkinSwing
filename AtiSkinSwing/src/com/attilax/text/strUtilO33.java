package com.attilax.text;

//public class strUtil {
	
	
	
//	JAVA正则表达式匹配，替换，查找，切割
//	复制代码
	import java.util.ArrayList;
	import java.util.regex.Matcher;
import java.util.regex.Pattern;

	public class strUtilO33  extends strUtil1{
	    public static void main(String[] args) {
	        getStrings(); //用正则表达式获取指定字符串内容中的指定内�?
	        System.out.println("********************");
	        replace(); //用正则表达式替换字符串内�?
	        System.out.println("********************");
	        strSplit(); //使用正则表达式切割字符串
	        System.out.println("********************");
	        strMatch(); //字符串匹�?
	    }

	    private static void strMatch() {
	        String phone = "13539770000";
	        //�?��phone是否是合格的手机�?标准:1�?��，第二位�?,5,8，后9位为任意数字)
	        System.out.println(phone + ":" + phone.matches("1[358][0-9]{9,9}")); //true    
	        
	        String str = "abcd12345efghijklmn";
	        //�?��str中间是否包含12345
	        System.out.println(str + ":" + str.matches("\\w+12345\\w+")); //true
	        System.out.println(str + ":" + str.matches("\\w+123456\\w+")); //false
	    }

	    private static void strSplit() {
	        String str = "asfasf.sdfsaf.sdfsdfas.asdfasfdasfd.wrqwrwqer.asfsafasf.safgfdgdsg";
	        String[] strs = str.split("\\.");
	        for (String s : strs){
	            System.out.println(s);
	        }        
	    }

	    private static void getStrings() {
	        String str = "rrwerqq84461376qqasfdasdfrrwerqq84461377qqasfdasdaa654645aafrrwerqq84461378qqasfdaa654646aaasdfrrwerqq84461379qqasfdasdfrrwerqq84461376qqasfdasdf";
	        Pattern p = Pattern.compile("qq(.*?)qq");
	        Matcher m = p.matcher(str);
	        ArrayList<String> strs = new ArrayList<String>();
	        while (m.find()) {
	            strs.add(m.group(1));            
	        } 
	        for (String s : strs){
	            System.out.println(s);
	        }        
	    }
	    
	    
	    /**
	     * 
	     * @param str
	     * @param find "qq(.*?)qq"
	     */
	    public static String getMidtrings(String str,String find) {
	      //  String str = "rrwerqq84461376qqasfdasdfrrwerqq84461377qqasfdasdaa654645aafrrwerqq84461378qqasfdaa654646aaasdfrrwerqq84461379qqasfdasdfrrwerqq84461376qqasfdasdf";
	      //"qq(.*?)qq"
	        Pattern p = Pattern.compile(find);
	        Matcher m = p.matcher(str);
	        ArrayList<String> strs = new ArrayList<String>();
	        while (m.find()) {
	            strs.add(m.group(1));            
	        } 
//	        for (String s : strs){
//	            System.out.println(s);
////	        }    
	        if(strs.size()==0)
	        	return "";
	        return strs.get(0);
	    }
	    
	    
	    public static String getMidtrings(String s2,String left,String right) {
	    //	String s2="   周期 Statement cycle 2013/11/15 - 2013/12/14  ";
	    //	s2=doc.text();
	    			
	    			String abcdef="abcdef";
	    			String fd=left+"(.*?)"+right;
	    		 
	    		String s=	strUtilO33.getMidtrings(s2, fd);
		        return s;
		    }

	    private static void replace() {
	        String str = "asfas5fsaf5s4fs6af.sdaf.asf.wqre.qwr.fdsf.asf.asf.asf";
	        //将字符串中的.替换成_，因�?是特殊字符，�?��要用\.表达，又因为\是特殊字符，�?��要用\\.来表�?
	        str = str.replaceAll("\\.", "_");
	        System.out.println(str);        
	    }
	    
	    public static boolean isContainCnchar(String s3)
	    {
	    	if(s3.getBytes().length == s3.length())
	    		return false;else return true;
	    }
	}
 

 

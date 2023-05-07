package calenderPopup;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Date_analysis {

	public static void main(String[] args) {
	
	//	date format required:- Mon Oct 03 2022
	/*	
	//1) not applicabale
		LocalDateTime ldt=LocalDateTime.now();
		System.out.println(ldt);//  2022-09-28T23:13:54.519674400
	
	//2)	not applicable
		LocalDate ld=LocalDate.now();
		System.out.println(ld);//2022-09-28
	*/	
	//3)similar format , we can give implementation as we required
		Date d=new Date();
	//	System.out.println(date);//Wed Sep 28 23:34:57 IST 2022
		
		//Mon Oct 03 2022
		//Wed Sep 28 23:34:57 IST 2022
		// 0   1   2     3     4   5
		
		String datestr = d.toString();
	//split will remove all the spaces inside the string	
		String[] strArr = datestr.split(" ");
		//split() -> strings are therefore not included inthe resulting array.
		for (int i = 0; i < strArr.length; i++) {
			System.out.print(strArr[i]);//WedSep2823:53:27IST2022
		}
		
		String day = strArr[0];
		String month = strArr[1];
		String date = strArr[2];
		String year=strArr[5];
		
		String travelDate = day+" "+month+" "+date+" "+year;
		System.out.println(travelDate);
		
		
		
		
		
		
		
		
		
	}

}

package csharp.moira;


import org.athomeprojects.base.ChartData;



public class MRI {
	public static String DllID = "MRI_x86";	
	public String name, gender, country, city, zone;
	public int birth_year, birth_month, birth_day, birth_hour, birth_minute;
	public int now_year, now_month, now_day, now_hour, now_minute;
	public ChartTab chart_tab = null;
	public ChartData data = null;	
	public PublicChartData result = new PublicChartData();


	public void setLocation(String countryName, String cityName, String zoneName) {
		country = countryName;
		city = cityName;
		zone = zoneName;
	}

	public void setBirthTime(int year, int month, int day, int hour, int minute) {
		birth_year = year;
		birth_month = month;
		birth_day = day;
		birth_hour = hour;
		birth_minute = minute;
	}
	public void setNowTime(int year, int month, int day, int hour, int minute) {
		now_year = year;
		now_month = month;
		now_day = day;
		now_hour = hour;
		now_minute = minute;
	}	

	//InjLocationSpinner loc = Moira.mri.chart_tab.getSpinner();
	//Moira.mri.chart_tab.getBirthDate(birth_date);
	//Moira.mri.chart_tab.getNowDate(now_date);	
	
	public InjLocationSpinner getSpinner(){
		return chart_tab.getSpinner();
	}
	
	public void getBirthDate(int[] date) {
		chart_tab.getBirthDate(date);
	}
	
	public void getNowDate(int[] date) {
		chart_tab.getNowDate(date);
	}
	
	public String getYearShaStar(String sha_shen, boolean use_now) {		
		String str = "´MµL";
		String year_info = use_now ? Moira.mri.data.getYearInfo(false, result.now_table) : Moira.mri.data.getYearInfo(true, result.birth_table);
		int pos = year_info.indexOf(sha_shen);
		if (pos > 0) {
			str = year_info.substring(pos + 3, pos+4);
		}		
		return str;
	}
}

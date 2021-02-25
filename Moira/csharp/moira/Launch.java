package csharp.moira;
//set main class to �uorg.athomeprojects.Moira.Moira�v to run original Moira

import java.util.*;

import org.athomeprojects.base.*;

public class Launch {

	public Launch() {
		Moira.mri.setBirthTime(1984, 1, 1, 1, 30);
		Moira.mri.setNowTime(2020, 4, 1, 9, 0);
		Moira.init();
		String[] country_list = City.getCountryList();
		Log.c(Log.arrOut(country_list));
		String[] city_list = City.getCityList(country_list[33]);
		Log.c(Log.arrOut(city_list));
		String[] zone_list = City.getAllZoneNames();
		Log.c(Log.arrOut(zone_list));
		Moira.mri.setLocation(country_list[33], city_list[6], zone_list[312]); // �x�W�A�x�n�AAsia/Taipei
		Moira.run();
		showData();
		Moira.disposeMoira();
	}

	public static void main(String[] args) {
		new Launch();
	}

	public void showData() {

		String selector = "1,3";
		//InjLocationSpinner loc = Moira.mri.chart_tab.getSpinner();
		InjLocationSpinner loc = Moira.mri.getSpinner();
		int[] birth_date = new int[5];
		int[] lunar_date = new int[5];
		int[] now_date = new int[5];
		int[] now_lunar_date = new int[5];
		//Moira.mri.chart_tab.getBirthDate(birth_date);
		//Moira.mri.chart_tab.getNowDate(now_date);
		Moira.mri.getBirthDate(birth_date);
		Moira.mri.getNowDate(now_date);		

		Moira.mri.data.copyToMRI();
		lunar_date = Moira.mri.result.lunar_date;
		now_lunar_date = Moira.mri.result.now_lunar_date;
		
		
		
		Log.OpenLogFile();
		if (selector.contains("1")) {
			// Log.cf("Name : " + Moira.mri.chart_tab.getName());
			// Log.cf("Sex : " + Moira.mri.chart_tab.getSex());
			Log.cf("Country/City/Zone : " + loc.getCountryName() + " , " + loc.getCityName() + " , "
					+ loc.getZoneName());
			Log.cf("Birth : " + birth_date[0] + "/" + String.format("%02d", birth_date[1]) + "/"
					+ String.format("%02d", birth_date[2]) + "  " + String.format("%02d", birth_date[3]) + ":"
					+ String.format("%02d", birth_date[4]));
			//Log.cf(Log.arrOut(Moira.mri.result.lunar_date));
			Log.cf("Birth(����) : " + Moira.mri.result.year_names[lunar_date[0]-1] + "�~/" + String.format("%02d", lunar_date[1]) + "/"
					+ String.format("%02d", lunar_date[2]) + "  " + String.format("%02d", lunar_date[3]) + ":"
					+ String.format("%02d", lunar_date[4]));			
			
			Log.cf("now : " + now_date[0] + "/" + String.format("%02d", now_date[1]) + "/"
					+ String.format("%02d", now_date[2]) + "  " + String.format("%02d", now_date[3]) + ":"
					+ String.format("%02d", now_date[4]));
			
			Log.cf("now(����) : " + Moira.mri.result.year_names[now_lunar_date[0]-1] + "�~/" + String.format("%02d", now_lunar_date[1]) + "/"
					+ String.format("%02d", now_lunar_date[2]) + "  " + String.format("%02d", now_lunar_date[3]) + ":"
					+ String.format("%02d", now_lunar_date[4]));			
		}
		if (selector.contains("2")) {
			Log.cf("AngleMarkerArray : " + Log.arrOut(Moira.mri.data.getAngleMarkerArray(true, false, 1)));
			Log.cf(("AngleMarkerEnable : " + Moira.mri.data.getAngleMarkerEnable()));
			Log.cf("AspectColorArray(�ۦ�����C��) : " + Log.arrOut(Moira.mri.data.getAspectColorArray(true)));
			Log.cf("AspectDegreeArray(�ۦ쨤��) : " + Log.arrOut(Moira.mri.data.getAspectDegreeArray(true)));
			Log.cf("AspectDisplayArray(�ۦ���ܿ��) : " + Log.arrOut(Moira.mri.data.getAspectDisplayArray(true)));
			Log.cf("AspectOrbArray : " + Log.arrOut(Moira.mri.data.getAspectOrbArray()));
			Log.cf("AspectSignArray(�ۦ줤�廡�k) : " + Log.arrOut(Moira.mri.data.getAspectSignArray(true)));
			Log.cf("AstroData(��v�P�L��T) : " + Log.arrOut(Moira.mri.data.getAstroData()));
			Log.cf("ChildLimit(����) : " + Moira.mri.data.getChildLimit(false));
			Log.cf("ChildLimit(����@18) : " + Moira.mri.data.getChildLimit(18, ","));
			Log.cf("Cal : " + Moira.mri.data.getCal());
			Log.cf("getCuspArray : " + Log.arrOut(Moira.mri.data.getCuspArray()));
			Log.cf("DayOrNight : " + Moira.mri.data.getDayOrNight());
			int[] start = new int[5];
			// Log.cf("DateAtPlanetPos : " +
			// Log.arrOut(Moira.mri.data.getDateAtPlanetPos(0, true, 0, "�x�W",
			// "�x�_",
			// "Asia/Taipei", start, false))); //call failed.
			Log.cf("DateAtPlanetPos : call failed"); // not needed so far.
														// bypass it
			// Log.cf("DateAtSunPos : " +
			// Log.arrOut(Moira.mri.data.getDateAtSunPos(0, "�x�W", "�x�_",
			// "Asia/Taipei", start, false, false))); call failed
			Log.cf("DateAtSunPos : call failed"); // not needed so far. bypass
													// it
			Hashtable[] displayTable = new Hashtable[2];
			displayTable = Moira.mri.data.getDisplayTable();
			Log.cf("DisplayTable is an array of Hashtable");
			Log.cf("DrawSize : " + Log.arrOut(Moira.mri.data.getDrawSize()));
			Log.cf("EightCharOverride : " + Moira.mri.data.getEightCharOverride());
			SearchRecord[] s_record = Moira.mri.data.getEclipseData();
			Log.cf("EclipseData is an array of SearchRecord");
			Log.cf("FlyLimit(����) : " + Moira.mri.data.getFlyLimit(18, ",", 12));
			Log.cf("House(�R�c) : " + Moira.mri.data.getHouse());
			Log.cf("HorizData : " + Log.arrOut(Moira.mri.data.getHorizData()));
			double[] loc_db = new double[5];
			Moira.mri.data.getLocation(loc_db);
			Log.cf("Location(�g�n��?) : " + Log.arrOut(loc_db));
			Log.cf("MergeName : " + Moira.mri.data.getMergeName("name1", "name2"));
			Log.cf("MonthLimit(�뭭@1��) : " + Moira.mri.data.getMonthLimit(1, ","));
			Log.cf("MonthLimit(�뭭@40��) : " + Moira.mri.data.getMonthLimit(40, ","));
			Log.cf("MountainPos(true) : " + Moira.mri.data.getMountainPos(true));
			Log.cf("MountainPos(false) : " + Moira.mri.data.getMountainPos(false));
			Log.cf("NoColor : " + Moira.mri.data.getNoColor());
			Log.cf("OverridenStatus : " + Moira.mri.data.getOverridenStatus());
			Log.cf("OverrideString : " + Moira.mri.data.getOverrideString());
			Log.cf("OrderArray : " + Log.arrOut(Moira.mri.data.getOrderArray()));
			Log.cf("PlanetOffset : " + Moira.mri.data.getPlanetOffset(0, 0));
		}
		if (selector.contains("3")) {
			Log.cf("PlanetPos of birth");
			Log.cf("PlanetPos(0) : " + Moira.mri.data.getPlanetPos(0, Moira.mri.result.birth_sign_pos[0])); // �ĤG�ӶǤJ�Ѽ�degree�H���c�Ǥ��׬��l�@360��
			Log.cf("PlanetPos(1) : " + Moira.mri.data.getPlanetPos(1, Moira.mri.result.birth_sign_pos[1]));
			Log.cf("PlanetPos(2) : " + Moira.mri.data.getPlanetPos(2, Moira.mri.result.birth_sign_pos[2]));
			Log.cf("PlanetPos(3) : " + Moira.mri.data.getPlanetPos(3, Moira.mri.result.birth_sign_pos[3]));
			Log.cf("PlanetPos(4) : " + Moira.mri.data.getPlanetPos(4, Moira.mri.result.birth_sign_pos[4]));
			Log.cf("PlanetPos(5) : " + Moira.mri.data.getPlanetPos(5, Moira.mri.result.birth_sign_pos[5]));
			Log.cf("PlanetPos(6) : " + Moira.mri.data.getPlanetPos(6, Moira.mri.result.birth_sign_pos[6]));
			Log.cf("PlanetPos(7) : " + Moira.mri.data.getPlanetPos(7, Moira.mri.result.birth_sign_pos[7]));
			Log.cf("PlanetPos(8) : " + Moira.mri.data.getPlanetPos(8, Moira.mri.result.birth_sign_pos[8]));
			Log.cf("PlanetPos(9) : " + Moira.mri.data.getPlanetPos(9, Moira.mri.result.birth_sign_pos[9]));
			Log.cf("PlanetPos(10) : " + Moira.mri.data.getPlanetPos(10, Moira.mri.result.birth_sign_pos[10]));
			Log.cf("PlanetPos(11) : " + Moira.mri.data.getPlanetPos(11, Moira.mri.result.birth_sign_pos[11]));
			Log.cf("PlanetPos(12) : " + Moira.mri.data.getPlanetPos(12, Moira.mri.result.birth_sign_pos[12]));
			Log.cf("PlanetPos(13) : " + Moira.mri.data.getPlanetPos(13, Moira.mri.result.birth_sign_pos[13]));
			Log.cf("PlanetPos(14) : " + Moira.mri.data.getPlanetPos(14, Moira.mri.result.birth_sign_pos[14]));
			Log.cf("PlanetPos(15) : " + Moira.mri.data.getPlanetPos(15, Moira.mri.result.birth_sign_pos[15]));
			Log.cf("PlanetPos(16) : " + Moira.mri.data.getPlanetPos(16, Moira.mri.result.birth_sign_pos[16]));
			Log.cf("PlanetPos(17) : " + Moira.mri.data.getPlanetPos(17, Moira.mri.result.birth_sign_pos[17]));
			Log.cf("PlanetPos(18) : " + Moira.mri.data.getPlanetPos(18, Moira.mri.result.birth_sign_pos[18]));
			Log.cf("PlanetPos(19) : " + Moira.mri.data.getPlanetPos(19, Moira.mri.result.birth_sign_pos[19]));
			Log.cf("PlanetPos(20) : " + Moira.mri.data.getPlanetPos(20, Moira.mri.result.birth_sign_pos[20]));
			Log.cf("PlanetPos(21) : " + Moira.mri.data.getPlanetPos(21, Moira.mri.result.birth_sign_pos[21]));
			Log.cf("PlanetPos of now");
			Log.cf("PlanetPos(0) : " + Moira.mri.data.getPlanetPos(0, Moira.mri.result.now_sign_pos[0])); // �ĤG�ӶǤJ�Ѽ�degree�H���c�Ǥ��׬��l�@360��
			Log.cf("PlanetPos(1) : " + Moira.mri.data.getPlanetPos(1, Moira.mri.result.now_sign_pos[1]));
			Log.cf("PlanetPos(2) : " + Moira.mri.data.getPlanetPos(2, Moira.mri.result.now_sign_pos[2]));
			Log.cf("PlanetPos(3) : " + Moira.mri.data.getPlanetPos(3, Moira.mri.result.now_sign_pos[3]));
			Log.cf("PlanetPos(4) : " + Moira.mri.data.getPlanetPos(4, Moira.mri.result.now_sign_pos[4]));
			Log.cf("PlanetPos(5) : " + Moira.mri.data.getPlanetPos(5, Moira.mri.result.now_sign_pos[5]));
			Log.cf("PlanetPos(6) : " + Moira.mri.data.getPlanetPos(6, Moira.mri.result.now_sign_pos[6]));
			Log.cf("PlanetPos(7) : " + Moira.mri.data.getPlanetPos(7, Moira.mri.result.now_sign_pos[7]));
			Log.cf("PlanetPos(8) : " + Moira.mri.data.getPlanetPos(8, Moira.mri.result.now_sign_pos[8]));
			Log.cf("PlanetPos(9) : " + Moira.mri.data.getPlanetPos(9, Moira.mri.result.now_sign_pos[9]));
			Log.cf("PlanetPos(10) : " + Moira.mri.data.getPlanetPos(10, Moira.mri.result.now_sign_pos[10]));
			Log.cf("PlanetPos(11) : " + Moira.mri.data.getPlanetPos(11, Moira.mri.result.now_sign_pos[11]));
			Log.cf("PlanetPos(12) : " + Moira.mri.data.getPlanetPos(12, Moira.mri.result.now_sign_pos[12]));
			Log.cf("PlanetPos(13) : " + Moira.mri.data.getPlanetPos(13, Moira.mri.result.now_sign_pos[13]));
			Log.cf("PlanetPos(14) : " + Moira.mri.data.getPlanetPos(14, Moira.mri.result.now_sign_pos[14]));
			Log.cf("PlanetPos(15) : " + Moira.mri.data.getPlanetPos(15, Moira.mri.result.now_sign_pos[15]));
			Log.cf("PlanetPos(16) : " + Moira.mri.data.getPlanetPos(16, Moira.mri.result.now_sign_pos[16]));
			Log.cf("PlanetPos(17) : " + Moira.mri.data.getPlanetPos(17, Moira.mri.result.now_sign_pos[17]));
			Log.cf("PlanetPos(18) : " + Moira.mri.data.getPlanetPos(18, Moira.mri.result.now_sign_pos[18]));
			Log.cf("PlanetPos(19) : " + Moira.mri.data.getPlanetPos(19, Moira.mri.result.now_sign_pos[19]));
			Log.cf("PlanetPos(20) : " + Moira.mri.data.getPlanetPos(20, Moira.mri.result.now_sign_pos[20]));
			Log.cf("PlanetPos(21) : " + Moira.mri.data.getPlanetPos(21, Moira.mri.result.now_sign_pos[21]));
			Log.cf("getYearInfo() : " + Moira.mri.data.getYearInfo(true,Moira.mri.result.birth_table));
			Log.cf(Moira.mri.getYearShaStar("�ѸS",false));
		}
		if (selector.contains("4")) {
			Log.cf("PoleDateData : " + Log.arrOut(Moira.mri.data.getPoleDateData(1984, "�Ҥl")));
			Log.cf("ShowAspects : " + Moira.mri.data.getShowAspects());
			Log.cf("ShowFixstar : " + Moira.mri.data.getShowFixstar());
			Log.cf("ShowGauquelin : " + Moira.mri.data.getShowGauquelin());
			Log.cf("ShowHoriz : " + Moira.mri.data.getShowHoriz());
			Log.cf("ShowNow : " + Moira.mri.data.getShowNow());
			Log.cf("SmallLimit(�p��@1��) : " + Moira.mri.data.getSmallLimit(1, ","));
			Log.cf("SolidHouse : " + Moira.mri.data.getSolidHouse("�l"));
			Log.cf("SearchResult : "
					+ Log.arrOut(Moira.mri.data.getSearchResult("�x�W", "�x�_", "Asia/Taipei", "mode_name", true)));
			Log.cf("SignArray(����ѬP) : " + Log.arrOut(Moira.mri.data.getSignArray()));
			Log.cf("SignDegreeShiftArray : " + Log.arrOut(Moira.mri.data.getSignDegreeShiftArray()));
			Log.cf("SignDisplayArray : " + Log.arrOut(Moira.mri.data.getSignDisplayArray()));
			Log.cf("SignRevFlipArray : " + Log.arrOut(Moira.mri.data.getSignRevFlipArray()));
			Log.cf("SpeedColorArray : " + Log.arrOut(Moira.mri.data.getSpeedColorArray(false)));
			Log.cf("StateColorArray : " + Log.arrOut(Moira.mri.data.getStateColorArray()));
			Log.cf("TransitData : " + Log.arrOut(Moira.mri.data.getTransitData(null, "�x�W", "�x�_", "Asia/Taipei", 0)));
			Log.cf("WeakHouse : " + Moira.mri.data.getWeakHouse("�l"));
			Log.cf("WallTime : " + Moira.mri.data.getWallTime(0, "�x�W", "�x�_", "Asia/Taipei"));
			Log.cf("YearInfo(�Ȧ~����) : " + Moira.mri.data.getYearInfo(true, new Hashtable()));
			Log.cf("\n�H�U�OChartData��Private�Ѽ�\n============================================================");
			Log.cf("birth_sign_pos : " + Log.arrOut(Moira.mri.result.birth_sign_pos)); // birth_sign_pos[planet_no]
		}
		Log.CloseLogFile();

	}
}

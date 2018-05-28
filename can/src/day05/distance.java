package day05;

public class distance {

	public static void main(String[] args) {

//		System.out.println(distance(50.038783, 8.562088, 50.117329, 8.680174, 'K') + " km");
		// Math.round(distance(50.038783, 8.562088, 50.117329, 8.680174, 'K')) 반올림
		// 프랑크푸르트 공항 50.038783, 8.562088
		// 플래밍스 호텔 50.117329, 8.680174
		// 프라이부르크 대성당 47.995598, 7.852781
		// 취리히 스위스 국립박물관 47.379057, 8.540548
		// 루체른 빈사의 사자상 47.058580, 8.310928
		// 스위스 루커버드 온천호텔 46.378313, 7.629762
		// 독일 슈투트가르트 벤츠 박물관 48.788149, 9.233980
		// 각각의 목적지 배열로
		// thread.sleep 시간 100초
		
		double seq[][] = new double[13][2];
		seq[0][0] = 50.038783;
		seq[0][1] = 8.562088;

		seq[1][0] = 50.056349;
		seq[1][1] = 8.584650;

		seq[2][0] = 50.071651;
		seq[2][1] = 8.613065;

		seq[3][0] = 50.097830;
		seq[3][1] = 8.612246;

		seq[4][0] = 50.109439;
		seq[4][1] = 8.602484;

		seq[5][0] = 50.120454;
		seq[5][1] = 8.595144;

		seq[6][0] = 50.132630;
		seq[6][1] = 8.590465;

		seq[7][0] = 50.131598;
		seq[7][1] = 8.608065;
		seq[8][0] = 50.134308;
		seq[8][1] = 8.634683;
		seq[9][0] = 50.132718;
		seq[9][1] = 8.647632;
		seq[10][0] = 50.131496;
		seq[10][1] = 8.666972;
		seq[11][0] = 50.123950;
		seq[11][1] = 8.675332;
		seq[12][0] = 50.117286;
		seq[12][1] = 8.680175;
		
		System.out.println(distance(seq[0][0], seq[0][1], seq[1][0], seq[1][1], 'K')+"km");
		
	}

	public static double distance(double lat1, double lon1, double lat2, double lon2, char unit) {
		double theta = lon1 - lon2;
		double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2))
				+ Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
		dist = Math.acos(dist);
		dist = rad2deg(dist);
		dist = dist * 60 * 1.1515; // 기본 마일
		if (unit == 'K') {
			dist = dist * 1.609344;
		} else if (unit == 'N') {
			dist = dist * 0.8684;
		}
		return dist;
	}

	public static double deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
	}

	public static double rad2deg(double rad) {
		return (rad * 180 / Math.PI);
	}
}

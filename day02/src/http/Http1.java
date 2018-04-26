package http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

public class Http1 {

	public static void main(String[] args) throws UnknownHostException {
		// InetAddress ia =null;
		// ia = InetAddress.getByName("localhost");
		// System.out.println(ia.getHostAddress());
		// System.out.println(ia.getHostName());

		URL url = null;
		String address = "http://localhost/";
		try {
			url = new URL(address);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		InputStreamReader in = null;
		// 한글처리 문제로 InputStreamReader를 꼭 써야함 단어단위로 읽음
		BufferedReader br = null;
		StringBuffer sb = new StringBuffer(); // 값을 변경하기 위해서 사용함
		String str = ""; // String은 기존에 만들면 다른 값으로 변경할 수 없다
		try {

			in = new InputStreamReader(url.openStream());
			br = new BufferedReader(in);
			while (true) {
				str = br.readLine();
				if (str == null) {
					break;
				}
				sb.append(str + "\n");
				
			}
			// 예외가 발생하면 실행되지 않기 떄문에 finally로 넘어가서 종료되게 설정
//			br.close();
//			System.out.println(sb);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(sb.toString());
	}

}

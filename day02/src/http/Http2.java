package http;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class Http2 {

	public static void main(String[] args) throws Exception {
		// webserver가 존재하고 http 프로토콜로 요청
		String name = "태우";
		name = URLEncoder.encode(name,"UTF-8");
		String surl = "http://127.0.0.1/login?id=qq&pwd=11&name="+name;
		URL url = new URL(surl);
		URLConnection con = url.openConnection();
		con.setConnectTimeout(5000);
		InputStream in = con.getInputStream();
		InputStreamReader ir = new InputStreamReader(in, "UTF-8");
		BufferedReader br = new BufferedReader(ir);

		String str = br.readLine();
		System.out.println(str);
		br.close();
	}

}

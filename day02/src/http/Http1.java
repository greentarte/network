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
		// �ѱ�ó�� ������ InputStreamReader�� �� ����� �ܾ������ ����
		BufferedReader br = null;
		StringBuffer sb = new StringBuffer(); // ���� �����ϱ� ���ؼ� �����
		String str = ""; // String�� ������ ����� �ٸ� ������ ������ �� ����
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
			// ���ܰ� �߻��ϸ� ������� �ʱ� ������ finally�� �Ѿ�� ����ǰ� ����
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

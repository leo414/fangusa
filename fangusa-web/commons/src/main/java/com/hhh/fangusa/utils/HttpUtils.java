package com.hhh.fangusa.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtils {
    private static final Logger logger = LoggerFactory.getLogger(HttpUtils.class);
    private static final int CONNECT_TIMEOUT = 1000;
    private static final int READ_TIMEOUT = 3000;

    public static String getHTMLByPOST(String url, String content) throws IOException {
        String responseContent = "";
        URL u = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) u.openConnection();
        conn.setRequestProperty("Charset", "UTF-8");
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Length", String.valueOf(content.getBytes().length));
        conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setUseCaches(false);
        try {
            conn.connect();
            DataOutputStream out = new DataOutputStream(conn.getOutputStream());
            out.writeBytes(content);
            out.flush();
            out.close();

            InputStream inputStream = conn.getInputStream();
            responseContent = getResponseContent(inputStream);
            return responseContent;
        } finally {
            conn.disconnect();
        }
    }

    public static String getHTML(String url) throws IOException {
        String responseContent = "";
        URL u = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) u.openConnection();
        try {
            conn.setConnectTimeout(CONNECT_TIMEOUT);
            conn.setReadTimeout(READ_TIMEOUT);

            InputStream inputStream = conn.getInputStream();

            responseContent = getResponseContent(inputStream);

            return responseContent;
        } finally {
            conn.disconnect();
        }
    }

    public static String getHTMLEncode(String url) throws IOException {
        String responseContent = "";
        url = urlEncode(url);
        URL u = new URL(url);
        System.out.println(url);
        HttpURLConnection conn = (HttpURLConnection) u.openConnection();
        try {
            InputStream inputStream = conn.getInputStream();

            responseContent = getResponseContent(inputStream);

            return responseContent;
        } finally {
            conn.disconnect();
        }
    }

    private static String urlEncode(String url) {
        StringBuilder sb = new StringBuilder();
        String[] temp = url.split("\\?");
        if (temp.length > 1) {
            sb.append(temp[0]);
            sb.append("?");
            String[] temp2 = temp[1].split("&");
            for (String tmp2 : temp2) {
                String[] temp3 = tmp2.split("=");
                if (temp3.length > 1) {
                    sb.append(temp3[0]);
                    sb.append("=");
                    if (temp3[1].contains(" ")) {
                        sb.append(java.net.URLEncoder.encode(temp3[1]));
                    } else {
                        sb.append(temp3[1]);
                    }
                    sb.append("&");
                } else {
                    sb.append(tmp2);
                    sb.append("&");
                }
            }
            if (sb.charAt(sb.length() - 1) == '&') {
                return sb.substring(0, sb.length() - 1);
            } else {
                return sb.toString();
            }

        } else {
            return url;
        }
    }

    public static String getHTML(String url, String auth) throws IOException {
        String responseContent = "";
        URL u = new URL(url);

        HttpURLConnection conn = (HttpURLConnection) u.openConnection();
        conn.setConnectTimeout(CONNECT_TIMEOUT);
        conn.setReadTimeout(READ_TIMEOUT);
        conn.setRequestProperty("Authorization", auth);
        conn.connect();
        try {
            InputStream inputStream = conn.getInputStream();

            responseContent = getResponseContent(inputStream);

            return responseContent;
        } finally {
            conn.disconnect();
        }
    }

    private static String getResponseContent(InputStream inputStream) throws IOException {
        BufferedReader reader = null;
        try {
            String line = null;
            StringBuffer buffer = new StringBuffer();
            reader = new BufferedReader(new InputStreamReader(inputStream));
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
            return buffer.toString();
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }

    @SuppressWarnings("deprecation")
    public static void main(String[] args) throws IOException {
//        String url = "http://api.accuweather.com/locations/v1/search.json?q=%s&apiKey=ff1b463d98fb47af848ea2843ec5c925&language=en-us&details=true&alias=never";
//        String name = "Dongguang Village";
//        try {
//            String response = HttpUtils.getHTML(String.format(url, java.net.URLEncoder.encode(name)));
//            System.out.println(response);
//        } catch (ClientProtocolException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        String url = "http://weatherapi.market.xiaomi.com/wtr-v2/city/half?belongings=Al Hudaydah,Yemen&language=en_us&shortName=&imei=7fe171f0dcebed158232a6a81b38cac6&name=Al Hudaydah";
//        
//        try {
//            System.out.println(getHTMLEncode(url));
//        } catch (ClientProtocolException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }

        System.out.println(HttpUtils.getHTMLByPOST("http://permission.d.xiaomi.net/validate?requestPath=/theme-stats/theme&serviceId=33", ""));


//        String imei = "85c57d63ae0bdae86fcec96adae51e47";
//        String num = "99000310519597";
//        System.out.println(Md5Util.md5("99000310519597"));
//        if(imei.equals(Md5Util.md5("99000310519597"))){
//            System.out.println("sddfds");
//        }
    }
}

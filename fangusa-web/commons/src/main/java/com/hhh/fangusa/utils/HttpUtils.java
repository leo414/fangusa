package com.hhh.fangusa.utils;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    public static String urlEncode(String url) {
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

    public static final String getHttps(final String url, final Map<String, Object> params) {
        StringBuilder sb = new StringBuilder("");

        if (null != params && !params.isEmpty()) {
            int i = 0;
            for (String key : params.keySet()) {
                if (i == 0) {
                    sb.append("?");
                } else {
                    sb.append("&");
                }
                sb.append(key).append("=").append(params.get(key));
                i++;
            }
        }

        CloseableHttpClient httpClient = createSSLClientDefault();

        CloseableHttpResponse response = null;
        HttpGet get = new HttpGet(url + sb.toString());
        String result = "";

        try {
            response = httpClient.execute(get);

            if (response.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = response.getEntity();
                if (null != entity) {
                    result = EntityUtils.toString(entity, "UTF-8");
                }
            }
        } catch (IOException ex) {
            logger.error(null, ex);
        } finally {
            if (null != response) {
                try {
                    EntityUtils.consume(response.getEntity());
                } catch (IOException ex) {
                    logger.error(null, ex);
                }
            }
        }

        return result;
    }

    public static final String postHttps(final String url, final Map<String, Object> params) {
        CloseableHttpClient httpClient = createSSLClientDefault();
        HttpPost post = new HttpPost(url);

        CloseableHttpResponse response = null;

        if (null != params && !params.isEmpty()) {
            List<NameValuePair> nvpList = new ArrayList<NameValuePair>();
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                NameValuePair nvp = new BasicNameValuePair(entry.getKey(), entry.getValue().toString());
                nvpList.add(nvp);
            }
            post.setEntity(new UrlEncodedFormEntity(nvpList, Charset.forName("UTF-8")));
        }

        String result = "";

        try {
            response = httpClient.execute(post);

            if (response.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = response.getEntity();
                if (null != entity) {
                    result = EntityUtils.toString(entity, "UTF-8");
                }
            }
        } catch (IOException ex) {
            logger.error(null, ex);
        } finally {
            if (null != response) {
                try {
                    EntityUtils.consume(response.getEntity());
                } catch (IOException ex) {
                    logger.error(null, ex);
                }
            }
        }

        return result;
    }

    private static CloseableHttpClient createSSLClientDefault() {

        SSLContext sslContext;
        try {
            sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
                //信任所有
                @Override
                public boolean isTrusted(X509Certificate[] xcs, String string){
                    return true;
                }
            }).build();

            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext);

            return HttpClients.custom().setSSLSocketFactory(sslsf).build();
        } catch (KeyStoreException ex) {
            logger.error(null, ex);
        } catch (NoSuchAlgorithmException ex) {
            logger.error(null, ex);
        } catch (KeyManagementException ex) {
            logger.error(null, ex);
        }

        return HttpClients.createDefault();
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

        System.out.println(HttpUtils.getHttps("https://www.baidu.com", null));


//        String imei = "85c57d63ae0bdae86fcec96adae51e47";
//        String num = "99000310519597";
//        System.out.println(Md5Util.md5("99000310519597"));
//        if(imei.equals(Md5Util.md5("99000310519597"))){
//            System.out.println("sddfds");
//        }
    }
}

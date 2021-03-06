package com.taotaoti.common.httpclient;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.SocketTimeoutException;
import java.net.URLEncoder;
import java.nio.charset.CodingErrorAction;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.config.MessageConstraints;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.config.SocketConfig;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.taotaoti.common.utils.ObjToStringUtil;
import com.taotaoti.weather.vo.RequestWeatherVo;


public class HttpClientUtils {
	
	private final static Logger logger = LoggerFactory.getLogger(HttpClientUtils.class);
	
	private static PoolingHttpClientConnectionManager connManager = null;
	private static CloseableHttpClient httpclient = null;
	public final static int connectTimeout = 5000;
	
	private static CloseableHttpClient getDefaultHttpClient(){
		try {
			SSLContext sslContext = SSLContexts.custom().useTLS().build();
			sslContext.init(null,
			        new TrustManager[] { new X509TrustManager() {
						
			        	public X509Certificate[] getAcceptedIssuers() {
			                return null;
			            }

			            public void checkClientTrusted(
			                    X509Certificate[] certs, String authType) {
			            }

			            public void checkServerTrusted(
			                    X509Certificate[] certs, String authType) {
			            }
					}}, null);
			Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
		            .register("http", PlainConnectionSocketFactory.INSTANCE)
		            .register("https", new SSLConnectionSocketFactory(sslContext))
		            .build();
			
			connManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
			httpclient = HttpClients.custom().setConnectionManager(connManager).build();
			SocketConfig socketConfig = SocketConfig.custom().setTcpNoDelay(true).build();
			connManager.setDefaultSocketConfig(socketConfig);
	        MessageConstraints messageConstraints = MessageConstraints.custom()
	            .setMaxHeaderCount(200)
	            .setMaxLineLength(2000)
	            .build();
	        ConnectionConfig connectionConfig = ConnectionConfig.custom()
	            .setMalformedInputAction(CodingErrorAction.IGNORE)
	            .setUnmappableInputAction(CodingErrorAction.IGNORE)
	            .setCharset(Consts.UTF_8)
	            .setMessageConstraints(messageConstraints)
	            .build();
	        connManager.setDefaultConnectionConfig(connectionConfig);
			connManager.setMaxTotal(200);
			connManager.setDefaultMaxPerRoute(20);
		} catch (KeyManagementException e) {
			logger.error("KeyManagementException", e);
		} catch (NoSuchAlgorithmException e) {
			logger.error("NoSuchAlgorithmException", e);
		}
		return httpclient;
	}
	
	public void getDownloadData(String url,List<NameValuePair> params,String fileName) throws IOException {
        //生成一个httpclient对象
		getDefaultHttpClient();
		try {
			HttpPost httpost = new HttpPost(url);
			// 设置表单提交编码为UTF-8
			httpost.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
			HttpResponse response = httpclient.execute(httpost);
			HttpEntity entity = response.getEntity();
			StatusLine statusLine = response.getStatusLine();
			if (statusLine.getStatusCode() == 200) {
				File csv = new File("d:/sabrina/" + fileName + ".csv");
				FileOutputStream outputStream = new FileOutputStream(csv);
				InputStream inputStream = response.getEntity().getContent();
				System.out.println(response.getEntity().getContent());
				byte b[] = new byte[1024];
				int j = 0;
				while ((j = inputStream.read(b)) != -1) {
					outputStream.write(b, 0, j);
				}
				outputStream.flush();
				outputStream.close();
				System.out.println("data: " + fileName);
			}
			EntityUtils.consume(entity);
		} finally {
			httpclient.getConnectionManager().shutdown();
		}
	}
	@SuppressWarnings("deprecation")
	public static String invokeGet(String url, Map<String, String> params, String encode, int connectTimeout,
			int soTimeout) {
		getDefaultHttpClient();
		String responseString = null;
	    RequestConfig requestConfig = RequestConfig.custom()
	    		.setSocketTimeout(connectTimeout)
	    		.setConnectTimeout(connectTimeout)
	    		.setConnectionRequestTimeout(connectTimeout).build();
	    
		StringBuilder sb = new StringBuilder();
		sb.append(url);
		int i = 0;
		for (Entry<String, String> entry : params.entrySet()) {
			if (i == 0 && !url.contains("?")) {
				sb.append("?");
			} else {
				sb.append("&");
			}
			sb.append(entry.getKey());
			sb.append("=");
			String value = entry.getValue();
			try {
				sb.append(URLEncoder.encode(value, "UTF-8"));
			} catch (UnsupportedEncodingException e) {
				logger.warn("encode http get params error, value is "+value, e);
				sb.append(URLEncoder.encode(value));
			}
			i++;
		}
		logger.info("[HttpUtils Get] begin invoke:" + sb.toString());
		HttpGet get = new HttpGet(sb.toString());
		get.setConfig(requestConfig);
		
		try {
			CloseableHttpResponse response = httpclient.execute(get);
			try {
				HttpEntity entity = response.getEntity();
				try {
					if(entity != null){
						responseString = EntityUtils.toString(entity, encode);
					}
				} finally {
					if(entity != null){
						entity.getContent().close();
					}
				}
			} catch (Exception e) {
				logger.error(String.format("[HttpUtils Get]get response error, url:%s", sb.toString()), e);
				return responseString;
			} finally {
				if(response != null){
					response.close();
				}
			}
			logger.info(String.format("[HttpUtils Get]Debug url:%s , response string %s:", sb.toString(), responseString));
		} catch (SocketTimeoutException e) {
			logger.error(String.format("[HttpUtils Get]invoke get timout error, url:%s", sb.toString()), e);
			return responseString;
		} catch (Exception e) {
			logger.error(String.format("[HttpUtils Get]invoke get error, url:%s", sb.toString()), e);
		} finally {
			get.releaseConnection();
		}
		return responseString;
	}
	@SuppressWarnings("deprecation")
	public static String getHtmlBody(String url, Map<String, String> params) {
		getDefaultHttpClient();
		String responseString = null;
	    RequestConfig requestConfig = RequestConfig.custom()
	    		.setSocketTimeout(connectTimeout)
	    		.setConnectTimeout(connectTimeout)
	    		.setConnectionRequestTimeout(connectTimeout).build();
	    
		StringBuilder sb = new StringBuilder();
		sb.append(url);
		int i = 0;
		for (Entry<String, String> entry : params.entrySet()) {
			if (i == 0 && !url.contains("?")) {
				sb.append("?");
			} else {
				sb.append("&");
			}
			sb.append(entry.getKey());
			sb.append("=");
			String value = entry.getValue();
			try {
				sb.append(URLEncoder.encode(value, "UTF-8"));
			} catch (UnsupportedEncodingException e) {
				logger.warn("encode http get params error, value is "+value, e);
				sb.append(URLEncoder.encode(value));
			}
			i++;
		}
		logger.info("[HttpUtils Get] begin invoke:" + sb.toString());
		HttpGet get = new HttpGet(sb.toString());
		get.setConfig(requestConfig);
		
		try {
			CloseableHttpResponse response = httpclient.execute(get);
			try {
				HttpEntity entity = response.getEntity();
				try {
					if(entity != null){
						responseString = EntityUtils.toString(entity, "UTF-8");
					}
				} finally {
					if(entity != null){
						entity.getContent().close();
					}
				}
			} catch (Exception e) {
				logger.error(String.format("[HttpUtils Get]get response error, url:%s", sb.toString()), e);
				return responseString;
			} finally {
				if(response != null){
					response.close();
				}
			}
			logger.info(String.format("[HttpUtils Get]Debug url:%s , response string %s:", sb.toString(), responseString));
		} catch (SocketTimeoutException e) {
			logger.error(String.format("[HttpUtils Get]invoke get timout error, url:%s", sb.toString()), e);
			return responseString;
		} catch (Exception e) {
			logger.error(String.format("[HttpUtils Get]invoke get error, url:%s", sb.toString()), e);
		} finally {
			get.releaseConnection();
		}
		return responseString;
	}
	public static String getHtmlBody(String url) {
		getDefaultHttpClient();
		String responseString = null;
	    RequestConfig requestConfig = RequestConfig.custom()
	    		.setSocketTimeout(connectTimeout)
	    		.setConnectTimeout(connectTimeout)
	    		.setConnectionRequestTimeout(connectTimeout).build();
	    
		StringBuilder sb = new StringBuilder();
		sb.append(url);
		logger.info("[HttpUtils Get] begin invoke:" + sb.toString());
		HttpGet get = new HttpGet(sb.toString());
		get.setConfig(requestConfig);
		
		try {
			CloseableHttpResponse response = httpclient.execute(get);
			try {
				HttpEntity entity = response.getEntity();
				try {
					if(entity != null){
						responseString = EntityUtils.toString(entity, "UTF-8");
					}
				} finally {
					if(entity != null){
						entity.getContent().close();
					}
				}
			} catch (Exception e) {
				logger.error(String.format("[HttpUtils Get]get response error, url:%s", sb.toString()), e);
				return responseString;
			} finally {
				if(response != null){
					response.close();
				}
			}
			System.out.println(sb.toString());
			System.out.println(responseString);
			logger.info(String.format("[HttpUtils Get]Debug url:%s , response string %s:", sb.toString(), responseString));
		} catch (SocketTimeoutException e) {
			logger.error(String.format("[HttpUtils Get]invoke get timout error, url:%s", sb.toString()), e);
			return responseString;
		} catch (Exception e) {
			logger.error(String.format("[HttpUtils Get]invoke get error, url:%s", sb.toString()), e);
		} finally {
			get.releaseConnection();
		}
		return responseString;
	}
	
	/**
	 * HTTPS请求，默认超时为5S
	 * @param reqURL
	 * @param params
	 * @return
	 */
	public static String connectPostHttps(String reqURL, Map<String, String> params) {
		getDefaultHttpClient();
		String responseContent = null;
		
		HttpPost httpPost = new HttpPost(reqURL); 
		try {
			RequestConfig requestConfig = RequestConfig.custom()
		    		.setSocketTimeout(connectTimeout)
		    		.setConnectTimeout(connectTimeout)
		    		.setConnectionRequestTimeout(connectTimeout).build();
			List<NameValuePair> formParams = new ArrayList<NameValuePair>(); 
			httpPost.setEntity(new UrlEncodedFormEntity(formParams, Consts.UTF_8));
			httpPost.setConfig(requestConfig);
			// 绑定到请求 Entry
			for (Map.Entry<String, String> entry : params.entrySet()) {
				formParams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
			}
			CloseableHttpResponse response = httpclient.execute(httpPost);
			 try {
				// 执行POST请求
				HttpEntity entity = response.getEntity(); // 获取响应实体
				try {
					if (null != entity) {
						responseContent = EntityUtils.toString(entity, Consts.UTF_8);
					}
				} finally {
					if(entity != null){
						entity.getContent().close();
					}
				}
			} finally {
				if(response != null){
					response.close();
				}
			}
			logger.info("requestURI : "+httpPost.getURI()+", responseContent: " + responseContent);
		} catch (ClientProtocolException e) {
			logger.error("ClientProtocolException", e);
		} catch (IOException e) {
			logger.error("IOException", e);
		} finally {
			httpPost.releaseConnection();
		}
	    return responseContent;
		
	}
	public static void main(String[] args) {
		//HttpClientUtils.getHtmlBody("https://api.forecast.io/forecast/1a4fbce4b6f79f5715b2b1a3f9777d10/37.8267,-122.423");
	 //   String josn=	HttpClientUtils.getHtmlBody("https://api.forecast.io/forecast/1a4fbce4b6f79f5715b2b1a3f9777d10/37.8267,-122.423,2014-05-06T14:00:02");
		Gson gson=new Gson();
		//FightWeather fightWeather=gson.fromJson(josn, FightWeather.class);
		
		String josn=HttpClientUtils.getHtmlBody("https://api.flightstats.com/flex/weather/rest/v1/json/all/sfo?appId=c4daadf2&appKey=46aa77182c010799973f50085c877d71");
		RequestWeatherVo forecast=gson.fromJson(josn, RequestWeatherVo.class);
	
		System.out.println(ObjToStringUtil.objToString(forecast));
	}
}
package com.cris.website.util;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

public class CusAccessObjectUtil {

	private static String IP138_URL;

	/**
	 * 得到本机的外网ip，出现异常时返回本地IP
	 * 
	 * @return
	 */
	public static String getPublicIP() {
		String ip = null;
		try {
			ip = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		org.jsoup.nodes.Document doc = null;
		Connection con = null;
		// 连接 http://www.ip138.com
		con = Jsoup.connect(IP138_URL).timeout(5000);
		try {
			doc = con.get();
			// 获得包含本机ip的文本串：您的IP是：[xxx.xxx.xxx.xxx]
			org.jsoup.select.Elements els = doc.body().select("center");
			for (org.jsoup.nodes.Element el : els) {
				ip = el.text();
			}
			// 从文本串过滤出ip，用正则表达式将非数字和.替换成空串""
			ip = ip.replaceAll("[^0-9.]", "");
		} catch (IOException e) {
			e.printStackTrace();
			return ip;
		}
		return ip;
	}

	public String getIP138_URL() {
		return IP138_URL;
	}

	public void setIP138_URL(String iP138_URL) {
		IP138_URL = iP138_URL;
	}

}
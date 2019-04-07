package com.zk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zk.service.ZKCreate;
import com.zk.service.ZKGetData;
import com.zk.service.ZKSetData;

/**
 * @author NewsDLi
 */
@Controller
public class ZkController {

	private static final String PATH = "/FirstZnode";
	// zookeeper伪集群，因为使用的是同一个服务器搭建集群
	private static final String HOST = "10.45.81.137:2181,10.45.81.137:2182,10.45.81.137:2183";

	// 创建节点
	@RequestMapping(value = "/creatNote")
	@ResponseBody
	public String CreatNote() {
		ZKCreate zkCreate = new ZKCreate();
		zkCreate.ZKCreate(HOST, PATH);
		return "success";
	}

	// 通知节点
	@RequestMapping(value = "/noticeZk")
	@ResponseBody
	public String noticeZk() {
		ZKSetData zkCreate = new ZKSetData();
		zkCreate.NoticeZk(HOST, PATH);
		return "success";
	}

	// 获取节点数据
	@RequestMapping(value = "/getDateZk")
	@ResponseBody
	public String GetDateZk() {
		ZKGetData zkGetData = new ZKGetData();
		String getData = zkGetData.GetData(HOST, PATH);
		System.out.println(getData);
		return getData;
	}

}

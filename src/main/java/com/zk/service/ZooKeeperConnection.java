package com.zk.service;

import java.io.IOException;

import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.springframework.stereotype.Component;

/**
 * @description 链接zk
 * @author NewsDLi
 * @date 2019年3月11日15:30:25
 */
@Component
public class ZooKeeperConnection {

	// declare zookeeper instance to access ZooKeeper ensemble
	private ZooKeeper zoo;
	
	// Method to connect zookeeper ensemble.
	public ZooKeeper connect(String host) throws IOException {
		zoo = new ZooKeeper(host, 5000, new MyWatcher());
		return zoo;
	}
	
	public ZooKeeper connect(String host, Watcher watcher) throws IOException {
		zoo = new ZooKeeper(host, 5000, watcher);
		return zoo;
	}

	// Method to disconnect from zookeeper server
	public void close() throws InterruptedException {
		zoo.close();
	}
}

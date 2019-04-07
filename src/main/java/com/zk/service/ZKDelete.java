package com.zk.service;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;

/**
 * @description 删除节点
 * @author NewsDli
 * @date 2019年3月12日20:29:43
 */
public class ZKDelete {
	private static ZooKeeper zk;
	private static ZooKeeperConnection conn;

	// Method to check existence of znode and its status, if znode is available.
	public static void delete(String path) throws KeeperException, InterruptedException {
		zk.delete(path, zk.exists(path, true).getVersion());
	}

	public static void main(String[] args) throws InterruptedException, KeeperException {
		String path = "/MyFirstZnode"; // Assign path to the znode

		try {
			conn = new ZooKeeperConnection();
			zk = conn.connect("localhost");
			delete(path); // delete the node with the specified path
		} catch (Exception e) {
			System.out.println(e.getMessage()); // catches error messages
		}
	}
}

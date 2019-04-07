package com.zk.service;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

/**
 * @description 判断节点是否存在
 * @author NewsDli
 * @date 2019年3月12日20:29:43
 */
public class ZKExists {

	private static ZooKeeper zk;
	private static ZooKeeperConnection conn;

	// Method to check existence of znode and its status, if znode is available.
	public static Stat znode_exists(String path) throws KeeperException, InterruptedException {
		return zk.exists(path, true);
	}

	public static void main(String[] args) throws InterruptedException, KeeperException {
		String path = "/FirstZnode"; // Assign znode to the specified path

		try {
			conn = new ZooKeeperConnection();
			zk = conn.connect("10.45.81.137:2181");
			Stat stat = znode_exists(path); // Stat checks the path of the znode

			if (stat != null) {
				System.out.println("Node exists and the node version is " + stat.getVersion());
			} else {
				System.out.println("Node does not exists");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage()); // Catches error messages
		}
	}
}

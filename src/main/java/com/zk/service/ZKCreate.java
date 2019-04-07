package com.zk.service;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

/**
 * @description 创建节点
 * @author NewsDli
 * @date 2019年3月12日20:29:43
 */
public class ZKCreate{

	// znode path
	// Assign path to znode
	private final static String PATH = "/MyFirstZnode";

	// create static instance for zookeeper class.
	private static ZooKeeper zk;

	// create static instance for ZooKeeperConnection class.
	private static ZooKeeperConnection conn;

	// Method to create znode in zookeeper ensemble
	public static void create(String path, byte[] data) throws KeeperException, InterruptedException {
		zk.create(path, data, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
	}
	
	public static Stat znode_exists(String path) throws KeeperException, InterruptedException {
		return zk.exists(path, true);
	}

	public void ZKCreate(String host, String path) {
		// data in byte array
		byte[] data = "My first zookeeper app".getBytes(); // Declare data
		try {
			conn = new ZooKeeperConnection();
			zk = conn.connect(host);
			if (znode_exists(path) != null){
				System.out.println("节点已经存在！");
				return;
			}
			create(PATH, data); // Create the data to the specified path
			conn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage()); // Catch error message
		}
	}
}

package com.zk.service;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;

/**
 * @description 更新节点中的数据
 * @author NewsDli
 * @date 2019年3月12日20:29:43
 */
public class ZKSetData {
	private static ZooKeeper zk;
	private static ZooKeeperConnection conn;

	// Method to update the data in a znode. Similar to getData but without
	// watcher.
	public static void update(String path, byte[] data) throws KeeperException, InterruptedException {
		zk.setData(path, data, zk.exists(path, true).getVersion());
	}

	public void NoticeZk(String host, String path){
		byte[] data = String.valueOf(System.currentTimeMillis()).getBytes(); // Assign data which is to be updated.
		try {
			conn = new ZooKeeperConnection();
			zk = conn.connect(host);
			update(path, data); // Update znode data to the specified path
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

package com.zk.service;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

/**
 * @description 获取子节中的数据
 * @author NewsDli
 * @date 2019年3月12日20:29:43
 */
public class ZKGetData {
	
	private static ZooKeeper zk;
	private static ZooKeeperConnection conn;
	
	private static Watcher watcher = new MyWatcher();

	public static Stat znode_exists(String path) throws KeeperException, InterruptedException {
		return zk.exists(path, true);
	}
	
	public String GetData(String host, String path){
		try {
			conn = new ZooKeeperConnection();
			zk = conn.connect(host);
			Stat stat = znode_exists(path);

			if (stat != null) {
				byte[] b = zk.getData(path, watcher, null);
				String data = new String(b, "UTF-8");
				return data;

			} else {
				System.out.println("Node does not exists");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

}

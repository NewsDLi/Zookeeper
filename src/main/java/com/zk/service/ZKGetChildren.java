package com.zk.service;

import java.util.List;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

/**
 * @description 获取子节点
 * @author NewsDli
 * @date 2019年3月12日20:29:43
 */
public class ZKGetChildren {
	private static ZooKeeper zk;
	private static ZooKeeperConnection conn;

	// Method to check existence of znode and its status, if znode is available.
	public static Stat znode_exists(String path) throws KeeperException, InterruptedException {
		return zk.exists(path, true);
	}

	public static void main(String[] args) throws InterruptedException,KeeperException {
	      String path = "/FirstZnode"; // Assign path to the znode
			
	      try {
	         conn = new ZooKeeperConnection();
	         zk = conn.connect("10.45.81.137:2181");
	         Stat stat = znode_exists(path); // Stat checks the path

	         if(stat!= null) {

	            //“getChildren" method- get all the children of znode.It has two args, path and watch
	            List <String> children = zk.getChildren(path, false);
	            for(int i = 0; i < children.size(); i++)
	            System.out.println(children.get(i)); //Print children's
	         } else {
	            System.out.println("Node does not exists");
	         }

	      } catch(Exception e) {
	         System.out.println(e.getMessage());
	      }

	   }
}

package com.zk.service;

import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.springframework.stereotype.Component;

/**
 * @description zk的监听，例如setData改变zk中的数据，这里就会监听到(we.getType() == Event.EventType.NodeDataChanged)，我们以此可以进行对应的操作
 * @author NewsDLi
 * @date 2019年3月12日20:28:23
 */
@Component
public class MyWatcher implements Watcher{
	
	final CountDownLatch connectedSignal = new CountDownLatch(1);
	
	@Override
	public void process(WatchedEvent we) {
		System.out.println("=================");
		System.out.println("=================");
		System.out.println("=================");
		if (we.getType() == Event.EventType.NodeDataChanged){
			// 当节点中的数据被改变之后，我们可以在这里进行数据的相关操作，比如：solr数据的同步
			System.out.println("被改变的节点：" + we.getPath() + "|||被改变的类型：" +we.getType());
			System.out.println("节点信息被改变！！");
		}
		if (we.getState() == KeeperState.SyncConnected) {
//			connectedSignal.countDown();
		}
		if (we.getType() == Event.EventType.None) {
			switch (we.getState()) {
			case Expired:
				connectedSignal.countDown();
				break;
			}

		}
	
	}

}

package carry.分布式服务治理专题.zookeeper.api;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

public class CuratorDemo {

    private static String CONNECTION_STR="localhost:2181";
    public static void main(String[] args) throws Exception {

        CuratorFramework curatorFramework= CuratorFrameworkFactory.builder().
                connectString(CONNECTION_STR).sessionTimeoutMs(5000).
                retryPolicy(new ExponentialBackoffRetry(1000,3)).build();
        curatorFramework.start(); //启动
        createData(curatorFramework);
    }

    private static void createNode(CuratorFramework curatorFramework) throws Exception {

        curatorFramework.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT).forPath("/data","test".getBytes());
    }


    private static void createData(CuratorFramework curatorFramework) throws Exception {
        curatorFramework.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT).
                forPath("/data/program","test".getBytes());

    }


}

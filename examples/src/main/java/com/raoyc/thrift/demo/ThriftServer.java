package com.raoyc.thrift.demo;


import com.raoyc.thrift.demo.service.PingService;
import com.raoyc.thrift.demo.service.impl.PingServiceImpl;
import org.apache.thrift.TProcessor;
import org.apache.thrift.TMultiplexedProcessor;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.TThreadedSelectorServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.server.TServer;

public class ThriftServer {

    public static final int SERVER_PORT = 50000;

    public static void main(String [] args) {
        ThriftServer server = new ThriftServer();
        server.startThriftServer();
    }

    public void startThriftServer() {
        try {
            TProcessor tprocessor = new PingService.Processor<PingService.Iface>(new PingServiceImpl());
            // 传输通道 - 非阻塞方式
            TNonblockingServerSocket serverTransport = new TNonblockingServerSocket(SERVER_PORT);
            // 多线程半同步半异步
            TThreadedSelectorServer.Args tArgs = new TThreadedSelectorServer.Args(serverTransport);
            tArgs.processor(tprocessor);
            tArgs.transportFactory(new TFramedTransport.Factory());
            // 二进制协议
            tArgs.protocolFactory(new TCompactProtocol.Factory());
            /*
            链式调用方式
            TThreadedSelectorServer.Args tArgs =
            new TThreadedSelectorServer.Args(new TNonblockingServerSocket(SERVER_PORT))
                .processor(tprocessor)
                .transportFactory(new TFramedTransport.Factory())
                .protocolFactory(new TCompactProtocol.Factory());
            */

            // 多线程半同步半异步的服务模型
            TServer server = new TThreadedSelectorServer(tArgs);

            System.out.println("ThreadedSelectorServer start....");
            server.serve(); // 启动服务

            /*
            作者：slimina
            来源：CSDN
            原文：https://blog.csdn.net/zhu_tianwei/article/details/44115297
            版权声明：本文为博主原创文章，转载请附上博文链接！
            */
        } catch (Exception e) {
            System.out.println("Exception:\n" + e.getStackTrace());
        }
    }
}

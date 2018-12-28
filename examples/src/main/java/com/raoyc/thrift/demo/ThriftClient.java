package com.raoyc.thrift.demo;

import com.raoyc.thrift.demo.service.PingService;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

public class ThriftClient {

    public static final String SERVER_IP = "127.0.0.1";

    public static final int SERVER_PORT = 50000;

    public static final int TIMEOUT = 30000;

    public void startThriftClient() {
        TTransport transport = null;
        try {
            transport = new TFramedTransport(new TSocket(SERVER_IP, SERVER_PORT, TIMEOUT));
            // 协议要和服务端一致
            TProtocol protocol = new TCompactProtocol(transport);
            PingService.Client client = new PingService.Client(protocol);
            transport.open();
            System.out.println(client.ping());
            client.say("Hello from Java");
            System.out.println("Client say by " + this.getClass() + '@' + this.hashCode());
        } catch (TTransportException e) {
            e.printStackTrace();
        } catch (TException e) {
            e.printStackTrace();
        } finally {
            if (null != transport) {
                transport.close();
            }
        }
    }

    public static void main(String[] args) {
        ThriftClient client = new ThriftClient();
        client.startThriftClient();
    }

}

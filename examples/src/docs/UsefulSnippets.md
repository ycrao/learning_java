有用的代码片段
------

### 获取内网IP

通过 `socket` 方式，最有可能找到出口路由的内网 `IP` ，避免获取到诸如 `docker` 与 `VM` 等软件网卡的 `IP` 地址 。

```java

package com.raoyc.util;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class GetLocalAddress {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket();
        // 这里 192.168.0.1 为内网网关地址；如果该机器有公网权限，可改成 www.baidu.com 之类的域名；如果该机器位于云服务器集群中，可以使用跳板机或者数据库内网 ip
        socket.connect(new InetSocketAddress("192.168.0.1", 80));
        System.out.println(socket.getLocalAddress());
        socket.close();
    }
}
```


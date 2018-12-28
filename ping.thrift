namespace java com.raoyc.thrift.demo.service
service PingService {
    string ping(),
    void say(1:string msg)
}
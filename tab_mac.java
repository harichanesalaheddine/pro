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
public class tab_mac {

public static StringBuilder []   tab_mac =new  StringBuilder [100];
public static String []   tab_ip =new String [100];
public static int  i_mac=0;
public static int  i_ip=0;













public static void set_mac(byte [] bytes)
{
    
byte [] bytesss=bytes;
StringBuilder sb = new StringBuilder(18);
    for (byte b :bytesss) {
        if (sb.length() > 0)
            sb.append(':');
        sb.append(String.format("%02x", b));}
int dina=0;


for(int i=0;i<i_ip;i++)
if(tab_mac[i].toString().equalsIgnoreCase(sb.toString())!=true)
dina++;

if(dina==i_mac)
{
 tab_mac[i_mac]=sb;
i_mac++;

}


}











 public static StringBuilder  get_mac(byte [] bytes)
{
byte [] bytesss=bytes;
StringBuilder sb = new StringBuilder(18);
    for (byte b :bytesss) {
        if (sb.length() > 0)
            sb.append(':');
        sb.append(String.format("%02x", b));}

for(int i=0;i<i_mac;i++){
System.out.println("tab_mac>>>>"+tab_mac[i]+"          sb>>>>"+sb);
String ch1=new String();
ch1=sb.toString();


if(tab_mac[i].toString().equalsIgnoreCase(ch1))
return sb;
}
System.out.println("ladress  introdui  n'exist   pas "); 
return null;



}





public static byte[] get_mac_byte(String x)
{
//String mac=x.toString();
String mac=x;
		String[] macAddressParts = mac.split(":");
		
	
		byte[] macAddressBytes = new byte[6];
		for(int i=0; i<6; i++){
		    Integer hex = Integer.parseInt(macAddressParts[i],16);
                   
		    macAddressBytes[i] = hex.byteValue();}
return macAddressBytes;
}





public static void   set_ip(byte [] ip)
{
byte []bytes=ip;
int ii = 4;
        String ipAddress = "";
        for (byte raw : bytes)
        {
            ipAddress += (raw & 0xFF);
            if (--ii > 0)
            {
                ipAddress += ".";
            }
        }

int dina=0;


for(int i=0;i<i_ip;i++)
if(tab_ip[i].toString().equalsIgnoreCase(ipAddress)!=true)
dina++;

if(dina==i_ip)
{
 tab_ip[i_ip]=ipAddress;
i_ip++;

}






}






public static String get_ip(byte [] ip)
{
byte []bytes=ip;
int ii = 4;
        String ipAddress = "";
        for (byte raw : bytes)
        {
            ipAddress += (raw & 0xFF);
            if (--ii > 0)
            {
                ipAddress += ".";
            }
        }
for(int i=0;i<=i_ip;i++){
if(    tab_ip[i].toString().equalsIgnoreCase( ipAddress))
return ipAddress;}
System.out.println("ladres ip nexist pa sadi9");
return null;

}
public static void main(String []args)
{











}
}
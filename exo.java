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





public  class exo{
public static void main(String [] args)
{


try{










/*  how convert  ad ip normal   ver  ad ip   byte  pske */
InetAddress ip = InetAddress.getByName("192.168.2.1");
byte[] bytes = ip.getAddress();
for (byte b : bytes) 
    System.out.println(b +"& 0xFF");



 System.out.println("macccccccccccccccccccccccccccccccccccccccccccccccccccccccccc");


/* convert  ad mac normal  ver adress mac  byte */

byte[] broadcast=new byte[]{(byte)255,(byte)255,(byte)255,(byte)255,(byte)255,(byte)255};
for(byte b:broadcast)
System.out.println(b);
System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                String mac="0c:84:dc:36:05:20";
		String[] macAddressParts = mac.split(":");
		for(String s:macAddressParts)
                System.out.println(s);
		// convert hex string to byte values
		byte[] macAddressBytes = new byte[6];
		for(int i=0; i<6; i++){
		    Integer hex = Integer.parseInt(macAddressParts[i],16);
                   
		    macAddressBytes[i] = hex.byteValue();
                     System.out.println("byte esttttttttt"+ macAddressBytes[i]);
                     //String decoded = new String( macAddressBytes[i], "UTF-8");
                String ch=new String(macAddressBytes, "UTF-8"); 
                 System.out.println("ch"+ch);
		}
		
		

System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");


//convert  mac byte aray to  mac visible
StringBuilder sb = new StringBuilder(18);
    for (byte b : macAddressBytes) {
        if (sb.length() > 0)
            sb.append(':');
        sb.append(String.format("%02x", b));}
System.out.println("sbbbbbbbbbbbbbbbbbbb"+sb);


InetAddress bb;

        bb=InetAddress.getLocalHost();
        bytes=bb.getAddress();
               

//convert  ip adress  byte aray to ip  lisible




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

       System.out.println("ladres ip  de  host est"+ipAddress);	
System.out.println( "host adres  esr "+bb.getHostAddress()
                     +"host name est"+   bb.getHostName());
}
catch(Exception E)
{
}

 





}}
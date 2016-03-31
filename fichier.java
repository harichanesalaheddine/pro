import java.io.*;

public class fichier {
   public   void ip_mac_gw()            throws IOException
   {
     

      try {
           String gw=" ";
             String mac=" ";
         
         
         int c;
          BufferedReader br = new BufferedReader(new FileReader("/proc/net/route"));
           BufferedReader  o = new BufferedReader(new FileReader("/proc/net/arp"));
         
   
       String line;
    
int cont=0;
         while ((line = br.readLine()) != null){
          cont++;
          if(cont==2)
           {
           
           
  int i=0; String tab[]=line.split("");
         int t=0;
 for(int g=22;g>14;g-=2) {      

gw=gw+tab[g-1]+tab[g];
}

         }
        
         }
String digits = "0123456789ABCDEF";
 gw = gw.toUpperCase(); 
String ip=":"; 
int some=0;
int ccc=0;
 String sb[]  = new String[4];
 for (int i = 1; i < gw.length(); i+=2)
 {  c = gw.charAt(i);
 char cc=gw.charAt(i+1);
 int d = digits.indexOf(c); 
int dd = digits.indexOf(cc); 
some=d*16+dd; 

sb[ccc]=Integer.toString(some);
ccc++;
 } 
String chh=sb[0]+"."+sb[1]+"."+sb[2]+"."+sb[3];

 
mask.ip_gw=chh;

cont=0;
 while ((line = o.readLine()) != null)
{


     String tab[]=line.split(" ");
    
     
      


        
       
       if( tab[0].toString().equalsIgnoreCase(chh))
         mac=tab[22];
       
        
       
    
      }

mask.mac_gw=mac;

}
catch(Exception E)
{}

   }

}

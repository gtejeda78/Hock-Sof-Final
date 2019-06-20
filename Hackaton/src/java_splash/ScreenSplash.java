package java_splash;
import java.awt.*;
import java.awt.SplashScreen;
import org.jvnet.substance.SubstanceLookAndFeel;
import MVC.controlador.jfLogin;


/**
 * 
 * @author Tejeda Silva Gerardo
 */
public final class ScreenSplash {

  final SplashScreen splash ;
  //texto que se muestra a medida que se va cargando el screensplah
  final String[] texto = {""};

  public ScreenSplash() {
	 splash = SplashScreen.getSplashScreen();
  }

   public void animar()
   {
        if (splash != null)
        {
            Graphics2D g = splash.createGraphics();
            for(int i=1; i<100; i++)
            {                       
                float dash1[] = {2.0f};
                BasicStroke dashed = new BasicStroke(9.0f,BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER,5.0f, dash1, 0.0f);
                g.setStroke(dashed);
                g.setColor(Color.GREEN);//color de barra de progeso
                g.setColor( new Color(4,52,101));
                g.drawLine(205,314, 510, 314);                
                //se actualiza todo
                splash.update();
		try {
		 Thread.sleep(100);
		} catch(InterruptedException e) { }
            }
	   splash.close();
	}
        //una vez terminada la animación se muestra la aplicación principal
        
        
            jfLogin j = new jfLogin();
                                              
               jfLogin.setDefaultLookAndFeelDecorated(true);
                SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.RavenSkin");
                SubstanceLookAndFeel.setCurrentTheme("org.jvnet.substance.theme.SubstanceBarbyPinkTheme");
                SubstanceLookAndFeel.setCurrentWatermark("org.jvnet.substance.watermark.SubstanceBinaryWatermark");
              
                j.setBounds(430,50, j.getWidth(), j.getHeight());
                j.setResizable(false);
                j.setVisible(true);

   }
    
}

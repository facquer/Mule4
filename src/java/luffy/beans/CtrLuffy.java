/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luffy.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author angel
 */
@ManagedBean
@ViewScoped
public class CtrLuffy {

    private String urlYT = "https://www.youtube.com/embed/tgbNymZ7vqY";
    private boolean renderizado = false;
    private String cancion;
    private String letra;
    private String imagen;
    private Date fecha;
    private String top1;
    private String top2;
    private String top3;
    private String top4;
    private String top5;
    private String top6;
    private String top7;
    private String top8;
    private String top9;
    private String top10;
    private String urlDescarga;
    private String usuario;
    private String pass;
    private boolean login = false;

    public CtrLuffy() throws IOException {
    }

    public void login() {
        RequestContext req = RequestContext.getCurrentInstance();
        try {
            StringBuilder resultado2 = new StringBuilder();
            URL url2 = new URL("http://localhost:8081/login/" + this.usuario + "/" + this.pass);

            HttpURLConnection conexion2 = (HttpURLConnection) url2.openConnection();
            conexion2.setRequestMethod("GET");

            BufferedReader rd2 = new BufferedReader(new InputStreamReader(conexion2.getInputStream()));
            String linea2;

            while ((linea2 = rd2.readLine()) != null) {
                resultado2.append(linea2);
            }

            rd2.close();
            String resul = resultado2.toString();
            if (resul.equals("1")) {
                FacesContext context = FacesContext.getCurrentInstance();
                this.login = true;
                context.getExternalContext().redirect("luffyMusic.jsf");
                FacesMessage facesMessage = new FacesMessage("Bienvenid@");
                context.addMessage(null, facesMessage);

            } else {
                FacesContext facesContext = FacesContext.getCurrentInstance();
                FacesMessage facesMessage = new FacesMessage("Usuario y/o Contraseña invalidos");
                facesContext.addMessage(null, facesMessage);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void buscarTop() {
        try {
            StringBuilder resultado2 = new StringBuilder();
            this.cancion = this.cancion.replaceAll(" ", "%20");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String fechita = sdf.format(fecha);
            URL url2 = new URL("http://localhost:8081/getTop/" + fechita + "/1-10");

            HttpURLConnection conexion2 = (HttpURLConnection) url2.openConnection();
            conexion2.setRequestMethod("GET");

            BufferedReader rd2 = new BufferedReader(new InputStreamReader(conexion2.getInputStream()));
            String linea2;

            while ((linea2 = rd2.readLine()) != null) {
                resultado2.append(linea2);
            }

            rd2.close();
            String top = resultado2.toString();
            String[] lines2 = resultado2.toString().split("\"rank\":");
            int contador = 0;
            for (String l : lines2) {
                String[] aux = l.split(":");
                System.out.println("Titulo:" + aux[1].replace(", \"artist\"", "") + "  " + "  " + " Artista:" + aux[2].replace(", \"weeks at no.1\"", "").replace(", \"last week\"", ""));
                if (contador == 1) {
                    this.top1 = "Titulo:" + aux[1].replace(", \"artist\"", "") + "  " + "  " + " Artista:" + aux[2].replace(", \"weeks at no.1\"", "").replace(", \"last week\"", "").replace(", \"last week\"", "");
                } else if (contador == 2) {
                    this.top2 = "Titulo:" + aux[1].replace(", \"artist\"", "") + "  " + "  " + " Artista:" + aux[2].replace(", \"weeks at no.1\"", "").replace(", \"last week\"", "");
                } else if (contador == 3) {
                    this.top3 = "Titulo:" + aux[1].replace(", \"artist\"", "") + "  " + "  " + " Artista:" + aux[2].replace(", \"weeks at no.1\"", "").replace(", \"last week\"", "");
                } else if (contador == 4) {
                    this.top4 = "Titulo:" + aux[1].replace(", \"artist\"", "") + "  " + "  " + " Artista:" + aux[2].replace(", \"weeks at no.1\"", "").replace(", \"last week\"", "");
                } else if (contador == 5) {
                    this.top5 = "Titulo:" + aux[1].replace(", \"artist\"", "") + "  " + "  " + " Artista:" + aux[2].replace(", \"weeks at no.1\"", "").replace(", \"last week\"", "");
                } else if (contador == 6) {
                    this.top6 = "Titulo:" + aux[1].replace(", \"artist\"", "") + "  " + "  " + " Artista:" + aux[2].replace(", \"weeks at no.1\"", "").replace(", \"last week\"", "");
                } else if (contador == 7) {
                    this.top7 = "Titulo:" + aux[1].replace(", \"artist\"", "") + "  " + "  " + " Artista:" + aux[2].replace(", \"weeks at no.1\"", "").replace(", \"last week\"", "");
                } else if (contador == 8) {
                    this.top8 = "Titulo:" + aux[1].replace(", \"artist\"", "") + "  " + "  " + " Artista:" + aux[2].replace(", \"weeks at no.1\"", "").replace(", \"last week\"", "");
                } else if (contador == 9) {
                    this.top9 = "Titulo:" + aux[1].replace(", \"artist\"", "") + "  " + "  " + " Artista:" + aux[2].replace(", \"weeks at no.1\"", "").replace(", \"last week\"", "");
                } else if (contador == 10) {
                    this.top10 = "Titulo:" + aux[1].replace(", \"artist\"", "") + "  " + "  " + " Artista:" + aux[2].replace(", \"weeks at no.1\"", "").replace(", \"last week\"", "");
                }
                contador++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void buscarCancion() {
        try {
            StringBuilder resultado2 = new StringBuilder();
            this.cancion = this.cancion.replaceAll(" ", "%20");
            URL url2 = new URL("http://localhost:8081/getCancion/" + this.cancion + "/1");

            HttpURLConnection conexion2 = (HttpURLConnection) url2.openConnection();
            conexion2.setRequestMethod("GET");

            BufferedReader rd2 = new BufferedReader(new InputStreamReader(conexion2.getInputStream()));
            String linea2;

            while ((linea2 = rd2.readLine()) != null) {
                resultado2.append(linea2);
            }

            rd2.close();
            String key = resultado2.toString();
            String[] lines2 = resultado2.toString().split(",\"");
            for (String l : lines2) {
                if (l.contains("key")) {
                    key = l;
                }
            }
            key = key.replace("key\":\"", "").replace("\"", "");
            /////////////////////////////////////////////////////////////////
            System.out.println("KEY: " + key);
            StringBuilder resultado = new StringBuilder();
            URL url = new URL("http://localhost:8081/getMusica/" + key);

            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestMethod("GET");

            BufferedReader rd = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
            String linea;

            while ((linea = rd.readLine()) != null) {
                resultado.append(linea);
            }

            rd.close();
            String yt = resultado.toString();
            String[] lines = resultado.toString().split("\"");
            for (String l : lines) {
                if (l.contains("https://youtu.be")) {
                    yt = l;
                }
            }
            boolean condicion = true;
            String letraCancion = resultado.toString();
            String[] lines3 = resultado.toString().split(":\"");
            for (String le : lines3) {
                if (le.contains("LYRICS\",\"text\":")) {
                    letraCancion = le.replace("LYRICS\",\"text\":[\"", "").replace("\"],\"footer\"", "");
                }
                if (le.contains("http") & condicion) {
                    this.imagen = le.replace("\",\"coverart\"", "");
                    condicion = false;
                }
            }
            System.out.println("IMAGEN: " + this.imagen);
            System.out.println("URL YT= " + yt);
            System.out.println("LETRA: " + letraCancion);
            this.letra = letraCancion.toUpperCase().replace("Ã©", "É").replace("Ã", "Í").replace("Íº", "Ú").replace("Â", "").replace("Í¡", "Á").replace("Í³", "Ó").replace("Í±", "Ñ");
            yt = yt.replace("https://youtu.be/", "").replace("?autoplay=1", "");
            this.renderizado = true;
            this.urlYT = "https://www.youtube.com/embed/" + yt;
            System.out.println("Nueva URL: " + this.urlYT);

            /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            StringBuilder resultado3 = new StringBuilder();
            URL url3 = new URL("http://localhost:8081/getUrl/" + yt);

            HttpURLConnection conexion3 = (HttpURLConnection) url3.openConnection();
            conexion3.setRequestMethod("GET");

            BufferedReader rd3 = new BufferedReader(new InputStreamReader(conexion3.getInputStream()));
            String linea3;

            while ((linea3 = rd3.readLine()) != null) {
                resultado3.append(linea3);
            }

            rd3.close();
            String[] lines4 = resultado3.toString().split(":\"");

            for (String l : lines4) {
                if (l.contains("https")) {
                    this.urlDescarga = l.replace("\",\"iframe\"", "");
                }
            }

            System.out.println("URL DESCARGA: " + this.urlDescarga);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getUrlYT() {
        return urlYT;
    }

    public void setUrlYT(String urlYT) {
        this.urlYT = urlYT;
    }

    public boolean isRenderizado() {
        return renderizado;
    }

    public void setRenderizado(boolean renderizado) {
        this.renderizado = renderizado;
    }

    public String getCancion() {
        return cancion;
    }

    public String getImagen() {
        return imagen;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getTop1() {
        return top1;
    }

    public void setTop1(String top1) {
        this.top1 = top1;
    }

    public String getTop2() {
        return top2;
    }

    public String getUrlDescarga() {
        return urlDescarga;
    }

    public void setUrlDescarga(String urlDescarga) {
        this.urlDescarga = urlDescarga;
    }

    public void setTop2(String top2) {
        this.top2 = top2;
    }

    public String getTop3() {
        return top3;
    }

    public void setTop3(String top3) {
        this.top3 = top3;
    }

    public String getTop4() {
        return top4;
    }

    public void setTop4(String top4) {
        this.top4 = top4;
    }

    public String getTop5() {
        return top5;
    }

    public void setTop5(String top5) {
        this.top5 = top5;
    }

    public String getTop6() {
        return top6;
    }

    public void setTop6(String top6) {
        this.top6 = top6;
    }

    public String getTop7() {
        return top7;
    }

    public void setTop7(String top7) {
        this.top7 = top7;
    }

    public String getTop8() {
        return top8;
    }

    public void setTop8(String top8) {
        this.top8 = top8;
    }

    public String getTop9() {
        return top9;
    }

    public void setTop9(String top9) {
        this.top9 = top9;
    }

    public String getTop10() {
        return top10;
    }

    public void setTop10(String top10) {
        this.top10 = top10;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public void setCancion(String cancion) {
        this.cancion = cancion;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

}

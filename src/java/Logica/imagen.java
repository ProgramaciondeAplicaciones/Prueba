/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;
import java.awt.Image;

/**
 *
 * @author Nicole
 */
public class imagen {
    private String id,name;
    private Image archivo;

    public Image getArchivo() {
        return archivo;
    }

    public void setArchivo(Image archivo) {
        this.archivo = archivo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }    

    @Override
    public String toString() {
        return this.id+" : "+this.name;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testobjetotojson;

/**
 *
 * @author SaFteiNZz
 */
public class rol {
    private int idRol;
    private String nombreRol;



    public rol(int idRol, String nombreRol)
    {
        this.idRol = idRol;
        this.nombreRol = nombreRol;
    }
        
    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }
        
}

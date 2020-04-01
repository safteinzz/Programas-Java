/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testobjetotojson;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.reflect.TypeToken;

/**
 *
 * @author SaFteiNZz
 */
public class TestObjetotoJSON {

    public static VentanaMain ventanaUser = new VentanaMain();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        ventanaUser.setVisible(true);
      rol adminRol = new rol(1, "Admin");
      rol admin2 = new rol(2, "Mod");
    
      usuario user = new usuario("Paco", adminRol);
    
    
      try {
          try (Writer writer = new FileWriter("C:\\test")) {
                  Gson gson = new GsonBuilder()
                      //.setExclusionStrategies(new TestExclStrat())
                      //.serializeNulls() <-- uncomment to serialize NULL fields as well
                      .create();
                  gson.toJson(user, writer);
          }
      } catch (JsonIOException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
      } catch (IOException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
      }
}
    
}

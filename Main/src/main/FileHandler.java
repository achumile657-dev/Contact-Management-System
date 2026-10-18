package main;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author USER
 */
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Formatter;
public class FileHandler {  
    public void createFile(){
    try{
    File file = new File("Contacts.csv");
    if(file.createNewFile()){
System.out.println("File created");
}
        else{
System.out.println("File already exists");}

  }
 
 catch(IOException e){
System.out.println("Error");
}
}
public void writeFile(String firstname,String lastName,String phoneNumber,String email){

try(Formatter formatter = new Formatter(new FileWriter("Contacts.csv" ,true))){
formatter.format("%-20s%-15s%-30s%n" ,firstname ,lastName,phoneNumber ,email);

}
catch(IOException e){

System.out.println("Error:" + e.getMessage());
}
}

}
